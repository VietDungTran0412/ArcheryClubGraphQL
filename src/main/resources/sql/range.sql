CREATE TABLE `range` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    round_id INT NOT NULL,
    face_id INT NOT NULL,
    distance_id INT NOT NULL,
    end_count INT NOT NULL,
    FOREIGN KEY (round_id) REFERENCES round_type(id),
    FOREIGN KEY (face_id) REFERENCES face(id),
    FOREIGN KEY (distance_id) REFERENCES distance(id)
);

INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 1,2,5,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 1,2,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 1,2,3,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 2,2,6,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 2,2,5,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 2,2,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 2,2,3,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 3,2,6,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 3,2,5,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 4,2,5,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 4,2,4,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 4,1,3,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 4,1,2,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 5,1,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 5,1,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 5,1,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 6,2,5,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 6,2,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 6,2,3,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 7,2,4,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 7,2,3,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 7,2,2,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 7,2,1,5);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 8,2,5,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 8,2,4,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 9,2,4,6);
INSERT INTO `range`(`id`, `round_id`, `face_id`, `distance_id`, `end_count`) VALUES(null, 9,2,3,6);