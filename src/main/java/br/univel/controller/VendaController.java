package br.univel.controller;

import java.sql.SQLException;
import java.util.List;

import br.univel.dao.VendaDao;
import br.univel.model.Produto;
import br.univel.model.Venda;

public class VendaController extends Venda{

	public void adicionarProduto(int nNota, String cliente, String descricao, int qtd) {

		
		VendaController vd = new VendaController();
		
		vd.setnNota(nNota);
		vd.setCliente(cliente);
		vd.setProduto(descricao);
		vd.setQtd(qtd);
		
		
		new VendaDao().inserirP(vd);

	}

}
