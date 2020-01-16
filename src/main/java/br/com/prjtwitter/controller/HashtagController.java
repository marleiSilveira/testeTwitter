package br.com.prjtwitter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.prjtwitter.entidade.Hashtag;
import br.com.prjtwitter.persistencia.jdbc.HashtagDAO;

/**
 * Servlet implementation class HashtagController
 * @author Marlei M. Silveira
 */
@WebServlet("/HashtagController")
public class HashtagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	


	/**
	 * http://localhost:8080/prjTwitter/HashtagController?operacao=<Operacao>&id=<Id>
	 * Operacoes: 
	 *     "exc" - Excluir hashtag 
	 *     "lis" - Listar todas as hashtags 
	 *     "alt" - Alterar hashtag 
	 *     "cad" - Cadastrar novo
	 * Id: Identificadorunico da hashtag no DB
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("entrou");
		//System.out.println("entrou");
		String operacao = request.getParameter("operacao");
		if (operacao.equals("exc")){
			//Excluir hashtag
			String id      = request.getParameter("id");
			HashtagDAO hashDAO = new HashtagDAO(); 
			hashDAO.delete(Integer.parseInt(id));      
			//response.getWriter().print("excluido com sucesso");
			response.sendRedirect("HashtagController?operacao=lis"); //recarrega a tela
			
		}else if (operacao.equals("lis")){
			//listar todas as hashtags
			HashtagDAO hashDAO = new HashtagDAO(); 
			List<Hashtag> listaHash = hashDAO.buscarTudo(); 
			//response.getWriter().print(listaHash);
			request.setAttribute("lisHashtags", listaHash);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listaHashtags.jsp");
			dispatcher.forward(request, response);
			
		}else if (operacao.equals("alt")){
			//Alterar hashtag
			String id      = request.getParameter("id");
			
			HashtagDAO hashDAO = new HashtagDAO(); 		
			Hashtag hashtag = hashDAO.buscarPorId(Integer.parseInt(id));
			request.setAttribute("has", hashtag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formhashtag.jsp");
			dispatcher.forward(request, response);
			
		}else if(operacao.equals("cad")){
			//Cadastrar novo 
			//HashtagDAO hashDAO = new HashtagDAO(); 		
			Hashtag hashtag = new Hashtag();
			hashtag.setHashtag("");
			request.setAttribute("has", hashtag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formhashtag.jsp");
			dispatcher.forward(request, response);			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recebe o retorno do formulario 
		String id      = request.getParameter("id"); 
		String hashtag = request.getParameter("hashtag");
		String status  = request.getParameter("status"); 
		
		//monta objeto Hashtag
		Hashtag hash = new Hashtag();
		hash.setHashtag(hashtag);
		if (id != null && id != ""){
			hash.setId(Integer.parseInt(id));
		}
		
		if (status != null) {
			hash.setStatus(Boolean.parseBoolean(status));
		}
		
		//grava no DB
		HashtagDAO hashDAO = new HashtagDAO(); 
		hashDAO.salvar(hash);
		
		//response.getWriter().print("Hashtag Salva");
		response.sendRedirect("HashtagController?operacao=lis"); //recarrega a tela
	}
	
	
	

}
