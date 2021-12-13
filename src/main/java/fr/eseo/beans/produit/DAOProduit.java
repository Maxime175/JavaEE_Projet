package fr.eseo.beans.produit;

import java.util.List;

public interface DAOProduit {

    public abstract void add(String nom, float prix, int quantite);
	
    public abstract Produit getProduit(String id_produit);
	
    public abstract List<Produit> getProduits();
    
    public abstract void update(String id_produit, String nom, float prix, int quantite);

    public abstract void delete(int id_produit);
    
}
