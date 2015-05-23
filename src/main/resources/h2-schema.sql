-- create user table
create table users(id bigint auto_increment primary key, userid char(5) not null unique, name varchar(255) not null, age int not null, mail varchar(256));
