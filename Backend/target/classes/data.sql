-- CREATE TABLE PRODUCT(
--             PRODUCT_ID VARCHAR(255) PRIMARY KEY,
--             PRODUCT_NAME  VARCHAR(255),
--             PRICE INTEGER ,
--             QUANTITY INTEGER);
-- CREATE TABLE CLIENTORDER(
--                         ORDER_ID VARCHAR(255) PRIMARY KEY,
--                         MEMBER_ID  VARCHAR(255),
--                         PRICE INTEGER,
--                         PAYSTATUS BIT);
-- CREATE TABLE ORDERDETAILL(
--                         ORDER_ITEMSN VARCHAR(255) PRIMARY KEY,
--                         ORDER_ID  VARCHAR(255),
--                         PRODUCT_ID VARCHAR(255),
--                         QUANTITY INTEGER,
--                         STAND_PRICE INTEGER,
--                         ITEM_PRICE INTEGER);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRICE, QUANTITY) VALUES
                    ('P001', 'osii舒壓按摩椅', 98000, 5),
                    ('P002', '網友最愛起司蛋糕', 1200, 50),
                    ('P003', '真愛密碼項鍊', 8500, 20);
INSERT INTO CLIENT_ORDER (ORDER_ID, MEMBER_ID, PRICE, PAY_STATUS) VALUES
                         ('Ms20250801186230', '458', 98000, 1),
                         ('Ms20250805157824', '55688', 9700, 0),
                         ('Ms20250805258200', '1713', 2400, 1);
INSERT INTO ORDER_DETAIL (ORDER_ITEMSN, Order_ID, PRODUCT_ID, QUANTITY, STAND_PRICE, ITEM_PRICE) VALUES
                          ('1', 'Ms20250801186230', 'P001', 1, 98000, 98000),
                          ('2', 'Ms20250805157824', 'P002', 1, 1200, 1200),
                          ('3', 'Ms20250805157824', 'P003', 1, 8500, 8500),
                          ('4', 'Ms20250805258200', 'P002', 2, 1200, 2400);