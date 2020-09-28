package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import model.dao.ConnectionPool;
import model.dao.PooledConnection;

/**
 * 
 * @author Pedro Abs
 * pedro_abs@yahoo.com.br
 * 
 */
public class TestConnectionPool {
	private static ConnectionPool pool;
	private static List<Connection> usedConnections = new ArrayList<Connection>();
	
	@BeforeClass
	public static void init(){
			
		Properties props = new Properties();
		props.put ("charSet", "ISO-8859-1");
		props.put("user","root" );
		props.put("password", "root");
		
		try {
			pool = new ConnectionPool.Builder()
				.setInitialCapacity(3)
				.setMaxCapacity(10)
				.setStep(2)
				.setConnectionString("jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC&autoReconnect=true&tcpKeepAlive=true")
				.setDriver("com.mysql.cj.jdbc.Driver")
				.setProperties(props)
				.setTimeOut(0)
				.build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testa os dados do passados para o 'pool' através do builder.
	 */
	@Test
	public void testConnectionPool(){
		assertTrue(pool.getInitialCapacity() == 3);
		assertTrue(pool.getMaxCapacity() == 10);
		assertTrue(pool.getStep() == 2);
		assertTrue(pool.getConnectionString().equals("jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC&autoReconnect=true&tcpKeepAlive=true"));
		assertTrue(pool.getDriver().equals("com.mysql.cj.jdbc.Driver"));
		assertTrue(pool.getTimeOut() == 0);
	}
	
	/**
	 * Testa o número de conexões iniciais.
	 */
	@Test
	public void testNumberOfInitialConections(){
		assertTrue(pool.availableConnections() == 3);
	}
	
	/**
	 * Testa e simula o uso de conexões disponíveis.
	 */
	@Test
	public void testCheckOut(){
		usedConnections.add(pool.checkOut());
		usedConnections.add(pool.checkOut());
		assertTrue(pool.availableConnections() == 1);
		assertTrue(pool.totalConnections() == 3);
		
		usedConnections.add(pool.checkOut());
		assertTrue(pool.availableConnections() == 0);
		assertTrue(pool.totalConnections() ==3 );
		
		try {
			for(Connection conn: usedConnections){
				assertTrue(conn.isClosed() == false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void checkIn(){
		try {
			for(Connection conn: usedConnections){
				conn.close();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Testa o retorno das conexões para o pool.
	 */
	@Test
	public void testCheckIn(){
		
		this.checkIn();
		assertTrue(pool.availableConnections() == 3);
		assertTrue(pool.totalConnections() == 3);
		assertTrue(pool.unavailableConnections() == 0);
		
	}
	
	/**
	 * Testa a criação de novas conexões pelo pool conforme necessidade.
	 */
	@Test
	public void testCreateNewConnectionsInStep(){
		for(int i = 0; i < 4; i++){
			usedConnections.add(pool.checkOut());
		}
		
		assertTrue(pool.totalConnections() == 5);
		
		for(int i = 0; i < 2; i++){
			usedConnections.add(pool.checkOut());
		}
		
		assertTrue(pool.totalConnections() == 7);
		
		this.checkIn();
	}
	
	@Test
	public void testIsAvailable(){
		Connection conn = pool.checkOut();
		PooledConnection pconn = (PooledConnection)conn;
		assertFalse(pconn.isAvailable());
		
		pool.checkIn(pconn);
		assertTrue(pconn.isAvailable());
	}
	
	/**
	 * Testa a máxima capacidade e o uso do objeto 'pool' através de Threads
	 * simulando o seu uso em servlets.
	 */
	@Test
	public void testMaxCapacityAndUse(){
		System.out.println("******************** BEGIN Max Capacity **********************");
		
		//pool.releaseAll();
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				// requer conexão
				Connection conn = pool.checkOut();
				System.out.println("requisitando " + conn);
				
				// realiza operações
				try {
					double d = Math.random()* 1000;
					long period = Double.valueOf(d).longValue();
					Thread.sleep(period);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// asserções
				try {
					assertFalse(conn.isClosed());
					assertTrue(conn.isValid(0));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				// fecha conexão.
				try {
					System.out.println("devolvendo " + conn);
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		// Simula a requisição de 25 conexões.
		for(int i = 0; i < 25; i++){
			Thread t = new Thread(r);
			t.start();
			
			// Faz com que a thread main só seja executada ao final da execução das threads.
			
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
				
		//pool.releaseAll();
		assertTrue(pool.totalConnections()==10);
		
		System.out.println();
		System.out.println("Total connections: " + pool.totalConnections());
		System.out.println("Available connections: " + pool.availableConnections());
		System.out.println("Unavailable connections: " + pool.unavailableConnections());
		System.out.println();
		
		System.out.println("******************** END Max Capacity **********************");
		
	}
	
	@Test
	public void testAleatorio(){
		System.out.println("******************** BEGIN Aleatório **********************");
		
		pool.checkOut();
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				// requer conexão
				Connection conn = pool.checkOut();
				
				System.out.println("Thread " + Thread.currentThread().getId() + " requisitando " + conn);
				// realiza operações
				try {
					double d = Math.random()* 1000 * Math.random();
					long period = Double.valueOf(d).longValue();
					Thread.sleep(period);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// asserções
				try {
					assertFalse(conn.isClosed());
					assertTrue(conn.isValid(0));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				// fecha conexão.
				try {
					System.out.println("Thread " + Thread.currentThread().getId() + " devolvendo " + conn);
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		// Simula a requisição de 400 conexões.
		for(int i = 0; i < 400; i++){
			Thread t = new Thread(r);
			t.start();			
		}
		
		// pausa a main thread por 5 segundos.
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		//pool.releaseAll();
		assertTrue(pool.totalConnections()==10);
		
		System.out.println();
		System.out.println("Total connections: " + pool.totalConnections());
		System.out.println("Available connections: " + pool.availableConnections());
		System.out.println("Unavailable connections: " + pool.unavailableConnections());
		System.out.println();
		
		System.out.println("******************** END Aleatorio **********************");
		
	}
	
	/**
	 * Testa o fechamento e exclusão de todas as conexões.
	 */
	@Test
	public void testFechandoConexoes(){
		pool.releaseAll();
		assertTrue(pool.totalConnections() == 0);
	}
		
}
