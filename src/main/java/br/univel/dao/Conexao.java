package br.univel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private static final String URLBANCO = "jdbc:h2:~/ContatoJava";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private static final String USER = "sa";
	private static final String PASS = "sa";
	public static ResultSet rs;
	public java.sql.Statement stm;
	public Connection con;

	public static Connection getConnection() {

		System.out.println("Iniciando coneção ao banco de dados!!!");

		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URLBANCO, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void executaSql(String sql) {

		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,
					rs.CONCUR_READ_ONLY);

			rs = stm.executeQuery(sql);
		} catch (SQLException e) {

		}

	}

}
