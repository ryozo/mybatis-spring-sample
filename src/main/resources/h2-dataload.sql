-- load users table
insert into users (userid, name, age, mail) values ('U0001', 'taro yamada', 20, 'taro@example.com');
insert into users (userid, name, age, mail) values ('U0002', 'jiro suzuki', 30, 'jiro@example.com');
insert into users (userid, name, age, mail) values ('U0003', 'sabro sato', 40, 'sabro@example.com');

-- load products table
insert into products (productcode, name, price) values ('PDT0000001', 'productA', 1000);
insert into products (productcode, name, price) values ('PDT0000002', 'productB', 2000);
insert into products (productcode, name, price) values ('PDT0000003', 'productC', 3000);
insert into products (productcode, name, price) values ('PDT0000004', 'productD', 4000);
insert into products (productcode, name, price) values ('PDT0000005', 'productE', 5000);

-- load orders table
insert into orders (ordercode, orderdate, users_id) values ('ORDER00001', current_timestamp(), 1);
insert into orders (ordercode, orderdate, users_id) values ('ORDER00002', current_timestamp(), 1);
insert into orders (ordercode, orderdate, users_id) values ('ORDER00003', current_timestamp(), 2);

-- load order_details
insert into order_details (count, orders_id, products_id) values (2, 1, 1);
insert into order_details (count, orders_id, products_id) values (3, 1, 3);
insert into order_details (count, orders_id, products_id) values (1, 2, 2);
insert into order_details (count, orders_id, products_id) values (5, 2, 4);
insert into order_details (count, orders_id, products_id) values (4, 2, 5);
insert into order_details (count, orders_id, products_id) values (1, 3, 1);
insert into order_details (count, orders_id, products_id) values (3, 3, 2);