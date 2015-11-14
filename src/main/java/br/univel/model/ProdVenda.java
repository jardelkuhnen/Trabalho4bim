package br.univel.model;

public class ProdVenda {

	private String descricao;
	private int qtd;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public ProdVenda(String descricao, int qtd) {
		super();
		this.descricao = descricao;
		this.qtd = qtd;
	}

}
