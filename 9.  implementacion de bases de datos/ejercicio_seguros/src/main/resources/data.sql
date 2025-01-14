-- src/main/resources/data.sql

-- Inserts for Vehiculos
INSERT INTO vehiculos (id, patente, marca, modelo, anio_fabricacion, cantidad_ruedas) VALUES
                                                                                          (1, 'ABC123', 'Toyota', 'Corolla', 2020, 4),
                                                                                          (2, 'DEF456', 'Ford', 'Focus', 2018, 4),
                                                                                          (3, 'GHI789', 'Chevrolet', 'Cruze', 2019, 4),
                                                                                          (4, 'JKL012', 'Honda', 'Civic', 2021, 4),
                                                                                          (5, 'MNO345', 'Nissan', 'Altima', 2020, 4),
                                                                                          (6, 'PQR678', 'Hyundai', 'Elantra', 2019, 4),
                                                                                          (7, 'STU901', 'Volkswagen', 'Jetta', 2020, 4),
                                                                                          (8, 'VWX234', 'Subaru', 'Impreza', 2018, 4),
                                                                                          (9, 'YZA567', 'Kia', 'Forte', 2021, 4),
                                                                                          (10, 'BCD890', 'Mazda', '3', 2019, 4);

-- Inserts for Siniestros
INSERT INTO siniestros (id, fecha_siniestro, perdida_economica, vehiculo_id) VALUES
                                                                                 (1, '2023-01-15', 15000.50, 1),
                                                                                 (2, '2023-02-18', 12000.75, 1),
                                                                                 (3, '2023-03-20', 25000.75, 2),
                                                                                 (4, '2023-04-12', 15500.00, 2),
                                                                                 (5, '2023-05-10', 30000.00, 3),
                                                                                 (6, '2023-05-30', 18000.90, 3),
                                                                                 (7, '2023-06-05', 12000.00, 4),
                                                                                 (8, '2023-07-25', 25000.25, 4),
                                                                                 (9, '2023-08-22', 18000.25, 5),
                                                                                 (10, '2023-09-14', 22000.80, 5),
                                                                                 (11, '2023-10-30', 22000.80, 6),
                                                                                 (12, '2023-11-15', 27000.60, 6),
                                                                                 (13, '2023-12-01', 19000.10, 7),
                                                                                 (14, '2024-01-05', 16000.55, 7),
                                                                                 (15, '2024-02-01', 19000.10, 8),
                                                                                 (16, '2024-03-20', 21000.30, 8),
                                                                                 (17, '2024-04-15', 16000.55, 9),
                                                                                 (18, '2024-05-10', 18000.40, 9),
                                                                                 (19, '2024-06-01', 21000.30, 10),
                                                                                 (20, '2024-07-30', 24000.20, 10);