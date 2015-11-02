package br.univel.controller;

import br.univel.dao.ClienteDao;
import br.univel.enun.Genero;
import br.univel.enun.Uf;
import br.univel.model.Cliente;

public class ClienteController extends Cliente {

	public void salvar(int id, String nome, String endereco, String cidade,
			Uf estado, String email) {

		ClienteController cc = new ClienteController();

		cc.setId(id);
		cc.setNome(nome);
		cc.setEndereco(endereco);
		cc.setCidade(cidade);
		cc.setEstado(estado);
		cc.setEmail(email);

		new ClienteDao().inserir(cc);

	}

	public void editar(int id, String nome, String endereco, String cidade,
			Uf estado, String email) {

		Cliente c = new Cliente();
		c.setId(id);
		c.setNome(nome);
		c.setEndereco(endereco);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setEmail(email);

		new ClienteDao().editar(id, nome, endereco, cidade, estado, email);

	}

	public void deletar(int id) {
		ClienteDao cd = new ClienteDao();
		cd.deletar(id);
	}

	

}
