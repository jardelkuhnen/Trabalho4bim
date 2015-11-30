package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BuscaClienteModel extends AbstractTableModel {
	List<Cliente> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	public void incluir(List<Cliente> lista2) {
		lista = lista2;
		super.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Cliente c = lista.get(row);

		switch (col) {
		case 1:
			return c.getNome();

		default:
			break;
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 1:
			return "Nome";

		default:
			break;
		}
		return null;

	}

}
