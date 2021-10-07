select count(*) from city;

SELECT c.Name FROM city c
INNER JOIN  country c1 ON c.CountryCode = c1.Code
WHERE c.Population>9000000

select c.name from city c
inner join country c1 on c.countrycode = c1.code
where c.population>5000000