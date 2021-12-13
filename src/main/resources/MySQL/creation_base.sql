/*   	Commandes de création de la base  */
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Produit;
DROP TABLE IF EXISTS Historique_Commande;

CREATE TABLE Client(id_client INTEGER NOT NULL, 
						login VARCHAR (30) NOT NULL,
						mdp VARCHAR (30) NOT NULL,
                        nom VARCHAR (50) NOT NULL ,
                        prenom VARCHAR (30) NOT NULL,
						mail VARCHAR (100) NOT NULL,
						adresse_livraison VARCHAR (30) NOT NULL,
						est_bloque BOOLEAN,
						token VARCHAR (30) NOT NULL,
                        PRIMARY KEY (id_client));
 
CREATE TABLE Produit (id_produit  INTEGER NOT NULL,
                        nom VARCHAR (50) NOT NULL,
						prix float,
						quantite_stock INTEGER,
                        PRIMARY KEY (id_produit));

CREATE TABLE Historique_Commande  (id_hist_commande INTEGER NOT NULL,
                       dateheure DATETIME NOT NULL,
                       id_client INTEGER NOT NULL,
					   id_produit INTEGER NOT NULL,
					   quantite INTEGER NOT NULL,
                       PRIMARY KEY (id_hist_commande),
					   FOREIGN KEY (id_client) REFERENCES Client(id_client),
                       FOREIGN KEY (id_produit) REFERENCES Produit(id_produit));