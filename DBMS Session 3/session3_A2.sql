-- query 1
-- Display the list of products (Id, Title, Count of Categories) which fall 
-- in more than one Categories.
select p.productId, p.productName, count(pc.categoryId) as "Number of Categories"
from products as p inner join productCategory as pc
on p.productId = pc.productId group by p.productId
having count(pc.categoryId)>1;


-- query 2
-- Display Count of products as price range
select count(productId) from products where price between 0 and 100;
select count(productId) from products where price between 101 and 500;
select count(productId) from products where price > 500;

-- query 3
-- Display the Categories along with number of products under each category.
select pc.categoryId, c.cname, count(pc.productId) as "Product Count" from
productCategory as pc left join category as c on c.cid = pc.categoryId
group by pc.categoryId;
