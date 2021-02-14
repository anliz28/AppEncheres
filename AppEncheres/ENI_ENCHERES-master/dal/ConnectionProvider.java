package fr.eni.encheres.dal;

	
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class ConnectionProvider {//sert a obtenir une connexion et est visible que depuis ce package
	
	private static DataSource dataSource;//va permettre de manipuler le pool de connexion vers la BDD
	private static Connection cnx;

	static {
		Context context;
		try {
			context = new InitialContext();//creation d'un objet context
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");//utilisation de la méthode lookup pour rechercher la ressource jdbc grace a la variable dataSource de la classe connectionProvider
			try {
				 cnx = dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
		try {
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();//obtention du pool de connexion a partir du dataSource
	}
}
	

	
