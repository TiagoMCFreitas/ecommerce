create table carrinho(
    id serial primary key,
    id_usuario integer not null,
    carrinho_fechado boolean not null,
    FOREIGN KEY (id_usuario) references usuario(id)
)