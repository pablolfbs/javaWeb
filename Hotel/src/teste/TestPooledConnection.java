package teste;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import model.dao.PooledConnection;

/**
 * 
 * @author Pedro Abs
 * pedro_abs@yahoo.com.br
 *
 */
public class TestPooledConnection {

	public Connection createConnection(){
		// 1) Carrega o driver para o banco de dados
		Properties props = null;
		Connection conn = null;
		PooledConnection pconn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			props = new Properties();
			props.put("user","root" );
			props.put("password", "root");
			conn =  DriverManager.getConnection("jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC", props);
			pconn = new PooledConnection(conn, null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pconn;
	}
	
	@Test
	public void testObjects(){
		Connection conn1 = createConnection();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Connection conn2 = createConnection();
		
		assertFalse(conn2.equals(conn1));
		assertFalse(conn2.hashCode() == conn1.hashCode());
				
		assertTrue(conn2.equals(conn2));
		assertTrue(conn1.equals(conn1));
	}
}
