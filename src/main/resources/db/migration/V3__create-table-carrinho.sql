create table carrinho(
    id serial primary key,
    id_usuario integer not null,
    status integer not null,
    ativo boolean default true,
    FOREIGN KEY (id_usuario) references usuario(id)
)