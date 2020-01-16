package br.com.prjtwitter.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prjtwitter.entidade.Config;
import br.com.prjtwitter.entidade.Config;
import br.com.prjtwitter.entidade.Hashtag;
import br.com.prjtwitter.persistencia.jdbc.ConfigDAO;
import br.com.prjtwitter.persistencia.jdbc.ConfigDAO;
import br.com.prjtwitter.persistencia.jdbc.HashtagDAO;

/**
 * Servlet implementation class ConfigController
 * @author Marlei M. Silveira
 */
@WebServlet("/ConfigController")
public class ConfigController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * http://localhost:8080/prjTwitter/ConfigController?operacao=<Operacao>&status=<Status>&id=<Id>
	 * Operacoes: 
	 *     "exc" - Excluir configuracao 
	 *     "lis" - Listar todas as configuracoes
	 *     "alt" - Alterar Configuracao 
	 *     "cad" - Cadastrar novo
	 * Status: 
	 *     "Running" - indica que o motor de buscas esta ativo 
	 *     "Stopped" - indica que o motor de buscas esta  parado
	 * Id: Identificador unico da configuracao no DB
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		String status = request.getParameter("status");
		if (operacao.equals("exc")){
			//Excluir configuracao
			String id      = request.getParameter("id");
			ConfigDAO configDAO = new ConfigDAO(); 
			configDAO.delete(Integer.parseInt(id));      
			response.sendRedirect("ConfigController?operacao=lis"); //recarrega a tela
					
		}else if (operacao.equals("lis")){
			//listar todas as configuracoes
			ConfigDAO configDAO = new ConfigDAO(); 
			List<Config> listaConfig = configDAO.buscarTudo(); 
			request.setAttribute("lisConfig", listaConfig);
			request.setAttribute("status", status);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listaConfig.jsp");
			dispatcher.forward(request, response);
		}else if (operacao.equals("alt")){
			//Alterar configuracao 
			String id      = request.getParameter("id");
			
			ConfigDAO configDAO = new ConfigDAO(); 		
			Config config = configDAO.buscarPorId(Integer.parseInt(id));
			request.setAttribute("con", config);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formConfig.jsp");
			dispatcher.forward(request, response);
		}if(operacao.equals("cad")){
			//Cadastrar novo 			
			Config config = new Config();
			request.setAttribute("con", config);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formConfig.jsp");
			dispatcher.forward(request, response);			
		}		
		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebe o retorno do formulario 
		String id      = request.getParameter("id"); 
		String frequencia = request.getParameter("frequencia");         
		String consumerKey = request.getParameter("consumerKey");      
		String consumerSecret = request.getParameter("consumerSecret"); 
		String accessToken = request.getParameter("accessToken");        
		String accessTokenSecret = request.getParameter("accessTokenSecret");  
		String count = request.getParameter("count");                    
		String language = request.getParameter("language");                
		String geoCodeLatitude = request.getParameter("geoCodeLatitude");
		String geoCodeLogitude = request.getParameter("geoCodeLogitude");
		String geoCodeRadius = request.getParameter("geoCodeRadius");  
		String geoCodeUnit = request.getParameter("geoCodeUnit");            
		String since = request.getParameter("since");                  
		String until = request.getParameter("until");                   

		
		//monta objeto Config
		Config config = new Config();
		config.setFrequencia(Integer.parseInt(frequencia));
		config.setConsumerKey(consumerKey);
		config.setConsumerSecret(consumerSecret);
		config.setAccessToken(accessToken);
		config.setAccessTokenSecret(accessTokenSecret);
		config.setCount(Integer.parseInt(count));
		config.setLanguage(language);
		config.setGeoCodeLatitude(Double.parseDouble(geoCodeLatitude));
		config.setGeoCodeLogitude(Double.parseDouble(geoCodeLogitude));
		config.setGeoCodeRadius(Double.parseDouble(geoCodeRadius));
		config.setGeoCodeUnit(geoCodeUnit);
		config.setSince(since);
		config.setUntil(until);
		
		if (id != null && id != ""){
			config.setId(Integer.parseInt(id));
		}
		

		//grava no DB
		ConfigDAO configDAO = new ConfigDAO(); 
		configDAO.salvar(config);
		
		//recarrega a tela
		response.sendRedirect("ConfigController?operacao=lis"); 
		
		

		
	}

}
