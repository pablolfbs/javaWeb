package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Connection createConnection(){
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
			
			System.out.println("Conectado com sucesso!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Class not found: " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Não pode conectar: " + e.getMessage());
		} 
		return pconn;
	}
	
//	public static Connection getConnection() {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC";
//			String username = "root";
//			String password = "root";
//			con = DriverManager.getConnection(url, username, password);
//			
//			System.out.println("Conectado com sucesso!!");
//		} catch (SQLException | ClassNotFoundException e) {
//			throw new RuntimeException("Não pode conectar: " + e.getMessage());
//		}
//		return con;
//	}
	
}
