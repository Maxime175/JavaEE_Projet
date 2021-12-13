package fr.eseo.beans.produit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOProduitJPA implements DAOProduit {

	private EntityManagerFactory emf;
	
	public DAOProduitJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void add(String nom, float prix, int quantite) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(new Produit(nom, prix, quantite));
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
	
	@Override
    public Produit getProduit(String id_produit) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.find(Produit.class, Integer.parseInt(id_produit));
		}
		finally {
		  entityManager.close();
		}	
	}

	@Override
	public List<Produit> getProduits() {
		List<Produit> produits;
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			produits = entityManager.createQuery("from Produit", Produit.class).getResultList();
		}
		finally {
		  entityManager.close();
		}
		return produits;
	}

	@Override
	public void update(String id_produit, String nom, float prix, int quantite) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Produit produit = new Produit(Integer.parseInt(id_produit), nom, prix, quantite);
			entityManager.merge(produit);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

	@Override
	public void delete(int id_produit) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Produit produit = entityManager.find(Produit.class, id_produit);
			entityManager.remove(produit);				
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
}
