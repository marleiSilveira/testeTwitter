package br.com.prjtwitter.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import br.com.prjtwitter.entidade.GrupoHashtag;
import br.com.prjtwitter.entidade.Hashtag;

/**
 * Classe de acesso ao Banco de Dados - Tabela TB_GrupoHashtag
 * @author Marlei M. Silveira
 *
 */

public class GrupoHashtagDAO {
	//pega conexao 
	private Connection conexao;
	
	
	
	public GrupoHashtagDAO(Connection conexao) {
		setConexao(conexao);
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Inserir GrupoHashtags no DB
	 * @param grupoHashtag (GrupoHashtag)
	 */
	public boolean insert(GrupoHashtag grupoHashtag){
		String sql = "insert into TB_grupo_Hashtags (id_hashtag, id_config, descricao) values (?, ?, ?)";
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, grupoHashtag.getId_hashtag());
			comandoSql.setInt(2, grupoHashtag.getId_config());
			comandoSql.setString(3, grupoHashtag.getDescricao());
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
	 * Alterar GrupoHashtag no DB
	 * @param grupoHashtag (GrupoHashtag)
	 */
	public boolean update(GrupoHashtag grupoHashtag) {
		String sql = "update TB_grupo_Hashtags set id_hashtag = ?, id_config = ?, descricao = ? where id = ?";
		
		try {
			//criando o comandoSQL
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, grupoHashtag.getId_hashtag());
			comandoSql.setInt(2, grupoHashtag.getId_config());
			comandoSql.setString(3, grupoHashtag.getDescricao());
			comandoSql.setInt(4, grupoHashtag.getId());
			
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
	 * Apagar GrupoHashtag do DB
	 * @param id (int)
	 */
	public boolean delete(int id){
		String sql = "delete from TB_grupo_Hashtags  where id = ?";

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
	 * Salvar GrupoHashtag, se Id = 0 entao insere no DB senao faz update 
	 * @param grupoHashtag (GrupoHashtag)
	 */
	public void salvar(GrupoHashtag grupoHashtag){
		if(grupoHashtag.getId() != 0){
			update(grupoHashtag);
		}else{
			insert(grupoHashtag);
		}
	}	
	
	/**
	 * Buscar GrupoHashtag por Id
	 * @param id (int)
	 * @return GrupoHashtag
	 */
	public GrupoHashtag buscarPorId(int id){
		GrupoHashtag grupoHashtag = new GrupoHashtag(); 
		String sql = "Select * from TB_grupo_Hashtags where id = ?";
		
		//criando o comandoSQL
		//try (PreparedStatement comandoSql = conexao.prepareStatement(sql)){
		try{ 
			PreparedStatement comandoSql = conexao.prepareStatement(sql);	
			comandoSql.setInt(1, id);

			//executando o camando SQL no banco
			ResultSet resultset = comandoSql.executeQuery();

			if(resultset.next()){	
				grupoHashtag.setId(resultset.getInt(1));
				grupoHashtag.setId_hashtag(resultset.getInt(2));
				grupoHashtag.setId_config(resultset.getInt(3));
				grupoHashtag.setDescricao(resultset.getString(4));
				return grupoHashtag;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	

}
