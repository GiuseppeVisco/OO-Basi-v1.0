CREATE DATABASE IF NOT EXISTS `projectristoranteoodb`; 
-- username per la connessione: ProjectRistorante-OO-BD
-- password per la connessione: Peron
--case sensitive

CREATE TABLE IF NOT EXISTS rider (
	ID_Rider SERIAL PRIMARY KEY,
	  Nome VARCHAR(16) NOT NULL,
 	 Veicolo VARCHAR(255) NOT NULL,
	  Cap_Numero_Consegne_raggiunto BOOLEAN NOT NULL
  );

CREATE TYPE IF NOT EXISTS Stato AS ENUM ('In Consegna','Consegnato');

CREATE TABLE IF NOT EXISTS Consegne 
(
	Ristorante_di_partenza VARCHAR(40) NOT NULL,
	Indirizzo_Consegna VARCHAR(40) Not Null,
	Costo_Totale NUMERIC(5,2) Not NUll,
	Mail_Utente VARCHAR(255) NOT NULL,
	ID_Rider serial NOT NULL,
	ID_Consegna Serial Primary Key,
	FOREIGN KEY (ID_Rider) REFERENCES Rider(ID_Rider),
	FOREIGN KEY (Mail_Utente) REFERENCES utente(email),
  	Stato_Consegna Stato
	--Stato_Consegna ENUM ('In Consegna', 'Consegnato')	
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


CREATE TABLE IF NOT EXISTS Composizione_Consegna
(
	id_ordine serial References Consegne(id_Consegna),
	id_piatto serial references Menù(id_piatto),
	Quantità numeric(10) not null
);

CREATE TABLE IF NOT EXISTS Composizione_Carrello
(
	id_ordine serial References Consegne(id_Consegna),
	id_piatto serial references Menù(id_piatto),
	Quantità numeric(10) not null
);

CREATE TABLE IF NOT EXISTS Carrello
	(
		id_Carrello serial  primary key,
		Data_Creazione TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		user_id SERIAL REFERENCES Utente(user_id),
		Completo bool DEFAULT 'false'
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


INSERT INTO Ristoranti(Indirizzo)
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


INSERT INTO menù (nome_piatto,Descrizione_Piatto,costo)
VALUES
('Arancino','Arancino','0.90'),
('Frittatina','Frittatina','0.90'),
('Mozarella in carrozza','Mozarella in carrozza','0.60'),
('Mozzarelline impanate','Mozzarelline impanate','2.00'),
('Rustico al Wurstel','Rustico al Wurstel','1.00'),
('Polpette di carne','Polpette di carne scottona fatte in loco','3.00'),
('Polpette di carne al formaggio','Polpette di carne scottona con aggiunta di scamorza','3.00'),
('Chicken nuggets','Stracciettti di pollo fatti in casa con salsa a scelta','2.00'),
('Crochetta di patata','Crochetta di patata','1.00'),
('Patate fritte','Potatine fritte fatte a mano e salsa a scelta','1.50'),
('Cistecca Classica','Sfilatino riempito con straccietti di carne bovina, scamorza e cipolla','6.50'),
('Cistecca Mediterranea','Sfilatino riempito con straccietti di carne bovina, scamorza, rucola e pomodoro','7.00'),
('Acqua Naturale 50 cl','Acqua Naturale 50 cl','0.50'),
('Aqcua Frizzante 50 cl','Aqcua Frizzante 50 cl','0.50'),
('Coca Cola','Coca Cola','1.00'),
('Fanta','Fanta','1.00'); 
('Sprite','Sprite', '1.00');

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
('4','12'),
('5','1'),
('5','3'),
('5','7'),
('6','1'),
('6','3'),
('6','6'),
('6','7'),
('6','9'),
('7','1'),
('7','3'),
('7','6'),
('7','7'),
('7','9'),
('8','1'),
('8','3'),
('8','5'),
('8','7'),
('9','1'),
('9','3'),
('9','5'),
('9','7'),
('10','5'),
('11','1'),
('11','7'),
('11','11'),
('11','12'),
('12','1'),
('12','7'),
('12','11'),
('12','12');
-- Querry di ricerca per allergeni
SELECT Menu.id_piatto, Menu.nome_piatto, Allergeni.id_allergene, Allergeni.nome_allergene
FROM Menu INNER JOIN (Allergeni INNER JOIN AllergeniAssociati ON AllergeniAssociati.id_allergene=Allergeni.id_allergene) ON Menu.id_piatto=AllergeniAssociati.id_piatto;
