create table carrinho(
    id serial primary key,
    id_usuario integer not null,
    status varchar not null,
    FOREIGN KEY (id_usuario) references usuario(id)
)