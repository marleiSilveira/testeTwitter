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
import br.com.prjtwitter.entidade.Tweet;
import br.com.prjtwitter.persistencia.jdbc.HashtagDAO;
import br.com.prjtwitter.persistencia.jdbc.TweetDAO;

/**
 * Servlet implementation class TweetsController
 * @author Marlei M. Silveira
 */
@WebServlet("/TweetsController")
public class TweetsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * http://localhost:8080/prjTwitter/TweetsController?operacao=<Operacao>&id=<Id>
	 * Operacoes: 
	 *     "exc" - Excluir tweet
     *     "ext" - Excluir todos os Tweets
	 *     "lis" - Listar todas os Tweets
	 *     "lih" - Listar todas os Tweets de uma determinada Hashtag
	 *     "alt" - Alterar Tweet
	 * Id: Identificador unico do Tweet no DB
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		if (operacao.equals("exc")){
			//Excluir Tweet
			String id      = request.getParameter("id");
			TweetDAO tweetDAO = new TweetDAO(); 
			tweetDAO.delete(Integer.parseInt(id));      
			//response.getWriter().print("excluido com sucesso");
			response.sendRedirect("TweetsController?operacao=lis"); //recarrega a tela
			
		}else if(operacao.equals("ext")){
			//Excluir todos os Tweets
			TweetDAO tweetDAO = new TweetDAO(); 
			tweetDAO.deleteAll();      
			//response.getWriter().print("excluido com sucesso");
			response.sendRedirect("TweetsController?operacao=lis"); //recarrega a tela			
		
		}else if (operacao.equals("lis")){
			//listar todos os Tweets
			TweetDAO tweetDAO = new TweetDAO();  
			List<Tweet> listaTweets = tweetDAO.buscarTudo(); 
			//response.getWriter().print(listaHash);
			request.setAttribute("lisTweets", listaTweets);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listaTweets.jsp");
			dispatcher.forward(request, response);
			
		}else if (operacao.equals("lih")){
			//listar todos os Tweets de determinada Hashtag
			String id_hashtag      = request.getParameter("id");
			TweetDAO tweetDAO = new TweetDAO();  
			List<Tweet> listaTweets = tweetDAO.buscarPorHashtag(Integer.parseInt(id_hashtag)); 
			//response.getWriter().print(listaHash);
			request.setAttribute("lisTweets", listaTweets);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listaTweets.jsp");
			dispatcher.forward(request, response);
		}else if (operacao.equals("alt")){
			//Alterar hashtag
			String id      = request.getParameter("id");
			
			TweetDAO tweetDAO = new TweetDAO(); 		
			Tweet tweet = tweetDAO.buscarPorId(Integer.parseInt(id));
			request.setAttribute("twe", tweet);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formTweets.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recebe o retorno do formulario 
		String id            = request.getParameter("id"); 
		String id_hashtag    = request.getParameter("id_hashtag");
		String msn           = request.getParameter("msn");
		String autor         = request.getParameter("autor");
		String data_post     = request.getParameter("data_post");
		String data_pesquisa = request.getParameter("data_pesquisa");
		
		//monta objeto Tweet
		Tweet tweet = new Tweet();
		if (id != null && id != ""){
			tweet.setId(Integer.parseInt(id));
		}
		
		if (id_hashtag  != null && id != "") {
			tweet.setId_hashtag(Integer.parseInt(id_hashtag));
		}
		
		tweet.setMsn(msn);
		tweet.setAutor(autor);
	 //tweet.setData_post(data_post); 
	//----	tweet.setData_pesquisa(data_pesquisa);
		
		//grava no DB
		TweetDAO tweetDAO = new TweetDAO(); 
		tweetDAO.salvar(tweet);
		
		//response.getWriter().print("Hashtag Salva");
		response.sendRedirect("TweetsController?operacao=lis"); //recarrega a tela		

	}

}
