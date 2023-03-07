DROP TABLE IF EXISTS cards;

CREATE TABLE cards
(
    card_id          int AUTO_INCREMENT PRIMARY KEY,
    customer_id      int,
    card_number      varchar(100) NOT NULL,
    card_type        varchar(100) NOT NULL,
    total_limit      int,
    amount_used      int,
    available_amount int,
    created_at       date DEFAULT NULL
);


INSERT INTO cards (customer_id, card_number, card_type, total_limit, amount_used, available_amount, created_at)
VALUES (1, 'ASIX324SDFIE', 'CREDIT', 300000, 10000, 232323,  CURDATE());

INSERT INTO cards (customer_id, card_number, card_type, total_limit, amount_used, available_amount, created_at)
VALUES (1, 'ASEWIE234SDF', 'DEBIT', 100000, 130000, 2332323,  CURDATE());

INSERT INTO cards (customer_id, card_number, card_type, total_limit, amount_used, available_amount, created_at)
VALUES (1, 'XXXISS3443SV', 'CREDIT', 550000, 4333, 22223,  CURDATE());
