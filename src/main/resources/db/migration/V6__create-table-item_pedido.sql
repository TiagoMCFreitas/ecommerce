create table item_pedido (
    id serial primary key ,
    quantidade integer not null,
    id_pedido integer not null,
    id_produto integer not null,
    FOREIGN KEY (id_pedido) REFERENCES pedido (id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);