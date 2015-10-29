package br.univel.controller;

import br.univel.dao.ClienteDao;
import br.univel.enun.Genero;
import br.univel.enun.Uf;
import br.univel.model.Cliente;

public class ClienteController extends Cliente {


	public void salvar(int id, String nome, String endereco, String cidade,
			Uf estado, String email, Genero genero) {

		ClienteController cc = new ClienteController();
		
		cc.setId(id);
		cc.setNome(nome);
		cc.setEndereco(endereco);
		cc.setCidade(cidade);
		cc.setEstado(estado);
		cc.setEmail(email);
		cc.setGenero(genero);
		
		
		new ClienteDao().inserir(cc);
		
	}

}
