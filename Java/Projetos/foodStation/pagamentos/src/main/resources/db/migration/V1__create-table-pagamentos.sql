create table pagamentos(

    id bigint not null auto_increment,
    valor decimal(19,2) not null,
    nome varchar(250) not null,
    numero varchar(19) not null unique,
    expiracao date not null,
    codigo varchar(3) not null,
    status varchar(100) not null,
    pedido_id bigint not null,
    forma_de_pagamento_id bigint not null,

    primary key(id)
);