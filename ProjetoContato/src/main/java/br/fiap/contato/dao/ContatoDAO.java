package br.fiap.contato.dao;

import java.sql.Date;
import java.sql.SQLException;

import br.fiap.contato.conexao.Conexao;
import br.fiap.contato.modelo.Contato;

public class ContatoDAO extends DAO {

	public void inserir(Contato contato) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();

		sql = "INSERT INTO java_contato VALUES(CONTATO_SEQUENCE.NEXTVAL, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getSenha());
			ps.setDate(4, Date.valueOf(contato.getDataNascimento()));

			ps.execute();
			ps.close();

			conexao.desconectar();

			System.out.println(contato + "\n Cadastrado");

		} catch (SQLException e) {
			System.out.println("Erro: \n" + e);
		}
	}

}
