package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			stmt.setString(4, produto.getDescricao().toUpperCase());
			stmt.setString(5, produto.getUnidade().toString().toUpperCase());
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

	public void editar(Produto p) {
		con = Conexao.getConnection();

		String sql = "UPDATE PRODUTO SET ID = ?, codBarras = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, CUSTO = ?, MARGEMLUCRO = ? where id = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(8, p.getId());
			stmt.setInt(1, p.getCodBarras());
			stmt.setString(2, p.getGenero().toString());
			stmt.setString(3, p.getDescricao().toUpperCase());
			stmt.setString(4, p.getUnidade().toString());
			stmt.setBigDecimal(5, p.getCusto());
			stmt.setBigDecimal(6, p.getMargemLucro());

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
			String sql = "DELETE FROM PRODUTO WHERE ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

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

	public BigDecimal valorProd(int vlrProduto) {

		con = Conexao.getConnection();

		String sql = "SELECT CUSTO FROM PRODUTO WHERE ID = ? ";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, vlrProduto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getBigDecimal("CUSTO");
			}
			System.out.println(rs.getBigDecimal("CUSTO"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao buscar valor do produto!");
			e.printStackTrace();
		}

		return BigDecimal.ZERO;
	}

	public BigDecimal buscaMargem(int i) {

		try {
			con = Conexao.getConnection();
			String sql = "SELECT MARGEMLUCRO FROM PODUTO WHERE ID = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getBigDecimal("MARGEMLUCRO");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao buscar margem de lucro!!!");
			e.printStackTrace();
		}
		return BigDecimal.ZERO;

	}
}
