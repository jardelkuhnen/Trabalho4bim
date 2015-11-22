package br.univel.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

import br.univel.dao.VendaDao;
import br.univel.model.Produto;
import br.univel.model.Venda;

public class VendaController extends Venda {
	// Classe controller, que ir� controlar todas as movimenta�oes da venda,
	public void gravarVenda(int nNota, String cliente, String descricao,
			int qtd, BigDecimal vlrTotal, String dataHora) {

		VendaController vd = new VendaController();

		vd.setnNota(nNota);
		vd.setCliente(cliente);
		vd.setProduto(descricao);
		vd.setQtd(qtd);
		vd.setDataHora(dataHora);
		vd.setVlrTotal(vlrTotal);

		new VendaDao().inserirP(vd);

	}

}
