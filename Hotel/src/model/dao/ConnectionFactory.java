package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hotel?autoReconnect=true", "root", "root");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
		}
		return con;
	}
	
	public static void main(String[] args) {
		getConnection();
	}
	
}
