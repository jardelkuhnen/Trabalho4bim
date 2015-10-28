package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.Produto;

public class ProdutoDao {

	Connection con;

	// Métod insere banco pegando valores das variáveis da classe produto
	public void inserir(Produto produto) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO PRODUTO (id, codBarras, categoria, descricao, unidade, custo, margemLucro) values (?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			stmt.setInt(2, produto.getCodBarras());
			stmt.setString(3, produto.getCategoria());
			stmt.setString(4, produto.getDescricao());
			stmt.setString(5, produto.getUnidade().toString());
			stmt.setBigDecimal(6, produto.getCusto());
			stmt.setBigDecimal(7, produto.getMargemLucro());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Produto> klistarProdutos() throws SQLException {

		String sql = "Select * from Produto";
		List<Produto> consulta = new ArrayList<Produto>();

		con = Conexao.getConnection();

		PreparedStatement pp = con.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();

		while (rs.next()) {
			Produto produto = new Produto();

			produto.setId(rs.getInt("id"));
			produto.setCodBarras(rs.getInt("codBarras"));
			produto.setCategoria(rs.getString("categoria"));
			produto.setDescricao(rs.getString("descricao"));
			// continua...
		}
		return null;

	}
}
