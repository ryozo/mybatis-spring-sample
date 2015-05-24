-- create user table
create table users(id bigint auto_increment primary key, userid char(5) not null unique, name varchar(255) not null, age int not null, mail varchar(256));

-- create product table
create table products(id bigint auto_increment primary key, productcode char(10) not null unique, name varchar(255) not null, price int not null);

-- create order
create table orders(id bigint auto_increment primary key, ordercode char(10) not null unique, orderdate varchar not null, users_id bigint not null);

-- create order detail
create table order_details(id bigint auto_increment primary key, count int not null, orders_id bigint not null, products_id bigint not null);
