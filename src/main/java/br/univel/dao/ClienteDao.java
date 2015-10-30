package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.enun.Uf;
import br.univel.enun.Unidade;
import br.univel.model.Cliente;
import br.univel.model.Produto;

public class ClienteDao {

	Connection con;

	public void inserir(Cliente c) {

		con = Conexao.getConnection();

		String sql = "INSERT INTO PRODUTO (ID, NOME, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getCidade());
			stmt.setString(4, c.getEstado().toString());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getGenero().toString());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null,
					"Cliente cadastrado com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public List<Cliente> listarClientes() throws SQLException {

		String sql = "Select nome from Cliente";
		List<Cliente> consulta = new ArrayList<Cliente>();

		con = Conexao.getConnection();

		PreparedStatement pp = con.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();

			cliente.setNome(rs.getString("nome"));

			consulta.add(cliente);
		}
		return consulta;

	}
	
	public void editar(int id, String nome, String endereco,
			String cidade, Uf estado, String email) {
		Cliente cliente = new Cliente();
		con = Conexao.getConnection();

		String sql = "UPDATE CLIENTE SET NOME = ?, ENDERECO = ?,"
				+ "CIDADE = ?, ESTADO = ?, EMAIL = ? WHERE ID = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(6, id);
			stmt.setString(1, nome);
			stmt.setString(2, endereco);
			stmt.setString(3, cidade);
			stmt.setString(4, estado.toString());
			stmt.setString(5, email);

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Cliente editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar cliente !!!");
			e.printStackTrace();
		}

	}

}
