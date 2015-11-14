package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModel extends AbstractTableModel {

	private List<ProdVenda> lista;

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int row, int col) {

		ProdVenda p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			p.getQtd();
			break;

		default:
			break;
		}

		return null;
	}

	public void incluir(ProdVenda p) {
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
