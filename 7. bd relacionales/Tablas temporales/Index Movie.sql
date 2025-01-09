create index movies_name_idx on movies(title);

show index from movies;

# El nombre es un campo que se consulta mucho, tiende a ser único y sirve para identificar a toda la fila.