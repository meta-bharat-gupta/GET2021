-- query 1
-- Display Recent 50 Orders placed (Id, Order Date, Order Total).

select orderId, userId, totalAmount from orders order by date desc limit 50;

-- query 2
-- Display 10 most expensive Orders.
select orderId, totalAmount from orders order by totalAmount desc limit 10;

-- query 3
-- Display all the Orders which are placed more than 10 days old and one or 
-- more items from those orders are still not shipped.
select o.orderId, o.totalAmount, o.date, od.status from orders as o
inner join orderdetails as od on o.orderId = od.orderId
where od.status = "Not Shipped" and
datediff(now(), o.date)>10;

-- query 4
-- Display list of shoppers which haven't ordered anything since last month
select u.userId, u.firstName from user as u
inner join orders as o on u.userId = o.userId and u.role = "Shopper"
and datediff(now(), o.date)>30 group by u.userId;


-- query 5
-- Display list of shopper along with orders placed by them in last 15 days.
select u.userId, u.firstName from user as u
inner join orders as o on u.userId = o.userId and u.role = "Shopper"
and datediff(now(), o.date) between 0 and 15;

-- query 6
-- Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
select od.orderId, p.productId, p.productName from orderdetails as od 
inner join products as p on od.productId = p.productId
where od.orderId = 202 and od.status = "Shipped";

-- query 7
-- Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
select o.orderId, p.productName, o.date, o.totalAmount from orders as o
inner join orderdetails as od on o.orderId = od.orderId
inner join products as p on p.productId = od.productId and o.totalAmount between 20000 and 50000;