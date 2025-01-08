CREATE DATABASE IF NOT EXISTS Facturacion;
USE Facturacion;

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(40),
    apellido_cliente VARCHAR(40),
    direccion_cliente VARCHAR(40)
);

-- Tabla Factura
CREATE TABLE Factura (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    fecha_factura DATE,
    forma_pago DECIMAL(10,0),
    IVA DECIMAL(10,0),
    importe DECIMAL(10,0),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabla Artículo
CREATE TABLE Articulo (
    id_articulo INT AUTO_INCREMENT PRIMARY KEY,
    descripcion_articulo VARCHAR(40)
);

-- Tabla Detalle_Factura
CREATE TABLE Detalle_Factura (
    id_factura INT,
    id_articulo INT,
    cantidad INT,
    PRIMARY KEY (id_factura, id_articulo),
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
    FOREIGN KEY (id_articulo) REFERENCES Articulo(id_articulo)
);
