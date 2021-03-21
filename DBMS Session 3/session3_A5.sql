-- Create a view displaying the order information
-- (Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
-- with latest ordered items should be displayed first for last 60 days
    
create view orderInformation as
select o.orderId, p.productName, p.price, u.firstName, u.email, o.date, od.status
from orders as o left join orderDetails as od on o.orderId = od.orderId
inner join products as p on p.productId = od.productId
inner join user as u on u.userId = o.userId 
where datediff(now(), o.date)<60 order by o.date desc;
    
select * from orderInformation;

-- query 2
-- Use the above view to display the Products(Items) which are in ‘shipped’ state

select orderId, productName, price, status from orderInformation
where status = "Shipped";

-- query 3
-- Use the above view to display the top 5 most selling products
select productName, count(productName) as ProductCount from orderInformation
group by productName order by ProductCount desc limit 5;