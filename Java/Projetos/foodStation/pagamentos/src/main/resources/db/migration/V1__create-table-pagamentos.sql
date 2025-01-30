create table pagamentos(

    id bigint not null auto_increment,
    valor double not null,
    nome varchar(250) not null,
    numero varchar(16) not null unique,
    expiracao date not null,
    codigo varchar(3) not null,
    status varchar(100) not null,
    pedido_id bigint not null,
    forma_de_pagamento_id bigint not null,

    primary key(id),

    constraint fk_pagamento_pedido_id foreign key(pedido_id) references pedido(id),
    constraint fk_pagamento_forma_de_pagamento_id foreign key(forma_de_pagamento_id) references forma_de_pagamento(id)
);