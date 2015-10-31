package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		setTitle("Mobili");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 288);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCadastros = new JMenuItem("Cliente");
		mntmCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadCliente cdCliente = new CadCliente();
				cdCliente.setVisible(true);
			}
		});
		mnCadastros.add(mntmCadastros);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mnCadastros.add(mntmUsurio);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
			}
		});
		mnCadastros.add(mntmProduto);

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
