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

import br.com.prjtwitter.entidade.Tweet;
import br.com.prjtwitter.persistencia.jdbc.ConexaoFactory;
import br.com.prjtwitter.persistencia.jdbc.TweetDAO;

/**
 * @author Marlei M. Silveira
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TweetDAOtest2 {

	private Connection conexao = ConexaoFactory.getConnection();
	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#insert(br.com.prjtwitter.entidade.Tweet)}.
	 */
	@Test
	public void a_testInsert() {
		Tweet tweet = new Tweet(1, "123455", "teste de tweet", "Fulano", "Mon Jan 06 03:24:35 BRST 2020", 120, 100, null); 
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		boolean testReturn = tweetDAO.insert(tweet); 
		assertEquals(true, testReturn);
		
		tweet = new Tweet(1, "123455234235", "teste de tweet2", "Fulano2", "Mon Jan 06 03:24:35 BRST 2020", 120, 100, null);  
		boolean testReturn2 = tweetDAO.insert(tweet); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#update(br.com.prjtwitter.entidade.Tweet)}.
	 */
	@Test
	public void b_testUpdate() {
		Tweet tweet = new Tweet(1, 1, "2222222222", "teste de tweet3", "Fulano3", "Mon Jan 06 03:24:35 BRST 2020", 120, 100, null); 
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		boolean testReturn = tweetDAO.update(tweet); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#delete(int)}.
	 */
	@Test
	public void c_testDelete() {
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		boolean testReturn = tweetDAO.delete(2); 
		assertEquals(true, testReturn);
	}


	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#salvar(br.com.prjtwitter.entidade.Tweet)}.
	 */
	@Test
	public void d_testSalvar() {
		//testando insert a partir do metodo Salvar
		Tweet tweet = new Tweet(1, "9999999", "teste de tweet4", "Fulano4", "Mon Jan 06 03:24:35 BRST 2020", 120, 100, null);
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		boolean testReturn = tweetDAO.insert(tweet); 
		assertEquals(true, testReturn);
		
		//testando update a partir do metodo Salvar
		tweet = new Tweet(3,1, "123455", "teste de tweet5", "Fulano5", "Mon Jan 06 03:24:35 BRST 2020", 120, 100, null); 
		boolean testReturn2 = tweetDAO.update(tweet); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#buscarPorId(int)}.
	 */
	@Test
	public void e_testBuscarPorId() {
		Tweet tweet = new Tweet();
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		tweet = tweetDAO.buscarPorId(1);
		assertEquals("Fulano3", tweet.getAutor());
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#buscarTudo()}.
	 */
	@Test
	public void f_testBuscarTudo() {
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		List<Tweet> listTweet = tweetDAO.buscarTudo();
		assertEquals( 2, listTweet.size());
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.TweetDAO#buscarPorHashtag(int)}.
	 */
	@Test
	public void g_testBuscarPorHashtag() {
		TweetDAO  tweetDAO = new TweetDAO(this.conexao); 
		List<Tweet> listTweet = tweetDAO.buscarPorHashtag(1);
		assertEquals( 2, listTweet.size());
	}




}
