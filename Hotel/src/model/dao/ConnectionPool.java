package model.dao;

import java.util.List;
import java.util.Queue;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Pedro Abs pedro_abs@yahoo.com.br
 * 
 *         Esta classe representa o pool de conex�es. Ela � respons�vel por
 *         instanciar inicialmente algumas conex�es (definido o n�mero inicial
 *         pelo usu�rio) e acrescentar novas conex�es de acordo com a demanda.
 * 
 * 
 */
public class ConnectionPool {

	private int initialCapacity;
	private int maxCapacity;
	private int step;
	private String connectionString;
	private String driver;
	private Properties properties;
	private long timeOut;
	private List<Connection> unavailable;
	private Queue<Connection> available;

	private ConnectionPool(String driver) throws ClassNotFoundException {
		this.driver = driver;
		// 1) Carrega o driver para o banco de dados
		Class.forName(driver);
		this.unavailable = new CopyOnWriteArrayList<Connection>();
		this.available = new ConcurrentLinkedQueue<Connection>();// new ConcurrentLinkedQueue<Connection>();
	}

	private void init() {
		// inicializa��o do pool
		for (int i = 0; i < this.getInitialCapacity(); i++) {
			Connection conn = this.createConnection();
			this.available.offer(conn);
		}
	}

	public void setInitialCapacity(int initialCapacity) {
		this.initialCapacity = initialCapacity;
	}

	public int getInitialCapacity() {
		return initialCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getStep() {
		return step;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriver() {
		return driver;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Properties getProperties() {
		return properties;
	}

	public synchronized void checkIn(Connection conn) {
		PooledConnection pconn = (PooledConnection) conn;
		// se a conex�o n�o estiver v�lida ela nem volta para o pool.
		if (this.isValid(conn)) {
			this.available.offer(conn);
		} else {
			this.expire(conn);
		}
		this.unavailable.remove(conn);
		pconn.setAvailable(true);

		// liberar
		// System.out.println(" Devolvendo " + pconn + " ****** idade " +
		// pconn.getAge());
		// notifica todas as threads que est�o esperando para
		// continuarem suas opera��es.

		this.notifyAll();
	}

	public synchronized Connection checkOut() {

		if (this.available.size() > 0) {

			// uma das conex�es dispon�veis ter�o de ser retornadas
			Connection conn = this.available.poll();
			// conex�o v�lida
			if (this.isValid(conn)) {
				this.unavailable.add(conn);
				// liberar
				// System.out.println("disponibilizou conex�o: " + conn);
				PooledConnection pconn = (PooledConnection) conn;
				pconn.setAvailable(false);
				pconn.setLastUsed(System.currentTimeMillis());
				return conn;
			} else {
				// caso a conex�o apesar de dispon�vel n�o esteja aberta.
				this.expire(conn);
				return this.checkOut();
			}
		} else {
			// Se n�o houverem conex�es dispon�veis:
			// Verificar se pode-se criar novas conex�es.
			if (this.creatorManager()) {
				// se criou novas conex�es chame o m�todo recursivamente.
				return this.checkOut();
			} else {
				// Se n�o criou novas conex�es fa�a a thread esperar a devolu��o de uma conex�o.
				try {
					// liberar
					// Thread se coloca no estado de espera por pelo menos X segundos
					this.wait(3000);
					// Quando acordar, chamada recursiva para o m�todo.
					return this.checkOut();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Connection Pool - checkOut() return null");
		return null;
	}

	public int totalConnections() {
		return this.available.size() + this.unavailable.size();
	}

	public int availableConnections() {
		return this.available.size();
	}

	public int unavailableConnections() {
		return this.unavailable.size();
	}

	private boolean isValid(Connection conn) {

		try {
			// Verifica se est� aberta
			if (conn.isClosed())
				return false;
			// Verifica se est� v�lida
			if (conn.isValid(0) == false)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Verifica se n�o deu timeout
		PooledConnection pconn = (PooledConnection) conn;

		// se o timeOut for > 0 e a idade da conex�o for > que o timeout
		if (this.timeOut > 0 && (pconn.getAge() > this.timeOut)) {
			return false;
		}

		return true;
	}

	private void expire(Connection conn) {
		PooledConnection pconn = (PooledConnection) conn;
		// remove a conex�o das cole��es
		this.available.remove(conn);
		this.unavailable.remove(conn);

		try {
			// realmente a fecha.
			if (!pconn.isClosed())
				pconn.reallyClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		try {
			// DriverManager.setLoginTimeout(0);

			// 2) Abre a conex�o
			Connection conn = DriverManager.getConnection(this.connectionString, this.properties);
			PooledConnection pconn = new PooledConnection(conn, this);
			return pconn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean creatorManager() {
		if (this.availableConnections() == 0 && (this.totalConnections() < this.getMaxCapacity())) {
			for (int i = 0; i < this.getStep(); i++) {
				Connection conn = this.createConnection();
				this.available.offer(conn);
				// liberar
				// System.out.println("CRIOU connection " + conn);
			}
			return true;
		}
		return false;
	}

	public void setTimeOut(long miliSeconds) {
		this.timeOut = miliSeconds;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public synchronized void releaseAll() {

		for (Connection conn : this.available) {
			PooledConnection pconn = (PooledConnection) conn;
			try {
				pconn.reallyClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for (Connection conn : this.unavailable) {
			PooledConnection pconn = (PooledConnection) conn;
			try {
				pconn.reallyClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		this.unavailable.clear();
		this.available.clear();

		/*
		 * Iterator<Connection> it = this.available.iterator(); while(it.hasNext()){
		 * Connection conn = it.next(); it.remove(); PooledConnection pconn =
		 * (PooledConnection)conn; try { pconn.reallyClose(); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 * 
		 * 
		 * it = this.unavailable.iterator(); while(it.hasNext()){ Connection conn =
		 * it.next(); it.remove(); PooledConnection pconn = (PooledConnection)conn; try
		 * { pconn.reallyClose(); } catch (SQLException e) { e.printStackTrace(); } }
		 */
	}

	public static class Builder {
		private int initialCapacity;
		private int maxCapacity;
		private int step;
		private String connectionString;
		private String driver;
		private long timeOut;
		private Properties properties;

		public Builder setInitialCapacity(int initCapacity) {
			this.initialCapacity = initCapacity;
			return this;
		}

		public Builder setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
			return this;
		}

		public Builder setStep(int step) {
			this.step = step;
			return this;
		}

		public Builder setConnectionString(String cstr) {
			this.connectionString = cstr;
			return this;
		}

		public Builder setDriver(String driver) {
			this.driver = driver;
			return this;
		}

		public Builder setProperties(Properties prop) {
			this.properties = prop;
			return this;
		}

		public Builder setTimeOut(long miliSeconds) {
			this.timeOut = miliSeconds;
			return this;
		}

		public ConnectionPool build() throws ClassNotFoundException {
			ConnectionPool pool = null;
			try {
				pool = new ConnectionPool(this.driver);
				pool.setInitialCapacity(this.initialCapacity);
				pool.setMaxCapacity(this.maxCapacity);
				pool.setStep(this.step);
				pool.setConnectionString(this.connectionString);
				pool.setProperties(this.properties);
				pool.setTimeOut(this.timeOut);

				pool.init();
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("Informe pelo menos o driver ");
			}

			return pool;
		}
	}
}
