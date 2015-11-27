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

	// M�tod insere banco pegando valores das vari�veis da classe usuario
	public void inserir(Usuario usuario) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO USUARIO (idCliente, idUs, usuario, senha) values(?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdCliente());
			stmt.setInt(2, usuario.getIdUs());
			stmt.setString(3, usuario.getUsuario().toUpperCase());
			stmt.setString(4, usuario.getSenha().toUpperCase());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usu�rio salvo com sucesso!!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar usu�rio!!!");
			e.printStackTrace();
		}

	}

	public void editar(Usuario u) {
		con = Conexao.getConnection();

		String sql = "UPDATE USUARIO SET idCliente = ?, IdUs = ?, USUARIO = ?, SENHA = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, u.getIdCliente());
			stmt.setInt(2, u.getIdUs());
			stmt.setString(3, u.getUsuario());
			stmt.setString(4, u.getSenha());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Usu�rio editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar usu�rio !!!");
			e.printStackTrace();
		}

	}

	public UsuarioDao deletar(int idUs) {

		con = Conexao.getConnection();

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM USUARIO WHERE IdUs = ?");

			stmt.setInt(1, idUs);
			JOptionPane.showMessageDialog(null, "Usu�rio " + idUs
					+ " apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar usu�rio!!!");
			e.printStackTrace();
		}

		return null;

	}

	public boolean logar(String usuario, String senha) {

		PreparedStatement stmt;
		con = Conexao.getConnection();
		String sql = "select usuario, senha from usuario where nome=? and senha=?";
		boolean a = true;
		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {

		}
		return a;

	}

}
