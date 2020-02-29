package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/cjweb1", "root", "");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
