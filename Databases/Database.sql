DROP DATABASE IF EXISTS GameHub;
CREATE DATABASE IF NOT EXISTS GameHub;

USE GameHub;

CREATE TABLE IF NOT EXISTS Users(
UserId INTEGER NOT NULL AUTO_INCREMENT,
Username VARCHAR(20) UNIQUE NOT NULL,
Password VARCHAR(200) NOT NULL,
Balance DOUBLE(7,2) NOT NULL,
FirstName VARCHAR(20) NOT NULL,
LastName VARCHAR(20) NOT NULL,
Address VARCHAR(50) NOT NULL,
City VARCHAR(20) NOT NULL,
Country VARCHAR(20) NOT NULL,
Rating DOUBLE(2,1) NOT NULL,
IsAdmin INT(1) NOT NULL, 
PRIMARY KEY (UserId)) ENGINE=INNODB;
INSERT INTO Users
VALUES  (1,'GameHub','b36c46e49a393ccf078228f2e89ac33134d8fe753b87c5591f0402eac0d2cf15',50000.00,'Main','Admin','OnServer','lol','Empty',5.0,1),
        /** GameHub's password is gamehub so we all know. **/
	(2,'ken123', '66164fd1c9a8234940536d902d18a712e7a9e74c6819b41fb014e33740f6e0dc', 100.0, 'Kenneth', 'Clifford', '64 zoo lane', 'Dundalk', 'Louth', 5.0, 1),
	(3,'lukegoss7', 'b7542fd1b209c1b414e1d175c425616fa36c9e686d71025a373f79396cd1e746', 50.30, 'Luke', 'Goss', '123 Bakers Street', 'Drogheda', 'Louth', 5.0, 1),
	(4,'tiernan', '71a1c22514124e647352e48e662466faeba40a027d60f486c19253908f2fed33', 540.0, 'Tiernan', 'Whelan', '5 Elm Street', 'Newry', 'Down', 5.0, 1),
        (5,'tester', '9bba5c53a0545e0c80184b946153c9f58387e3bd1d4ee35740f29ac2e718b019', 1000, 'Mr', 'Tester', 'Test Street.', 'TestLand', 'TestCountry.', 5.0, 0);
ALTER TABLE Users AUTO_INCREMENT=6;

CREATE TABLE IF NOT EXISTS Games(
GameId INTEGER NOT NULL AUTO_INCREMENT,
Title VARCHAR(50) NOT NULL,
Platform VARCHAR(6) NOT NULL,
Genre VARCHAR(20) NOT NULL,
GameImage VARCHAR(100) NOT NULL,
Quality DECIMAL(6,4),
Price DECIMAL(5,2),
PRIMARY KEY (GameId))ENGINE=INNODB;
INSERT INTO Games
VALUES	(1, "Destiny", "ps4", "shooter","http://assets.vg247.com/current//2013/09/Destiny-Box-Art-Reveal.jpg", 4.2, 60.00),
	(2, "The Order 1886", "ps4","shooter","http://images.pushsquare.com/games/ps4/order_1886/cover_large.jpg",5.0, 80.00),
	(3, "Dying Light", "pc","horror", "http://www.ezedownloads.com/wp-content/uploads/2014/12/Dying-Light-Cover.jpg", 4.9, 49.99),
	(4, "Halo 5: Guardian", "xbox one", "shooter","http://img1.wikia.nocookie.net/__cb20140820100313/halo/images/3/38/Halo5_2D_RP-Boxshot.png", 3.0, 70.50),
	(5, "The Crew", "pc", "Driving","http://bolea.de/images/63501/pc/cover/the-crew-pc-0.jpg", 4.1, 29.00),
	(6, "Shadow of Mordor", "xbox one", "action","http://nextgengamingblog.com/files/2014/10/Middle-earth-Shadow-of-Mordor-box.png", 3.3, 43.99),
	(7, "Grim Fandango", "pc", "adventure","http://pics.mobygames.com/images/covers/large/1220019975-00.jpg", 5.0, 39.99),
	(8, "the Last of Us", "ps4", "horror","http://cdn3.vox-cdn.com/assets/4267493/13741695334_e2f461ca7a_b.jpg", 2.2, 65.00),
	(9, "Grand Theft Auto 5", "xbox one", "shooter","http://compass.xboxlive.com/assets/26/da/26da1d68-fb76-4d26-ab4a-8ce20bea06d1.jpg?n=GTAV_XB1_FOB_ENG.jpg", 3.9, 75.00),
	(10, "Kingdom Hearts", "ps3", "adventure","http://upload.wikimedia.org/wikipedia/en/c/c5/Kingdom_Hearts_HD_1.5_ReMIX_box_art.jpg", 4.0, 35.00),
    (11, "Baldur's Gate Compilation", "pc", "Adventure","http://cdn3.spong.com/pack/b/a/baldursgat206218l/_-Baldurs-Gate-Compilation-PC-_.jpg", 4.0, 3000.00),
	(12, "Far Cry 4", "ps4", "shooter", "http://intl.rakuten-static.com/t/f4d/86e/5697/2572/20ba/6fd0/1860/119ee4836a005056b74b38.jpg", 5.0, 70.00),
	(13, "Saints Row 4", "ps4", "action", "http://intl.rakuten-static.com/t/d88/95d/51db/2653/7020/a2cb/d831/116be48377005056b75887.jpg", 3.5, 40.00),
	(14, "Batman Arkham Asylum", "xbox 360", "action", "http://dsmedia.ign.com/ds/image/object/057/057795/Batman-Arkham-Asylum_XBOX_GOTY_FOBboxart_160w.jpg", 4.0, 30.50),
	(15, "Batman Arkham City", "xbox 360", "action", "http://media.ign.com/games/image/object/055/055051/arkham_city_360_final1.jpg", 2.5, 45.00),
	(16, "Batman Arkham Origins", "ps3", "action", "http://www.shogungames.co.uk/ekmps/shops/shogungames/images/batman-arkham-origins-360--1839-p.png", 2.0, 50.00),
	(17, "Batman Arkham Knight", "ps4", "action", "http://daxgamer.com/wp-content/uploads/2014/03/Batman-Arkham-Knight_PS4-cover.jpg", 5.0, 75.00),
	(18, "Mortal Kombat x", "ps4", "fighting", "http://www.psu.com/media/articles/image/PS4PS3MortalKombatXCoverArt.png", 5.0, 80.00),
	(19, "Red Dead Redemption", "xbox 360", "adventure", "http://media.ign.com/games/image/object/143/14320288/red_dead_redemption_360.jpg", 3.3, 29.99),
	(20, "the Walking Dead", "pc", "horror", "http://cdn2.spong.com/pack/t/h/thewalking391942l/_-The-Walking-Dead-PC-_.jpg", 4.8, 50.00); 
ALTER TABLE Games AUTO_INCREMENT=21;

CREATE TABLE IF NOT EXISTS Wants(
WantId INTEGER NOT NULL AUTO_INCREMENT,
UserId INTEGER NOT NULL,
GameId INTEGER NOT NULL,
MaxPrice DECIMAL(5,2) NOT NULL,
PRIMARY KEY (WantId),
FOREIGN KEY fk_wants1 (UserId) REFERENCES Users (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY fk_wants2 (GameId) REFERENCES Games (GameId) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=INNODB;
INSERT INTO Wants
VALUES  (1,2,1,10.00),
        (2,3,2,10.00),
        (3,4,3,10.00),
        (4,4,4,15.00),
	(5,2,5,15.00),
	(6,2,6,10.00),
	(7,2,7,10.00),
	(8,3,8,10.00),
	(9,4,9,10.00),
	(10,4,10,10.00),
	(11,2,11,10.00),
	(12,3,12,15.00),
	(13,4,13,10.00),
	(14,1,14,10.00),
	(15,2,15,15.00),
	(16,3,16,10.00),
	(17,4,17,10.00),
	(18,1,18,15.00),
	(19,2,19,10.00),
	(20,3,20,10.00);
ALTER TABLE Wants AUTO_INCREMENT=21;

CREATE TABLE IF NOT EXISTS Haves(
HaveId INTEGER NOT NULL AUTO_INCREMENT,
UserId INTEGER NOT NULL,
GameId INTEGER NOT NULL,
SellingPrice DECIMAL(5,2) NOT NULL,
PRIMARY KEY (HaveId),
FOREIGN KEY fk_Haves1 (UserId) REFERENCES Users (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY fk_Haves2 (GameId) REFERENCES Games (GameId) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=INNODB;
INSERT INTO Haves
VALUES  (1,2,1,15.00),
        (2,3,2,10.00),
        (3,4,3,15.00),
        (4,4,4,10.00),
	(5,2,5,10.00),
	(6,2,6,10.00),
	(7,2,7,15.00),
	(8,3,8,10.00),
	(9,4,9,10.00),
	(10,4,10,15.00),
    (11,3,1,10.00),
	(12,3,12,10.00),
	(13,4,13,10.00),
	(14,1,14,10.00),
	(15,2,15,15.00),
	(16,3,16,15.00),
	(17,4,17,10.00),
	(18,1,18,15.00),
	(19,2,19,15.00),
	(20,3,20,10.00);
ALTER TABLE Haves AUTO_INCREMENT=21;

CREATE TABLE IF NOT EXISTS Trades(
TradeId INTEGER NOT NULL AUTO_INCREMENT,
SenderId INTEGER NOT NULL,
ReceivingId INTEGER NOT NULL,
GameId INTEGER NOT NULL,
Price DECIMAL(5,2) NOT NULL,
Completed BOOLEAN NOT NULL,
PRIMARY KEY (TradeId),
FOREIGN KEY fk_Trades1 (SenderId) REFERENCES Users (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY fk_Trades2 (ReceivingId) REFERENCES Users (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY fk_Trades3 (GameId) REFERENCES Games (GameId) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=INNODB;
INSERT INTO Trades
VALUES  (1,2,3,1,15.00,true);
ALTER TABLE Trades AUTO_INCREMENT=2;

CREATE TABLE IF NOT EXISTS Rating(
RatingId INTEGER NOT NULL AUTO_INCREMENT,
UserId INTEGER NOT NULL,
RatingScore DOUBLE NOT NULL,
PRIMARY KEY (RatingId),
FOREIGN KEY fk_Rating1 (UserId) REFERENCES Users (UserId) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=INNODB;
INSERT INTO Rating
VALUES  (1,1,10.00),
        (2,1,10.00),
        (3,1,10.00),
        (4,1,10.00),
	(5,2,10.00),
	(6,2,10.00),
	(7,2,10.00),
	(8,3,10.00),
	(9,4,10.00),
	(10,4,10.00);
ALTER TABLE Rating AUTO_INCREMENT=11;

CREATE TABLE Transaction_Log(
LogId INTEGER NOT NULL AUTO_INCREMENT,
UserId INTEGER NOT NULL,
Amount DECIMAL(5,2) NOT NULL,
Message VARCHAR(20),
Log_Time TIMESTAMP,
PRIMARY KEY(LogId))ENGINE=INNODB;


DELIMITER //
CREATE PROCEDURE GetUserByCountry(IN countryName VARCHAR(30))
BEGIN
SELECT * 
FROM Users
WHERE country = countryName;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllUsers()
BEGIN
SELECT * FROM Users;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllGames()
BEGIN
SELECT * FROM Games;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllWants()
BEGIN
SELECT * FROM Wants;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllHaves()
BEGIN
SELECT * FROM Haves;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetUserByUsernamePassword(IN inUsername VARCHAR(50), IN inPassword VARCHAR(50))
BEGIN
SELECT * from Users 
WHERE Username = inUsername AND Password = inPassword;
END; //
DELIMITER ;

CREATE TABLE Message(
MessageId INTEGER NOT NULL AUTO_INCREMENT,
ObjectId INTEGER NOT NULL,
Message VARCHAR(20),
Log_Time TIMESTAMP,
PRIMARY KEY(MessageId))ENGINE=INNODB;

/** Before delete triggers. **/

DELIMITER |
CREATE TRIGGER Delete_Wants_Message BEFORE DELETE ON Wants FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = OLD.WantId,
        Message = 'Want Deleted.',
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Delete_Haves_Message BEFORE DELETE ON Haves FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = OLD.HaveId,
        Message = 'Have Deleted.',
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Delete_Game_Message BEFORE DELETE ON Games FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = OLD.GameId,
        Message = OLD.Title,
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Delete_Users_Message BEFORE DELETE ON Users FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = OLD.UserId,
        Message = OLD.Username,
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

/** After insert triggers. **/

DELIMITER |
CREATE TRIGGER Add_Wants_Message AFTER INSERT ON Wants FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = NEW.WantId,
        Message = 'Want Added.',
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Add_Haves_Message AFTER INSERT ON Haves FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = NEW.HaveId,
        Message = 'Have Added.',
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Add_Game_Message AFTER INSERT ON Games FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = NEW.GameId,
        Message = NEW.Title,
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER Add_Users_Message AFTER INSERT ON Users FOR EACH ROW
BEGIN
    INSERT INTO Message SET 
        ObjectId = NEW.UserId,
        Message = NEW.Username,
        Log_Time = CURRENT_TIMESTAMP;
END
|
DELIMITER ;

/** Transaction_Log trigger.**/

DELIMITER |
CREATE TRIGGER Transaction_Log AFTER UPDATE ON Users FOR EACH ROW
BEGIN
    IF OLD.balance != NEW.balance THEN
        INSERT INTO Transaction_Log
            SET
                UserId = NEW.UserId,
                amount = (OLD.Balance - NEW.Balance),
                message = 'Balance changed',
                Log_Time = CURRENT_TIMESTAMP;
    END IF;
END
|
DELIMITER ;


/**
DROP PROCEDURE IF EXISTS Temp_Transaction; 
DELIMITER // 
CREATE PROCEDURE Temp_Transaction(IN payer INTEGER, IN amn DECIMAL(5,2))
BEGIN 
  DECLARE EXIT HANDLER FOR 1062 ROLLBACK; 
  START TRANSACTION; 
    
  COMMIT; 
END // 
DELIMITER ;

Need to write Stored procedures for sending money to me as a buyer,a seller and completeing trade....maybe.
DELIMITER //
CREATE PROCEDURE Buy_Transaction(IN BuyId INTEGER, IN Amount Decimal(6,2))
BEGIN
    Update Users
        SET Balance = Balance + Amount WHERE Username = "GameHub";
END; //
DELIMITER ;
**/

/**
    Use this to get trades by completed or active
DELIMITER $$
CREATE PROCEDURE Check_User_Trades(IN userId INT,BOOLEAN status,OUT amn INT)
BEGIN
    SELECT count(Completed) INTO amn
    FROM trades
    WHERE Completed = (status);
END$$
DELIMITER ;
**/

