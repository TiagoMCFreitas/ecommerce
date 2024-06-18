create table pedido(
    id serial primary key,
    total_pedido float not null,
    id_carrinho integer not null,
    status integer not null,
    id_endereco integer not null,
    ativo boolean default true,
    data_registro timestamp not null,
    foreign key (id_carrinho) references carrinho(id),
    foreign key (id_endereco) references endereco(id)
);