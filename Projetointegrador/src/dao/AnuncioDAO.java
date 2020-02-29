package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Anuncio;


public class AnuncioDAO extends BaseDAO {

	public List<Anuncio> getListAnuncios() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Anuncio> anuncios = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from Anuncio");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Anuncio u = createAnuncio(rs);
				anuncios.add(u);
				System.out.println(u.getNome());
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return anuncios;
	}

	public Anuncio createAnuncio(ResultSet rs) throws SQLException {
		Anuncio u = new Anuncio();
		u.setId(rs.getInt("anuncio_id"));
		u.setDataSaida(rs.getString("anuncio_data"));
		u.setNome(rs.getString("anuncio_nome"));
		u.setDescricao(rs.getString("anuncio_descricao"));
		u.setPreco(rs.getString("anuncio_preco"));
	

		return u;
	}

}
