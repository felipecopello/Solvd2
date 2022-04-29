INSERT INTO airlines (airline_name, working_planes)
VALUES ("Qatar Airways", 1350),
("American Airlines", 1826),
("Iberia", 820),
("Emirates", 1666);

INSERT INTO countries (country_name)
VALUES ("Argentina"),
("Belarus"),
("United States"),
("England"),
("France"),
("Australia"),
("Mexico");

INSERT INTO cities (city_name, country_ID)
VALUES ("Buenos Aires", (SELECT ID FROM countries WHERE country_name ="Argentina")),
("Minsk", (SELECT ID FROM countries WHERE country_name ="Belarus")),
("Nueva York", (SELECT ID FROM countries WHERE country_name ="United States")),
("London", (SELECT ID FROM countries WHERE country_name ="England")),
("París", (SELECT ID FROM countries WHERE country_name ="France")),
("Sydney", (SELECT ID FROM countries WHERE country_name ="Australia")),
("Ciudad de Mexico", (SELECT ID FROM countries WHERE country_name ="Mexico"));

INSERT INTO airports (airport_name,planes_capacity, city_ID)
VALUES ("Aeropuerto Internacional de Ezeiza", 183, (SELECT ID FROM cities WHERE city_name = "Buenos Aires")),
("Minsk International Airport", 198, (SELECT ID FROM cities WHERE city_name = "Minsk")),
(" John F. Kennedy International Airport ", 356, (SELECT ID FROM cities WHERE city_name = "Nueva York")),
("Heathrow Airport", 398, (SELECT ID FROM cities WHERE city_name = "London")),
("Paris-Charles de Gaulle International Airport", 281, (SELECT ID FROM cities WHERE city_name = "París")),
("Sydney Kingsford Smith Airport", 188, (SELECT ID FROM cities WHERE city_name = "Sydney")),
("Mexico City International Airport ", 212, (SELECT ID FROM cities WHERE city_name = "Ciudad de Mexico"));

INSERT INTO airlines_in_airports (airline_ID,airport_ID)
VALUES (1,1),(1,2),(1,4),(1,5),(1,7),(2,3),(2,2),(2,6),(2,1),(3,1),(3,4),(3,2),(3,6),(3,5),(4,1),(4,2),(4,4),(4,6),(4,7);

INSERT INTO passengers (passenger_name,email,age)
VALUES ("Felipe Copello", "felipecopello@gmail.com", 27),
("Pedro Sanchez", "pedrosanchez@gmail.com", 43),
("Maria Lopez", "marialopez@gmail.com", 69),
("Susana Perez", "superez@gmail.com", 87);

INSERT INTO pilots (pilot_name,age,employed_by_airline)
VALUES ("Danna García", 41,1),
("Mario Cimarro", 61,1),
("Jorge Cao", 38,2),
("Michel Brown", 54,3),
("Zharick León", 67,4),
("Sergio Goyri", 58,2),
("Bernardo Flores", 33,3);

INSERT INTO planes (model,capacity)
VALUES("Boeing 747-8",421),
("Boeing 777-9",128),
("Boeing Unified 787-8", 192);

INSERT INTO luggages (weight_in_kg,owner_ID)
VALUES (17.5,1),
(20.3,2),
(12.1,3),
(25.0,4);

INSERT INTO routes (departure_airport_ID,arrival_airport_ID)
VALUES (1,4),(1,3),(1,5),(1,7),(2,4),(2,6),(2,1),(3,2),(3,4),(3,6),(4,1),(4,2),(4,5);

INSERT INTO flights (plane_ID,pilot_ID,route_ID, price_usd)
VALUES (1,2,1,200),(2,4,2,250),(3,3,3,400),(1,7,4,350),(2,6,5,600),(3,5,6,420),(2,1,8,190),(1,7,7,490),(3,2,9,360)
,(1,3,10,210),(2,4,11,350),(1,7,12,420),(2,6,13,570);

