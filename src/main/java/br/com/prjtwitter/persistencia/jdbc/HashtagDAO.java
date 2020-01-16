package br.com.prjtwitter.persistencia.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prjtwitter.entidade.Hashtag;

/**
 * Classe de acesso ao Banco de Dados - Tabela TB_Hashtag
 * @author Marlei M. Silveira
 *
 */
public class HashtagDAO {

	//pega conexao 
	private Connection conexao = ConexaoFactory.getConnection();
	
	
	/**
	 * Inserir Hashtag no DB
	 * @param hashtag (Hashtag)
	 * @return False se ocorrer erro no SQL
	 */
	public boolean insert(Hashtag hashtag) {
		String sql = "insert into TB_hashtag (hashtag, status) values (?, ?)";
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, hashtag.getHashtag());
			comandoSql.setBoolean(2, hashtag.isStatus());
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
	 * Alterar Hashtag no DB
	 * @param hashtag (Hashtag)
	 */
	public boolean update(Hashtag hashtag) {
		String sql = "update TB_hashtag set hashtag = ?, status = ? where id = ?";
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setString(1, hashtag.getHashtag());
			comandoSql.setBoolean(2, hashtag.isStatus());
			comandoSql.setInt(3, hashtag.getId());
			
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
	 * Apagar Haschtag do DB
	 * @param id (int)
	 */
	public boolean delete(int id) {
		String sql = "delete from TB_hashtag  where id = ?";

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
	 * Salvar Hashtag se Id = 0 entao insere no DB senao faz update
	 * @param hashtag
	 */
	public void salvar(Hashtag hashtag){
		if(hashtag.getId() != 0){
			update(hashtag);
		}else{
			insert(hashtag);
		}
	}
	
	
	/**
	 * Buscar todas as Hashtags do DB
	 * @param id (int)
	 * @return hashtag (Hashtag)
	 */
	public Hashtag buscarPorId(int id){
		Hashtag hashtag = new Hashtag(); 
		String sql = "Select * from TB_Hashtag where id = ?";
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, id);

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			if(resultset.next()){	
				hashtag.setId(resultset.getInt(1));
				hashtag.setHashtag(resultset.getString(2));
				hashtag.setStatus(resultset.getBoolean(3));
				return hashtag;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;		
	}
	
	/**
	 * Buscar todas as Hashtags do DB
	 * @return lista de hashtags (List<Hashtag>)
	 */
	public List<Hashtag> buscarTudo(){
		
		String sql = "Select * from TB_Hashtag";
		
		List<Hashtag> lista = new ArrayList<Hashtag>();
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);	

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			lista.clear();
			while(resultset.next()){ //Posicionando o cursor no Resultset	
				Hashtag hashtag = new Hashtag(); 
				hashtag.setId(resultset.getInt(1));
				hashtag.setHashtag(resultset.getString(2));
				hashtag.setStatus(resultset.getBoolean(3));
				lista.add(hashtag);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;		
	}	
	
}
