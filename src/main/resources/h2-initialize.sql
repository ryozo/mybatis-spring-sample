create table user(id bigint auto_increment primary key, name varchar(255) not null, age int not null, mail varchar(256));

insert into user (name, age, mail) values ('taro yamada', 20, 'taro@example.com');
insert into user (name, age, mail) values ('jiro suzuki', 30, 'jiro@example.com');
insert into user (name, age, mail) values ('sabro sato', 40, 'sabro@example.com');
