package br.univel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.dao.Conexao;

public class TabelaModel extends AbstractTableModel {

	private List<Produto> lista;

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int row, int col) {

		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			p.getCusto();
			break;

		default:
			break;
		}

		return null;
	}

	public void incluir(Produto p) {
		lista.add(p);
		super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Nome";
		case 1:
			return "Valor";
		default:
			return "Erro";

		}
	}
}
