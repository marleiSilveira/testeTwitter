/**
 * 
 */
package br.com.prjtwitter.testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.prjtwitter.entidade.Hashtag;
import br.com.prjtwitter.persistencia.jdbc.ConexaoFactory;
import br.com.prjtwitter.persistencia.jdbc.HashtagDAO;

/**
 * @author Marlei M. Silveira
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashtagDAOtest2 {

	private Connection conexao = ConexaoFactory.getConnection();
	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#insert(br.com.prjtwitter.entidade.Hashtag)}.
	 */
	@Test
	public void a_testInsert() {
		Hashtag hashtag = new Hashtag("#hashtagTest", false); 
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		boolean testReturn = hashtagDAO.insert(hashtag); 
		assertEquals(true, testReturn);
		
		hashtag = new Hashtag("#hashtagTest2", false);  
		boolean testReturn2 = hashtagDAO.insert(hashtag); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#update(br.com.prjtwitter.entidade.Hashtag)}.
	 */
	@Test
	public void b_testUpdate() {
		Hashtag hashtag = new Hashtag(1, "#hashtagTest1", false); 
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		boolean testReturn = hashtagDAO.update(hashtag); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#delete(int)}.
	 */
	@Test
	public void c_testDelete() {
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		boolean testReturn = hashtagDAO.delete(2); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#salvar(br.com.prjtwitter.entidade.Hashtag)}.
	 */
	@Test
	public void d_testSalvar() {
		//testando insert a partir do metodo Salvar
		Hashtag hashtag = new Hashtag("#hashtagTest3", false);
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		boolean testReturn = hashtagDAO.insert(hashtag); 
		assertEquals(true, testReturn);
		
		//testando update a partir do metodo Salvar
		hashtag = new Hashtag(3, "#hashtagTest4", false); 
		boolean testReturn2 = hashtagDAO.update(hashtag); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#buscarPorId(int)}.
	 */
	@Test
	public void e_testBuscarPorId() {
		Hashtag hashtag = new Hashtag();
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		hashtag = hashtagDAO.buscarPorId(3);
		assertEquals("#hashtagTest4", hashtag.getHashtag());
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.HashtagDAO#buscarTudo()}.
	 */
	@Test
	public void f_testBuscarTudo() {
		HashtagDAO  hashtagDAO = new HashtagDAO(this.conexao); 
		List<Hashtag> listHashtag = hashtagDAO.buscarTudo();
		assertEquals( 2, listHashtag.size());
	}

}
