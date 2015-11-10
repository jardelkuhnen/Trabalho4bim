package br.univel.view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Graphics2D;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import br.univel.controller.UsuarioController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Login fLogin;

			public void run() {
				try {
					fLogin = new Login();
					fLogin.setVisible(true);
					fLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 51, 0, 0, 281, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 21, 9, 28, 12, 12, 50, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblRf = new JLabel("Mobili");
		lblRf.setForeground(Color.RED);
		lblRf.setFont(new Font("Andalus", Font.PLAIN, 28));
		GridBagConstraints gbc_lblRf = new GridBagConstraints();
		gbc_lblRf.gridwidth = 5;
		gbc_lblRf.insets = new Insets(0, 0, 5, 0);
		gbc_lblRf.gridx = 0;
		gbc_lblRf.gridy = 0;
		panel.add(lblRf, gbc_lblRf);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioController uc = new UsuarioController();
				String msg = uc.logar(txtNome.getText(), txtSenha.getText());

				if (msg == "Usuário não cadastrado") {

					JOptionPane.showMessageDialog(null, msg);
				} else {
					limpaCampos();
					Principal p = new Principal();
					p.setVisible(true);
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 3;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 3;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.gridwidth = 3;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 5;
		panel.add(txtSenha, gbc_txtSenha);
		GridBagConstraints gbc_btnLogar = new GridBagConstraints();
		gbc_btnLogar.gridwidth = 5;
		gbc_btnLogar.gridx = 0;
		gbc_btnLogar.gridy = 6;
		panel.add(btnLogar, gbc_btnLogar);
	}

	public void limpaCampos() {
		txtNome.setText("");
		txtSenha.setText("");
	}

}
