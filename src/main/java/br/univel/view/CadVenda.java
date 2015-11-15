package br.univel.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.controller.VendaController;
import br.univel.dao.ClienteDao;
import br.univel.dao.VendaDao;
import br.univel.model.Cliente;
import br.univel.model.Produto;
import br.univel.model.TabelaModel;
import br.univel.model.Venda;

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
	private TabelaModel model;
	private JTable tabela;

	List<Produto> listaProd = new ArrayList<Produto>();
	List<Cliente> listaCli = new ArrayList<Cliente>();
	List<Venda> listaProdVenda = new ArrayList<Venda>();

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
		gbl_panel.columnWidths = new int[] { 111, 25, 33, 37, 119, 50, 75, 16,
				77, 0 };
		gbl_panel.rowHeights = new int[] { 30, 20, 20, 20, 20, 23, 171, 20, 20,
				20, 23, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				adicionarProdutos();

			}
		});

		JLabel lblvendas = new JLabel("***Vendas***");
		lblvendas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblvendas = new GridBagConstraints();
		gbc_lblvendas.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblvendas.insets = new Insets(0, 0, 5, 5);
		gbc_lblvendas.gridx = 4;
		gbc_lblvendas.gridy = 1;
		panel.add(lblvendas, gbc_lblvendas);

		JLabel lblNmeroNota = new JLabel("Nota");
		GridBagConstraints gbc_lblNmeroNota = new GridBagConstraints();
		gbc_lblNmeroNota.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroNota.gridx = 0;
		gbc_lblNmeroNota.gridy = 2;
		panel.add(lblNmeroNota, gbc_lblNmeroNota);
		txtNNota = new JTextField();
		GridBagConstraints gbc_txtNNota = new GridBagConstraints();
		gbc_txtNNota.anchor = GridBagConstraints.NORTH;
		gbc_txtNNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNNota.insets = new Insets(0, 0, 5, 5);
		gbc_txtNNota.gridwidth = 3;
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
		gbc_cbCliente.anchor = GridBagConstraints.NORTH;
		gbc_cbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbCliente.gridwidth = 7;
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
		gbc_cbProduto.anchor = GridBagConstraints.NORTH;
		gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbProduto.gridwidth = 7;
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 4;
		panel.add(cbProduto, gbc_cbProduto);

		JLabel lblQuantidade = new JLabel("Qtd");
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
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionar.gridx = 8;
		gbc_btnAdicionar.gridy = 5;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		JScrollPane tabela = new JScrollPane();
		GridBagConstraints gbc_tabela = new GridBagConstraints();
		gbc_tabela.gridwidth = 9;
		gbc_tabela.insets = new Insets(0, 0, 5, 5);
		gbc_tabela.fill = GridBagConstraints.BOTH;
		gbc_tabela.gridx = 0;
		gbc_tabela.gridy = 6;
		panel.add(tabela, gbc_tabela);

		JLabel lblValorTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.EAST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 1;
		gbc_lblValorTotal.gridy = 7;
		panel.add(lblValorTotal, gbc_lblValorTotal);

		txtVlrTotal = new JTextField();
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTotal.gridwidth = 5;
		gbc_txtVlrTotal.gridx = 2;
		gbc_txtVlrTotal.gridy = 7;
		panel.add(txtVlrTotal, gbc_txtVlrTotal);
		txtVlrTotal.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravarVenda();
			}
		});

		JLabel lblValorPagamento = new JLabel("Vlr. Pagamento");
		GridBagConstraints gbc_lblValorPagamento = new GridBagConstraints();
		gbc_lblValorPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagamento.gridwidth = 2;
		gbc_lblValorPagamento.gridx = 0;
		gbc_lblValorPagamento.gridy = 8;
		panel.add(lblValorPagamento, gbc_lblValorPagamento);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});

		txtVlrPagamento = new JTextField();
		GridBagConstraints gbc_txtVlrPagamento = new GridBagConstraints();
		gbc_txtVlrPagamento.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrPagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrPagamento.gridwidth = 5;
		gbc_txtVlrPagamento.gridx = 2;
		gbc_txtVlrPagamento.gridy = 8;
		panel.add(txtVlrPagamento, gbc_txtVlrPagamento);
		txtVlrPagamento.setColumns(10);

		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.gridwidth = 2;
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 0;
		gbc_lblTroco.gridy = 9;
		panel.add(lblTroco, gbc_lblTroco);

		txtTroco = new JTextField();
		GridBagConstraints gbc_txtTroco = new GridBagConstraints();
		gbc_txtTroco.anchor = GridBagConstraints.NORTH;
		gbc_txtTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTroco.insets = new Insets(0, 0, 5, 5);
		gbc_txtTroco.gridwidth = 5;
		gbc_txtTroco.gridx = 2;
		gbc_txtTroco.gridy = 9;
		panel.add(txtTroco, gbc_txtTroco);
		txtTroco.setColumns(10);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 10;
		panel.add(btnCancelar, gbc_btnCancelar);
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGravar.anchor = GridBagConstraints.NORTH;
		gbc_btnGravar.gridwidth = 2;
		gbc_btnGravar.gridx = 7;
		gbc_btnGravar.gridy = 10;
		panel.add(btnGravar, gbc_btnGravar);

	}

	public void adicionarProdutos() {
		String produto = cbProduto.getSelectedItem().toString();
		int qtd = Integer.parseInt(txtQuantidade.getText());

		Venda v = new Venda();
		v.setDescricao(produto);
		v.setQtd(qtd);
		
		
		
		System.out.println(produto + " " + qtd);
		model.incluir(v);
		txtQuantidade.setText("");

	}

	protected void gravarVenda() {

		VendaController vd = new VendaController();

		Cliente c = (Cliente) cbCliente.getSelectedItem();
		Produto p = (Produto) cbProduto.getSelectedItem();
		String horaData = horaVenda();
		vd.gravarVenda(Integer.parseInt(txtNNota.getText().trim()),
				c.toString(), p.toString(),
				Integer.parseInt(txtQuantidade.getText().trim()), horaData);

		limparCampos();

	}

	protected void configuraManual() {

		model = new TabelaModel();
		tabela.setModel(model);

	}

	private void limparCampos() {
		txtNNota.setText("");
		txtQuantidade.setText("");
		txtTroco.setText("");
		txtVlrPagamento.setText("");
		txtVlrTotal.setText("");

	}

	public String horaVenda() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	void preencheLista() throws SQLException {

		VendaDao vdao = new VendaDao();
		ClienteDao cdao = new ClienteDao();

		vdao.listarProdutos(listaProd);
		cdao.listarCLiente(listaCli);

	}
}
