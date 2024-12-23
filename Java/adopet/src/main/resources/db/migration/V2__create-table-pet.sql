create table pets(

id bigint not null auto_increment,
tipo varchar(50) not null,
nome varchar(100) not null,
raca varchar(50) not null,
idade varchar(3) not null,
cor varchar(20) not null,
peso varchar(6) not null,

primary key(id)

);