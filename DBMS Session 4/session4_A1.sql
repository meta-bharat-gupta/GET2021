-- query 1
-- Create a function to calculate number of orders in a month. 
-- Month and year will be input parameter to function.

DELIMITER ;;
create function getOrderCount(year INT , month INT)   
returns INT
DETERMINISTIC
BEGIN  
    declare orderCount INT;
    set orderCount = (select count(orderId) from orders where MONTH(date)= month and YEAR(date)=year);
    return (orderCount);  
END;;
DELIMITER ;

SELECT getOrderCount(2021,3);


-- Create a function to return month in a year having maximum orders. 
-- Year will be input parameter.
DELIMITER ;;
create function getMaxOrderMonth(year INT)   
returns INT
DETERMINISTIC  
BEGIN  
    declare maxOrderMonth INT;
    
    set maxOrderMonth = ( select MONTH(date) from orders where YEAR(date)=year
    group by MONTH(date) order by count(orderId) desc limit 1);
    return (maxOrderMonth);  
END;;
DELIMITER ;

SELECT getMaxOrderMonth(2021);