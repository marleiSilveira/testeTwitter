package br.com.prjtwitter.entidade;

/**
 * Classe Entidade GrupoHashtag  
 * @author Marlei M. Silveira
 *
 */
public class GrupoHashtag {
	   private int id;
	   private int id_hashtag;
	   private int id_config; 
	   private String descricao;
	   
	   
	/**
	 * Construtor destinado ao uso com o metodo Insert   
	 * @param id
	 * @param id_hashtag
	 * @param id_config
	 * @param descricao
	 */
	public GrupoHashtag(int id, int id_hashtag, int id_config, String descricao) {
		setId(id);
		setId_hashtag(id_hashtag);
		setId_config(id_config);
		setDescricao(descricao);
	}

	/**
	 * Construtor destinao ao uso com o metodo Update
	 * @param id_hashtag
	 * @param id_config
	 * @param descricao
	 */
	public GrupoHashtag(int id_hashtag, int id_config, String descricao) {
		setId_hashtag(id_hashtag);
		setId_config(id_config);
		setDescricao(descricao);
	}	
	
	/**
	 * Construtor default
	 */
	public GrupoHashtag() {

	}

	/**
	 * Identificador unico do Grupo de Hashtags no DB
	 * @return id (int)
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Identificador unico do Grupo de Hashtags no DB
	 * @param id (int)
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Identificador unico da Hashtag no DB (FK)
	 * @return id_hashtag (int)
	 */
	public int getId_hashtag() {
		return id_hashtag;
	}
	
	/**
	 * Identificador unico da Hashtag no DB (FK)
	 * @param id_hashtag (int)
	 */
	public void setId_hashtag(int id_hashtag) {
		this.id_hashtag = id_hashtag;
	}
	
	/**
	 * Identificador unico da Config no DB (FK)
	 * @return id_config (int)
	 */
	public int getId_config() {
		return id_config;
	}
	
	/**
	 * Identificador unico da Config no DB (FK)
	 * @param id_config (int)
	 */
	public void setId_config(int id_config) {
		this.id_config = id_config;
	}
	
	/**
	 * Descricao do grupo de hashtags
	 * @return descricao (String)
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Descricao do grupo de hashtags
	 * @param descricao (String)
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "GrupoHashtag [id=" + id + ", id_hashtag=" + id_hashtag
				+ ", id_config=" + id_config + ", descricao=" + descricao + "]";
	} 
	
	
}
