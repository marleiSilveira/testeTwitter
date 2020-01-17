package br.com.prjtwitter.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConfigDAOtest2.class, HashtagDAOtest2.class,
		 TweetDAOtest2.class, GrupoHashtagDAOtest.class })
public class AllTests {

}
