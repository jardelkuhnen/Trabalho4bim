package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.univel.enun.Genero;
import br.univel.enun.Unidade;
import br.univel.model.Produto;
import br.univel.model.Usuario;

public class UsuarioDao {

	Connection con;

	// M�tod insere banco pegando valores das vari�veis da classe usuario
	public void inserir(Usuario usuario) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO USUARIO (idCliente, idUs, senha) values(?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			 stmt.setInt(1, usuario.getIdCliente());
			 stmt.setInt(2, usuario.getIdUs());
			 stmt.setString(3, usuario.getSenha());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usu�rio salvo com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void editar(int idCliente, int idUs, String senha) {
		con = Conexao.getConnection();

		String sql = "UPDATE USUARIO SET idCliente = ?, IdUs = ?, SENHA = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, idCliente);
			stmt.setInt(2, idUs);
			stmt.setString(3, senha);

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

}
