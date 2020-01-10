DROP SCHEMA IF EXISTS test_db;
CREATE SCHEMA test_db;
USE test_db;
DROP TABLE IF EXISTS count;
CREATE TABLE count
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    current_count INT
);