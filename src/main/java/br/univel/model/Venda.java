package br.univel.model;

import java.math.BigDecimal;
import java.util.Date;

public class Venda {
	
	
	private int nNota;
	private String produto;
	private BigDecimal vlrTotal;
	private BigDecimal vlrPagamento;
	private BigDecimal vlrTroco;
	private Date dataHora;
	
	public int getnNota() {
		return nNota;
	}
	public void setnNota(int nNota) {
		this.nNota = nNota;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	public BigDecimal getVlrPagamento() {
		return vlrPagamento;
	}
	public void setVlrPagamento(BigDecimal vlrPagamento) {
		this.vlrPagamento = vlrPagamento;
	}
	public BigDecimal getVlrTroco() {
		return vlrTroco;
	}
	public void setVlrTroco(BigDecimal vlrTroco) {
		this.vlrTroco = vlrTroco;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	
	

}
