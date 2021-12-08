package fr.eseo.beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOBookJPA implements DAOBook {
	
	private EntityManagerFactory emf;
	
	public DAOBookJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void add(String title, String author, String description) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(new Book(title,author,description));
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
	
	@Override
    public Book getBook(String id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.find(Book.class, Integer.parseInt(id));
		}
		finally {
		  entityManager.close();
		}	
	}

	@Override
	public List<Book> getBooks() {
		List<Book> catalog;
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			catalog = entityManager.createQuery("from Book", Book.class).getResultList();
		}
		finally {
		  entityManager.close();
		}
		return catalog;
	}

	@Override
	public void update(String id, String title, String author, String description) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Book book = new Book(Integer.parseInt(id),title,author,description);
			entityManager.merge(book);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}

	@Override
	public void delete(int id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Book book = entityManager.find(Book.class, id);
			entityManager.remove(book);				
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		}
	}
}
