-- query 1
-- Display Shopper’s information along with number of orders he/she placed during last 30 days.

select u.userId, count(o.orderId) as "Order Count", u.firstName from user as u
left join orders as o on u.userId = o.userId 
where u.role = "Shopper" and datediff(now(), o.date)<30 group by u.userId;

-- query 2
-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

select o.userId, u.firstName, sum(o.totalAmount) as totalAmount from orders as o
inner join user as u on o.userId = u.userId
where u.role = "Shopper" and datediff(now(), o.date) < 30 group by o.userId
order by totalAmount desc limit 10;

-- query 3
-- Display top 20 Products which are ordered most in last 60 days along with numbers.

select p.productId, p.productName, count(od.productId) as ProductCount from 
products as p inner join orderDetails as od on p.productId = od.productId
inner join orders as o on o.orderId = od.orderId
where datediff(now(), o.date)<60 group by od.productId
order by ProductCount desc limit 20;

-- query 4
-- Display Monthly sales revenue of the StoreFront for last 6 months. 
-- It should display each month’s sale.

select sum(o.totalAmount) as Revenue, 
period_diff(date_format(now(), "%Y%m"), date_format(o.date, "%Y%m")) as MonthDiff
from orders as o where 
period_diff(date_format(now(), "%Y%m"), date_format(o.date, "%Y%m")) < 6 group by MonthDiff;

-- query 5
-- Mark the products as Inactive which are not ordered in last 90 days.

SET SQL_SAFE_UPDATES=0;

update products set status = "Inactive" where productId not in 
(select od.productId from orders as o inner join orderDetails as od on od.orderId = o.orderId
where datediff(now(), o.date)<90 group by od.productId);

SET SQL_SAFE_UPDATES=1;

-- query 6
-- Given a category search keyword, display all the Products present in this category/categories. 
select p.productId, p.productName from products as p
inner join productCategory as pc on pc.productId = p.productId
where pc.categoryId in 
(select cid from category where cname LIKE "%book%");

-- query 7
-- Display top 10 Items which were cancelled most
select p.productId, p.productName from products as p 
inner join orderDetails od on od.productId = p.productId 
where od.status = "Cancelled" limit 10;