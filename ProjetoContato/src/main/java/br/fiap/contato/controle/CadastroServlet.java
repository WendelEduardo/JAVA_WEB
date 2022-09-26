package br.fiap.contato.controle;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.contato.dao.ContatoDAO;
import br.fiap.contato.modelo.Contato;
import br.fiap.contato.util.Util;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContatoDAO dao = new ContatoDAO();
		Util util = new Util();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = util.criptografar(request.getParameter("senha"));
		// String telefone = request.getParameter("fone");
		LocalDate data = util.formatarData(request.getParameter("data"));

		Contato contato = new Contato(nome, email, senha, data);
		dao.inserir(contato);

	}

}
