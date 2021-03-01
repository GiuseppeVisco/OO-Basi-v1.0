CREATE DATABASE `projectristoranteoodb`; 

CREATE TABLE rider (
  Nome VARCHAR(16) NOT NULL PRIMARY KEY,
  Veicolo VARCHAR(255) NOT NULL,
  Cap_Numero_Consegne_raggiunto BOOLEAN NOT NULL
  );

CREATE TABLE Consegne 
(
  idconsegne INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  Ristorante_di_Partenza VARCHAR( 40 ) NOT NULL,
  Contenuti_consegna TEXT NOT NULL,
  Costo_Totale FLOAT NOT NULL,
  Stato_Consegna ENUM ('In Consegna', 'Consegnato')	
);

Create TABLE menù
(
    id_piatto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
    nome_piatto varchar( 45 ) UNIQUE NOT NULL, 
    Descrizione_Piatto TEXT,
    costo NUMERIC(5,2) NOT NULL
);

CREATE TABLE accounts 
(
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL
);

CREATE TABLE Ristoranti
(
	Ristorante_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	Indirizzo VARCHAR ( 25 ) NOT NULL
);

CREATE TABLE Allergeni 
(
  id_allergene SMALLSERIAL PRIMARY KEY,
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
('Fritatina',0.90),
('Mozarella in carrozza',0.60),
('Rustico al Wurstel',1.00),
('Crochetta di patata',1.00),
('Patate fritte',1.50),
('Acqua Naturale 50 cl',0.50),
('Aqcua Frizzante 50 cl',0.50),
('Coca Cola', '1.00'),
("Fanta", "1.00"); 

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
('Molluschi')

