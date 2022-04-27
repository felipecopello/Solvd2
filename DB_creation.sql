CREATE DATABASE `airport`;

CREATE TABLE Countries (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(45) NOT NULL
)ENGINE=INNODB;

CREATE TABLE Cities (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    city_name VARCHAR(25) NOT NULL
)ENGINE=INNODB;

CREATE TABLE Airlines (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	airline_name VARCHAR(25) NOT NULL,
    working_planes int NOT NULL
)ENGINE=INNODB;

CREATE TABLE Planes (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(45) NOT NULL,
    capacity int NOT NULL
)ENGINE=INNODB;

CREATE TABLE Passengers (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    passenger_name VARCHAR(45) NOT NULL, 
	email VARCHAR(45) NOT NULL,
    age int NOT NULL
)ENGINE=INNODB;

CREATE TABLE Luggages (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    weight_in_kg float NOT NULL,
    owner_ID int,
    FOREIGN KEY (owner_ID) REFERENCES Passengers(ID)
)ENGINE=INNODB;

CREATE TABLE Pilots(
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    pilot_name VARCHAR(45) NOT NULL, 
    age int NOT NULL,
    employed_by_airline int,
    CONSTRAINT FOREIGN KEY (employed_by_airline) REFERENCES Airlines(ID)
)ENGINE=INNODB;

CREATE TABLE Airports (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    airport_name VARCHAR(45) NOT NULL,
    planes_capacity INT NOT NULL,
    country_ID INT,
    city_ID INT,
	FOREIGN KEY (country_ID) REFERENCES Countries(ID),
    FOREIGN KEY (city_ID) REFERENCES Cities(ID)
)ENGINE=INNODB;

CREATE TABLE Airlines_In_Airports (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    airline_ID INT,
    airport_ID INT,
	FOREIGN KEY (airline_ID) REFERENCES Airlines(ID),
    FOREIGN KEY (airport_ID) REFERENCES Airports(ID)
)ENGINE=INNODB;

CREATE TABLE Routes (
ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
departure_airport_ID int,
arrival_airport_ID int,
FOREIGN KEY (departure_airport_ID) REFERENCES Airports(ID),
FOREIGN KEY (arrival_airport_ID) REFERENCES Airports(ID)
)ENGINE=INNODB;

CREATE TABLE Flights (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    plane_ID int,
    airline_ID int,
    pilot_ID int,
    route_ID int,
    price_usd int NOT NULL,
    FOREIGN KEY (plane_ID) REFERENCES Planes(ID),
    FOREIGN KEY (airline_ID) REFERENCES Airlines(ID),
    FOREIGN KEY (pilot_ID) REFERENCES Pilots(ID),
    FOREIGN KEY (route_ID) REFERENCES Routes(ID)
)ENGINE=INNODB;

CREATE TABLE Tickets (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    price_usd int NOT NULL,
    passenger_ID INT,
    flight_ID INT,
    luggage_ID INT,
    FOREIGN KEY (passenger_ID) REFERENCES Passengers(ID),
    FOREIGN KEY (flight_ID) REFERENCES Flights(ID),
    FOREIGN KEY (luggage_ID) REFERENCES Luggages(ID)
)ENGINE=INNODB;


