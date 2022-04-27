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


