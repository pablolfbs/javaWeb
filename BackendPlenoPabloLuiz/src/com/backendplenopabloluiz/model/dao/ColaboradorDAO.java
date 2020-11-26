package com.backendplenopabloluiz.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.backendplenopabloluiz.model.Colaborador;

/**
 * Classe DAO de colaborador.
 * 
 * @author pablo
 *
 */
public class ColaboradorDAO {

	/**
	 * Busca conexão com o banco.
	 */
	Connection con = BDConfig.getConnection();

	SetorDAO sDAO = new SetorDAO();

	/**
	 * Adiciona o colaborador no banco de dados e devolve o id do colaborador criado.
	 * 
	 * @param colaborador
	 * @return
	 */
	public int adiciona(Colaborador colaborador) {
		int id = 0;

		String sql = "INSERT INTO colaborador(cpf, nome, telefone, email, data_nasc, id_setor) VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, colaborador.getCpf());
			ps.setString(2, colaborador.getNome());
			ps.setString(3, colaborador.getTelefone());
			ps.setString(4, colaborador.getEmail());
			ps.setDate(5, new java.sql.Date(colaborador.getDtNascimento().getTime()));
			ps.setInt(6, colaborador.getSetor().getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs;
		try {
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Remove colaborador por id.
	 * 
	 * @param id
	 */
	public void remove(Integer id) {
		String sql = " DELETE FROM colaborador WHERE id = ? ";

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Busca no banco o colaborador por id.
	 * 
	 * @param id
	 * @return
	 */
	public Colaborador buscar(Integer id) {
		String sql = " SELECT * FROM colaborador WHERE id = " + id + "; ";

		Colaborador colaborador = new Colaborador();

		try (Statement sttm = con.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			if (rs.next()) {
				colaborador.setId(id);
				colaborador.setCpf("cpf");
				colaborador.setNome(rs.getString("nome"));
				colaborador.setTelefone("telefone");
				colaborador.setEmail(rs.getString("email"));
				colaborador.setDtNascimento(rs.getDate("data_nasc"));
				colaborador.setSetor(sDAO.buscar(rs.getInt("id_setor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaborador;
	}

	/**
	 * Lista todos os colaboradores cadastrados no banco de dados.
	 * @return
	 */
	public List<Colaborador> listar() {
		String sql = " SELECT c.nome, c.email, c.data_nasc, c.id_setor FROM colaborador c JOIN setor s "
				+ "WHERE c.id_setor = s.id ORDER BY s.descricao ";

		List<Colaborador> colaboradores = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Colaborador colaborador = new Colaborador();
				colaborador.setNome(rs.getString("nome"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setDtNascimento(rs.getDate("data_nasc"));
				colaborador.setSetor(sDAO.buscar(rs.getInt("id_setor")));
				colaboradores.add(colaborador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaboradores;
	}

}
