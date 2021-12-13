TRUNCATE TABLE Client;
TRUNCATE TABLE Produit; 
TRUNCATE TABLE Historique_Commande;

INSERT INTO Client VALUES(1,"pouplama", "1234", "Maxime", "Pouplain", "maxime.pouplain@reseau.eseo.fr", "Angers", False, "abc");
INSERT INTO Client VALUES(2,"couriema", "4567", "Martin", "Courier de Mere", "martin.courierdemere@reseau.eseo.fr", "Tours", False, "def");

INSERT INTO Produit VALUES(1,"console", 5, 300);
INSERT INTO Produit VALUES(2,"telephone", 15, 890);
INSERT INTO Produit VALUES(3,"tele", 40, 1500);
INSERT INTO Produit VALUES(4,"enceinte", 24, 250);

INSERT INTO Historique_Commande VALUES(1, "2021-11-16-16-00-00", 1, 1, 2);
INSERT INTO Historique_Commande VALUES(2, "2021-11-16-17-30-00", 2, 3, 1);
INSERT INTO Historique_Commande VALUES(3, "2021-11-16-15-15-00", 1, 4, 3);