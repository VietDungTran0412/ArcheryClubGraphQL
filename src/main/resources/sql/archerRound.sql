CREATE TABLE archer_round
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    archer_id    INT NOT NULL,
    round_id     INT NOT NULL,
    category_id  INT NOT NULL,
    equipment_id INT NOT NULL,
    createdDate  DATETIME NOT NULL,
    FOREIGN KEY (archer_id) REFERENCES archer (id) ON DELETE CASCADE,
    FOREIGN KEY (round_id) REFERENCES round_type (id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE,
    FOREIGN KEY (equipment_id) REFERENCES equipment (id) ON DELETE CASCADE
)