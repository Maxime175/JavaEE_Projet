package fr.eseo.beans.historique_commande;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOHistoriqueCommandeJPA implements DAOHistoriqueCommande {
	
	private EntityManagerFactory emf;

	public DAOHistoriqueCommandeJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void add(Integer id_client, Integer id_produit, int quantite) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(new HistoriqueCommande(id_client, id_produit, quantite));
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
	
	@Override
    public HistoriqueCommande getUnHistoriqueCommande(String id_hist_commande) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.find(HistoriqueCommande.class, Integer.parseInt(id_hist_commande));
		}
		finally {
		  entityManager.close();
		}	
	}

	@Override
	public List<HistoriqueCommande> getHistorique() {
		List<HistoriqueCommande> historique;
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			historique = entityManager.createQuery("from HistoriqueCommande", HistoriqueCommande.class).getResultList();
		}
		finally {
		  entityManager.close();
		}
		return historique;
	}

	@Override
	public void update(String id_hist_commande, Integer id_client, Integer id_produit, int quantite) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			HistoriqueCommande hist_commande = new HistoriqueCommande(Integer.parseInt(id_hist_commande), id_client, id_produit, quantite);
			entityManager.merge(hist_commande);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

	@Override
	public void delete(int id_hist_commande) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			HistoriqueCommande hist_commande = entityManager.find(HistoriqueCommande.class, id_hist_commande);
			entityManager.remove(hist_commande);				
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

}
