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

import br.com.prjtwitter.entidade.Config;
import br.com.prjtwitter.persistencia.jdbc.ConexaoFactory;
import br.com.prjtwitter.persistencia.jdbc.ConfigDAO;

/**
 * @author Marlei M. Silveira
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigDAOtest2 {

	private Connection conexao = ConexaoFactory.getConnection();
	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#insert(br.com.prjtwitter.entidade.Config)}.
	 */
	@Test
	public void a_testInsert() {
		Config config = new Config(5, "consumerKey", "consumerSecret", "accessToken", "accessTokenSecret", 100, "pt", -26.305498, -48.857075, 500.0, "km", "2020-01-03", "2020-01-03"); 
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		boolean testReturn = configDAO.insert(config); 
		assertEquals(true, testReturn);
		
		config = new Config(10, "consumerKey", "consumerSecret", "accessToken", "accessTokenSecret", 100, "pt", -26.305498, -48.857075, 500.0, "km", "2020-01-03", "2020-01-03");  
		boolean testReturn2 = configDAO.insert(config); 
		assertEquals(true, testReturn2);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#update(br.com.prjtwitter.entidade.Config)}.
	 */
	@Test
	public void b_testUpdate() {
		Config config = new Config(1, 5, "c8qT8WHyJz4mG3MY7ANtRcj0z", "MJAuR78KgaiIFQTvGuly7OZqnLieXSnDqFbiUqAwmbZNADPCVa", "1213120996149846016-ZPAjK5PcqYdwKAWTFNELXd2s5bKzcr", "lCfkpLq4e28WctwfLpagiegLcirQRxuv6F5GzpdBjw9Kj", 100, "pt", -26.305498, -48.857075, 500.0, "km", "2020-01-03", ""); 
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		boolean testReturn = configDAO.update(config); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#delete(int)}.
	 */
	@Test
	public void c_testDelete() {
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		boolean testReturn = configDAO.delete(2); 
		assertEquals(true, testReturn);
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#buscarPorId(int)}.
	 */
	@Test
	public void d_testBuscarPorId() {
		Config config = new Config();
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		config = configDAO.buscarPorId(1);
		assertEquals("MJAuR78KgaiIFQTvGuly7OZqnLieXSnDqFbiUqAwmbZNADPCVa", config.getConsumerSecret());
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#buscarTudo()}.
	 */
	@Test
	public void e_testBuscarTudo() {
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		List<Config> listConfig = configDAO.buscarTudo();
		assertEquals( 1, listConfig.size());
	}

	/**
	 * Test method for {@link br.com.prjtwitter.persistencia.jdbc.ConfigDAO#salvar(br.com.prjtwitter.entidade.Config)}.
	 */
	@Test
	public void f_testSalvar() {
		//testando insert a partir do metodo Salvar
		Config config = new Config(10, "consumerKey", "consumerSecret", "accessToken", "accessTokenSecret", 100, "pt", -26.305498, -48.857075, 500.0, "km", "2020-01-03", "2020-01-03");
		ConfigDAO  configDAO = new ConfigDAO(this.conexao); 
		boolean testReturn = configDAO.insert(config); 
		assertEquals(true, testReturn);
		
		//testando update a partir do metodo Salvar
		config = new Config(3, 10, "consumerKey2", "consumerSecret2", "accessToken2", "accessTokenSecret2", 90, "en", -26.305498, -48.857075, 500.0, "km", "2020-01-03", "2020-01-03"); 
		boolean testReturn2 = configDAO.update(config); 
		assertEquals(true, testReturn2);
	}

}
