create table session(
    id varchar not null,
    id_usuario integer not null,
    data_registro timestamp not null,
    FOREIGN KEY (id_usuario) references usuario(id)
)