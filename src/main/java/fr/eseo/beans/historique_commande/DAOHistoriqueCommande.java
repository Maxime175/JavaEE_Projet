package fr.eseo.beans.historique_commande;

import java.util.List;

public interface DAOHistoriqueCommande {
	
    public abstract void add(Integer id_client, Integer id_produit, int quantite);
	
    public abstract HistoriqueCommande getUnHistoriqueCommande(String id_hist_commande);
	
    public abstract List<HistoriqueCommande> getHistorique();
    
    public abstract void update(String id_hist_commande, Integer id_client, Integer id_produit, int quantite);

    public abstract void delete(int id_hist_commande);

}
