package fr.eseo.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	private void setParamJPA() {
		emf = Persistence.createEntityManagerFactory("Book");
	}
	
	public DAOBook getDAOBook(String type) {
		switch(type) {
			case "JPA":
				setParamJPA();
				return new DAOBookJPA(emf);
			default:
				return null;	
		}
	}

}
