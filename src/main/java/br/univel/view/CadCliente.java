package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;

import br.univel.controller.ClienteController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class CadCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadCliente frame = new CadCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadCliente() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel cadCliente = new JPanel();
		cadCliente.setToolTipText("Cadastro de Clientes");
		cadCliente.setBorder(new BevelBorder(BevelBorder.RAISED, UIManager
				.getColor("Button.foreground"), null, null, null));
		cadCliente.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(cadCliente, BorderLayout.CENTER);
		GridBagLayout gbl_cadCliente = new GridBagLayout();
		gbl_cadCliente.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 86 };
		gbl_cadCliente.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_cadCliente.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_cadCliente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		cadCliente.setLayout(gbl_cadCliente);

		JLabel lblCadasroDeCliente = new JLabel("Cadasro de Cliente");
		lblCadasroDeCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				16));
		GridBagConstraints gbc_lblCadasroDeCliente = new GridBagConstraints();
		gbc_lblCadasroDeCliente.gridwidth = 11;
		gbc_lblCadasroDeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_lblCadasroDeCliente.gridx = 0;
		gbc_lblCadasroDeCliente.gridy = 1;
		cadCliente.add(lblCadasroDeCliente, gbc_lblCadasroDeCliente);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 3;
		cadCliente.add(lblId, gbc_lblId);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.gridwidth = 3;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 3;
		cadCliente.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		cadCliente.add(lblNewLabel, gbc_lblNewLabel);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 7;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 2;
		gbc_txtNome.gridy = 4;
		cadCliente.add(txtNome, gbc_txtNome);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 5;
		cadCliente.add(lblTelefone, gbc_lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.gridwidth = 5;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.gridx = 2;
		gbc_txtTelefone.gridy = 5;
		cadCliente.add(txtTelefone, gbc_txtTelefone);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 1;
		gbc_lblEndereco.gridy = 6;
		cadCliente.add(lblEndereco, gbc_lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.gridwidth = 7;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.gridx = 2;
		gbc_txtEndereco.gridy = 6;
		cadCliente.add(txtEndereco, gbc_txtEndereco);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 1;
		gbc_lblCidade.gridy = 7;
		cadCliente.add(lblCidade, gbc_lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.gridwidth = 6;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridx = 2;
		gbc_txtCidade.gridy = 7;
		cadCliente.add(txtCidade, gbc_txtCidade);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 8;
		cadCliente.add(lblEstado, gbc_lblEstado);

		final JComboBox cbEstado = new JComboBox();
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.gridwidth = 4;
		gbc_cbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.gridx = 2;
		gbc_cbEstado.gridy = 8;
		cadCliente.add(cbEstado, gbc_cbEstado);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		cadCliente.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 7;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 9;
		cadCliente.add(txtEmail, gbc_txtEmail);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					ClienteController cc = new ClienteController();

					// cc.salvar(txtId.getText().trim(),
					// txtNome.getText().trim(),
					// txtEndereco.getText().trim(), txtCidade.getText()
					// .trim(),cbEstado.toString().trim(),
					// txtEmail.getText().trim());

				}

			}
		});

		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 7;
		gbc_btnExcluir.gridy = 10;
		cadCliente.add(btnExcluir, gbc_btnExcluir);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 8;
		gbc_btnSalvar.gridy = 10;
		cadCliente.add(btnSalvar, gbc_btnSalvar);
	}

	boolean validaCampos() {
		boolean valida;
		if (txtId.getText().equals("")) {
			valida = true;
		} else {
			valida = false;
		}
		return valida;

	}

}
