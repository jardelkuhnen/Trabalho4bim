package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.univel.enun.GeneroProd;
import br.univel.enun.Unidade;
import br.univel.model.Produto;
import br.univel.model.Usuario;

public class UsuarioDao {

	Connection con;

	// Métod insere banco pegando valores das variáveis da classe usuario
	public void inserir(Usuario usuario) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO USUARIO (idCliente, idUs, senha) values(?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdCliente());
			stmt.setInt(2, usuario.getIdUs());
			stmt.setString(3, usuario.getSenha().toUpperCase());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void editar(Usuario u) {
		con = Conexao.getConnection();

		String sql = "UPDATE USUARIO SET idCliente = ?, IdUs = ?, SENHA = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, u.getIdCliente());
			stmt.setInt(2, u.getIdUs());
			stmt.setString(3, u.getSenha().toUpperCase());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Usuário editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar usuário !!!");
			e.printStackTrace();
		}

	}

	public UsuarioDao deletar(int idUs) {

		con = Conexao.getConnection();

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM USUARIO WHERE IdUs = ?");

			stmt.setInt(1, idUs);
			JOptionPane.showMessageDialog(null, "Usuário " + idUs
					+ " apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar usuário!!!");
			e.printStackTrace();
		}

		return null;

	}

	public boolean logar(String nome, String senha) {

		PreparedStatement stmt;
		con = Conexao.getConnection();
		String sql = "select * from usuario where nome=? and senha=?";
		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			ResultSet result = stmt.executeQuery();

			boolean a = result.next();

			if (a) {

			} else {
				return false;
			}

		} catch (Exception e) {

		}
		return false;

	}

}
