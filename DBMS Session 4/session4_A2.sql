-- query 1
-- Create a Stored procedure to retrieve average sales of each product in a month.
-- Month and year will be input parameter to function
DELIMITER ;;
create procedure averageSales(
    IN month INT,
    IN year INT
)
BEGIN
    select p.productId, p.productName, AVG(od.quantity) as AverageSale from orderDetails as od
    left join products as p on p.productId = od.productId
    inner join orders as o on o.orderId = od.orderId
    where MONTH(o.date) = month and YEAR(o.date) = year
    group by p.productId;
END;;

DELIMITER ;

call averageSales(2, 2021);


-- query 2
-- Create a stored procedure to retrieve table having order detail with status for a given period. 
-- Start date and end date will be input parameter. 
-- Put validation on input dates like start date is less than end date. 
-- If start date is greater than end date take first date of month as start date
DELIMITER ;;
create procedure getOrderDetails(
    IN startDate DATE,
    IN endDate DATE
)
BEGIN
    set startDate = IF (startDate> endDate, DATE_ADD(startDate, INTERVAL - DAY(startDate)+ 1 DAY), startDate);

    select o.orderId, o.totalAmount, o.date, o.status from orders as o
    where o.date between startDate and endDate;
END;;

DELIMITER ;

call getOrderDetails('2021-03-25','2021-03-21');