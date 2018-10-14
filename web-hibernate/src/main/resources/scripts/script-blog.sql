CREATE TABLE blog.post (
	id serial not null, 
	texto varchar(1000) not null, 
	data timestamp not null
);

alter table blog.post 
	add constraint pk_post primary key(id);

create table blog.imagem (
	id serial not null, 
	arquivo varchar(100) not null, 
	id_post integer not null
);


alter table blog.imagem
	add constraint pk_imagem primary key (id); 

alter table blog.imagem
	add constraint fk_post_imagem foreign key(id_post) references blog.post(id);