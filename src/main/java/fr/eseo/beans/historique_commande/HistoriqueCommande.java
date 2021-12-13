package fr.eseo.beans.historique_commande;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="historique_commande")
public class HistoriqueCommande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_hist_commande")
	private Integer id_hist_commande;
	
	@Column(name="dateheure")
	private LocalDateTime dateheure;
	
	@Column(name="quantite")
	private int quantite;
	
    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id_client"
    )
    private Integer id_client;
    
    @JoinColumn(
            name = "id_produit",
            referencedColumnName = "id_produit"
    )
    private Integer id_produit;

	public HistoriqueCommande() {}
	
	public HistoriqueCommande(Integer id_client, Integer id_produit, int quantite) {
		this.id_client = id_client;
		this.id_produit = id_produit;
		this.dateheure = LocalDateTime.now();
	}
	
	public HistoriqueCommande(Integer id_hist_commande, Integer id_client, Integer id_produit, int quantite) {
		this.id_hist_commande = id_hist_commande;
		this.id_client = id_client;
		this.id_produit = id_produit;
		this.dateheure = LocalDateTime.now();
	}	
	
	public Integer getId_hist_commande() {
		return id_hist_commande;
	}

	public void setId_hist_commande(Integer id_hist_commande) {
		this.id_hist_commande = id_hist_commande;
	}

	public LocalDateTime getDateheure() {
		return dateheure;
	}

	public void setDateheure(LocalDateTime dateheure) {
		this.dateheure = dateheure;
	}

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public Integer getId_produit() {
		return id_produit;
	}

	public void setId_produit(Integer id_produit) {
		this.id_produit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
