-- Iniciar la inserción de vehículos
INSERT INTO vehiculos (id, patente, marca, modelo, anio_fabricacion, cantidad_ruedas) VALUES
(1,'ABC123', 'Toyota', 'Corolla', 2020, 4),
(2,'DEF456', 'Ford', 'F-150', 2018, 4),
(3,'GHI789', 'Chevrolet', 'Silverado', 2021, 4),
(4,'JKL012', 'Volkswagen', 'Crafter', 2022, 6),
(5,'MNO345', 'Mercedes', 'Sprinter', 2019, 6),
(6,'PQR678', 'Dodge', 'Ram 1500', 2021, 4),
(7,'STU901', 'Isuzu', 'Elf', 2017, 4);

-- Iniciar la inserción de siniestros
INSERT INTO siniestros (id, fecha_siniestro, perdida_economica, vehiculo_id) VALUES
(1,'2023-01-15', 12000, 1),
(2,'2023-02-20', 8000, 2),
(3,'2023-03-12', 15000, 3),
(4,'2023-04-05', 5000, 4),
(5,'2023-05-28', 25000, 5),
(6,'2023-06-30', 6000, 1),
(7,'2023-07-15', 1500, 6),
(8,'2023-08-20', 30000, 7);