package br.univel.controller;

import java.sql.SQLException;
import java.util.List;

import br.univel.dao.VendaDao;
import br.univel.model.Produto;

public class VendaController {

	// metodo que ira adicionar todos produtos em uma lista
	public List<Produto> listarProdutos() throws SQLException {

		VendaDao vd = new VendaDao();
		return vd.listarProdutos();

	}

}
