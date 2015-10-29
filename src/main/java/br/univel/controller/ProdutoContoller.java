package br.univel.controller;

import java.math.BigDecimal;

import br.univel.enun.Unidade;
import br.univel.model.Produto;
import br.univel.dao.ProdutoDao;

public class ProdutoContoller extends Produto {

	public void salvar(int id, int codBarras, String categoria,
			String descricao, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		ProdutoContoller pp = new ProdutoContoller();

		pp.setId(id);
		pp.setCodBarras(codBarras);
		pp.setDescricao(descricao);
		pp.setCategoria(categoria);
		pp.setUnidade(unidade);
		pp.setCusto(custo);
		pp.setMargemLucro(margemLucro);

		new ProdutoDao().inserir(pp);
	}

	public void editar(int id, int codBarras, String categoria,
			String descricao, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		Produto p = new Produto();
		p.setId(id);
		p.setCodBarras(codBarras);
		p.setDescricao(descricao);
		p.setCategoria(categoria);
		p.setUnidade(unidade);
		p.setCusto(custo);
		p.setMargemLucro(margemLucro);

		
		new ProdutoDao().editar(id, codBarras, categoria, descricao, unidade, custo, margemLucro);
		
	}

}
