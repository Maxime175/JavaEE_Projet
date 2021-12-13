package fr.eseo.beans.book;

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
@Table(name="livre")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_livre")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="titre")
	private String title;
	
	@Column(name="auteur")
	private String author;
	
	@Column(name="description")
	private String description;
	
	public Book() {}
	
	public Book(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}	
	
	public Book(int id, String title, String author, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
	}	

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}
}
