package fr.eseo.beans.produit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_produit")
	private Integer id_produit;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prix")
	private float prix;
	
	@Column(name="quantite_stock")
	private int quantite_stock;
	
	public Produit() {}
	
	public Produit(String nom, float prix, int quantite_stock) {
		this.nom = nom;
		this.prix = prix;
		this.quantite_stock = quantite_stock;
	}
	
	public Produit(Integer id_produit, String nom, float prix, int quantite_stock) {
		this.id_produit = id_produit;
		this.nom = nom;
		this.prix = prix;
		this.quantite_stock = quantite_stock;
	}

	public Integer getId_produit() {
		return id_produit;
	}

	public void setId_produit(Integer id_produit) {
		this.id_produit = id_produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite_stock() {
		return quantite_stock;
	}

	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}	

}
