create table abrigo(

id bigint not null auto_increment,
nome varchar(100) not null,
telefone varchar(20) not null unique,
email varchar(100) not null,

primary key(id)

);