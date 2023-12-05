CREATE TABLE IF NOT EXISTS round_equipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    equipment_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE,
    FOREIGN KEY (equipment_id) REFERENCES equipment(id) ON DELETE CASCADE
);

INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 2, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 2, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 2, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 2, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 2, 5);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 1, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 1, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 1, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 1, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 3, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 3, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 3, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 3, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 4, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 4, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 4, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 4, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 6, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 6, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 6, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 6, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 8, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 8, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 8, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 8, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 10, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 10, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 10, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 10, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 10, 5);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 9, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 9, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 9, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 9, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 12, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 12, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 12, 3);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 12, 4);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 11, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 11, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 5, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 5, 2);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 7, 1);
INSERT INTO category_equipment(id, category_id, equipment_id) VALUES(null, 7, 2);
