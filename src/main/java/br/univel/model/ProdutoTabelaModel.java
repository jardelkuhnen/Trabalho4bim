package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTabelaModel extends AbstractTableModel {

	private List<Produto> lista;

	public void preencherResultado(List<Produto> resultado) {
		this.lista = resultado;

		fireTableDataChanged();
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		if (lista == null) {
			return 0;
		}

		return lista.size();
	}

	public Object getValueAt(int row, int col) {

		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			return p.getQuantidade();
		case 2:
			return p.getCusto();

		default:
			return "Erro!";
		}

	}

	public void incluir(Produto p) {
		lista.add(p);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Produto";
		case 1:
			return "Quantidade";
		case 2:
			return "Valor Unitário";
		default:
			return "Erro";

		}
	}

	public void limparlista() {
		lista.clear();
	}

	public Produto getProdutoAt(int idx) {
		if (idx >= this.lista.size()) {
			return null;
		}
		return this.lista.get(idx);
	}
}
