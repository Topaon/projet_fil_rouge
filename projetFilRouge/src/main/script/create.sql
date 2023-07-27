create table domaine (id number(19,0) generated as identity, description varchar2(255 char), nom varchar2(255 char), primary key (id));
create table livre (id number(19,0) generated as identity, auteur varchar2(255 char), dispo number(1,0), editeur varchar2(255 char), etat varchar2(255 char), titre varchar2(255 char), primary key (id));
