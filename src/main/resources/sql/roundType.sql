CREATE TABLE round_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);


INSERT INTO round_type(`id`, `name`) VALUES (null, 'WA 60/900');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Sydney');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Townsville');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'FITA 60m');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Holt');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Short Sydney');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Junior Sydney');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Short Townsville');
INSERT INTO round_type(`id`, `name`) VALUES (null, 'Junior Townsville');