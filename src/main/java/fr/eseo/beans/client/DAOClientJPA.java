package fr.eseo.beans.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOClientJPA implements DAOClient {

	private EntityManagerFactory emf;
	
	public DAOClientJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void add(String nom, String prenom, String adresse, String mail, String mdp) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(new Client(nom, prenom, adresse, mail, mdp));
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
	
	@Override
    public Client getClient(String id_client) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.find(Client.class, Integer.parseInt(id_client));
		}
		finally {
		  entityManager.close();
		}	
	}

	@Override
	public List<Client> getClients() {
		List<Client> clients;
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			clients = entityManager.createQuery("from Client", Client.class).getResultList();
		}
		finally {
		  entityManager.close();
		}
		return clients;
	}

	@Override
	public void update(String id_client, String nom, String prenom, String adresse, String mail, String mdp) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Client client = new Client(Integer.parseInt(id_client), nom, prenom, adresse, mail, mdp);
			entityManager.merge(client);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

	@Override
	public void delete(int id_client) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Client client = entityManager.find(Client.class, id_client);
			entityManager.remove(client);				
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

}
