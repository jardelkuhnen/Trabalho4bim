package br.univel.model;

public enum Genero {

	Moveis("M�veis"), Eletrodom�sticos("Eletrodom�sticos"), Eletr�nicos(
			"Eletr�nicos");

	private String genero;

	Genero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
