INSERT INTO vehiculos (patente, marca, modelo, anio_fabricacion, cant_ruedas)
VALUES ('ABC123', 'Toyota', 'Corolla', 2015, 4),
       ('DEF456', 'Honda', 'Civic', 2016, 4),
       ('GHI789', 'Ford', 'Fiesta', 2017, 4),
       ('JKL012', 'Chevrolet', 'Aveo', 2018, 4),
       ('MNO345', 'Volkswagen', 'Golf', 2019, 4),
       ('PQR678', 'BMW', 'X5', 2025, 6),
       ('STU901', 'Audi', 'A4', 2021, 4),
       ('VWX234', 'Mercedes', 'Benz C-Class', 2021, 4),
       ('YZA567', 'Nissan', 'X-Trail', 2017, 4),
       ('BCD890', 'Renault', 'Kangoo', 2016, 4),
       ('EFG123', 'Peugeot', '208', 2018, 4),
       ('HIJ456', 'Fiat', 'Punto', 2019, 4),
       ('KLM789', 'Kia', 'Sportage', 2020, 4),
       ('NOP012', 'Hyundai', 'Tucson', 2021, 4),
       ('QRS345', 'Mazda', 'CX-5', 2020, 4),
       ('TUV678', 'Chrysler', 'Pacifica', 2021, 4),
       ('WXY901', 'Subaru', 'Outback', 2022, 4),
       ('ZAB234', 'Land Rover', 'Range Rover', 2019, 4),
       ('CDE567', 'Jeep', 'Cherokee', 2021, 4),
       ('FGH890', 'Volvo', 'XC60', 2020, 4);

INSERT INTO siniestros (fecha_siniestro, perdida_valor, vehiculo_id)
VALUES ('2023-01-15', 12000.50, 1),  -- Siniestro relacionado con el vehículo 1 (id=1)
       ('2022-12-10', 1500.75, 2),   -- Siniestro relacionado con el vehículo 2 (id=2)
       ('2023-05-21', 5000.00, 3),   -- Siniestro relacionado con el vehículo 3 (id=3)
       ('2023-03-10', 2500.25, 4),   -- Siniestro relacionado con el vehículo 4 (id=4)
       ('2022-10-12', 8000.00, 5),   -- Siniestro relacionado con el vehículo 5 (id=5)
       ('2023-06-30', 15000.00, 6),  -- Siniestro relacionado con el vehículo 6 (id=6)
       ('2022-08-25', 2300.50, 7),   -- Siniestro relacionado con el vehículo 7 (id=7)
       ('2023-07-13', 3000.80, 8),   -- Siniestro relacionado con el vehículo 8 (id=8)
       ('2023-04-01', 17000.40, 9),  -- Siniestro relacionado con el vehículo 9 (id=9)
       ('2023-06-05', 4000.00, 10),  -- Siniestro relacionado con el vehículo 10 (id=10)
       ('2023-02-28', 1300.30, 11),  -- Siniestro relacionado con el vehículo 11 (id=11)
       ('2023-01-05', 11000.70, 12), -- Siniestro relacionado con el vehículo 12 (id=12)
       ('2022-11-14', 5000.90, 13),  -- Siniestro relacionado con el vehículo 13 (id=13)
       ('2023-03-22', 2500.00, 14),  -- Siniestro relacionado con el vehículo 14 (id=14)
       ('2023-07-01', 3000.00, 15); -- Siniestro relacionado con el vehículo 15 (id=15)