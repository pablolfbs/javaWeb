create database banco;
use banco;

create table colaborador (id int not null primary key auto_increment, cpf varchar(11), nome varchar(55),
							telefone varchar(14), email varchar(55), data_nasc date, id_setor int);
							
create table setor (id int not null primary key auto_increment, descricao varchar(55));
						
alter table colaborador add constraint fk1 foreign key (id_setor) references setor (id);


insert into setor (descricao) values ('Administração'), ('Tesouraria'), ('Operacional');