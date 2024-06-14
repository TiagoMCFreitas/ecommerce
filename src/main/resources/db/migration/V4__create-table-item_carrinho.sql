create table item_carrinho (
    id serial primary key ,
    quantidade integer not null,
    id_carrinho integer not null,
    id_produto integer not null,
    ativo boolean default true,
    FOREIGN KEY (id_carrinho) REFERENCES carrinho (id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);