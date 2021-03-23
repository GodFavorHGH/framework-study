drop database if exists mall;
create database mall;
use mall;
drop table if exists commodity;
create table commodity(
    id int not null auto_increment,
    name varchar(64) not null,
    brand varchar(64) not null,
    model varchar(62) not null,
    type varchar(64) not null,
    price decimal(10,2) not null,
    discount double default 1,
    stock int not null,
    description varchar(256) not null,
    primary key(id),
    index inx_tp(type),
    index inx_prc(price)
);
insert into commodity(name,type,brand,model,price,discount,stock,description)values('HUAWEI Mate40 pro plus','phone','HUAWEI','Mate40 pro plus',8999,1,1000,'华为高端旗舰机');
insert into commodity(name,type,brand,model,price,discount,stock,description)values('XIAOMI 10 pro plus','phone','XIAOMI','MI 10 pro plus',5999,1,1000,'小米高端旗舰机');