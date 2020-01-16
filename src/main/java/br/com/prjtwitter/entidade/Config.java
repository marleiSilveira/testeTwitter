package br.com.prjtwitter.entidade;

/**
 * Classe Entidade Config
 * @author Marlei M. Silveira
 *
 */
public class Config {
	private int    id;
	private int    frequencia;            //frequencia de busca em horas 
	private String consumerKey;           //https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	private String consumerSecret;        //https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	private String accessToken;           //https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	private String accessTokenSecret;     //https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	private int    count;                 //quantidade de tweets que a query deve retornar (maximo 100)
	private String language;              //Idioma do tweet
	private double geoCodeLatitude;       //Latidute da localizacao geografica de interesse (pegar no google)
	private double geoCodeLogitude;       //Longitude da localizacao geografica de interesse (pegar no google)
	private double geoCodeRadius;         //raio a partir da localizacao geografica
	private String geoCodeUnit;           //Use "mi" for miles or "km" for kilometers
	private String since;                 //If specified, returns tweets with since the given date. Date should be formatted as YYYY-MM-DD
	private String until;                 //If specified, returns tweets with generated before the given date. Date should be formatted as YYYY-MM-DD
	
	
	

	/**
	 * Construtor default
	 */
	public Config() {
	}




	/**
	 * Construtor destinado para uso com o metodo Update 
	 * @param id
	 * @param frequencia
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 * @param count
	 * @param language
	 * @param geoCodeLatitude
	 * @param geoCodeLogitude
	 * @param geoCodeRadius
	 * @param geoCodeUnit
	 * @param since
	 * @param until
	 */
	public Config(int id, int frequencia, String consumerKey,
			String consumerSecret, String accessToken,
			String accessTokenSecret, int count, String language,
			double geoCodeLatitude, double geoCodeLogitude,
			double geoCodeRadius, String geoCodeUnit, String since, String until) {
		setId(id);
		setFrequencia(frequencia);
		setConsumerKey(consumerKey);
		setConsumerSecret(consumerSecret);
		setAccessToken(accessTokenSecret);
		setAccessTokenSecret(accessTokenSecret);
		setCount(count);
		setLanguage(language);
		setGeoCodeLatitude(geoCodeLatitude);
		setGeoCodeLogitude(geoCodeLogitude);
		setGeoCodeRadius(geoCodeRadius);
		setGeoCodeUnit(geoCodeUnit);
		setSince(since);
		setUntil(until);
	}

	/**
	 * Construtor destinado para uso com o metodo Insert
	 * @param frequencia
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 * @param count
	 * @param language
	 * @param geoCodeLatitude
	 * @param geoCodeLogitude
	 * @param geoCodeRadius
	 * @param geoCodeUnit
	 * @param since
	 * @param until
	 */
	public Config(int frequencia, String consumerKey,
			String consumerSecret, String accessToken,
			String accessTokenSecret, int count, String language,
			double geoCodeLatitude, double geoCodeLogitude,
			double geoCodeRadius, String geoCodeUnit, String since, String until) {
		setFrequencia(frequencia);
		setConsumerKey(consumerKey);
		setConsumerSecret(consumerSecret);
		setAccessToken(accessTokenSecret);
		setAccessTokenSecret(accessTokenSecret);
		setCount(count);
		setLanguage(language);
		setGeoCodeLatitude(geoCodeLatitude);
		setGeoCodeLogitude(geoCodeLogitude);
		setGeoCodeRadius(geoCodeRadius);
		setGeoCodeUnit(geoCodeUnit);
		setSince(since);
		setUntil(until);
	}

	/**
	 * identificador unico da configuracao no BD  
	 * @return id (int)
	 */
	public int getId() {
		return id;
	}




	/**
	 * identificador unico da configuracao no BD 
	 * @param id (int)
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * frequencia em minutos com a qual as buscas de tweets eh realizada
	 * @return frequencia (int)
	 */
	public int getFrequencia() {
		return frequencia;
	}




	/**
	 * frequencia em minutos com a qual as buscas de tweets eh realizada
	 * @param frequencia (int)
	 */
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}




	/**
	 * chave do usuario da aplicacao registrada no twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @return consumerKey (String)
	 */
	public String getConsumerKey() {
		return consumerKey;
	}




	/**
	 * chave do usuario da aplicacao registrada no twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @param consumerKey (String)
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}




	/**
	 * codigo de seguranca do usuario da aplicacao registrada no twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @return consumerSecret (String)
	 */
	public String getConsumerSecret() {
		return consumerSecret;
	}




	/**
	 * codigo de seguranca do usuario da aplicacao registrada no twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @param consumerSecret (String)
	 */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}




	/**
	 * Token de acesso da aplicacao registrada no Twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @return accessToken (String)	 
	 */
	public String getAccessToken() {
		return accessToken;
	}




	/**
	 * Token de acesso da aplicacao registrada no Twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @param accessToken (String)
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}




	/**
	 * Codigo de seguranca do token de acesso da aplicacao registrada no Twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @return accessTokenSecret (String)
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}




	/**
	 * Codigo de seguranca do token de acesso da aplicacao registrada no Twitter developer
	 * https://developer.twitter.com/en/apps/17236613 (keys and Tokens)
	 * @param accessTokenSecret (String)
	 */
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}




	/**
	 * Quantidade de resultados a serem retornados na busca 
	 * @return count (int)
	 */
	public int getCount() {
		return count;
	}




	/**
	 * Quantidade de resultados a serem retornados na busca 
	 * @param count (int)
	 */
	public void setCount(int count) {
		this.count = count;
	}




	/**
	 * Idioma dos tweets buscados (veja idiomas validos no site do Tweeter developer)
	 * @return language (String)
	 */
	public String getLanguage() {
		return language;
	}




	/**
	 * Idioma dos tweets buscados (veja idiomas validos no site do Tweeter developer)
	 * @param language (String)
	 */
	public void setLanguage(String language) {
		this.language = language;
	}




	/**
	 * Latitude da localizacao geografica a partir da qual se pretende buscar tweets
	 * @return geoCodeLatitude (double)
	 */
	public double getGeoCodeLatitude() {
		return geoCodeLatitude;
	}




	/**
	 * Latitude da localizacao geografica a partir da qual se pretende buscar tweets
	 * @param geoCodeLatitude (double)
	 */
	public void setGeoCodeLatitude(double geoCodeLatitude) {
		this.geoCodeLatitude = geoCodeLatitude;
	}




	/**
	 * Longitude da localizacao geografica a partir da qual se pretende buscar tweets
	 * @return geoCodeLogitude (double)
	 */
	public double getGeoCodeLogitude() {
		return geoCodeLogitude;
	}




	/**
	 * Longitude da localizacao geografica a partir da qual se pretende buscar tweets
	 * @param geoCodeLogitude (double)
	 */
	public void setGeoCodeLogitude(double geoCodeLogitude) {
		this.geoCodeLogitude = geoCodeLogitude;
	}




	/**
	 * Raio a partir do ponto geografico da busca
	 * @return double
	 */
	public double getGeoCodeRadius() {
		return geoCodeRadius;
	}




	/**
	 * Raio a partir do ponto geografico da busca
	 * @param geoCodeRadius (double)
	 */
	public void setGeoCodeRadius(double geoCodeRadius) {
		this.geoCodeRadius = geoCodeRadius;
	}




	/**
	 * Unidade de medida do raio da busca (km - Kilometros; mi - Milhas)
	 * @return geoCodeUnit (String)
	 */
	public String getGeoCodeUnit() {
		return geoCodeUnit;
	}




	/**
	 * Unidade de medida do raio da busca (km - Kilometros; mi - Milhas)
	 * @param geoCodeUnit (String)
	 */
	public void setGeoCodeUnit(String geoCodeUnit) {
		this.geoCodeUnit = geoCodeUnit;
	}




	/**
	 * Data inicial das mensagens  a considerar na busca (AAAA-MM-DD)
	 * @return since (String)
	 */
	public String getSince() {
		return since;
	}




	/**
	 * Data inicial das mensagens  a considerar na busca (AAAA-MM-DD)
	 * @param since (String)
	 */
	public void setSince(String since) {
		this.since = since;
	}




	/**
	 * Data limite das mensagens  a considerar na busca (AAAA-MM-DD)
	 * @return until (String)
	 */
	public String getUntil() {
		return until;
	}




	/**
	 * Data limite das mensagens  a considerar na busca (AAAA-MM-DD)
	 * @param until (String)
	 */
	public void setUntil(String until) {
		this.until = until;
	}





	@Override
	public String toString() {
		return "Config [id=" + id + ", frequencia=" + frequencia
				+ ", consumerKey=" + consumerKey + ", consumerSecret="
				+ consumerSecret + ", accessToken=" + accessToken
				+ ", accessTokenSecret=" + accessTokenSecret + ", count="
				+ count + ", language=" + language + ", geoCodeLatitude="
				+ geoCodeLatitude + ", geoCodeLogitude=" + geoCodeLogitude
				+ ", geoCodeRadius=" + geoCodeRadius + ", geoCodeUnit="
				+ geoCodeUnit + ", since=" + since + ", until=" + until + "]";
	}	
	
	
}
