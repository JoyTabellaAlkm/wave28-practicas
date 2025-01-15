-- Insertar datos en la tabla 'vehiculos' con IDs específicos e incluir vehículos de dos ruedas
INSERT INTO vehiculos (id, patente, marca, modelo, anio_de_fabricación, cantidad_de_ruedas) VALUES
(1, 'ABC123', 'Ford', 'Focus', 2015, 4),
(2, 'DEF456', 'Toyota', 'Corolla', 2018, 4),
(3, 'GHI789', 'Honda', 'Civic', 2020, 4),
(4, 'JKL012', 'Chevrolet', 'Cruze', 2022, 4),
(5, 'MNO345', 'Hyundai', 'Elantra', 2025, 4),
(6, 'PQR678', 'Nissan', 'Sentra', 2025, 4),
(7, 'STU901', 'Mazda', '3', 2023, 4),
(8, 'VWX234', 'Volkswagen', 'Polo', 2021, 4),
(9, 'YZA567', 'Kia', 'Rio', 2025, 4),
(10, 'BCD890', 'Subaru', 'Impreza', 2019, 4),
(11, 'EFG123', 'Yamaha', 'YZF-R3', 2021, 2),   -- Motocicleta
(12, 'HIJ456', 'Kawasaki', 'Ninja 400', 2022, 2); -- Motocicleta

-- Insertar datos en la tabla 'siniestro' con IDs específicos
INSERT INTO siniestro (id, fecha, perdida_economica, vehiculo_id) VALUES
(1, '2023-01-01', 1500.00, 1),
(2, '2023-01-10', 8000.00, 1),  -- Segundo siniestro para el mismo vehículo
(3, '2023-02-15', 2500.50, 2),
(4, '2024-03-01', 12000.00, 2), -- Segundo siniestro con pérdida mayor a 10000
(5, '2023-03-10', 3000.75, 3),
(6, '2023-04-05', 1750.00, 4),
(7, '2023-04-20', 2200.00, 5),
(8, '2023-05-18', 3100.00, 6),
(9, '2024-05-25', 15000.00, 6), -- Segundo siniestro con pérdida mayor a 10000
(10, '2023-06-22', 2700.00, 7),
(11, '2023-06-30', 5000.00, 7),  -- Segundo siniestro para el mismo vehículo
(12, '2023-07-11', 1900.00, 8),
(13, '2023-08-15', 2800.00, 9),
(14, '2024-08-20', 9200.00, 9),  -- Segundo siniestro para el mismo vehículo
(15, '2023-09-25', 3300.00, 10),
(16, '2024-09-30', 11000.00, 10), -- Segundo siniestro con pérdida mayor a 10000
(17, '2023-10-01', 3500.00, 11), -- Siniestro para motocicleta
(18, '2023-10-15', 4500.00, 12); -- Siniestro para motocicleta