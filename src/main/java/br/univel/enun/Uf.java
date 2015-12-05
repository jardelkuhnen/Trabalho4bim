package br.univel.enun;

public enum Uf {

	AP(0, "Amap�"),
	AM(1, "Amazonas"),
	BA(2, "Bahia"),
	CE(3, "Cear�"),
	DF(4, "Distrito Federal"),
	ES(5, "Esp�rito Santo"),
	GO(6, "Goi�s"),
	MA(7, "Maranh�o"),
	MT(8, "Mato Grosso"),
	MS(9, "Mato Grosso do Sul"),
	MG(10, "Minas Gerais"),
	PA(11, "Par�"),
	PB(12, "Para�ba"),
	PR(13, "Paran�"),
	PE(14, "Pernambuco"),
	PI(15, "Piau�"),
	RJ(16, "Rio de Janeiro"),
	RN(17, "Rio Grande do Norte"),
	RS(18, "Rio Grande do Sul"),
	RO(19, "Rond�nia"),
	RR(20, "Roraima"),
	SC(21, "Santa Catarina"),
	SP(22, "S�o Paulo"),
	SE(23, "Sergipe"),
	TO(24, "Tocantins");


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
