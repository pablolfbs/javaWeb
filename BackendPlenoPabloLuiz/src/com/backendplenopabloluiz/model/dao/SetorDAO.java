package com.backendplenopabloluiz.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.backendplenopabloluiz.model.Setor;

/**
 * Classe DAO de setor.
 * 
 * @author pablo
 *
 */
public class SetorDAO {

	/**
	 * Busca conexão com o banco.
	 */
	Connection con = BDConfig.getConnection();

	/**
	 * Busca no banco o setor pelo id.
	 * 
	 * @param id
	 * @return
	 */
	public Setor buscar(Integer id) {
		String sql = " SELECT s.id, s.descricao FROM setor s WHERE id = " + id + "; ";

		Setor setor = new Setor();

		try (Statement sttm = con.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			if (rs.next()) {
				setor.setId(id);
				setor.setDescricao(rs.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setor;
	}

	/**
	 * Lista todos os setores cadastrados.
	 * 
	 * @return
	 */
	public List<Setor> listar() {
		String sql = " SELECT s.id, s.descricao FROM setor s ";

		List<Setor> setores = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Setor setor = new Setor();
				setor.setId(rs.getInt("id"));
				setor.setDescricao(rs.getString("descricao"));
				setores.add(setor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setores;
	}

}
