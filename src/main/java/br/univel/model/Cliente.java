package br.univel.model;

import br.univel.enun.Genero;
import br.univel.enun.Uf;

public class Cliente {

	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private Uf estado;
	private String email;

	public Cliente() {
		this.id = id;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getEstado() {
		return estado;
	}

	public void setEstado(Uf estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}
	
	

	
	
}
