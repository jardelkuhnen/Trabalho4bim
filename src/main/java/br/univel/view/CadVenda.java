package br.univel.view;

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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

import br.univel.dao.ClienteDao;
import br.univel.dao.VendaDao;
import br.univel.model.Cliente;
import br.univel.model.Produto;
import br.univel.model.TabelaModel;
import br.univel.model.Venda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNNota;
	private JTable tblCompra;
	private JTextField txtVlrTotal;
	private JTextField txtVlrPagamento;
	private JTextField txtTroco;
	private JComboBox cbProduto;
	private JComboBox cbCliente;
	private TabelaModel model;
	List<Produto> listaProd = new ArrayList<Produto>();
	List<Cliente> listaCli = new ArrayList<Cliente>();

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
	public CadVenda() {
		configuraManua();
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 68, 30, 214, 61, 179, 37, 84, 89,
				0 };
		gbl_panel.rowHeights = new int[] { 20, 20, 20, 20, 23, 313, 20, 20, 20,
				23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblvendas = new JLabel("***Vendas***");
		lblvendas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblvendas = new GridBagConstraints();
		gbc_lblvendas.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblvendas.insets = new Insets(0, 0, 5, 5);
		gbc_lblvendas.gridx = 4;
		gbc_lblvendas.gridy = 0;
		panel.add(lblvendas, gbc_lblvendas);

		JLabel lblNmeroNota = new JLabel("N\u00FAmero Nota");
		GridBagConstraints gbc_lblNmeroNota = new GridBagConstraints();
		gbc_lblNmeroNota.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroNota.gridx = 0;
		gbc_lblNmeroNota.gridy = 1;
		panel.add(lblNmeroNota, gbc_lblNmeroNota);

		txtNNota = new JTextField();
		GridBagConstraints gbc_txtNNota = new GridBagConstraints();
		gbc_txtNNota.anchor = GridBagConstraints.NORTH;
		gbc_txtNNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNNota.insets = new Insets(0, 0, 5, 5);
		gbc_txtNNota.gridwidth = 2;
		gbc_txtNNota.gridx = 1;
		gbc_txtNNota.gridy = 1;
		panel.add(txtNNota, gbc_txtNNota);
		txtNNota.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		panel.add(lblCliente, gbc_lblCliente);

		try {
			preencheLista();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao preencher lista de produtos");
			e2.printStackTrace();
		}

		cbCliente = new JComboBox(new Vector<Cliente>(listaCli));
		GridBagConstraints gbc_cbCliente = new GridBagConstraints();
		gbc_cbCliente.anchor = GridBagConstraints.NORTH;
		gbc_cbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbCliente.gridwidth = 2;
		gbc_cbCliente.gridx = 1;
		gbc_cbCliente.gridy = 2;
		panel.add(cbCliente, gbc_cbCliente);

		JLabel lblNewLabel = new JLabel("Produto");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		cbProduto = new JComboBox(new Vector<Produto>(listaProd));
		GridBagConstraints gbc_cbProduto = new GridBagConstraints();
		gbc_cbProduto.anchor = GridBagConstraints.NORTH;
		gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbProduto.gridwidth = 4;
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 3;
		panel.add(cbProduto, gbc_cbProduto);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 4;
		gbc_btnAdicionar.gridy = 4;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		tblCompra = new JTable();
		GridBagConstraints gbc_tblCompra = new GridBagConstraints();
		gbc_tblCompra.fill = GridBagConstraints.BOTH;
		gbc_tblCompra.insets = new Insets(0, 0, 5, 0);
		gbc_tblCompra.gridwidth = 8;
		gbc_tblCompra.gridx = 0;
		gbc_tblCompra.gridy = 5;
		panel.add(tblCompra, gbc_tblCompra);

		JLabel lblValorTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridwidth = 2;
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 6;
		panel.add(lblValorTotal, gbc_lblValorTotal);

		txtVlrTotal = new JTextField();
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTotal.gridx = 2;
		gbc_txtVlrTotal.gridy = 6;
		panel.add(txtVlrTotal, gbc_txtVlrTotal);
		txtVlrTotal.setColumns(10);

		JLabel lblValorPagamento = new JLabel("Valor Pagamento");
		GridBagConstraints gbc_lblValorPagamento = new GridBagConstraints();
		gbc_lblValorPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagamento.gridwidth = 2;
		gbc_lblValorPagamento.gridx = 0;
		gbc_lblValorPagamento.gridy = 7;
		panel.add(lblValorPagamento, gbc_lblValorPagamento);

		txtVlrPagamento = new JTextField();
		GridBagConstraints gbc_txtVlrPagamento = new GridBagConstraints();
		gbc_txtVlrPagamento.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrPagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrPagamento.gridx = 2;
		gbc_txtVlrPagamento.gridy = 7;
		panel.add(txtVlrPagamento, gbc_txtVlrPagamento);
		txtVlrPagamento.setColumns(10);

		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 1;
		gbc_lblTroco.gridy = 8;
		panel.add(lblTroco, gbc_lblTroco);

		txtTroco = new JTextField();
		GridBagConstraints gbc_txtTroco = new GridBagConstraints();
		gbc_txtTroco.anchor = GridBagConstraints.NORTH;
		gbc_txtTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTroco.insets = new Insets(0, 0, 5, 5);
		gbc_txtTroco.gridx = 2;
		gbc_txtTroco.gridy = 8;
		panel.add(txtTroco, gbc_txtTroco);
		txtTroco.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTH;
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 9;
		panel.add(btnCancelar, gbc_btnCancelar);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTH;
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.gridx = 7;
		gbc_btnSalvar.gridy = 9;
		panel.add(btnSalvar, gbc_btnSalvar);
	}

	void preencheLista() throws SQLException {

		VendaDao vdao = new VendaDao();
		ClienteDao cdao = new ClienteDao();

		vdao.listarProdutos(listaProd);
		cdao.listarCLiente(listaCli);

	}

	void configuraManua() {

		model = new TabelaModel();
		tblCompra.setModel(model);
	}

}
