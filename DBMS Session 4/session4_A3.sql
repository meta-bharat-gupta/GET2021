-- Identify the columns require indexing in order, product, 
-- category tables and create indexes.

create index orderId_date_index
on orders(orderId, date);

create index productId_index
on products(Product_Id);

create index categoryId_index
on category(cid);