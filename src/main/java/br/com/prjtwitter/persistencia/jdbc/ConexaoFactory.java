package br.com.prjtwitter.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para conectar o DB
 * @author Marlei M. Silveira 
 *
 */
public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver"); //forca o carregamento do driver jdbc  
			return DriverManager.getConnection("jdbc:postgresql://ec2-174-129-255-21.compute-1.amazonaws.com:5432/d5k0j7m4tn8ia8?sslmode=require", "pdedadntpijtjx", "7c72a0a68f5534dfbe721eab3b27a50656f1bee7e1cb27612a2aa2eed40f62d3");
			//return DriverManager.getConnection("jdbc:postgresql://ec2-174-129-32-200.compute-1.amazonaws.com:5432/d7jptuvm5p7jtb?sslmode=require", "eptfscqhlwyjsp", "9c71100c726aa1c5b59c31db3e3e80a222f0cacb222ae17c9bffcccefa2d3376");
			//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Twitter-watcher", "postgres", "postgres");
		} catch (SQLException e) {
			// relancando a exeception
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
