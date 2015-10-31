package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.Produto;
import br.univel.model.Venda;

public class VendaDao {

	Connection con;

	public List<Produto> listarProdutos() throws SQLException {

		String sql = "Select nome, custo from Produto";

		List<Produto> consulta = new ArrayList<Produto>();

		con = Conexao.getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Produto p = new Produto();

			p.setDescricao(rs.getString("descricao"));
			p.setCusto(rs.getBigDecimal("custo"));

			consulta.add(p);
		}

		return consulta;

	}
}
