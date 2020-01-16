package br.com.prjtwitter.entidade;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * Classe Entidade Tweet
 * @author Marlei M. Silveira
 *
 */
public class Tweet {
	private int id; 
	private int id_hashtag;
	private String  msn_id;            // id do tweet 
	private String msn;                // texto do status
	private String autor;              // autor da mensagem/Status
	private String data_post;          // data do post
	private int retweet_count;         // quantas vezes a mensagem foi retweetada
	private int favorite_count;        // contagem aproximada de quantas vezes o Tweet foi marcado como favorito
	private Timestamp data_pesquisa; 
	
	

	/**
	 * Construtor destinado ao uso com o metodo Update
	 * @param id
	 * @param id_hashtag
	 * @param msn_id
	 * @param msn
	 * @param autor
	 * @param data_post
	 * @param retweet_count
	 * @param favorite_count
	 * @param data_pesquisa
	 */
	public Tweet(int id, int id_hashtag, String msn_id, String msn, String autor,
			String data_post, int retweet_count, int favorite_count,
			Timestamp data_pesquisa) {
		//super();
		this.setId(id);
		this.setId_hashtag(id_hashtag);
		this.setMsn_id(msn_id);
		this.setMsn(msn);
		this.setAutor(autor);
		this.setData_post(data_post);
		this.setRetweet_count(retweet_count);
		this.setFavorite_count(favorite_count);
		this.setData_pesquisa(data_pesquisa);
	}

	/**
	 * Construtor destinado ao uso com o metodo Insert
	 * @param id_hashtag
	 * @param msn_id
	 * @param msn
	 * @param autor
	 * @param data_post
	 * @param retweet_count
	 * @param favorite_count
	 * @param data_pesquisa
	 */
	public Tweet(int id_hashtag, String msn_id, String msn, String autor,
			String data_post, int retweet_count, int favorite_count,
			Timestamp data_pesquisa) {
		//super();
		this.setId_hashtag(id_hashtag);
		this.setMsn_id(msn_id);
		this.setMsn(msn);
		this.setAutor(autor);
		this.setData_post(data_post);
		this.setRetweet_count(retweet_count);
		this.setFavorite_count(favorite_count);
		this.setData_pesquisa(data_pesquisa);
	}
	
	/**
	 * Construtor default
	 */
	public Tweet() {
	}
	
	/**
	 * Indentificador unico do tweet no BD
	 * @return id (int)
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Indentificador unico do tweet no BD
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Identificador unico da hashtag no DB (chave estrangeira)
	 * @return id_hashtag (int)
	 */
	public int getId_hashtag() {
		return id_hashtag;
	}
	
	/**
	 * Identificador unico da hashtag no DB (chave estrangeira)
	 * @param id_hashtag (int)
	 */
	public void setId_hashtag(int id_hashtag) {
		this.id_hashtag = id_hashtag;
	}
	
	/**
	 * Status/mensagem do tweet
	 * @return msn (String)
	 */
	public String getMsn() {
		return msn;
	}
	
	/**
	 * Status/mensagem do tweet
	 * @param msn (String)
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	/**
	 * Autor do tweet
	 * @return autor (String)
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Autor do tweet
	 * @param autor (String)
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Data do tweet
	 * @return data_post (String)
	 */
	public String getData_post() {
		return data_post;
	}
	
	/**
	 * Data do tweet,  exemplo: Mon Jan 06 03:24:35 BRST 2020
	 * @param data_post (String)
	 */
	public void setData_post(String data_post) {
		this.data_post = data_post;
	}
	
	/**
	 * Data da ultima busca
	 * @return data_pesquisa (Timestamp)
	 */
	public Timestamp getData_pesquisa() {
		return data_pesquisa;
	}

	/**
	 * Data da ultima busca
	 * @param data_pesquisa (Timestamp)
	 */
	public void setData_pesquisa(Timestamp data_pesquisa) {
		this.data_pesquisa = data_pesquisa;
	}

	/**
	 * Id do Tweet
	 * @return msn_id (String)
	 */
	public String getMsn_id() {
		return msn_id;
	}

	/**
	 * Id do Tweet 
	 * @param msn_id (String)
	 */
	public void setMsn_id(String msn_id) {
		this.msn_id = msn_id;
	}

	/**
	 * Quantidade de vezes que o Tweet foi retweetado
	 * @return retweet_count (int)
	 */
	public int getRetweet_count() {
		return retweet_count;
	}

	/**
	 * Quantidade de vezes que o Tweet foi retweetado
	 * @param retweet_count (int)
	 */
	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	/**
	 * Quantidade aproximada de vezes em que o tweet foi marcado como favorito 
	 * @return favorite_count (int)
	 */
	public int getFavorite_count() {
		return favorite_count;
	}

	/**
	 * Quantidade aproximada de vezes em que o tweet foi marcado como favorito 
	 * @param favorite_count (int)
	 */
	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}	
	
	
	
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", id_hashtag=" + id_hashtag + ", msn="
				+ msn + ", autor=" + autor + ", data_post=" + data_post
				+ ", data_pesquisa=" + data_pesquisa + "]";
	} 
	



	
	

}
