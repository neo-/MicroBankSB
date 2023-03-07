DROP TABLE IF EXISTS loans;

CREATE TABLE `loans`
(
    `loan_number`        int AUTO_INCREMENT PRIMARY KEY,
    `customer_id`        int,
    `loan_type`          varchar(100) NOT NULL,
    `amount_paid`        int,
    `outstanding_amount` int,
    `created_at`         date DEFAULT NULL,
    `start_at`           date DEFAULT NULL
);


INSERT INTO `loans` (customer_id, loan_type, amount_paid, outstanding_amount, created_at, start_at)
VALUES (1, 'Home', 100000, 300000, CURDATE(), CURDATE());

INSERT INTO `loans` (customer_id, loan_type, amount_paid, outstanding_amount, created_at, start_at)
VALUES (1, 'Personal', 40000, 544000, CURDATE(), CURDATE());

INSERT INTO `loans` (customer_id, loan_type, amount_paid, outstanding_amount, created_at, start_at)
VALUES (1, 'Home', 2122, 344322, CURDATE(), CURDATE());

INSERT INTO `loans` (customer_id, loan_type, amount_paid, outstanding_amount, created_at, start_at)
VALUES (1, 'Vehicle', 10000, 30000, CURDATE(), CURDATE());