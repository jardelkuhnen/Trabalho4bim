package br.univel.model;

public enum Genero {

	Moveis("Móveis"), Eletrodomésticos("Eletrodomésticos"), Eletrônicos(
			"Eletrônicos");

	private String genero;

	Genero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
