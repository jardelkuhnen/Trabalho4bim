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

import br.univel.controller.ProdutoContoller;
import br.univel.controller.UsuarioController;
import br.univel.enun.Genero;
import br.univel.enun.Unidade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class CadUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtIdUs;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 9, 97, 133, 85, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 44, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
				JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
				lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
						16));
				GridBagConstraints gbc_lblCadastroDeUsurio = new GridBagConstraints();
				gbc_lblCadastroDeUsurio.gridwidth = 10;
				gbc_lblCadastroDeUsurio.insets = new Insets(0, 0, 5, 0);
				gbc_lblCadastroDeUsurio.gridx = 0;
				gbc_lblCadastroDeUsurio.gridy = 1;
				panel.add(lblCadastroDeUsurio, gbc_lblCadastroDeUsurio);

		JLabel lblIdcliente = new JLabel("IdCliente");
		GridBagConstraints gbc_lblIdcliente = new GridBagConstraints();
		gbc_lblIdcliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdcliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdcliente.gridx = 1;
		gbc_lblIdcliente.gridy = 3;
		panel.add(lblIdcliente, gbc_lblIdcliente);

		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 5);
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
		gbc_txtIdUs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdUs.insets = new Insets(0, 0, 5, 5);
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
		gbc_txtSenha.gridwidth = 2;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 2;
		gbc_txtSenha.gridy = 5;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha os campos corretamente !!!");
				} else {
					UsuarioController us = new UsuarioController();

					int resposta = JOptionPane.showConfirmDialog(null,
							"Deseja excluir o usuário de Id: "
									+ txtIdUs.getText().trim() + " ?");
					if (resposta == JOptionPane.YES_OPTION) {
						us.deletar(Integer.parseInt(txtIdUs.getText().trim()));

					}
				}
				limparCampos();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.anchor = GridBagConstraints.EAST;
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 7;
		panel.add(btnExcluir, gbc_btnExcluir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.EAST;
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 7;
		panel.add(btnEditar, gbc_btnEditar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					UsuarioController us = new UsuarioController();

					us.salvar(Integer.parseInt(txtIdCliente.getText().trim()),
							Integer.parseInt(txtIdUs.getText().trim()),
							txtSenha.getText().trim());
					limparCampos();

				}

			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 7;
		panel.add(btnSalvar, gbc_btnSalvar);
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
