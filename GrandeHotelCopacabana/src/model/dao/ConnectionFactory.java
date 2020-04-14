package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hotel?autoReconnect=true&useTimezone=true&serverTimezone=UTC", "root", "root");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("N�o pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		getConnection();
	}
	
}
