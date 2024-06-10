create table item (
    id serial primary key ,
    quantidade integer not null,
    id_carrinho integer not null,
    id_produto integer not null,
    FOREIGN KEY (id_carrinho) REFERENCES carrinho (id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
)