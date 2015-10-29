package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.univel.model.Cliente;

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

}
