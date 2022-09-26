package br.fiap.contato.modelo;

import java.time.LocalDate;

public class Contato {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private LocalDate dataNascimento;

	public Contato(String nome, String email, String senha, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Nome: " + nome;
		aux += "Email: " + email;
		aux += "Senha: " + senha;
		aux += "Data de Nascimento: " + dataNascimento + "\n";
		return aux;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}
