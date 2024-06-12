create table pedido(
    id serial primary key,
    total_pedido float not null,
    cep_entrega varchar not null,
    rua_entrega varchar not null,
    numero_entrega varchar not null,
    id_carrinho integer not null,
    status varchar not null,
    foreign key (id_carrinho) references carrinho(id)
);