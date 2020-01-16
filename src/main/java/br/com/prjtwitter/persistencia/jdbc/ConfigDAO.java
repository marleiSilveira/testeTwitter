package br.com.prjtwitter.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prjtwitter.entidade.Config;
import br.com.prjtwitter.entidade.Hashtag;

/**
 * Classe de acesso ao Banco de Dados - Tabela TB_Config
 * @author Marlei M. Silveira
 *
 */
public class ConfigDAO {
	//pega conexao 
	private Connection conexao = ConexaoFactory.getConnection();
	
	
	/**
	 * Inserir Config no DB
	 * @param config (Config)
	 */
	public boolean insert(Config config) {
		String sql = "insert into TB_config (frequencia, consumerKey, consumerSecret, accessToken, accessTokenSecret, "
				+ "count, language, geoCodeLatitude, geoCodeLogitude, geoCodeRadius, geoCodeUnit, since, until) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, config.getFrequencia());
			comandoSql.setString(2,config.getConsumerKey());
			comandoSql.setString(3, config.getConsumerSecret());
			comandoSql.setString(4, config.getAccessToken());
			comandoSql.setString(5, config.getAccessTokenSecret());
			comandoSql.setInt(6, config.getCount());
			comandoSql.setString(7, config.getLanguage());
			comandoSql.setDouble(8, config.getGeoCodeLatitude());
			comandoSql.setDouble(9, config.getGeoCodeLogitude());
			comandoSql.setDouble(10, config.getGeoCodeRadius());
			comandoSql.setString(11, config.getGeoCodeUnit());
			comandoSql.setString(12, config.getSince());
			comandoSql.setString(13, config.getUntil());
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
	 * Alterar Config no DB
	 * @param config (Config)
	 */
	public boolean update(Config config) {
		String sql = "update TB_config set frequencia = ?, consumerKey = ?, consumerSecret = ?, accessToken = ?, accessTokenSecret = ?, "
				+ " count = ?, language = ?, geoCodeLatitude = ?, geoCodeLogitude = ?, geoCodeRadius = ?, geoCodeUnit = ?, since = ?, until = ? where id = ?";
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, config.getFrequencia());
			comandoSql.setString(2,config.getConsumerKey());
			comandoSql.setString(3, config.getConsumerSecret());
			comandoSql.setString(4, config.getAccessToken());
			comandoSql.setString(5, config.getAccessTokenSecret());
			comandoSql.setInt(6, config.getCount());
			comandoSql.setString(7, config.getLanguage());
			comandoSql.setDouble(8, config.getGeoCodeLatitude());
			comandoSql.setDouble(9, config.getGeoCodeLogitude());
			comandoSql.setDouble(10, config.getGeoCodeRadius());
			comandoSql.setString(11, config.getGeoCodeUnit());
			comandoSql.setString(12, config.getSince());
			comandoSql.setString(13, config.getUntil());
			comandoSql.setInt(14, config.getId());
			
			//executando o camndo SQL no banco
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
	 * Apagar Config do DB
	 * @param id (int)
	 */
	public boolean delete(int id) {
		String sql = "delete from TB_config  where id = ?";

		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, id);
			
			//executando o camndo SQL no banco
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
	 * Buscar Config por Id
	 * @param id (int)
	 * @return config (Config)
	 */
	public Config buscarPorId(int id){
		Config config = new Config(); 
		String sql = "Select * from TB_Config where id = ?";
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, id);

			//executando o camndo SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			if(resultset.next()){	
				config.setId(resultset.getInt(1));
				config.setFrequencia(resultset.getInt(2));
				config.setConsumerKey(resultset.getString(3));
				config.setConsumerSecret(resultset.getString(4));
				config.setAccessToken(resultset.getString(5));
				config.setAccessTokenSecret(resultset.getString(6));
				config.setCount(resultset.getInt(7));
				config.setLanguage(resultset.getString(8));
				config.setGeoCodeLatitude(resultset.getDouble(9));
				config.setGeoCodeLogitude(resultset.getDouble(10));
				config.setGeoCodeRadius(resultset.getDouble(11));
				config.setGeoCodeUnit(resultset.getString(12));
				config.setSince(resultset.getString(13));
				config.setUntil(resultset.getString(14));
				return config;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;		
	}	
	
	
	/**
	 * Busca todas as configuracoes do DB
	 * @return lista de config (List<Config>)
	 */
	public List<Config> buscarTudo(){
		
		String sql = "Select * from TB_Config";
		
		List<Config> lista = new ArrayList<Config>();
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);	

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			lista.clear();
			while(resultset.next()){ //Posicionando o cursor no Resultset	
				Config config = new Config(); 
				config.setId(resultset.getInt(1));
				config.setFrequencia(resultset.getInt(2));
				config.setConsumerKey(resultset.getString(3));
				config.setConsumerSecret(resultset.getString(4));
				config.setAccessToken(resultset.getString(5));
				config.setAccessTokenSecret(resultset.getString(6));
				config.setCount(resultset.getInt(7));
				config.setLanguage(resultset.getString(8));
				config.setGeoCodeLatitude(resultset.getDouble(9));
				config.setGeoCodeLogitude(resultset.getDouble(10));
				config.setGeoCodeRadius(resultset.getDouble(11));
				config.setGeoCodeUnit(resultset.getString(12));
				config.setSince(resultset.getString(13));
				config.setUntil(resultset.getString(14));
				lista.add(config);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;		
	}	
	
	/**
	 * Salvar Config, se Id = 0 entao insere no DB senao faz update
	 * @param config
	 */
	public void salvar(Config config){
		if(config.getId() != 0){
			update(config);
		}else{
			insert(config);
		}
	}
}
