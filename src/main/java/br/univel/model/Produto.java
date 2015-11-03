package br.univel.model;

import java.math.BigDecimal;

import br.univel.enun.Genero;
import br.univel.enun.Unidade;

public class Produto {

	private int id;
	private int codBarras;
	private String descricao;
	private Genero genero;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + "]";
	}

}
