package fr.eseo.beans.client;

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
@Table(name="client")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_client")
	private Integer id_client;
	
	@Column(name="login")
	private String login;
	
	@Column(name="mdp")
	private String mdp;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="adresse_livraison")
	private String adresse_livraison;

	@Column(name="est_bloque")
	private Boolean est_bloque;
	
	public Client() {}
	
	public Client(String nom, String prenom, String adresse, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = nom.substring(0, 6) + prenom.substring(0, 2);
		this.adresse_livraison = adresse;
		this.mail = mail;
		this.mdp = mdp;
		this.est_bloque = false;
	}	
	
	public Client(Integer id_client, String nom, String prenom, String adresse, String mail, String mdp) {
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.login = nom.substring(0, 6) + prenom.substring(0, 2);
		this.adresse_livraison = adresse;
		this.mail = mail;
		this.mdp = mdp;
		this.est_bloque = false;
	}
	
	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getEst_bloque() {
		return est_bloque;
	}

	public void setEst_bloque(Boolean est_bloque) {
		this.est_bloque = est_bloque;
	}	

	public String getAdresse_livraison() {
		return adresse_livraison;
	}

	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}
	
}
