package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.controller.VendaController;
import br.univel.dao.ClienteDao;
import br.univel.dao.VendaDao;
import br.univel.model.Cliente;
import br.univel.model.Produto;
import br.univel.model.TabelaModel;

public class CadVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNNota;
	private JTextField txtVlrTotal;
	private JTextField txtVlrPagamento;
	private JTextField txtTroco;
	private JComboBox cbProduto;
	private JComboBox cbCliente;
	private JTextField txtQuantidade;
	private JLabel lblVlrTotal;
	private JTable tblVenda;
	private TabelaModel model = new TabelaModel();
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
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		try {
			preencheLista();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao preencher lista de produtos");
			e2.printStackTrace();
		}

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 122, 4, 38, 146, 76, 33, 10, 62,
				23, 0 };
		gbl_panel.rowHeights = new int[] { 30, 20, 20, 22, 22, 23, 176, 20, 20,
				20, 32, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblvendas = new JLabel("***Vendas***");
		lblvendas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblvendas = new GridBagConstraints();
		gbc_lblvendas.anchor = GridBagConstraints.NORTH;
		gbc_lblvendas.insets = new Insets(0, 0, 5, 5);
		gbc_lblvendas.gridwidth = 9;
		gbc_lblvendas.gridx = 0;
		gbc_lblvendas.gridy = 1;
		panel.add(lblvendas, gbc_lblvendas);

		JLabel lblNmeroNota = new JLabel("N\u00FAmero Nota");
		GridBagConstraints gbc_lblNmeroNota = new GridBagConstraints();
		gbc_lblNmeroNota.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroNota.gridx = 0;
		gbc_lblNmeroNota.gridy = 2;
		panel.add(lblNmeroNota, gbc_lblNmeroNota);
		txtNNota = new JTextField();
		GridBagConstraints gbc_txtNNota = new GridBagConstraints();
		gbc_txtNNota.fill = GridBagConstraints.BOTH;
		gbc_txtNNota.insets = new Insets(0, 0, 5, 5);
		gbc_txtNNota.gridwidth = 6;
		gbc_txtNNota.gridx = 1;
		gbc_txtNNota.gridy = 2;
		panel.add(txtNNota, gbc_txtNNota);
		txtNNota.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 3;
		panel.add(lblCliente, gbc_lblCliente);

		cbCliente = new JComboBox(new Vector<Cliente>(listaCli));
		GridBagConstraints gbc_cbCliente = new GridBagConstraints();
		gbc_cbCliente.fill = GridBagConstraints.BOTH;
		gbc_cbCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbCliente.gridwidth = 6;
		gbc_cbCliente.gridx = 1;
		gbc_cbCliente.gridy = 3;
		panel.add(cbCliente, gbc_cbCliente);

		JLabel lblNewLabel = new JLabel("Produto");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		cbProduto = new JComboBox(new Vector<Produto>(listaProd));
		GridBagConstraints gbc_cbProduto = new GridBagConstraints();
		gbc_cbProduto.fill = GridBagConstraints.BOTH;
		gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbProduto.gridwidth = 6;
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 4;
		panel.add(cbProduto, gbc_cbProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 5;
		panel.add(lblQuantidade, gbc_lblQuantidade);

		txtQuantidade = new JTextField();
		GridBagConstraints gbc_txtQuantidade = new GridBagConstraints();
		gbc_txtQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantidade.gridwidth = 2;
		gbc_txtQuantidade.gridx = 1;
		gbc_txtQuantidade.gridy = 5;
		panel.add(txtQuantidade, gbc_txtQuantidade);
		txtQuantidade.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto p = (Produto) cbProduto.getSelectedItem();

			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionar.gridx = 7;
		gbc_btnAdicionar.gridy = 5;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		tblVenda = new JTable();
		tblVenda.setModel(model);
		GridBagConstraints gbc_tblVenda = new GridBagConstraints();
		gbc_tblVenda.fill = GridBagConstraints.BOTH;
		gbc_tblVenda.insets = new Insets(0, 0, 5, 0);
		gbc_tblVenda.gridwidth = 9;
		gbc_tblVenda.gridx = 0;
		gbc_tblVenda.gridy = 6;
		panel.add(tblVenda, gbc_tblVenda);

		JLabel lblValorTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.EAST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridwidth = 2;
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 7;
		panel.add(lblValorTotal, gbc_lblValorTotal);

		txtVlrTotal = new JTextField();
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.fill = GridBagConstraints.BOTH;
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTotal.gridwidth = 3;
		gbc_txtVlrTotal.gridx = 2;
		gbc_txtVlrTotal.gridy = 7;
		panel.add(txtVlrTotal, gbc_txtVlrTotal);
		txtVlrTotal.setColumns(10);

		JLabel lblValorPagamento = new JLabel("Vlr. Pagamento");
		GridBagConstraints gbc_lblValorPagamento = new GridBagConstraints();
		gbc_lblValorPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagamento.gridwidth = 2;
		gbc_lblValorPagamento.gridx = 0;
		gbc_lblValorPagamento.gridy = 8;
		panel.add(lblValorPagamento, gbc_lblValorPagamento);

		txtVlrPagamento = new JTextField();
		GridBagConstraints gbc_txtVlrPagamento = new GridBagConstraints();
		gbc_txtVlrPagamento.fill = GridBagConstraints.BOTH;
		gbc_txtVlrPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrPagamento.gridwidth = 3;
		gbc_txtVlrPagamento.gridx = 2;
		gbc_txtVlrPagamento.gridy = 8;
		panel.add(txtVlrPagamento, gbc_txtVlrPagamento);
		txtVlrPagamento.setColumns(10);

		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 0;
		gbc_lblTroco.gridy = 9;
		panel.add(lblTroco, gbc_lblTroco);

		txtTroco = new JTextField();
		GridBagConstraints gbc_txtTroco = new GridBagConstraints();
		gbc_txtTroco.fill = GridBagConstraints.BOTH;
		gbc_txtTroco.insets = new Insets(0, 0, 5, 5);
		gbc_txtTroco.gridwidth = 3;
		gbc_txtTroco.gridx = 2;
		gbc_txtTroco.gridy = 9;
		panel.add(txtTroco, gbc_txtTroco);
		txtTroco.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 11;
		panel.add(btnCancelar, gbc_btnCancelar);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				adicionarProduto();

			}
		});
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGravar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGravar.gridx = 7;
		gbc_btnGravar.gridy = 11;
		panel.add(btnGravar, gbc_btnGravar);

	}

	protected void adicionarProduto() {

		VendaController vd = new VendaController();

		Cliente c = (Cliente) cbCliente.getSelectedItem();
		Produto p = (Produto) cbProduto.getSelectedItem();
		String horaData = horaVenda();
		vd.gravarVenda(Integer.parseInt(txtNNota.getText().trim()),
				c.toString(), p.toString(),
				Integer.parseInt(txtQuantidade.getText().trim()), horaData);

		limparCampos();
	}

	private void limparCampos() {
		txtNNota.setText("");
		txtQuantidade.setText("");
		txtTroco.setText("");
		txtVlrPagamento.setText("");
		txtVlrTotal.setText("");

	}

	public String horaVenda() {
		String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String data1, hora1;

		java.util.Date agora = new java.util.Date();
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);

		String hCompleta = data1 + " " + hora1;
		return hCompleta;
	}

	void preencheLista() throws SQLException {

		VendaDao vdao = new VendaDao();
		ClienteDao cdao = new ClienteDao();

		vdao.listarProdutos(listaProd);
		cdao.listarCLiente(listaCli);

	}
}
