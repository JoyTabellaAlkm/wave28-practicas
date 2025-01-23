INSERT INTO people (name, surname, age) VALUES
('John', 'Doe', 25),
('Jane', 'Smith', 30),
('Michael', 'Johnson', 20),
('Emily', 'Davis', 27),
('Chris', 'Brown', 22),
('Sara', 'Wilson', 29);

INSERT INTO sports (name, level) VALUES
('Basketball', 5),
('Soccer', 4),
('Tennis', 3),
('Swimming', 2),
('Running', 5);

INSERT INTO sport_people (sport_id, person_id) VALUES
(1, 1),  -- Sport 1 (Basketball), Person 1 (John Doe)
(1, 2),  -- Sport 1 (Basketball), Person 2 (Jane Smith)
(2, 1),  -- Sport 2 (Soccer), Person 1 (John Doe)
(2, 3),  -- Sport 2 (Soccer), Person 3 (Michael Johnson)
(3, 2),  -- Sport 3 (Tennis), Person 2 (Jane Smith)
(4, 3),  -- Sport 4 (Swimming), Person 3 (Michael Johnson)
(5, 4),  -- Sport 5 (Running), Person 4 (Emily Davis)
(5, 5);  -- Sport 5 (Running), Person 5 (Chris Brown)