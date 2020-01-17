/**
 * 
 */
package br.com.prjtwitter.testes;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.prjtwitter.entidade.GrupoHashtag;
import br.com.prjtwitter.persistencia.jdbc.ConexaoFactory;
import br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO;

/**
 * @author Marlei M. Silveira
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GrupoHashtagDAOtest {

	private Connection conexao = ConexaoFactory.getConnection();
	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO#insert(br.com.prjtwitter.entidade.GrupoHashtag)}.
	 */
	@Test
	public void a_testInsert() {
		GrupoHashtag grupoHashtag = new GrupoHashtag(1,1,"Pol�tica"); 
		GrupoHashtagDAO  grupoHashtagDAO = new GrupoHashtagDAO(this.conexao); 
		boolean testReturn = grupoHashtagDAO.insert(grupoHashtag); 
		assertEquals(true, testReturn);
		
		grupoHashtag = new GrupoHashtag(1,1,"Guerras no mundo");  
		boolean testReturn2 = grupoHashtagDAO.insert(grupoHashtag); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO#update(br.com.prjtwitter.entidade.GrupoHashtag)}.
	 */
	@Test
	public void b_testUpdate() {
		GrupoHashtag grupoHashtag = new GrupoHashtag(1, 1, 1, "Desastres ambientais"); 
		GrupoHashtagDAO  grupoHashtagDAO = new GrupoHashtagDAO(this.conexao); 
		boolean testReturn = grupoHashtagDAO.update(grupoHashtag); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO#delete(int)}.
	 */
	@Test
	public void c_testDelete() {
		GrupoHashtagDAO  grupoHashtagDAO = new GrupoHashtagDAO(this.conexao); 
		boolean testReturn = grupoHashtagDAO.delete(2); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO#salvar(br.com.prjtwitter.entidade.GrupoHashtag)}.
	 */
	@Test
	public void d_testSalvar() {
		//testando insert a partir do metodo Salvar
		GrupoHashtag grupoHashtag = new GrupoHashtag(1,1,"Politica no Brasil");
		GrupoHashtagDAO  grupoHashtagDAO = new GrupoHashtagDAO(this.conexao); 
		boolean testReturn = grupoHashtagDAO.insert(grupoHashtag); 
		assertEquals(true, testReturn);
		
		//testando update a partir do metodo Salvar
		grupoHashtag = new GrupoHashtag(3,1,1,"Politica no Mundo"); 
		boolean testReturn2 = grupoHashtagDAO.update(grupoHashtag); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.GrupoHashtagDAO#buscarPorId(int)}.
	 */
	@Test
	public void e_testBuscarPorId() {
		GrupoHashtag grupoHashtag = new GrupoHashtag();
		GrupoHashtagDAO  grupoHashtagDAO = new GrupoHashtagDAO(this.conexao); 
		grupoHashtag = grupoHashtagDAO.buscarPorId(1);
		assertEquals("Desastres ambientais", grupoHashtag.getDescricao());
	}

}
