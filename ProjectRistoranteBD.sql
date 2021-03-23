CREATE DATABASE IF NOT EXISTS `projectristoranteoodb`; 
-- username per la connessione: ProjectRistorante-OO-BD
-- password per la connessione: Peron
--"jdbc:postgresql://localhost:5432/projectristoranteoodb","ProjectRistorante-OO-BD","Peron"
--case sensitive

CREATE TABLE IF NOT EXISTS Rider (
	ID_Rider SERIAL PRIMARY KEY,
	  Nome VARCHAR(25) NOT NULL,
 	 Veicolo VARCHAR(16) NOT NULL,
	  Cap_Numero_Consegne_raggiunto BOOLEAN DEFAULT false,
	Consegne_assegnate INT DEFAULT 0
  );

CREATE TABLE IF NOT EXISTS Consegne 
(
	Ristorante_di_partenza VARCHAR(40) NOT NULL,
	Indirizzo_Consegna VARCHAR(40) Not Null,
	Costo_Totale NUMERIC(5,2) Not NUll,
	Mail_Utente VARCHAR(255) NOT NULL,
	ID_Rider serial NOT NULL,
	ID_Consegna Serial Primary Key,
	Veicolo_utilizzato VARCHAR(20),
	Stato_consegna VARCHAR(15),
	FOREIGN KEY (ID_Rider) REFERENCES Rider(ID_Rider),
	FOREIGN KEY (Mail_Utente) REFERENCES Utente(Email)
);

Create TABLE IF NOT EXISTS Menù
(
    Id_piatto SERIAL PRIMARY KEY NOT NULL,  
    Nome_piatto varchar( 45 ) UNIQUE NOT NULL, 
    Descrizione_Piatto TEXT,
    Costo NUMERIC(5,2) NOT NULL,
    Tipo_Ristorante INT references ristoranti(ristorante_id) default 0
);

CREATE TABLE IF NOT EXISTS Utente 
(
	User_Id SERIAL PRIMARY KEY NOT NULL,
	Email VARCHAR ( 255 ) UNIQUE NOT NULL,
	Password_Utente VARCHAR ( 50 ) NOT NULL,
	Indirizzo VARCHAR (50),
	Created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	Admin BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Ristoranti
(
	Ristorante_id SERIAL PRIMARY KEY NOT NULL,
	Indirizzo_ristorante VARCHAR ( 25 ) NOT NULL,
	Admin_id INTEGER REFERENCES Utente(User_Id)
);

CREATE TABLE IF NOT EXISTS Allergeni 
(
  Id_allergene SMALLSERIAL PRIMARY KEY NOT NULL,
  Nome_allergene VARCHAR (30) NOT NULL
);
CREATE TABLE IF NOT EXISTS Allergeni_Associati
(
	Id_Piatto INT,
	Id_Allergene INT,
	CONSTRAINT fk_allergene FOREIGN KEY(Id_allergene) REFERENCES Allergeni(Id_allergene) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_menu FOREIGN KEY(Id_piatto) REFERENCES Menù(Id_piatto) ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO Utente (Email,Password_Utente,Indirizzo,Admin)
VALUES
('bidey98441@onzmail.com','Lorem52','Via Chiaia 8','false'),
('delissandramedeiy@dongrup.com','ipsum89','Via Croce 10','false'),
('itufessag-8610@yopmail.com','dolor49','Via Palo 62','false'),
('8ilyes.kamytlm5@warehouseofthebooks.com','sit47','Via Miano 36','false'),
('1yakob@emsinau.com','amet65','Via Bosco 6','false'),
('7yuonsqaaz8@mailboxvip.com','consectetur29','Via Mare 41','false'),
('micheleirace@gmail.com', 'mikeirace98','Via Toledo 34', 'false'),
('Marina-Admin@gmail.com','admin','Via Marina 18','true'),
('Roma-Admin@gmail.com','admin','Via Roma 24','true'),
('Terracina-Admin@gmail.com','admin','Via Terracina 89','true'),
('Claudio-Admin@gmail.com','admin','Via Claudio 35','true'),
('Foria-Admin@gmail.com','admin','Via Foria 9','true'),
('Augusto-Admin@gmail.com','admin','Viale Augusto 67','true');


INSERT INTO Ristoranti(Indirizzo_ristorante, Admin_Id)
	VALUES 
	('Via Marina 18', '8'),
	('Via Roma 24', '9'),
	('Via Terracina 89', '10'),
	('Via Claudio 35', '11'),
	('Via Foria 9','12'),
	('Viale Augusto 67', '13');

INSERT INTO rider (nome, veicolo)
VALUES
('Donatello Allegro','Bicicletta'),
('Marco Bartolomeo','Automobile'),
('Arianna Romano','Moto'),
('Genoveffa Pavia','Bicicletta'),
('Viola Landolfi','Automobile'),
('Gianpaolo Tiraboschi','Moto'),
('Tonio Nascimbene','Motorino'),
('Anastasia Basso','Motorino');


INSERT INTO Menù (Nome_Piatto,Descrizione_Piatto,Costo,Tipo_Ristorante)
VALUES
('Arancino','Arancino','0.90','2'),
('Frittatina','Frittatina','0.90','2'),
('Mozarella in carrozza','Mozarella in carrozza','0.60','2'),
('Mozzarelline impanate','Mozzarelline impanate','2.00','2'),
('Rustico al Wurstel','Rustico al Wurstel','1.00','2'),
('Polpette di carne','Polpette di carne scottona fatte in loco','3.00','2'),
('Polpette di carne al formaggio','Polpette di carne scottona con aggiunta di scamorza','3.00','2'),
('Chicken nuggets','Stracciettti di pollo fatti in casa con salsa a scelta','2.00','2'),
('Crochetta di patata','Crochetta di patata','1.00','2'),
('Patate fritte','Potatine fritte fatte a mano e salsa a scelta','1.50','2'),
('Hamburger Classico','Hamburger di manzo con formaggio, pomodoro, insalata, cipolle, Ketchup e Maionese','7.50','1'),
('Cistecca Classica','Sfilatino riempito con straccietti di carne bovina, scamorza e cipolla','6.50','3'),
('Cistecca Mediterranea','Sfilatino riempito con straccietti di carne bovina, scamorza, rucola e pomodoro','7.00','3'),
('Hamburger Croccante','Hamburger di manzo con bacon, insalata, pomodoro e cheddar','7.50','1'),
('Hamburger Boscaiolo','Hamburger di manzo con speck, funghi, insalata, provola affumicata e maionese o salsa boscaiola','8.00','1'),
('Hamburger Gustoso','Hamburger di manzo con pomodori secchi, insalata, mozzarella fiordilatte e pesto di basilico','8.00','1'),
('Hamburger Bismark','Hamburger di manzo con uovo occhio di bue, insalata, emmental e maionese al tartufo','8.50','1'),
('Cistecca Parmigiana','Sfilatino riempito con straccietti di carne bovina, scamorza e parmigiana di melanzane','7.00','3'),
('Cistecca Rustica','Sfilatino riempito con straccietti di carne bovina, scamorza, pancetta piastrata e patate al forno','7.50','3'),
('Cistecca Cafona','Sfilatino riempito con straccietti di carne bovina, scamorza, friarielli e salsa piccante','7.50','3'),
('Burrito Beef','Tortilla riempita con manzo, riso, fagioli, lattuga e salse','6.50','4'),
('Burrito Chicken','Tortilla riempita con pollo, riso, fagioli, lattuga e salse','6.50','4'),
('Burrito Pork','Tortilla riempita con maiale, riso, fagioli, lattuga e salsa rossa','6.50','4'),
('Quesadilla','Tortilla grigliatta con formaggio, tagliata di bistecca, guacamole, panna acida e pomodori','8.00','4'),
('Taco Pollo','Tortilla croccante con pollo, salsa, guacamole e formaggio','5.00','4'),
('Taco Maiale','Tortilla croccante con maiale alla griglia, salsa, guacamole e formaggio','5.00','4'),
('Chirashi','Riso con salmone salsa di soia e sesamo','10.00','5'),
('Tori Meshi','Riso Saltato con pollo e verdure','7.00','5'),
('Yaki Soba','Spaghetti di soia con verdure e pollo','9.00','5'),
('Tempura Ebi', '6 pezzi di gamberi fritti in pastella','12.00','5'),
('Gyoza','Ravioli di carne di maiale cotti al vapore','6.00','5'),
('Sushi Misto','Pezzi assortiti di sushi tra cui Nigiri, Hosomaki e Futomaki','15.00','5'),
('Antipasto','Insalata di giardino con verdure fresche, cetrioli, cipolle rosse, pomodori datterini, formaggio cheddar e crostini','8.50','6'),
('Pasta al pomodoro fresco','Pasta fresca trafilata al bronzo, salsa di pomodori del pendolo con basilico e agio tostato','12.50','6'),
('Ravioli ripieni','Ravioli ripieni di ricotta e spinaci, serviti in salsa al burro aromatizzata con salvia','13.00','6'),
('Entrée di Terra','Tagliata di bistecca di manzo 100% Black Angus in salsa con funghi Portabella arrostiti e cipolle saltate. Servito con Purè di patate','18.50','6'),
('Entrée di Mare','Salmone bollito in salsa al burro, lime e Chardonnay, servita con spinachi e pomodori all julienne','19.00','6'),
('Fanta','Fanta','1.00','2'), 
('Sprite','Sprite', '1.00','2'),
('Vino Rosso', "Bottiglia di Chateau de Programmateur", '35.00','6'),
('Vino Bianco', "Bottiglia di Chateau de Programmateur", '35.00','6');
INSERT INTO Menù (Nome_Piatto,Descrizione_Piatto,Costo)
VALUES
('Acqua Naturale 50 cl','Acqua Naturale 50 cl','0.50'),
('Aqcua Frizzante 50 cl','Aqcua Frizzante 50 cl','0.50'),
('Coca Cola','Coca Cola','1.00');
INSERT INTO Allergeni (Nome_Allergene)
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

INSERT INTO Allergeni_Associati (Id_Piatto,Id_Allergene)
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
('12','12'),
('13','1'),
('13','3'),
('13','5'),
('13','6'),
('13','7'),
('13','10'),
('13','11'),
('14','1'),
('14','3'),
('14','7'),
('14','10'),
('14','11'),
('15','1'),
('15','3'),
('15','7'),
('15','10'),
('15','11'),
('16','1'),
('16','3'),
('16','7'),
('16','10'),
('16','11'),
('17','1'),
('17','7'),
('17','9'),
('17','12'),
('18','1'),
('18','7'),
('18','12'),
('19','1'),
('19','9'),
('19','12'),
('20','1'),
('20','9'),
('20','12'),
('21','1'),
('21','9'),
('21','12'),
('22','1'),
('22','7'),
('22','9'),
('22','12'),
('23','1'),
('23','7'),
('23','9'),
('23','12'),
('24','1'),
('24','7'),
('24','9'),
('24','12'),
('25','1'),
('25','4'),
('25','6'),
('25','11'),
('26','1'),
('26','12'),
('26','6'),
('26','11'),
('27','1'),
('27','6'),
('27','9'),
('27','11'),
('28','1'),
('28','3'),
('28','5'),
('28','8'),
('28','2'),
('29','1'),
('29','6'),
('29','9'),
('30','1'),
('30','2'),
('30','4'),
('30','6'),
('30','14'),
('31','12'),
('32','1'),
('32','3'),
('31','9'),
('31','12'),
('32','1'),
('32','3'),
('32','7'),
('32','12'),
('33','7'),
('34','4'),
('34','7'),
('34','12'),
('37','12'),
('38','12');
-- Querry di ricerca per allergeni
--SELECT Menu.id_piatto, Menu.nome_piatto, Allergeni.id_allergene, Allergeni.nome_allergene
--FROM Menu INNER JOIN (Allergeni INNER JOIN AllergeniAssociati ON AllergeniAssociati.id_allergene=Allergeni.id_allergene) ON Menu.id_piatto=AllergeniAssociati.id_piatto;
