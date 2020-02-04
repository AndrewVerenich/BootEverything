package com.andver.firstApp.changelog

databaseChangeLog {
    changeSet(id: '2', author: 'aviarenich') {
        sql "USE test_db;"
        sql "DROP TABLE IF EXISTS count;"
        sql "CREATE TABLE count (" +
                "id            INT PRIMARY KEY AUTO_INCREMENT," +
                "current_count INT" +
                ");"
        sql "INSERT INTO test_db.count (current_count) values (0);"
    }
}