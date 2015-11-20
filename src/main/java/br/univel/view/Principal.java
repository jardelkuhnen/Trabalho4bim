package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;

import br.univel.model.TabelaModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class Principal extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	

	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setPreferredSize(new Dimension(640, 480));
		setTitle("Mobili");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCadastros = new JMenuItem("Cliente");
		mntmCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadCliente cdCliente = new CadCliente();
				cdCliente.setVisible(true);
				cdCliente.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmCadastros);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadUsuario cadUsuario = new CadUsuario();
				cadUsuario.setVisible(true);
				cadUsuario.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmUsurio);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
				cadProduto.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmProduto);

		JMenu mnVenda = new JMenu("Lan\u00E7amentos");
		menuBar.add(mnVenda);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadVenda TVenda = new CadVenda();
				TVenda.setVisible(true);
				TVenda.setLocationRelativeTo(null);
				TVenda.configuraManual();

			}
		});
		mnVenda.add(mntmVenda);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mnRelatrios.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Produto");
		mnRelatrios.add(mntmNewMenuItem_1);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}


}
