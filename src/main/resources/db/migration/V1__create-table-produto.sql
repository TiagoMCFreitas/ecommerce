create table produto
(
    id         serial primary key,
    nome       varchar,
    descricao  varchar,
    preco      float,
    quantidade integer,
    foto       varchar,
    tipo_produto varchar,
    ativo boolean default true
);