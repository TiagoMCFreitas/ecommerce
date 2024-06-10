create table usuario(
    id serial primary key,
    nome varchar not null,
    cpf varchar not null,
    email varchar not null ,
    telefone varchar not null,
    tipo_usuario varchar not null
);