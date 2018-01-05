drop database if exists owndb;
create database owndb char set utf8;
use owndb;
drop table if exists user;
create table user(
	uid		int		auto_increment,
	name	varchar(255) not null,
    constraint pk_uid primary key(uid)
) engine InnoDB;