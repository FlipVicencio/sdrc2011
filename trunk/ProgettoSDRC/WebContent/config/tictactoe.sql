drop database if exists tictactoe;
create database tictactoe;

use tictactoe;

drop table if exists utente ;
create table utente(
username varchar(20) primary key,
password varchar(100),
nome varchar(20),
cognome varchar(30),
eta int,
email varchar(30),
nVinte int,
nPerse int,
nPari int
);

