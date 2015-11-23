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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class RelProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	public RelProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{63, 67, 175, 65, 0};
		gbl_contentPane.rowHeights = new int[]{35, 22, 35, 23, 35, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblRelatrioDeClientes = new JLabel("Relat\u00F3rio de Produtos");
		lblRelatrioDeClientes.setForeground(new Color(0, 0, 128));
		lblRelatrioDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblRelatrioDeClientes = new GridBagConstraints();
		gbc_lblRelatrioDeClientes.anchor = GridBagConstraints.NORTH;
		gbc_lblRelatrioDeClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelatrioDeClientes.gridwidth = 4;
		gbc_lblRelatrioDeClientes.gridx = 0;
		gbc_lblRelatrioDeClientes.gridy = 1;
		contentPane.add(lblRelatrioDeClientes, gbc_lblRelatrioDeClientes);
		
		JLabel lblMargemLucro = new JLabel("Margem Lucro");
		GridBagConstraints gbc_lblMargemLucro = new GridBagConstraints();
		gbc_lblMargemLucro.anchor = GridBagConstraints.WEST;
		gbc_lblMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemLucro.gridx = 1;
		gbc_lblMargemLucro.gridy = 3;
		contentPane.add(lblMargemLucro, gbc_lblMargemLucro);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		
		JButton btnBuscaLucro = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaLucro = new GridBagConstraints();
		gbc_btnBuscaLucro.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaLucro.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscaLucro.gridx = 3;
		gbc_btnBuscaLucro.gridy = 3;
		contentPane.add(btnBuscaLucro, gbc_btnBuscaLucro);
		
		JLabel lblEstado = new JLabel("Categoria");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		contentPane.add(lblEstado, gbc_lblEstado);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnBuscaCategoria = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaCategoria = new GridBagConstraints();
		gbc_btnBuscaCategoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaCategoria.gridx = 3;
		gbc_btnBuscaCategoria.gridy = 5;
		contentPane.add(btnBuscaCategoria, gbc_btnBuscaCategoria);
	}

}
