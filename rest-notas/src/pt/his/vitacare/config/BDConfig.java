package pt.his.vitacare.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import pt.his.vitacare.util.Propriedades;

public class BDConfig {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/notes_db?useTimezone=true&serverTimezone=UTC", "root", "root");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnection2() {
		Connection conexao = null;
		try {
			Properties prop = Propriedades.getProp();
			
			String enderecodb = prop.getProperty("prop.enderecodb");
			String nomedb = prop.getProperty("prop.nomedb");
			String user = prop.getProperty("prop.userdb");
			String password = prop.getProperty("prop.passworddb");
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conexao = DriverManager.getConnection(enderecodb + ";" + nomedb + ";" + user + ";" + password);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conexao;
	}

}
