package fr.eseo.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eseo.beans.book.DAOBook;
import fr.eseo.beans.book.DAOBookJPA;
import fr.eseo.beans.client.DAOClient;
import fr.eseo.beans.client.DAOClientJPA;

public class DAOFactory {
	
	private static volatile DAOFactory instance = null;
	private EntityManagerFactory emf;
	private String url;
	private String username;
	private String password;
	
	private DAOFactory() {}
	
	public final static DAOFactory getInstance() {
		if(DAOFactory.instance == null) {
			synchronized(DAOFactory.class) {
				if(DAOFactory.instance == null) {
			        instance = new DAOFactory();
				}
			}
		}
	    return DAOFactory.instance;
	}
	
	public Connection getConnection() throws SQLException {
	    return DriverManager.getConnection(url, username, password);
	}
	
	public DAOBook getDAOBook() {
		emf = Persistence.createEntityManagerFactory("Book");
		return new DAOBookJPA(emf);
	}
	
	public DAOClient getDAOClient() {
		emf = Persistence.createEntityManagerFactory("Client");
		return new DAOClientJPA(emf);
	}

}
