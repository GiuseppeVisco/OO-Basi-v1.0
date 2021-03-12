CREATE DATABASE IF NOT EXISTS `projectristoranteoodb`; 
-- username per la connessione: ProjectRistorante-OO-BD
-- password per la connessione: Peron
--case sensitive

CREATE TABLE IF NOT EXISTS rider (
  Nome VARCHAR(16) NOT NULL PRIMARY KEY,
  Veicolo VARCHAR(255) NOT NULL,
  Cap_Numero_Consegne_raggiunto BOOLEAN NOT NULL
  );

CREATE TABLE IF NOT EXISTS Consegne 
(
  idconsegne SERIAL PRIMARY KEY NOT NULL,
  Ristorante_di_Partenza VARCHAR( 40 ) NOT NULL,
  Contenuti_consegna TEXT NOT NULL,
  Costo_Totale FLOAT NOT NULL,
  Stato_Consegna ENUM ('In Consegna', 'Consegnato')	
);

Create TABLE IF NOT EXISTS menù
(
    id_piatto SERIAL PRIMARY KEY NOT NULL,  
    nome_piatto varchar( 45 ) UNIQUE NOT NULL, 
    Descrizione_Piatto TEXT,
    costo NUMERIC(5,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS utente 
(
	user_id SERIAL PRIMARY KEY NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	passwordutente VARCHAR ( 50 ) NOT NULL,
	created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	rider BOOLEAN NOT NULL DEFAULT false
);

INSERT INTO utente (email,passwordutente,rider)
VALUES
('bidey98441@onzmail.com','Lorem52','false'),
('delissandramedeiy@dongrup.com','ipsum89','True'),
('itufessag-8610@yopmail.com','dolor49','false'),
('8ilyes.kamytlm5@warehouseofthebooks.com','sit47','false'),
('1yakob@emsinau.com','amet65','true'),
('7yuonsqaaz8@mailboxvip.com','consectetur29','true');

CREATE TABLE IF NOT EXISTS Ristoranti
(
	Ristorante_id SERIAL PRIMARY KEY NOT NULL,
	Indirizzo VARCHAR ( 25 ) NOT NULL
);

CREATE TABLE Allergeni 
(
  id_allergene SMALLSERIAL PRIMARY KEY NOT NULL,
  nome_allergene VARCHAR (30) NOT NULL
);


INSERT INTO "Ristoranti"("Indirizzo")
	VALUES 
	('Via Giulio Cesare 13'),
	('Via San Ciro 10'),
	('Via Marina 5');

INSERT INTO rider (nome, veicolo, Cap_numero_consegne_raggiunto)
VALUES
('Aldo', 'moto', false), 
('Ben', 'automobile', false), 
('Carlo', 'Bicicletta', false), 
('Dario', 'Nessuno', false); 


INSERT INTO menù (nome_piatto,costo)
VALUES
('Arancino','0.90'),
('Frittatina','0.90'),
('Mozarella in carrozza','0.60'),
('Mozzarelline impanate','2.00'),
('Rustico al Wurstel','1.00'),
('Polpette di carne','1.00'),
('Chicken nuggets','3.00'),
('Crochetta di patata','1.00'),
('Patate fritte','1.50'),
('Acqua Naturale 50 cl','0.50'),
('Aqcua Frizzante 50 cl','0.50'),
('Coca Cola', '1.00'),
('Fanta', '1.00'); 
('Sprite', '1.00');

INSERT INTO allergeni (nome_allergene)
VALUES
('Cereali e derivati'),
('Crostacei'),
('Uova'),
('Pesce'),
('Arachidi'),
('Soia'),
('Latte'),
('Frutta a guscio'),
('Sedano'),
('Senape'),
('Sesamo'),
('Anidride solforosa e solfiti'),
('Lupini'),
('Molluschi');
CREATE TABLE IF NOT EXISTs AllergeniAssociati
(
	id_piatto SERIAL,
	id_allergene Serial,
	CONSTRAINT fk_allergene FOREIGN KEY(id_allergene) REFERENCES Allergeni(id_allergene) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_menu FOREIGN KEY(id_piatto) REFERENCES Menu(id_piatto) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT Allergeni_Associati_pkey PRIMARY KEY (id_Allergene, Id_piatto)
);
INSERT INTO AllergeniAssociati (id_Piatto,id_allergene)
VALUES
('1','1'),
('1','3'),
('1','6'),
('1','7'),
('2','1'),
('2','3'),
('2','6'),
('2','7'),
('3','1'),
('3','3'),
('3','6'),
('3','7'),
('4','1'),
('4','3'),
('4','7'),
('4','12');
-- Querry di ricerca per allergeni
SELECT Menu.id_piatto, Menu.nome_piatto, Allergeni.id_allergene, Allergeni.nome_allergene
FROM Menu INNER JOIN (Allergeni INNER JOIN AllergeniAssociati ON AllergeniAssociati.id_allergene=Allergeni.id_allergene) ON Menu.id_piatto=AllergeniAssociati.id_piatto;
