package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import br.univel.controller.VendaController;
import br.univel.model.Produto;
import br.univel.model.Venda;

public class VendaDao {

	Connection con;

	public List<Produto> listarProdutos(List<Produto> lista)
			throws SQLException {

		String sql = "Select descricao from Produto";

		con = Conexao.getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Produto p = new Produto();

			p.setDescricao(rs.getString("descricao"));

			lista.add(p);
		}

		return lista;
	}

	public void inserirP(Venda v) {
		con = Conexao.getConnection();

		String sql = "insert into Venda (nNota, cliente, produto, qtd, valorvenda,valorPagamento, valorTroco, dataHora) values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, v.getnNota());
			stmt.setString(2, v.getCliente());
			stmt.setString(3, v.getProduto());
			stmt.setInt(4, v.getQtd());
			stmt.setBigDecimal(5, v.getVlrTotal());
			stmt.setBigDecimal(6, v.getVlrPagamento());
			stmt.setBigDecimal(7, v.getVlrTroco());
			stmt.setString(8, v.getDataHora());

			stmt.execute();
			stmt.close();

			JOptionPane
					.showMessageDialog(null, "Venda Gravada com sucesso !!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
