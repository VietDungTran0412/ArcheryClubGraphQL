CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    age_range VARCHAR(20) NOT NULL,
    gender ENUM('MALE','FEMALE') NOT NULL
);

INSERT INTO category(id,age_range, gender) VALUES(null,"Open","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"Open","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"50+","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"50+","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"60+","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"60+","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"70+","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"70+","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U21","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U21","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U18","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U18","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U16","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U16","MALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U14","FEMALE");
INSERT INTO category(id,age_range, gender) VALUES(null,"U14","MALE");