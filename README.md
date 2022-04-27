Second part of the Java Test Automation Course provided by Solvd

SQL Airport task: In the file DB_creation, i define the tables and their columns i will be using. Those are: airlines, airports, airlines_in_airport wich is the realizacion of the many to many relation between those two tables, cities, countries, flights, luggages, passengers, pilots, planes, routes and tickets. The cities and countries tables are used in the airports table, to specify the location. There are defined routes from one airport to another, and the flights use those routes. Each flight has an airline that provides that service, it uses a specific plane, wich is driven by a specific pilot, the flights have a price too. There are passengers that are the owners of the tickets for the flights, the tickets include luggage as well.

The file DB_filling, populates each table with information

The file DB_manipulating, asks for the information needed to know how to get from buenos aires to minsk, wich flights take, and how much does it cost.