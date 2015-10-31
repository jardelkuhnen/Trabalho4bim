package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel {

	private List<Produto> lista = new ArrayList<Produto>();

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int row, int column) {

		Produto p = new Produto();

		switch (column) {
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
		super.fireTableDataChanged();
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
