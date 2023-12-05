CREATE TABLE face (
    id INT AUTO_INCREMENT PRIMARY KEY,
    target INT UNIQUE NOT NULL
);

INSERT INTO face(`id`, `target`) VALUES (2, 120);
INSERT INTO face(`id`, `target`) VALUES (1, 80);