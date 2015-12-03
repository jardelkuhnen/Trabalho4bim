package br.univel.enun;

public enum Uf {

	PR(0, "Paran�"), 
	SC(1, "Santa Catarian"), 
	SP(2, "S�o Paulo"), 
	RS(3, "Rio Grande do Sul"), 
	RJ(4, "Rio de Janeiro");

	private String descricao;


	private Uf(Integer ordinal, String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}

}
