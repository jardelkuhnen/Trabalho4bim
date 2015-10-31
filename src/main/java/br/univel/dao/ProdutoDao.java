package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.enun.Genero;
import br.univel.enun.Unidade;
import br.univel.model.Produto;

public class ProdutoDao {

	Connection con;

	// Métod insere banco pegando valores das variáveis da classe produto
	public void inserir(Produto produto) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO PRODUTO (id, codBarras, genero, descricao,"
				+ "unidade, custo, margemLucro) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			stmt.setInt(2, produto.getCodBarras());
			stmt.setString(3, produto.getGenero().toString());
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

	public List<Produto> listarProdutos() throws SQLException {

		String sql = "Select descricao from Produto";
		List<Produto> consulta = new ArrayList<Produto>();

		con = Conexao.getConnection();

		PreparedStatement pp = con.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();

		while (rs.next()) {
			Produto produto = new Produto();

			produto.setDescricao(rs.getString("descricao"));

			consulta.add(produto);
		}
		return consulta;

	}

	public void editar(int id, int codBarras, Genero genero,
			String descricao, Unidade unidade, BigDecimal lucro,
			BigDecimal margemLucro) {
		con = Conexao.getConnection();

		String sql = "UPDATE PRODUTO SET ID = ?, codBarras = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, LUCRO = ?, MARGEMLUCRO = ? where id = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(8, id);
			stmt.setInt(1, codBarras);
			stmt.setString(2, genero.toString());
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

	public Produto deletar(int id) {

		con = Conexao.getConnection();

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");

			stmt.setInt(1, id);
			JOptionPane.showMessageDialog(null,
					"Produto apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar produto!!!");
			e.printStackTrace();
		}

		return null;

	}
}
