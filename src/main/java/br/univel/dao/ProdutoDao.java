package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.enun.Unidade;

import br.univel.model.Produto;

public class ProdutoDao {

	Connection con;

	// M�tod insere banco pegando valores das vari�veis da classe produto
	public void inserir(Produto produto) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO PRODUTO (id, codBarras, categoria, descricao,"
				+ "unidade, custo, margemLucro) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
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

			JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// public List<Produto> listarProdutos() throws SQLException {
	//
	// String sql = "Select * from Produto";
	// List<Produto> consulta = new ArrayList<Produto>();
	//
	// con = Conexao.getConnection();
	//
	// PreparedStatement pp = con.prepareStatement(sql);
	// ResultSet rs = pp.executeQuery();
	//
	// while (rs.next()) {
	// Produto produto = new Produto();
	//
	// produto.setId(rs.getInt("id"));
	// produto.setCodBarras(rs.getInt("codBarras"));
	// produto.setCategoria(rs.getString("categoria"));
	// produto.setDescricao(rs.getString("descricao"));
	// produto.setUnidade(rs.getString("unidade"));
	// produto.setCusto(rs.getBigDecimal("lucro"));
	// produto.setMargemLucro(rs.getBigDecimal("margemLucro"));
	//
	// }
	// return null;
	//
	// }

	public void editar(int id, int codBarras, String categoria,
			String descricao, Unidade unidade, BigDecimal lucro,
			BigDecimal margemLucro) {
		Produto produto = new Produto();
		con = Conexao.getConnection();

		String sql = "UPDATE PRODUTO SET ID = ?, codBarras = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, LUCRO = ?, MARGEMLUCRO = ? where id = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(8, id);
			stmt.setInt(1, codBarras);
			stmt.setString(2, categoria);
			stmt.setString(3, descricao);
			stmt.setString(4, unidade.toString());
			stmt.setBigDecimal(5, lucro);
			stmt.setBigDecimal(6, margemLucro);

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Produto editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar produto !!!");
			e.printStackTrace();
		}

	}

}
