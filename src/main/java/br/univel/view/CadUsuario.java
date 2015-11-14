package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.univel.controller.ClienteController;
import br.univel.controller.ProdutoContoller;
import br.univel.controller.UsuarioController;
import br.univel.dao.Conexao;
import br.univel.enun.GeneroProd;
import br.univel.enun.Unidade;
import br.univel.model.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtIdUs;
	private JTextField txtSenha;
	boolean resp = false;

	public CadUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 94, 43, 15, 61, 63, 0 };
		gbl_panel.rowHeights = new int[] { 39, 20, 0, 20, 20, 20, 31, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				16));
		GridBagConstraints gbc_lblCadastroDeUsurio = new GridBagConstraints();
		gbc_lblCadastroDeUsurio.anchor = GridBagConstraints.NORTH;
		gbc_lblCadastroDeUsurio.insets = new Insets(0, 0, 5, 0);
		gbc_lblCadastroDeUsurio.gridwidth = 10;
		gbc_lblCadastroDeUsurio.gridx = 0;
		gbc_lblCadastroDeUsurio.gridy = 1;
		panel.add(lblCadastroDeUsurio, gbc_lblCadastroDeUsurio);

		JLabel lblIdcliente = new JLabel("IdCliente");
		GridBagConstraints gbc_lblIdcliente = new GridBagConstraints();
		gbc_lblIdcliente.anchor = GridBagConstraints.WEST;
		gbc_lblIdcliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdcliente.gridx = 1;
		gbc_lblIdcliente.gridy = 3;
		panel.add(lblIdcliente, gbc_lblIdcliente);

		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdCliente.gridwidth = 3;
		gbc_txtIdCliente.gridx = 2;
		gbc_txtIdCliente.gridy = 3;
		panel.add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 4;
		panel.add(lblId, gbc_lblId);

		txtIdUs = new JTextField();
		GridBagConstraints gbc_txtIdUs = new GridBagConstraints();
		gbc_txtIdUs.anchor = GridBagConstraints.NORTH;
		gbc_txtIdUs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdUs.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdUs.gridwidth = 3;
		gbc_txtIdUs.gridx = 2;
		gbc_txtIdUs.gridy = 4;
		panel.add(txtIdUs, gbc_txtIdUs);
		txtIdUs.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 5;
		panel.add(lblSenha, gbc_lblSenha);

		txtSenha = new JTextField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.gridwidth = 3;
		gbc_txtSenha.gridx = 2;
		gbc_txtSenha.gridy = 5;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					UsuarioController us = new UsuarioController();

					try {
						verificaCliente(Integer.parseInt(txtIdCliente.getText()
								.trim()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					if (resp == true) {
						JOptionPane.showMessageDialog(null,
								"Cliente inexistente !!!");
					} else {

						us.salvar(
								Integer.parseInt(txtIdCliente.getText().trim()),
								Integer.parseInt(txtIdUs.getText().trim()),
								txtSenha.getText().trim());
					}
					limparCampos();

				}

			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					UsuarioController us = new UsuarioController();

					us.editar(Integer.parseInt(txtIdCliente.getText().trim()),
							Integer.parseInt(txtIdUs.getText().trim()),
							txtSenha.getText().trim());

					limparCampos();

				}

			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha os campos corretamente !!!");
				} else {
					UsuarioController us = new UsuarioController();

					int resposta = JOptionPane.showConfirmDialog(null,
							"Deseja excluir o usu�rio de Id: "
									+ txtIdUs.getText().trim() + " ?");
					if (resposta == JOptionPane.YES_OPTION) {
						us.deletar(Integer.parseInt(txtIdUs.getText().trim()));

					}
				}
				limparCampos();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.anchor = GridBagConstraints.SOUTH;
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridwidth = 2;
		gbc_btnExcluir.gridx = 1;
		gbc_btnExcluir.gridy = 6;
		panel.add(btnExcluir, gbc_btnExcluir);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 6;
		panel.add(btnEditar, gbc_btnEditar);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 6;
		panel.add(btnSalvar, gbc_btnSalvar);
	}

	public boolean verificaCliente(int idCl) throws SQLException {
		Connection con = Conexao.getConnection();

		String sql = "select id cliente where id = " + idCl;
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		PreparedStatement pp = con.prepareStatement(sql);

		ResultSet rs = pp.executeQuery();

		while (rs.next()) {

			Cliente c = new Cliente();

			c.setId(rs.getInt("id"));

			listaCliente.add(c);

		}

		for (int i = 0; i < listaCliente.size(); i++) {

			if (listaCliente.get(i) == null) {
				resp = true;
			}
		}

		return resp;

	}

	protected void limparCampos() {

		txtIdCliente.setText("");
		txtIdUs.setText("");
		txtSenha.setText("");

	}

	protected boolean validaCampos() {
		boolean valida;
		if (txtIdUs.getText().equals("")) {
			valida = true;
		} else {
			valida = false;
		}
		return valida;

	}

}
