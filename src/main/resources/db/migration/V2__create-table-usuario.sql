create table usuario(
    id serial primary key,
    nome varchar not null,
    cpf varchar not null unique,
    email varchar not null unique,
    senha varchar not null,
    telefone varchar not null,
    tipo_usuario varchar not null,
    ativo boolean default true
);