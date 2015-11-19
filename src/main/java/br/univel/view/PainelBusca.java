package br.univel.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.univel.controller.ProdutoContoller;
import br.univel.dao.ProdutoDao;
import br.univel.exemplos.telabusca.Pet;
import br.univel.model.Produto;
import br.univel.model.ProdutoTabelaModel;

public class PainelBusca extends JPanel {
	private JTextField txtProduto;
	private JTable table;
	private Consumer<Produto> consumerOnOk;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public PainelBusca() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 38, 0 };
		gridBagLayout.rowHeights = new int[] { 14, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.WEST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 0);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 0;
		add(lblProduto, gbc_lblProduto);

		txtProduto = new JTextField();
		GridBagConstraints gbc_txtProduto = new GridBagConstraints();
		gbc_txtProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProduto.gridx = 0;
		gbc_txtProduto.gridy = 1;
		add(txtProduto, gbc_txtProduto);
		txtProduto.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// O WindowBuilder vai ignorar o código que está
		// dentro desses comentários:

		// $hide>>$
		configuraTela();
		// $hide<<$

	}

	private void configuraTela() {
		ProdutoTabelaModel model = new ProdutoTabelaModel();
		table.setModel(model);
		txtProduto.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						busca(txtProduto.getText().trim());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro ao buscar produtos!");
						e1.printStackTrace();
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					// Seleciona o primeiro item na tabela.
					table.getSelectionModel().setSelectionInterval(0, 0);
					// Transfere o foco pra frente.
					txtProduto.transferFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBusca.this.runnableOnCancel != null) {
						PainelBusca.this.runnableOnCancel.run();
					}
				}
			}
		});

	}

	public void setOnOk(Consumer<Produto> c) {
		this.consumerOnOk = c;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

	@Override
	public void setVisible(boolean arg0) {

		super.setVisible(arg0);

		// Depois que ficar visivel e terminar tudo
		// o que foi agendado para a EDT, solicita o
		// foco do teclado para o textField.
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				txtProduto.requestFocusInWindow();
			}
		});
	}

	private void busca(String palavra) throws SQLException {

		List<Produto> lista = buscaNoBanco(palavra);

		((ProdutoTabelaModel) table.getModel()).preencherResultado(lista);

	}

	private List<Produto> buscaNoBanco(String palavra) throws SQLException {
		List<Produto> produtoList;
		ProdutoDao pp = new ProdutoDao();
		pp.buscaDadosF2(palavra);

		return null;
	}
}
