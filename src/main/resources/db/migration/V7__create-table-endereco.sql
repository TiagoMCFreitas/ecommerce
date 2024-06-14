create table endereco (
    id serial primary key ,
    cep varchar not null,
    rua varchar not null,
    cidade varchar not null,
    uf varchar not null,
    numero varchar not null,
    complemento varchar not null,
    id_usuario integer not null,
    ativo boolean default true,
    FOREIGN KEY (id_usuario) references usuario(id)
);