package br.univel.enun;

public enum Uf {

	PR("Paran�"), SC("Santa Catarian"), SP("S�o Paulo"), RS("Rio Grande do Sul"), RJ(
			"Rio de Janeiro");

	private String uf;

	Uf(String uf) {
		this.uf = uf;
	}

	public String getUf() {
		return uf;
	}

}
