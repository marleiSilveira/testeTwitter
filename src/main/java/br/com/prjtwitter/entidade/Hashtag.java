package br.com.prjtwitter.entidade;

/**
 * Classe Entidade Hashtag
 * @author Marlei M. Silveira
 *
 */
public class Hashtag {
	private int id; 
	private String hashtag;
	private boolean status;
	
	
	/**
	 * Construtor destinado ao uso com metodo Update
	 * @param id
	 * @param hashtag
	 * @param status
	 */
	public Hashtag(int id, String hashtag, boolean status) {
		//super();
		this.setId(id);
		this.setHashtag(hashtag);
		this.setStatus(status);
	}
	
	/**
	 * Contrutor destinado ao uso com o metodo Insert
	 * @param hashtag
	 * @param status
	 */
	public Hashtag(String hashtag, boolean status) {
		//super();
		this.setHashtag(hashtag);
		this.setStatus(status);
	}	
	
	/**
	 * Construtor default
	 */
	public Hashtag() {

	}	
	
	/**
	 * Identificador unico da Hashtag no DB
	 * @return id1 (int)
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Identificador unico da Hashtag no DB
	 * @param id (int)
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Hashtag
	 * @return hashtag (String)
	 */
	public String getHashtag() {
		return hashtag;
	}
	
	/**
	 * Hashtag
	 * @param hashtag (String)
	 */
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	/**
	 * Status da hashtag, quando false a hashtag nao eh buscada 
	 * @return status (boolean)
	 */
	public boolean isStatus() {
		return status;
	}
	
	/**
	 * Status da hashtag, quando false a hashtag nao eh buscada 
	 * @param status (boolean)
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", hashtag=" + hashtag + ", status="
				+ status + "]";
	} 
	
	

}
