package br.com.prjtwitter.persistencia.jdbc;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prjtwitter.entidade.Tweet;

/**
 * Classe de acesso ao Banco de Dados - Tabela TB_Tweets
 * @author Marlei M. Silveira
 *
 */
public class TweetDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Inserir Tweet no DB
	 * @param tweet (Tweet)
	 */
	public boolean insert(Tweet tweet){
		String sql = "insert into TB_Tweets (id_hashtag, msn_id, msn, autor, data_post, retweet_count, favorite_count, data_pesquisa) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//criando o comandoSQL
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, tweet.getId_hashtag());
			comandoSql.setString(2, tweet.getMsn_id());
			comandoSql.setString(3, tweet.getMsn());
			comandoSql.setString(4, tweet.getAutor());
			comandoSql.setString(5,  tweet.getData_post());
			comandoSql.setInt(6, tweet.getRetweet_count()); 
			comandoSql.setInt(7, tweet.getFavorite_count()); 
			comandoSql.setTimestamp(8, tweet.getData_pesquisa());
			
		    //executando o camando SQL no banco
			comandoSql.execute(); 
			//fechando o objeto comandoSQL
			comandoSql.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true; 
	}
	
	/**
	 * Alterar Tweet no DB
	 * @param tweet (Tweet)
	 */
	public boolean update(Tweet tweet){
		String sql = "update TB_Tweets set id_hashtag = ?, msn_id = ?, msn = ?, autor = ?, data_post = ?, retweet_count = ?, favorite_count = ?, data_pesquisa = ?   where id = ?";
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, tweet.getId_hashtag());
			comandoSql.setString(2, tweet.getMsn_id());
			comandoSql.setString(3, tweet.getMsn());
			comandoSql.setString(4, tweet.getAutor());
			comandoSql.setString(5,  tweet.getData_post());
			comandoSql.setInt(6, tweet.getRetweet_count()); 
			comandoSql.setInt(7, tweet.getFavorite_count()); 
			comandoSql.setTimestamp(8, tweet.getData_pesquisa());
			comandoSql.setInt(9, tweet.getId());
			
			//executando o camando SQL no banco
			comandoSql.execute(); 
			//fechando o objeto comandoSQL
			comandoSql.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
		return true; 
	}

	/**
	 * Apagar Tweet do DB
	 * @param id (int)
	 */
	public boolean delete(int id) {
		String sql = "delete from TB_Tweets  where id = ?";

		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, id);
			
			//executando o camando SQL no banco
			comandoSql.execute(); 
			//fechando o objeto comandoSQL
			comandoSql.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
		return true; 
		
	}
	
	/**
	 * Apagar todos os Tweets do DB
	 */
	public boolean deleteAll() {
		String sql = "delete from TB_Tweets";

		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);

			//executando o camando SQL no banco
			comandoSql.execute(); 
			//fechando o objeto comandoSQL
			comandoSql.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
		return true; 
		
	}	
	
	/**
	 * Salvar Tweet, se Id = 0 entao insere no DB senao faz update
	 * @param tweet (Tweet)
	 */	
	public void salvar(Tweet tweet){
		if(tweet.getId() != 0){
			update(tweet);
		}else{
			insert(tweet);
		}
	}	
	
	/**
	 * Buscar Tweet por Id
	 * @param id (int)
	 * @return tweet (Tweet)
	 */
	public Tweet buscarPorId(int id){
		Tweet tweet = new Tweet(); 
		String sql = "Select * from TB_Tweets where id = ?";
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, id);

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			if(resultset.next()){	
				tweet.setId(resultset.getInt(1));
				tweet.setId_hashtag(resultset.getInt(2));
				tweet.setMsn_id(resultset.getString(3));
				tweet.setMsn(resultset.getString(4));
				tweet.setAutor(resultset.getString(5));
				tweet.setData_post(resultset.getString(6));
				tweet.setRetweet_count(resultset.getInt(7));
				tweet.setFavorite_count(resultset.getInt(8));
				tweet.setData_pesquisa(resultset.getTimestamp(9));
				return tweet;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;		
	}	
	
	/**
	 * Buscar todos os Tweets do DB
	 * @return lista de Tweets (List<Tweet>)
	 */
	public List<Tweet> buscarTudo(){
		
		String sql = "Select * from TB_tweets";
		
		List<Tweet> lista = new ArrayList<Tweet>();
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);	

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			lista.clear();
			while(resultset.next()){ //Posicionando o cursor no Resultset	
				Tweet tweet = new Tweet(); 
				tweet.setId(resultset.getInt(1));
				tweet.setId_hashtag(resultset.getInt(2));
				tweet.setMsn_id(resultset.getString(3));
				tweet.setMsn(resultset.getString(4));
				tweet.setAutor(resultset.getString(5));
				tweet.setData_post(resultset.getString(6));
				tweet.setRetweet_count(resultset.getInt(7));
				tweet.setFavorite_count(resultset.getInt(8));
				tweet.setData_pesquisa(resultset.getTimestamp(9));		
				lista.add(tweet);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;		
	}	
	
	/**
	 * Buscar todos os Tweets de determinada Hashtag
	 * @param id_hashtag (int)
	 * @return lista de Tweets (List<Tweet>)
	 */
	public List<Tweet> buscarPorHashtag(int id_hashtag){
		
		String sql = "Select * from TB_tweets where id_hashtag = ?";
		
		List<Tweet> lista = new ArrayList<Tweet>();
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1,id_hashtag);

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			lista.clear();
			while(resultset.next()){ //Posicionando o cursor no Resultset	
				Tweet tweet = new Tweet(); 
				tweet.setId(resultset.getInt(1));
				tweet.setId_hashtag(resultset.getInt(2));
				tweet.setMsn_id(resultset.getString(3));
				tweet.setMsn(resultset.getString(4));
				tweet.setAutor(resultset.getString(5));
				tweet.setData_post(resultset.getString(6));
				tweet.setRetweet_count(resultset.getInt(7));
				tweet.setFavorite_count(resultset.getInt(8));
				tweet.setData_pesquisa(resultset.getTimestamp(9));		
				lista.add(tweet);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;		
	}	
	
	
}
