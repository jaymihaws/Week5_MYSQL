create database if not exists favoriteFoods;

use favoriteFoods;

drop table if exists foods;

create table foods(
	id int(11) not null auto_increment,
	name varchar(20) not null,
	cuisine varchar(20) not null,
	primary key(id)
	);
	