package br.univel.relatorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import br.univel.dao.ClienteDao;
import br.univel.dao.VendaDao;
import br.univel.model.Cliente;
import br.univel.model.Produto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RelVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static List<Cliente> listaCli = new ArrayList<Cliente>();
	static List<Produto> listaProd = new ArrayList<Produto>();

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

	public static void preencherListas() throws SQLException {

		VendaDao dao = new VendaDao();
		ClienteDao cli = new ClienteDao();

		dao.listarProdutos(listaProd);
		cli.listarCliente(listaCli);

	}

	/**
	 * Create the frame.
	 */
	public RelVenda() {
		try {
			preencherListas();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados!!!");
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 417);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 88, 162, 65, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 40, 22, 40, 23, 40, 23, 35,
				23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblRelatrioDeClientes = new JLabel("Relat\u00F3rio de Clientes");
		lblRelatrioDeClientes.setForeground(new Color(0, 0, 128));
		lblRelatrioDeClientes.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 18));
		GridBagConstraints gbc_lblRelatrioDeClientes = new GridBagConstraints();
		gbc_lblRelatrioDeClientes.anchor = GridBagConstraints.NORTH;
		gbc_lblRelatrioDeClientes.insets = new Insets(0, 0, 5, 0);
		gbc_lblRelatrioDeClientes.gridwidth = 5;
		gbc_lblRelatrioDeClientes.gridx = 0;
		gbc_lblRelatrioDeClientes.gridy = 1;
		contentPane.add(lblRelatrioDeClientes, gbc_lblRelatrioDeClientes);

		JLabel lblDia = new JLabel("Dia");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 3;
		contentPane.add(lblDia, gbc_lblDia);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);

		JButton btnBuscaDia = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaDia = new GridBagConstraints();
		gbc_btnBuscaDia.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaDia.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscaDia.gridx = 3;
		gbc_btnBuscaDia.gridy = 3;
		contentPane.add(btnBuscaDia, gbc_btnBuscaDia);

		JLabel lblEstado = new JLabel("M\u00EAs");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		contentPane.add(lblEstado, gbc_lblEstado);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnBuscaEstado = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaEstado = new GridBagConstraints();
		gbc_btnBuscaEstado.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaEstado.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscaEstado.gridx = 3;
		gbc_btnBuscaEstado.gridy = 5;
		contentPane.add(btnBuscaEstado, gbc_btnBuscaEstado);

		JLabel lblNewLabel = new JLabel("Categoria Produto");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 7;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JComboBox cbProduto = new JComboBox(new Vector<Produto>(listaProd));
		GridBagConstraints gbc_cbProduto = new GridBagConstraints();
		gbc_cbProduto.gridwidth = 2;
		gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 7;
		contentPane.add(cbProduto, gbc_cbProduto);

		JButton btnBuscaCategoria = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaCategoria = new GridBagConstraints();
		gbc_btnBuscaCategoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscaCategoria.gridx = 3;
		gbc_btnBuscaCategoria.gridy = 7;
		contentPane.add(btnBuscaCategoria, gbc_btnBuscaCategoria);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 9;
		contentPane.add(lblCliente, gbc_lblCliente);

		JComboBox cbCliente = new JComboBox(new Vector<Cliente>(listaCli));
		GridBagConstraints gbc_cbCliente = new GridBagConstraints();
		gbc_cbCliente.gridwidth = 2;
		gbc_cbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCliente.insets = new Insets(0, 0, 0, 5);
		gbc_cbCliente.gridx = 1;
		gbc_cbCliente.gridy = 9;
		contentPane.add(cbCliente, gbc_cbCliente);

		JButton btnBuscaCliente = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaCliente = new GridBagConstraints();
		gbc_btnBuscaCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscaCliente.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaCliente.gridx = 3;
		gbc_btnBuscaCliente.gridy = 9;
		contentPane.add(btnBuscaCliente, gbc_btnBuscaCliente);
	}

}
