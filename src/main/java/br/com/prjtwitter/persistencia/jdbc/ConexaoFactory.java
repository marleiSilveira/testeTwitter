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
			return DriverManager.getConnection("jdbc:postgresql://ec2-174-129-18-210.compute-1.amazonaws.com:5432/d5q0j1b60a07uf?sslmode=require", "tkkrtuzllsxgim", "0c53bdb30414907d42fe540955489f12c63a6e8c2bd78bb1b90948db4a885c14");
						
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
