create table pedido(
    id serial primary key,
    total_pedido float not null,
    id_carrinho integer not null,
    status varchar not null,
    ativo boolean default true,
    foreign key (id_carrinho) references carrinho(id)
);