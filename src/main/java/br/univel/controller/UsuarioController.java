package br.univel.controller;

import br.univel.dao.UsuarioDao;
import br.univel.model.Usuario;

public class UsuarioController extends Usuario {

	public void salvar(int idCliente, int idUs, String senha) {

		UsuarioController us = new UsuarioController();

		us.setIdCliente(idCliente);
		us.setIdUs(idUs);
		us.setSenha(senha);

		new UsuarioDao().inserir(us);
	}

	public void editar(int idCliente, int idUs, String senha) {

		Usuario u = new Usuario();

		u.setIdCliente(idCliente);
		u.setIdUs(idUs);
		u.setSenha(senha);

		new UsuarioDao().editar(idCliente, idUs, senha);

	}

	public void deletar(int idUs) {
		UsuarioDao us = new UsuarioDao().deletar(idUs);
	}

}
