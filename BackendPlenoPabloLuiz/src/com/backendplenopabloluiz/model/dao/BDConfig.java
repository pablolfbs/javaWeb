package com.backendplenopabloluiz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com o banco de dados.
 * 
 * @author pablo
 *
 */
public class BDConfig {
	
	private BDConfig() {
		
	}
	
	/**
	 * Faz a conexão com o banco de dados.
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/banco?useTimezone=true&serverTimezone=UTC&autoReconnect=true", "root", "root");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
