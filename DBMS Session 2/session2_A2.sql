-- Inserting data to user table
INSERT INTO user
(userId, firstName, lastName, email, password, mobile, role)
values
(100, "Bharat", "Gupta", "bharatgupta@gmail.com", "bharat", "9999999999", "Admin"),
(101, "User1", "One", "user1@gmail.com", "user1", "9393939939", "Shopper"),
(102, "User2", "Two", "user2@gmail.com", "user2", "9393939939", "Shopper"),
(103, "User3", "Three", "user3@gmail.com", "user3", "9393939939", "Shopper"),
(104, "User4", "Four", "user4@gmail.com", "user4", "9393939939", "Shopper"),
(105, "User5", "Five", "user5@gmail.com", "user5", "9393939939", "Shopper"),
(106, "User6", "Six", "user6@gmail.com", "user6", "9393939939", "Shopper"),
(107, "User7", "Seven", "user7@gmail.com", "user7", "9393939939", "Shopper"),
(108, "User8", "Eight", "user8@gmail.com", "user8", "9393939939", "Shopper"),
(109, "User9", "Nine", "user9@gmail.com", "user9", "9393939939", "Shopper"),
(110, "User10", "Ten", "user10@gmail.com", "user10", "9393939939", "Shopper");


-- inserting data into products table
INSERT INTO products
(productId, productName, description, price, quantity, status, date)
values
(1001, "Ignited Minds", "Book by Dr. APJ Abdul Kalam", 400, 55, "Active", "2021-03-11 12:00:00"),
(1002, "The Art of Happiness", "Book by HH Dalai Lama and Howard C Cutler", 600, 30, "Active", "2021-02-21 12:00:00"),
(1003, "Think Like a Monk", "Book by Jay Shetty", 200, 30, "Active", "2021-03-11 12:00:00"),
(1004, "Jeans", "Denim Jeans", 900, 80, "Active", "2019-09-12 12:00:00"),
(1005, "Palace of Illusion", "By Chitra Banarjee", 100, 10, "Inactive", "2021-01-01 12:00:00"),
(1006, "Bhagavad Gita", "Geeta Press", 750, 30, "Active", "2020-08-21 12:00:00"),
(2007, "Dell Laptop", "Dell Latitude 3410", 65000, 5, "Active", "2020-11-30 12:00:00"),
(2008, "Acer Laptop", "Acer Aspire 7 Laptop", 49000, 7, "Active", "2021-01-10 12:00:00"),
(3009, "Realme Phone", "Realme Phone x7", 19999, 20, "Active", "2021-03-11 12:00:00"),
(3010, "Redmi Phone", "Redmi Phone Note 7", 10000, 50, "Active", "2021-03-11 12:00:00"),
(3011, "iPhone 11", "iPhone 11 4GB", 46000, 10, "Active", "2020-12-11 12:00:00"),
(3012, "Keypad Phone", "Nokia's Keypad Phone", 1500, 100, "Active", "2020-03-11 12:00:00"),
(3013, "Micromax Keypad Phone", "Micromax's Keypad Phone", 1800, 60, "Inactive", "2020-09-24 12:00:00");


-- inserting data into category table
INSERT INTO category
(cid, cname, parentId)
VALUES
(1, "Books", null),
(2, "Motivational Books", 1),
(3, "Mythological Books", 1),
(4, "Fictional Books", 1),
(5, "Electronics", null),
(6, "Mobile Phones", 5),
(7, "Laptops", 5),
(8, "Keypad Phones", 6),
(9, "Smart Phones", 6),
(10, "Clothes", null),
(11, "Men's Clothing", 10),
(12, "Women's Clothing", 10);


-- inserting data into productcategory mapping table
INSERT INTO productCategory
(productId, categoryid)
VALUES
(1001, 2),
(1002, 2),
(1003, 2),
(1004, 11),
(1004, 12),
(1005, 3),
(1006, 3),
(2007, 7),
(2008, 7),
(3009, 9),
(3010, 9),
(3011, 9),
(3012, 8),
(3013, 8);


-- entering image paths into table
INSERT INTO productImages
(imageId, productId, path)
VALUES
(401, 2007, "Dell Laptop Image 1"),
(402, 2007, "Dell Laptop Image 2"),
(403, 2008, "Acer Laptop Image"),
(404, 1001, "Ignited Minds Image 1"),
(405, 1001, "Dr. APJ Abdul Kalam"),
(406, 1003, "Think like a Monk Image"),
(407, 1004, "Jeans Image 1"),
(408, 1004, "Jeans Image 2"),
(409, 1004, "Jeans Image 3"),
(410, 3011, "Iphone"),
(411, 3013, "Micromax keypad Phone Image"),
(412, 3011, "Iphone Image 2"),
(413, 3011, "Iphone Image 3"),
(414, 3009, "Realme Phone"),
(415, 3009, "Realme Phone Image 2");


-- inserting addresses of users
INSERT INTO address
(addressId, userId, area, city, state, pin)
VALUES
(701, 100, "Arya Nagar", "Alwar", "Rajasthan", 301001),
(702, 102, "Gandhi Nagar", "Jaipur", "Rajasthan", 302002),
(703, 102, "Suraj Nagar", "Alwar", "Rajasthan", 301001),
(704, 103, "Sector 18", "Jaipur", "Rajasthan", 302020),
(705, 104, "Ram Nagar", "Jodhpur", "Rajasthan", 302604),
(706, 105, "Sector 15", "Udaipur", "Rajasthan", 303030),
(707, 105, "Panchvati colony", "Alwar", "Rajasthan", 301001),
(708, 106, "Malakhera", "Udaipur", "Rajasthan", 303031),
(709, 107, "Street 45", "Jodhpur", "Rajasthan", 302601),
(710, 108, "Ashoka Talkies", "Alwar", "Rajasthan", 301001),
(711, 109, "Nangli Circle", "Alwar", "Rajasthan", 301001),
(712, 110, "NEB", "Alwar", "Rajasthan", 301002);


-- inserting orders
INSERT INTO orders
(orderId, userId, totalAmount, date, status)
VALUES
(200, 102, 1000, '2021-02-27 12:34:12', 'Delivered'),
(201, 102, 40000, '2021-02-28 10:24:11', 'Returned'),
(202, 103, 2000, '2020-04-17 01:15:12', 'Shipped'),
(203, 104, 30000, '2019-05-18 05:27:12', 'Shipped'),
(204, 104, 15000, '2021-01-01 09:45:12', 'Cancelled'),
(205, 107, 25000, '2021-03-16 11:02:12', 'Cancelled'),
(206, 102, 45500, '2021-02-13 02:30:12', 'Delivered'),
(207, 105, 75000, '2021-03-02 02:30:12', 'Delivered'),
(208, 105, 170000, '2021-02-02 22:03:21', 'Cancelled'),
(209, 108, 15000, '2021-03-10 20:30:21', 'Not Shipped'),
(210, 110, 30000, '2021-03-05 13:10:22', 'Not Shipped');


-- inserting order details
INSERT INTO orderDetails
(orderId, productId, quantity, status)
VALUES
(200, 1003, 1, 'Delivered'),
(201, 2008, 1, 'Returned'),
(201, 3010, 1, 'Returned'),
(202, 1004, 2, 'Shipped'),
(203, 2007, 1, 'Shipped'),
(204, 2008, 1, 'Cancelled'),
(205, 1005, 1, 'Cancelled'),
(206, 1001, 1, 'Not Shipped'),
(206, 1002, 1, 'Delivered'),
(207, 3010, 1, 'Delivered'),
(208, 1005, 1, 'Not Shipped'),
(208, 2008, 1, 'Shipped'),
(208, 3009, 1, 'Cancelled'),
(208, 3011, 1, 'Shipped'),
(209, 2008, 1, 'Not Shipped'),
(210, 2007, 1, 'Not Shipped');


-- query 2
-- Display Id, Title, Category Title, Price of the products 
-- which are Active and recently added products should be at top.
select p.productid, p.productname, c.cname as "Category" , p.price  from products as p left join
productcategory as pc on p.productid = pc.productid left join 
category as c on pc.categoryid = c.cid where p.status = "Active" order by p.date desc;


-- query 3
-- Display the list of products which don't have any images.
select p.productid, p.productname from products as p where 
p.productid not in (select productid from productImages);

-- query 4
-- Display all Id, Title and Parent Category Title for all the Categories listed, 
-- sorted by Parent Category Title and then Category Title. (If Category is 
-- top category then Parent Category Title column should display “Top Category” as value.)
select c1.cid, c1.cname, ifnull(c2.cname, 'Top Category') as "Parent Category" 
from category as c1 left join category as c2 
on c1.parentid = c2.cid order by c2.cname, c1.cname;


-- query 5
-- Display Id, Title, Parent Category Title of all the 
-- leaf Categories (categories which are not parent of any other category)
select c.cid, c.cname, p.cname from category as c
left join category as p on c.parentid = p.cid
where c.cid not in (select parentId from category);


-- query 6
-- Display Product Title, Price & Description which falls into 
-- particular category Title (i.e. “Mobile”)
select p.productname, p.price, p.description from products as p where p.productid in 
(select pc.productid from productCategory as pc where pc.categoryid in 
(select cid from category where cname = "Motivational Books"));


-- query 7
-- Display the list of Products whose Quantity on hand (Inventory) is under 50.
select p.productname, p.quantity from products as p where p.quantity <50;