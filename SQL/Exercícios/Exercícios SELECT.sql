select ano, nome, carga, descrição from cursos
where total_aulas between 20 and 30
order by total_aulas, nome;

select * from cursos
where ano in (2014, 2016, 2018)
order by ano desc, nome;

select nome, total_aulas, ano from cursos
where ano > 2015 && total_aulas < 50
order by total_aulas desc, nome;	

select nome, total_aulas, ano from cursos
where carga > 35 || total_aulas < 30
order by total_aulas desc, nome;	

select * from cursos where nome like 'P%' order by idcurso;

select distinct nacionalidade from gafanhotos order by nacionalidade;

select count(nome) from cursos;
select count(carga) from cursos where carga > 40;

select max(carga) from cursos;
select max(total_aulas) from cursos where ano = '2016'; 
select min(carga) from cursos;
select nome, min(total_aulas) from cursos where ano = '2016';

select sum(total_aulas) from cursos;
select sum(total_aulas) from cursos where ano = '2018';

select avg(ano) from cursos;
select avg(total_aulas) from cursos where ano = '2015';


/* AGRUPAMENTO */

select carga, count(*) from cursos group by carga;
select carga, count(*) from cursos where total_aulas = '30' group by carga;
select ano, carga, count(*) from cursos where total_aulas > 30 group by ano having ano > 2013 order by count(*);
select avg(carga) from cursos;
select carga, count(*) from cursos where ano > 2015 group by carga having carga > (select avg(carga) from cursos);

/* FIM DO AGRUPAMENTO */


/* TABELAS RELACIONAIS */

/* Relacionamento n - 1 */
alter table gafanhotos add column curso_preferido int after id; /* adicionando a coluna */ 
alter table gafanhotos add foreign key(curso_preferido) references cursos(idcurso); /* adicionando a chave estrangeira */ 

select * from gafanhotos;
select * from cursos;

update gafanhotos set curso_preferido = '6' where id = '1'; /* relacionando as tabelas */

select gafanhotos.nome, cursos.nome, cursos.ano from gafanhotos /*inner*/ join cursos on cursos.idcurso = gafanhotos.curso_preferido order by gafanhotos.nome; /* mostra apenas os dados que estão relacionado à outros dados */
select g.nome, c.nome, c.ano from gafanhotos as g /*inner*/ join cursos as c on c.idcurso = g.curso_preferido order by g.nome; /* abreviação com o 'as' */ 
select g.nome, c.nome, c.ano from gafanhotos as g left /*outer*/ join cursos as c on c.idcurso = g.curso_preferido order by g.nome; /* mostra todos os dados, até os nulos com preferência para a tabela da esquerda */
select g.nome, c.nome, c.ano from gafanhotos as g right /*outer*/ join cursos as c on c.idcurso = g.curso_preferido order by g.nome; /* mostra todos os dados, até os nulos com preferência para a tabela da direita */
/* Fim do relacionamento n - 1 */

/* Relacionamento n - n */
create table gafanhoto_assiste_curso (
	id int not null auto_increment, 
	data date,
	id_gafanhoto int,
	id_curso int,
	primary key(id),
	foreign key(id_gafanhoto) references gafanhotos(id),
	foreign key(id_curso) references cursos(idcurso)
) default charset = utf8mb4;

insert into gafanhoto_assiste_curso values
(default, '2014-03-01', '1', '2');

select g.nome, c.nome from gafanhotos as g 
join gafanhoto_assiste_curso as a 
on g.id = a.id_gafanhoto 
join cursos as c 
on c.idcurso = a.id_curso
order by g.nome;
/* Fim do relacionamento n - n */

/* FIM DAS TABELAS RELACIONAIS */


/* Exercícios */

select * from gafanhotos;
select * from gafanhotos where nascimento between '2000-01-01' and '2015-12-31' order by nascimento; 
select * from gafanhotos where profissão = 'programador' && sexo = 'M';
select * from gafanhotos where nacionalidade = 'Brasil' && sexo = 'F' && nome like 'J%';
select nome, nacionalidade from gafanhotos where sexo = 'M' and nome like '%silva%' and peso < '100';
select max(altura) from gafanhotos where sexo = 'M' and nacionalidade = 'Brasil';
select avg(peso) from gafanhotos;
select min(peso) from gafanhotos where sexo = 'F' and nacionalidade != 'Brasil' and nascimento between '1990-01-01' and '2000-12-31';
select count(altura) from gafanhotos where sexo = 'F' and altura > 1.90;

select profissão, count(*) from gafanhotos group by profissão order by count(*) desc;
select sexo, count(*) from gafanhotos where nascimento > '2005-01-01' group by sexo;
select nacionalidade, count(*) from gafanhotos where nacionalidade != 'Brasil' group by nacionalidade having count(*) > 3;
select peso, count(*) from gafanhotos where peso > 100 group by altura having peso > 100 and altura > (select avg(altura) from gafanhotos);

	