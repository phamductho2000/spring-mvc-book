-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: web_book
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(105) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `author` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(145) DEFAULT NULL,
  `page` int DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `size` varchar(145) DEFAULT NULL,
  `publish_date` varchar(145) DEFAULT NULL,
  `des` varchar(345) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `publisher_id` bigint NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_categoryId_idx` (`category_id`),
  KEY `fk_book_publisherId_idx` (`publisher_id`),
  CONSTRAINT `fk_book_categoryId` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_book_publisherId` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (5,'javabccdd',333,'a','aaa',1,'abc','abc',NULL,'nhanh giau',1,1,NULL,'2021-06-03 13:41:22',NULL,'anonymousUser'),(7,'java',333,'a','aaa',2,'abc','abc',NULL,'nhanh giau',2,1,'2021-05-26 06:37:05','2021-05-28 13:59:50',NULL,NULL),(9,'java',333,'a','aaa',10,'abc','abc',NULL,'nhanh giau',1,3,'2021-05-26 14:51:22','2021-05-28 13:59:50',NULL,NULL),(10,'HÃ£y NÃ³i Vá»i TÃ´i Má»i Chuyá»n Rá»i Sáº½ á»n',281000,'KEI','https://www.vinabook.com/images/thumbnails/product/240x/366796_p94018muntitledkeiiiii1.jpg',208,' 320.00 gam',' 19 x 12 cm',NULL,'',2,3,'2021-06-01 13:13:06','2021-06-01 13:13:06','anonymousUser','anonymousUser'),(11,'abcd',2,'a','a',2,'2a','2a',NULL,'a',1,1,'2021-06-01 13:55:58','2021-06-01 13:55:58','anonymousUser','anonymousUser'),(12,'test',2,'test','test',2,'test','test',NULL,'test',1,1,'2021-06-02 06:43:29','2021-06-02 06:43:29',NULL,NULL),(13,'Tay trắng làm nên   - Chìa khóa thành công ( TẶNG Kèm Bút Nhiều Màu Sắc LH)',20000,'Nguyễn Hiến Lê','https://salt.tikicdn.com/cache/w444/ts/product/be/7d/71/9ee6692d319cfc6000eb8d89acfbaa87.jpg',168,NULL,'14,5*20,5','09-2019',NULL,2,5,'2021-06-03 05:56:51','2021-06-03 05:56:51',NULL,NULL),(14,'Tay trắng làm nên   - Chìa khóa thành công ( TẶNG Kèm Bút Nhiều Màu Sắc LH)',20000,'Nguyễn Hiến Lê','https://salt.tikicdn.com/cache/w444/ts/product/be/7d/71/9ee6692d319cfc6000eb8d89acfbaa87.jpg',168,NULL,'14,5*20,5','09-2019',NULL,2,5,'2021-06-03 05:57:24','2021-06-03 05:57:24',NULL,NULL),(17,'Thay Đổi Cuộc Sống Với Nhân Số Học',20000,'David A. Phillips','https://salt.tikicdn.com/cache/w444/ts/product/15/11/f8/56b303e000cb42faada663569fc5d7c9.jpg',342,'','16 x 24 cm','10-2020','',2,6,'2021-06-04 12:24:46','2021-06-04 12:24:46',NULL,NULL),(18,'Hài Hước Một Chút Thế Giới Sẽ Khác Đi',20000,'The Book Worm','https://salt.tikicdn.com/cache/w444/media/catalog/product/h/a/hai-huoc-mot-chut-ca-the-gioi-se-khac-di-bia-1.u547.d20160927.t111929.864455.jpg',228,'','14.5 x 20.5 cm','09-2016','',2,6,'2021-06-04 12:27:21','2021-06-04 12:27:21',NULL,NULL),(19,'Đắc Nhân Tâm (Khổ Lớn)',50700,'Dale Carnegie','https://salt.tikicdn.com/cache/w444/ts/product/df/7d/da/d340edda2b0eacb7ddc47537cddb5e08.jpg',320,'','14.5 x 20.5 cm ','03-2016','',2,6,'2021-06-04 12:28:12','2021-06-04 12:28:12',NULL,NULL),(20,'Nóng Giận Là Bản Năng , Tĩnh Lặng Là Bản Lĩnh',50700,'Tống Mặc','https://salt.tikicdn.com/cache/w444/ts/product/70/9a/98/e6d54019a2079b9565114bce93b245b7.jpg',264,'','13.5 x 20.5 cm','01-2019','',2,6,'2021-06-04 12:28:52','2021-06-04 12:28:52',NULL,NULL),(21,'Đời Ngắn Đừng Ngủ Dài (Tái Bản)',41000,'Robin Sharma','https://salt.tikicdn.com/cache/w444/ts/product/57/44/86/19de0644beef19b9b885d0942f7d6f25.jpg',228,'','13 x 20.5 cm','12-2018','',2,6,'2021-06-04 12:30:00','2021-06-04 12:30:00',NULL,NULL),(22,'Rèn Luyện Tư Duy Phản Biện',41000,'Albert Rutherford','https://salt.tikicdn.com/cache/w444/ts/product/22/cb/a9/524a27dcd45e8a13ae6eecb3dfacba7c.jpg',204,'','13 x 19 cm','12-2019','',2,7,'2021-06-04 12:31:29','2021-06-04 12:31:29',NULL,NULL),(23,'Đừng Lựa Chọn An Nhàn Khi Còn Trẻ',41000,'Cảnh Thiên','https://salt.tikicdn.com/cache/w444/ts/product/eb/62/6b/0e56b45bddc01b57277484865818ab9b.jpg',316,'','13.5 x 20 cm','02-2019','',2,7,'2021-06-04 12:32:42','2021-06-04 12:32:42',NULL,NULL),(24,'How Psychology Works - Hiểu Hết Về Tâm Lý Học',41000,'Jo Hemmings','https://salt.tikicdn.com/cache/w444/ts/product/2b/84/ff/cb34637573525a998596b58d6939411e.jpg',247,'','19.5 x 23 cm','11-2020','',2,8,'2021-06-04 12:33:49','2021-06-04 12:33:49',NULL,NULL),(25,'Hành Trình Về Phương Đông (Tái Bản 2019)',70000,'Nguyên Phong','https://salt.tikicdn.com/cache/w444/ts/product/46/9d/88/6560a409f40c37ac63d4e279bbea34b7.jpg',256,'','14.5 x 20.5 cm','01-2019','',2,8,'2021-06-04 12:34:51','2021-06-04 12:34:51',NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(105) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'kinh tế','2021-05-24 06:59:56','2021-05-28 14:00:31',NULL,NULL),(2,'kỹ năng','2021-05-24 06:59:56','2021-05-28 14:00:31',NULL,NULL),(3,'khoa học','2021-05-24 06:59:56','2021-05-28 14:00:31',NULL,NULL),(4,'văn học','2021-05-24 06:59:56','2021-05-28 14:00:31',NULL,NULL),(5,'đầu tư','2021-05-24 06:59:56','2021-05-28 14:00:31',NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_order`
--

DROP TABLE IF EXISTS `detail_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL,
  `book_id` bigint NOT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detailOrder_orderId_idx` (`order_id`),
  KEY `fk_detailOrder_bookId_idx` (`book_id`),
  CONSTRAINT `fk_detailOrder_bookId` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_detailOrder_orderId` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_order`
--

LOCK TABLES `detail_order` WRITE;
/*!40000 ALTER TABLE `detail_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total_price` decimal(10,0) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_userID_idx` (`user_id`),
  CONSTRAINT `fk_order_userID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'Nhà Xuất Bản Kim Đồng','HCM','2021-05-24 07:00:50','2021-05-28 14:02:34',NULL,NULL),(2,'Nhà Xuất Bản Trẻ','HCM','2021-05-24 07:00:50','2021-05-28 14:02:34',NULL,NULL),(3,'Nhà Xuất Bản Giáo dục','HN','2021-05-24 07:00:50','2021-05-28 14:02:34',NULL,NULL),(4,'Nhà Xuất Bản Hà Nội','Thai Binh','2021-05-26 12:33:55','2021-05-28 14:02:34',NULL,NULL),(5,'Nhà Xuất Bản Hồng Đức','HN','2021-06-03 05:42:44','2021-06-03 05:42:44',NULL,NULL),(6,'Nhà Xuất Bản Tổng hợp TP.HCM',NULL,'2021-06-04 12:16:29','2021-06-04 12:16:29',NULL,NULL),(7,'Nhà Xuất Bản Phụ Nữ',NULL,'2021-06-04 12:31:06','2021-06-04 12:31:06',NULL,NULL),(8,'Nhà Xuất Bản Thế Giới',NULL,'2021-06-04 12:33:38','2021-06-04 12:33:38',NULL,NULL);
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(106) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'quản trị','ADMIN','2021-05-30 13:19:18','2021-05-30 13:19:18',NULL,NULL),(2,'người dùng','USER','2021-05-30 13:19:18','2021-05-30 13:19:18',NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(145) DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  `address` varchar(245) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(145) DEFAULT NULL,
  `password` varchar(145) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(145) DEFAULT NULL,
  `modified_by` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,'admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'2021-05-30 13:24:19','2021-05-30 13:24:19',NULL,NULL),(2,NULL,NULL,NULL,NULL,'user1','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'2021-05-30 13:24:19','2021-05-30 13:24:19',NULL,NULL),(3,NULL,NULL,NULL,NULL,'user2','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'2021-05-30 13:24:19','2021-05-30 13:24:19',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `fk_userID_idx` (`user_id`),
  KEY `fk_roleID_idx` (`role_id`),
  CONSTRAINT `fk_roleID` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_userID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-06 20:09:23
