package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.enun.GeneroCli;
import br.univel.enun.Uf;
import br.univel.model.Cliente;
import br.univel.model.Produto;

public class ClienteDao {

	Connection con;

	// insere todos os atributos de cliente na tavela cliente do banco, caso
	// haja erro é apresentado uma mensagem de erro
	public void inserir(Cliente c) {

		con = Conexao.getConnection();

		String sql = "INSERT INTO CLIENTE (ID, NOME, ENDERECO, CIDADE, ESTADO, GENERO, EMAIL) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getNome().toUpperCase());
			stmt.setString(3, c.getEndereco().toUpperCase());
			stmt.setString(4, c.getCidade().toUpperCase());
			stmt.setString(5, c.getEstado().toString());
			stmt.setString(6, c.getGenero().toString());
			stmt.setString(7, c.getEmail());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null,
					"Cliente cadastrado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao salvar cliente!!!");
			e.printStackTrace();
		}

	}

	public List<Cliente> listarCliente(List<Cliente> lista) throws SQLException {

		String sql = "Select nome from Cliente";

		con = Conexao.getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cliente c = new Cliente();

			c.setNome(rs.getString("nome"));

			lista.add(c);
		}

		return lista;
	}

	public void editar(Cliente c) {
		con = Conexao.getConnection();

		String sql = "UPDATE CLIENTE SET NOME = ?, ENDERECO = ?,"
				+ "CIDADE = ?, ESTADO = ?, GENERO = ?, EMAIL = ? WHERE ID = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(6, c.getId());
			stmt.setString(1, c.getNome().toUpperCase());
			stmt.setString(2, c.getEndereco().toUpperCase());
			stmt.setString(3, c.getCidade().toUpperCase());
			stmt.setString(4, c.getEstado().toString());
			stmt.setString(5, c.getGenero().toString());
			stmt.setString(6, c.getEmail().toUpperCase());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Cliente editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar cliente !!!");
			e.printStackTrace();
		}

	}

	public Cliente deletar(int id) {

		con = Conexao.getConnection();

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
			int rs = stmt.executeUpdate();
			stmt.setInt(1, id);
			JOptionPane.showMessageDialog(null,
					"Cliente apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar cliente!!!");
			e.printStackTrace();
		}

		return null;

	}

}
