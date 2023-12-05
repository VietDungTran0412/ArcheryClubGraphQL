CREATE TABLE IF NOT EXISTS end(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    archer_round_id BIGINT NOT NULL,
    score INT NOT NULL,
    CHECK (score >= 0 AND score <= 60),
    FOREIGN KEY (archer_round_id) REFERENCES archer_round(id) ON DELETE CASCADE
)