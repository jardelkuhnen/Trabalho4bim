package br.univel.controller;

import java.math.BigDecimal;

import br.univel.enun.Genero;
import br.univel.enun.Unidade;
import br.univel.model.Produto;
import br.univel.dao.ProdutoDao;

public class ProdutoContoller extends Produto {

	public void salvar(int id, int codBarras, Genero genero,
			String descricao, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		ProdutoContoller pp = new ProdutoContoller();

		pp.setId(id);
		pp.setCodBarras(codBarras);
		pp.setDescricao(descricao);
		pp.setGenero(genero);
		pp.setUnidade(unidade);
		pp.setCusto(custo);
		pp.setMargemLucro(margemLucro);

		new ProdutoDao().inserir(pp);
	}

	public void editar(int id, int codBarras, Genero genero,
			String descricao, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		Produto p = new Produto();
		p.setId(id);
		p.setCodBarras(codBarras);
		p.setDescricao(descricao);
		p.setGenero(genero);
		p.setUnidade(unidade);
		p.setCusto(custo);
		p.setMargemLucro(margemLucro);

		new ProdutoDao().editar(id, codBarras, genero, descricao, unidade,
				custo, margemLucro);

	}

	public void deletar(int id) {

		Produto pp = new ProdutoDao().deletar(id);
		
	}

}
