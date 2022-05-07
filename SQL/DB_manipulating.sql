/*I want to get from buenos aires to minsk*/

/*to see the cities id*/
select * from cities;

/*to see the airport names*/
select * from airports;

/*to see the routes i need to take*/
select * from routes where departure_airport_ID=(select id from airports where airport_name="Aeropuerto Internacional de Ezeiza") 
or arrival_airport_ID=(select id from airports where airport_name="Minsk International Airport");

/*to see the flights that make those routes, and their price*/
select * from flights where route_ID in (2,8) ;
select *,sum(price_usd) from flights where route_ID in (2,8) ;

update passengers 
set age = 28
/*dont forget where declaration or it changes the hole table*/
where ID = 1;

update passengers 
set age = 33
where passenger_name = "Pedro Sanchez";

update passengers 
set email = "marialopez999@gmail.com"
where ID = 3;

update luggages
set weight_in_kg = 23.2
where ID = 1;

update luggages
set owner_ID = 2
where ID = 1;

update pilots 
set employed_by_airline = 2
where ID = 2;

update pilots 
set age = 55
where ID = 4;

update pilots
set pilot_name = "Miguel Brown"
where pilot_name= "Michel Brown";

delete from pilots where ID = 1;
delete from pilots where ID = 3;
delete from luggages where weight_in_kg = 25;
delete from luggages where weight_in_kg < 23;
delete from passengers where age > 70;
delete from passengers where age <= 18;

alter table tickets
add column flight_date varchar(45);

/*
alter table tickets
alter column flight_date datetime;
*/	

alter table tickets
drop column flight_date;

alter table Cities
add column pupulation int NULL;

INSERT INTO tickets (price_usd,passenger_ID,flight_ID)
values (500,2,4);

select * from airports
join cities on cities.ID = airports.city_ID
join countries on countries.ID = cities.country_ID
join routes on departure_airport_ID = airports.ID
join flights on flights.route_ID = routes.ID
join pilots on pilots.ID = flights.pilot_ID
join airlines on airlines.ID = pilots.employed_by_airline
join planes on planes.ID = flights.plane_ID
join tickets on flights.ID = tickets.flight_ID
join passengers on passengers.ID = tickets.passenger_ID
join luggages on luggages.owner_ID = passengers.ID;

select * from flights
inner join planes on planes.ID = plane_ID;

select * from flights
left join planes on planes.ID = plane_ID;

select * from flights
right join planes on planes.ID = plane_ID;

select * from flights
full join planes on planes.ID = plane_ID;

select avg(capacity) from planes;

select avg(capacity) from planes
where ID IN (1,3);

SELECT * from planes 
where capacity between 100 and 350;

SELECT * from planes 
where capacity between 100 and 350 having sum(capacity)<800;

SELECT * from planes 
where capacity between 100 and 350 having sum(capacity)<800 order by ID;

select avg(age) from pilots;

select * from pilots
having age < avg(age);

select * from pilots
group by employed_by_airline;

select * from pilots
group by employed_by_airline
order by ID DESC;

select * from airlines
having working_planes < avg(working_planes);

select sum(working_planes) from airlines;

select*, count(working_planes) from airlines
where working_planes >=1000
LIMIT 10;

select* from pilots
join airlines on airlines.ID=pilots.employed_by_airline 
where pilots.id=1;

Select * from cities
join countries on countries.ID=cities.country_ID where cities.id=1;

Select * from airports join cities on cities.ID=airports.city_ID where airports.id=1;

select * from airports
join cities on cities.ID = airports.city_ID
join countries on countries.ID = cities.country_ID
where airports.id=1;

Select * from luggages join passengers on passengers.id = luggages.owner_ID where  passengers.id=1 ;

Select * from routes 
join airports a1 on a1.ID=routes.departure_airport_ID
join airports a2 on routes.arrival_airport_ID=a2.id
where routes.id=1 and routes.arrival_airport_ID=a2.id;

Select * from routes where ID=1;

Select * from planes
join flights on flights.plane_ID=planes.ID where planes.id =1;

Select * from pilots
join flights on flights.pilot_ID=pilots.ID where pilots.id =3;

Select * from routes
join flights on flights.route_ID=routes.ID where routes.id =1;

select * from airlines_in_airports 
join airports on airports.id = airlines_in_airports.airport_ID
where airline_ID=1;








