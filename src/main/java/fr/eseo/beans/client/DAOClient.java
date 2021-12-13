package fr.eseo.beans.client;

import java.util.List;

public interface DAOClient {

    public abstract void add(String nom, String prenom, String adresse, String mail, String mdp);
	
    public abstract Client getClient(String id_client);
	
    public abstract List<Client> getClients();
    
    public abstract void update(String id_client, String nom, String prenom, String adresse, String mail, String mdp);

    public abstract void delete(int id_client);
    
}
