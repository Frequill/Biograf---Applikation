CREATE DATABASE  IF NOT EXISTS `furniturestore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `furniturestore`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: furniturestore
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping events for database 'furniturestore'
--

--
-- Dumping routines for database 'furniturestore'
--
/*!50003 DROP FUNCTION IF EXISTS `multiply` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `multiply`(x DOUBLE, y DOUBLE) RETURNS double
    DETERMINISTIC
BEGIN
	DECLARE result DOUBLE;
    SET result = x * y;
RETURN result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_customer`(customer_name VARCHAR(100), customer_password VARCHAR (100),credit_card_info VARCHAR (100), email_address VARCHAR (100))
BEGIN

SET @random_salt1 = md5(rand());
SET @random_salt2 = md5(rand());
SET @random_salt3 = md5(rand());
SET @key1 = concat(customer_name, ' key1');
SET @key2 = concat(customer_name, ' key2');
 
INSERT INTO customers (customer_name, customer_password, /*salt1,*/ credit_card_info, salt1, email, salt2)
VALUES (customer_name, sha2(concat(customer_password, @random_salt3), '0'), /*@random_salt1,*/ 
aes_encrypt(concat(credit_card_info, @random_salt1), @key1), @random_salt1,
aes_encrypt(concat(email_address, @random_salt2), @key2), @random_salt2);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_product` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_product`(product VARCHAR(255), In_stock INT, price DOUBLE)
BEGIN
INSERT INTO products (product_name, stock, price_SEK)
VALUES (product, In_stock, price);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_staff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_staff`(staff_name VARCHAR(50), salary VARCHAR (10), email_address VARCHAR (100))
BEGIN

SET @random_salt1 = md5(rand());
SET @random_salt2 = md5(rand());
SET @key1 = concat(staff_name, ' key1');
SET @key2 = concat(staff_name, ' key2');
 
INSERT INTO staff (name, salary, salt1, email_address, salt2)
VALUES (staff_name, aes_encrypt(concat(salary, @random_salt1), @key1), @random_salt1,
aes_encrypt(concat(email_address, @random_salt2), @key2), @random_salt2);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_supplier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_supplier`(supplier_name VARCHAR(50), email_address VARCHAR (100), phone_nr VARCHAR(50),
country VARCHAR(50), city VARCHAR(50), postal_code VARCHAR(50), address VARCHAR(50))
BEGIN

SET @random_salt1 = md5(rand());
SET @random_salt2 = md5(rand());
SET @random_salt3 = md5(rand());
SET @random_salt4 = md5(rand());

SET @key1 = concat(supplier_name, ' key1');
SET @key2 = concat(supplier_name, ' key2');
SET @key3 = concat(supplier_name, ' key3');
SET @key4 = concat(supplier_name, ' key4');
 
INSERT INTO suppliers (supplier_name, email_address, salt1, phone_nr, salt2, country, city, postal_code, salt3, address, salt4)
VALUES (supplier_name, 
aes_encrypt(concat(email_address, @random_salt1), @key1), @random_salt1,
aes_encrypt(concat(phone_nr, @random_salt2), @key2), @random_salt2,
country, city,
aes_encrypt(concat(postal_code, @random_salt3), @key3), @random_salt3,
aes_encrypt(concat(address, @random_salt4), @key4), @random_salt4);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `decrypt_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `decrypt_customer`(credit_card_salt VARCHAR (50), credit_card_key VARCHAR(50), email_salt VARCHAR(50), email_key VARCHAR(50))
BEGIN

 SELECT customer_ID, customer_name, customer_password, credit_card_info, email FROM customers;
    
	SELECT customer_ID, customer_name,
	REPLACE(cast(aes_decrypt(credit_card_info, credit_card_key) AS CHAR(100)), credit_card_salt, '') AS credit_card_info, 
	REPLACE(cast(aes_decrypt(email, email_key) AS CHAR(100)), email_salt, '') AS email_address
	FROM customers ORDER BY customer_ID; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `decrypt_staff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `decrypt_staff`(salary_salt VARCHAR (50), salary_key VARCHAR(50), email_salt VARCHAR(50), email_key VARCHAR(50))
BEGIN

 -- SELECT staff_ID, name, salary, email_address FROM staff;
    
	SELECT staff_ID, name,
	REPLACE(cast(aes_decrypt(salary, salary_key) AS CHAR(100)), salary_salt, '') AS salary, 
	REPLACE(cast(aes_decrypt(email_address, email_key) AS CHAR(100)), email_salt, '')AS email_address
	FROM staff ORDER BY salary; 
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `decrypt_supplier` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `decrypt_supplier`(email_salt VARCHAR (50), email_key VARCHAR(50), phone_salt VARCHAR(50), phone_key VARCHAR(50),
 postal_salt VARCHAR(50), postal_key VARCHAR(50), address_salt VARCHAR(50), address_key VARCHAR(50))
BEGIN

 SELECT supplier_ID, supplier_name, email_address, phone_nr, country, city, postal_code, address FROM suppliers;
    
	SELECT supplier_ID, supplier_name,
	REPLACE(cast(aes_decrypt(email_address, email_key)AS CHAR(100)), email_salt, '') AS email_address, 
	REPLACE(cast(aes_decrypt(phone_nr, phone_key)AS CHAR(100)), phone_salt, '') AS phone_nr, 
	country, city,
    REPLACE(cast(aes_decrypt(postal_code, postal_key)AS CHAR(100)), postal_salt, '') AS postal_code, 
    REPLACE(cast(aes_decrypt(address, address_key)AS CHAR(100)), address_salt, '') AS address
    
    FROM suppliers ORDER BY supplier_ID; 
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_customer`(user_to_remove INTEGER)
BEGIN
SELECT @order_ID := order_ID FROM orders WHERE customer_ID = user_to_remove;

	 -- SELECT @newOrderId := MAX(order_id) FROM orders;
     
DELETE from transaction_history WHERE order_ID = @order_ID;
DELETE FROM orders WHERE customer_ID = user_to_remove;
DELETE FROM customers WHERE customer_ID = user_to_remove;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `extend_existing_order` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `extend_existing_order`(Your_order_ID INT, product INT, quantity INT, current_customer INT)
BEGIN
        
START TRANSACTION;  

	UPDATE products
	SET stock = stock - quantity
    WHERE product_ID = product;
     
	INSERT INTO order_details(order_ID, customer_ID, product_ID, quantity_purchased, order_date)
    VALUES(Your_order_ID, current_customer, product, quantity, NOW());
     
	UPDATE transaction_history
	SET shipment_date = DATE_ADD(NOW(), INTERVAL 1 DAY), expected_delivery = DATE_ADD(NOW(), INTERVAL 7 DAY)
    WHERE order_ID = Your_order_ID;
    
     SELECT @stockForProduct := (stock) FROM products where product_ID = product;
     
	SET @error_text = 'A rollback has occured! Make sure not to attempt a greater order than current avalible stock can cover. Should error persist, please contact customer support at leaveusalone.wedonotcare@yahoo.com';

    COMMIT;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_orders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_orders`()
BEGIN
	DROP VIEW IF EXISTS order_total_price;
	CREATE VIEW order_total_price AS
	SELECT order_ID, customers.customer_ID, customers.customer_name, products.product_ID, product_name, 
	price_SEK, quantity_purchased, price_SEK * quantity_purchased AS total_price, order_details.order_date
	FROM customers, order_details, products
	WHERE customers.customer_ID = order_details.customer_ID AND order_details.product_ID = products.product_ID;
	SELECT * FROM order_total_price;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_single_order` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_single_order`(single_order INT)
BEGIN
	DROP VIEW IF EXISTS order_total_price;
	CREATE VIEW order_total_price AS
	SELECT order_ID, customers.customer_ID, customers.customer_name, products.product_ID, product_name, 
	price_SEK, quantity_purchased, price_SEK * quantity_purchased AS total_price
	FROM customers, order_details, products
	WHERE customers.customer_ID = order_details.customer_ID AND order_details.product_ID = products.product_ID;
	SELECT * FROM order_total_price
    WHERE order_ID = single_order;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lower_all_prices` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lower_all_prices`(percentage DOUBLE)
BEGIN
SET @statement = concat('All product prices decreased by ', percentage, '%');
SET percentage = 1 - (percentage / 100);
SET @counter = 1;
SELECT @all_products := COUNT(product_ID)
FROM products;


WHILE (@counter <= @all_products) DO

UPDATE products
SET price_SEK = price_SEK * percentage
WHERE product_ID = @counter;
SET @counter = @counter + 1;

END WHILE;

SELECT @statement;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `place_order` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `place_order`(product INT, quantity INT, current_customer INT)
BEGIN
		DECLARE `_rollback` BOOL DEFAULT 0;
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
        
START TRANSACTION;  -- If rollback occures we jump back up here!

	UPDATE products
	SET stock = stock - quantity
    WHERE product_ID = product;
    
    INSERT INTO orders(customer_ID)
    VALUES(current_customer);
        
	 SELECT @newOrderId := MAX(order_id) FROM orders;
     
	INSERT INTO order_details(order_ID, customer_ID, product_ID, quantity_purchased, order_date)
    VALUES(@newOrderId, current_customer, product, quantity, NOW());
     
	INSERT INTO transaction_history (order_ID, shipment_date, expected_delivery)
	VALUES (@newOrderId, DATE_ADD(NOW(), INTERVAL 1 DAY), DATE_ADD(NOW(), INTERVAL 7 DAY));
     
	 SELECT @stockForProduct := (stock) FROM products where product_ID = product;

     SET @error_text = 'A rollback has occured! Make sure not to attempt a greater order than current avalible stock can cover. Should error persist, please contact customer support at leaveusalone.wedonotcare@yahoo.com';
     
	IF `_rollback` OR @stockForProduct < quantity THEN 
    SELECT @error_text as 'Error message';  
    ROLLBACK;
    
    ELSE
    COMMIT;
    
    END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `raise_all_prices` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `raise_all_prices`(percentage DOUBLE)
BEGIN
SET @statement = concat('All product prices increased by ', percentage, '%');
SET percentage = percentage / 100 + 1;
SET @counter = 1;
SELECT @all_products := COUNT(product_ID)
FROM products;


WHILE (@counter <= @all_products) DO

UPDATE products
SET price_SEK = price_SEK * percentage
WHERE product_ID = @counter;
SET @counter = @counter + 1;

END WHILE;

SELECT @statement;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 22:20:25
