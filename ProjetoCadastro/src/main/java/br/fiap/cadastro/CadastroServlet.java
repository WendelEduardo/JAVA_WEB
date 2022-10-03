package br.fiap.cadastro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");		
		
		request.setAttribute("nomeServlet", nome);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("exibir.jsp");
		
		dispatcher.forward(request, response);
	}

}
