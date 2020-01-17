package br.com.prjtwitter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.management.InstanceAlreadyExistsException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.prjtwitter.entidade.Config;
import br.com.prjtwitter.entidade.Hashtag;
import br.com.prjtwitter.entidade.Tweet;
import br.com.prjtwitter.persistencia.jdbc.ConexaoFactory;
import br.com.prjtwitter.persistencia.jdbc.ConfigDAO;
import br.com.prjtwitter.persistencia.jdbc.HashtagDAO;
import br.com.prjtwitter.persistencia.jdbc.TweetDAO;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Servlet implementation class SystemController
 * @author Marlei M. Silveira
 */
@WebServlet("/SystemController")
public class SystemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Timer timer = null; 
	private TimerTask timerTask = null; 
	
	private boolean timerTaskStatus = false; 
	
	private ConfigDAO configDAO = null; 
	private Config config = null;
	private Connection conexao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.conexao = ConexaoFactory.getConnection();
		configDAO = new ConfigDAO(this.conexao);
		config = configDAO.buscarPorId(1); 

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}
	
	/**
	 * http://localhost:8080/prjTwitter/SystemController?operacao=<Operacao>
	 * Operacoes: 
	 *     "run" - Inicia a busca automatica de Tweets 
	 *     "stop" - Para a busca automatica de Tweets
	 *     "test" - Executa a busca de tweets uma vez
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		//String frequencia = request.getParameter("frequencia");
		if (operacao.equals("run")){
		//Inicia a busca automatica de Tweets 	
			if (timer == null && timerTaskStatus == false) {
				timer = new Timer();
			    timerTask = new TimerTask() {
			    	@Override
			    	public void run() {
			        	Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
			        	System.out.println(dataDeHoje);
			        	timerTaskStatus = true; 
			        	//busca mensagens no Twitter e salva na tabela TB_tweets
			        	getTweets();
			    	}
			    };												
			}
			final long TEMPO = (1000 * 60 * config.getFrequencia()); //executa a cada <frequencia> minutos
			//final long TEMPO = (1000 * 1 * config.getFrequencia()); //executa a cada <frequencia> minutos
	        //final long TEMPO = (1000 * 5); //executa a cada 5 segundos
	        timer.scheduleAtFixedRate(timerTask, TEMPO, TEMPO);	
	        response.sendRedirect("ConfigController?operacao=lis&status=Running"); //recarrega a tela	
	        
		}else if (operacao.equals("stop")) {
		//Para a busca automatica de Tweets
			if (timerTaskStatus == true) {
				timerTask.cancel();
				timer = null;  
				timerTaskStatus = false; 
			}
 
			response.sendRedirect("ConfigController?operacao=lis&status=Stopped"); //recarrega a tela	
			
		}else if (operacao.equals("test")) {
        //busca mensagens no Twitter e salva na tabela TB_tweets
			if (timerTaskStatus == false) {
				getTweets();
			}

        	response.sendRedirect("ConfigController?operacao=lis"); //recarrega a tela	

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	/**
	 * Busca Tweets no Tweeter
	 */
	private void getTweets(){
		ConfigDAO configDAO = new ConfigDAO(this.conexao); 
		Config config = configDAO.buscarPorId(1); 
		
		ConfigurationBuilder cb = new ConfigurationBuilder(); 
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(config.getConsumerKey())
			.setOAuthConsumerSecret(config.getConsumerSecret())
			.setOAuthAccessToken(config.getAccessToken())
			.setOAuthAccessTokenSecret(config.getAccessTokenSecret());
		
		
		//System.out.println("Configuration Builder OK ");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		
		//System.out.println("Twitter Factory OK ");
		
		twitter4j.Twitter twitter = tf.getInstance(); 

		
		//Busca todas as Hashtags cadastradas
		HashtagDAO hashtagDao = new HashtagDAO(this.conexao); 
		List<Hashtag> listaHastag = hashtagDao.buscarTudo();
		for (Hashtag hashtag : listaHastag) {
			if (hashtag.isStatus() == true) { //se o Status da Hashtag for True, entao busca no Twitter
				try {
					//cria a busca com base nas hashtags
					System.out.println("Hashtag: " + hashtag.getHashtag());
					Query query = new Query();
					query.setQuery(hashtag.getHashtag() + " +exclude:retweets"); 
					
					query.setCount(config.getCount());
					
					GeoLocation geoLoc = new GeoLocation(config.getGeoCodeLatitude(), config.getGeoCodeLogitude());
		            query.setGeoCode(geoLoc, config.getGeoCodeRadius(), config.getGeoCodeUnit());
					query.setLang(config.getLanguage());
					query.setSince(config.getSince());
				    query.setUntil(config.getUntil());
					
					//Executa a busca no Twitter
					QueryResult result = twitter.search(query);
					List < Status > tweets = result.getTweets();
					
					TweetDAO tweetDAO = new TweetDAO(this.conexao); 
		        	Timestamp dataDaPesquisa = new Timestamp(System.currentTimeMillis());
		        	
					//System.out.println("Lista de tweets OK2 " + tweets.size()+" " + tweets.toString()) ;
					for (Status twt : tweets) {						
						Tweet tweet = new Tweet(hashtag.getId(),String.valueOf(twt.getId()), twt.getText(), twt.getUser().getName(), twt.getCreatedAt().toString(), twt.getRetweetCount(), twt.getFavoriteCount(),  dataDaPesquisa);
						tweetDAO.salvar(tweet);
					}
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
	
			

}
