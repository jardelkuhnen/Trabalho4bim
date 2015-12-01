package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BuscaClienteModel extends AbstractTableModel {
	List<Cliente> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		if (lista == null)
			return 0;

		return lista.size();
	}

	public void incluir(List<Cliente> c) {
		this.lista = c;
		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Cliente c = lista.get(row);

		switch (col) {
		case 1:
			return c.getId();
		case 2:
			return c.getNome();
		default:
			break;
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Nome";

		default:
			break;
		}
		return " ";

	}

}
