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
			return DriverManager.getConnection("jdbc:postgresql://ec2-34-193-42-173.compute-1.amazonaws.com:5432/defc4rtlrifmnu?sslmode=require", "ngzuzzzgrancrd", "7bb5de600a4f6017e845ba3d230515ccf0236fef85c0eef03d53790291c2f766");
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
