alter table pets add column abrigo_id bigint,
add constraint fk_abrigo_pets foreign key(abrigo_id) references abrigo(id);