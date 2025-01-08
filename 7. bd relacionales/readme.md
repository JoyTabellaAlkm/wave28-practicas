## Ejercicio de normalizacion a 3FN
La actividad se ve reflejada en el DER del archivo practicaNormalizacion.mwb

Se veia todo en una misma tabla, por eso analizando la misma se notó que se hablaba
de varias cosas, como facturas, metodos de pago, clientes, y articulos.

Por eso se penso en dividir en cuatro tablas, una para cada entidad que se mencionó anteriormente.
Se utilizaron los mismos atributos que ya existian en la tabla que se nos había dado.
1. Clientes:
   * cliente_id PK
   * nombre_cliente
   * direccion_cliente
2. Articulos:
   * articulo_id PK
   * descripcion_articulo
3. Formas_pago:
   * forma_pago_id PK
   * descripcion
4. Facturas:
    * id_factura PK
   * fecha_factura
   * forma_pago_id FK
   * IVA
   * importe
   * cliente_id FK

Y luego para relacionar tanto las facturas con los articulos, se creó una tabla
intermedia que va a tener el atributo cantidad para llevar el dato que ya existia.
5. Factura_articulos:
    * id_factura PK FK
   * articulo_id PK FK
   * cantidad