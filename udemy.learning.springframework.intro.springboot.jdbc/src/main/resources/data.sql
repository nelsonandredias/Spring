create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);


insert into person (id, name, location, birth_date) values (10001, 'Nelson', 'Lisbon', sysdate());
insert into person (id, name, location, birth_date) values (10002, 'Andre', 'Amadora', sysdate());
insert into person (id, name, location, birth_date) values (10003, 'Bernardo', 'Porto', sysdate());
insert into person (id, name, location, birth_date) values (10004, 'Jose', 'Faro', sysdate());
insert into person (id, name, location, birth_date) values (10005, 'Rogerio', 'Faro', sysdate());
insert into person (id, name, location, birth_date) values (10006, 'Fernando', 'Coimbra', sysdate());