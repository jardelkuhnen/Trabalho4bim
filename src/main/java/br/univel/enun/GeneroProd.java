package br.univel.enun;

public enum GeneroProd {

	Moveis("M�veis"), Eletrodom�sticos("Eletrodom�sticos"), Eletr�nicos(
			"Eletr�nicos");

	private String genero;

	GeneroProd(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
