package br.univel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.univel.controller.ClienteController;
import br.univel.controller.ProdutoContoller;
import br.univel.enun.GeneroProd;
import br.univel.enun.Uf;
import br.univel.enun.Unidade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class CadProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	private JComboBox cbGenero;
	private JComboBox cbUnidade;
	private JTextField txtCodBarras;

	public CadProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 52, 82, 45, 61, 120, 0 };
		gbl_panel.rowHeights = new int[] { 30, 20, 32, 20, 20, 20, 20, 20, 20,
				20, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCadastroDeProduto = new JLabel("Cadastro de Produto");
		lblCadastroDeProduto.setFont(new Font("Tahoma",
				Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblCadastroDeProduto = new GridBagConstraints();
		gbc_lblCadastroDeProduto.anchor = GridBagConstraints.NORTH;
		gbc_lblCadastroDeProduto.insets = new Insets(0, 0, 5, 0);
		gbc_lblCadastroDeProduto.gridwidth = 4;
		gbc_lblCadastroDeProduto.gridx = 1;
		gbc_lblCadastroDeProduto.gridy = 1;
		panel.add(lblCadastroDeProduto, gbc_lblCadastroDeProduto);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 3;
		panel.add(lblId, gbc_lblId);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.anchor = GridBagConstraints.NORTH;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridwidth = 2;
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 3;
		panel.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cod. de Barras");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtCodBarras = new JTextField();
		GridBagConstraints gbc_txtCodBarras = new GridBagConstraints();
		gbc_txtCodBarras.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtCodBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodBarras.gridwidth = 2;
		gbc_txtCodBarras.gridx = 2;
		gbc_txtCodBarras.gridy = 4;
		panel.add(txtCodBarras, gbc_txtCodBarras);
		txtCodBarras.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		cbGenero = new JComboBox(GeneroProd.values());
		cbGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.anchor = GridBagConstraints.NORTHWEST;
		gbc_cbGenero.insets = new Insets(0, 0, 5, 0);
		gbc_cbGenero.gridwidth = 3;
		gbc_cbGenero.gridx = 2;
		gbc_cbGenero.gridy = 5;
		panel.add(cbGenero, gbc_cbGenero);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 6;
		panel.add(lblDescrio, gbc_lblDescrio);

		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridwidth = 3;
		gbc_txtDescricao.gridx = 2;
		gbc_txtDescricao.gridy = 6;
		panel.add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 1;
		gbc_lblUnidade.gridy = 7;
		panel.add(lblUnidade, gbc_lblUnidade);

		cbUnidade = new JComboBox(Unidade.values());
		GridBagConstraints gbc_cbUnidade = new GridBagConstraints();
		gbc_cbUnidade.anchor = GridBagConstraints.NORTH;
		gbc_cbUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_cbUnidade.gridwidth = 3;
		gbc_cbUnidade.gridx = 2;
		gbc_cbUnidade.gridy = 7;
		panel.add(cbUnidade, gbc_cbUnidade);

		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 1;
		gbc_lblCusto.gridy = 8;
		panel.add(lblCusto, gbc_lblCusto);

		txtCusto = new JTextField();
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.anchor = GridBagConstraints.NORTH;
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 0);
		gbc_txtCusto.gridwidth = 3;
		gbc_txtCusto.gridx = 2;
		gbc_txtCusto.gridy = 8;
		panel.add(txtCusto, gbc_txtCusto);
		txtCusto.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha os campos corretamente !!!");
				} else {
					ProdutoContoller pp = new ProdutoContoller();

					int resposta = JOptionPane.showConfirmDialog(null,
							"Deseja excluir o produto de Id: "
									+ txtId.getText().trim() + " ?");
					if (resposta == JOptionPane.YES_OPTION) {
						pp.deletar(Integer.parseInt(txtId.getText().trim()));

					}
				}
				limparCampos();

			}
		});

		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.WEST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 1;
		gbc_lblMargemDeLucro.gridy = 9;
		panel.add(lblMargemDeLucro, gbc_lblMargemDeLucro);

		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.anchor = GridBagConstraints.NORTH;
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtMargemLucro.gridwidth = 3;
		gbc_txtMargemLucro.gridx = 2;
		gbc_txtMargemLucro.gridy = 9;
		panel.add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridwidth = 2;
		gbc_btnExcluir.gridx = 1;
		gbc_btnExcluir.gridy = 10;
		panel.add(btnExcluir, gbc_btnExcluir);

		JButton btnEdtar = new JButton("Editar");
		btnEdtar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					ProdutoContoller pp = new ProdutoContoller();

					GeneroProd genero = (GeneroProd) cbGenero.getSelectedItem();
					Unidade un = (Unidade) cbUnidade.getSelectedItem();
					BigDecimal custo = new BigDecimal(txtCusto.getText().trim());
					BigDecimal mgLucro = new BigDecimal(txtMargemLucro
							.getText().trim());

					pp.editar(Integer.parseInt(txtId.getText().trim()),
							Integer.parseInt(txtCodBarras.getText().trim()),
							txtDescricao.getText().trim(), genero, un, custo,
							mgLucro);

					limparCampos();

				}

			}
		});
		GridBagConstraints gbc_btnEdtar = new GridBagConstraints();
		gbc_btnEdtar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEdtar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdtar.gridx = 3;
		gbc_btnEdtar.gridy = 10;
		panel.add(btnEdtar, gbc_btnEdtar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					ProdutoContoller pp = new ProdutoContoller();

					Unidade un = (Unidade) cbUnidade.getSelectedItem();
					GeneroProd cat = (GeneroProd) cbGenero.getSelectedItem();
					BigDecimal custo = new BigDecimal(txtCusto.getText().trim());
					BigDecimal mgValor = new BigDecimal(txtMargemLucro
							.getText().trim());

					pp.salvar(Integer.parseInt(txtId.getText().trim()),
							Integer.parseInt(txtCodBarras.getText().trim()),
							cat, txtDescricao.getText().trim(), un, custo,
							mgValor);

					limparCampos();

				}

			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 10;
		panel.add(btnSalvar, gbc_btnSalvar);
	}

	void limparCampos() {
		txtId.setText("");
		txtCodBarras.setText("");
		txtDescricao.setText("");
		txtCusto.setText("");
		txtMargemLucro.setText("");
	}

	protected boolean validaCampos() {
		boolean valida;
		if (txtId.getText().equals("")) {
			valida = true;
		} else {
			valida = false;
		}
		return valida;

	}
}
