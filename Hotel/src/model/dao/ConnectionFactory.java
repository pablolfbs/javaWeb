package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Não pode conectar: " + e.getMessage());
		}
		return con;
	}
	
}
