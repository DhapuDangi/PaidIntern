CREATE DATABASE TrainAllocationSystem;

USE TrainAllocationSystem;

CREATE TABLE userprofile (
    user_login_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
     age INT);

    
  CREATE TABLE TrainAllocation (
    allocation_id INT PRIMARY KEY AUTO_INCREMENT,
    train_id INT NOT NULL,
    boogie_number INT NOT NULL,
    seat_number INT NOT NULL,
    user_login_id INT NOT NULL,
    allocation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(train_id, boogie_number, seat_number),
    FOREIGN KEY (user_login_id) REFERENCES userprofile(user_login_id)
);