package br.univel.enun;

public enum Uf {

	PR("Paraná"), SC("Santa Catarian"), SP("São Paulo"), RS("Rio Grande do Sul"), RJ(
			"Rio de Janeiro");

	private String uf;

	Uf(String uf) {
		this.uf = uf;
	}

	public String getUf() {
		return uf;
	}

}
