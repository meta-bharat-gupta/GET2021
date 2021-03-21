-- query 1
-- Create appropriate tables and relationships for the same and write a SQL
-- query for that returns a Resultset containing Zip Code, City Names and
-- States ordered by State Name and City Name.

select pin as ZipCode, area, city, state from address
group by ZipCode
order by state, city;