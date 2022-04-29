Second part of the Java Test Automation Course provided by Solvd

SQL Airport task:
The database cointains the following tables wich have the following fields. At the end you can find 

--Airports:
ID
airport_name
planes_capacity
city_ID

--Cities:
ID
citiy_name
country_ID

--Countries:
ID
country_name

--Airlines:
ID
airline_name
working_planes

--Airlines_in_airports:
ID
airline_ID
airport_ID

--Routes:
ID
departure_airport_ID
arrival_airport_ID

--Pilots:
ID
pilot_name
age
employed_by_airline

--Planes:
ID
model
capacity

--Flights:
ID
plane_ID
pilot_ID
route_ID
price_usd

--Tickets:
ID
price_usd
passenger_ID
flight_ID

--Passengers
ID
passenger_name
email
age

-Luggage
ID
weight_in_kg
owner_ID

![dbDiagram](https://user-images.githubusercontent.com/90850725/165952242-20101d3b-8fcb-4e7a-a099-4d0346dd9a54.png)
