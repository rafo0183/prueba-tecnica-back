/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 100413
 Source Host           : localhost:3306
 Source Schema         : pruebatecnica

 Target Server Type    : MySQL
 Target Server Version : 100413
 File Encoding         : 65001

 Date: 08/03/2024 19:23:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checking_accounts
-- ----------------------------
DROP TABLE IF EXISTS `checking_accounts`;
CREATE TABLE `checking_accounts`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `account_number` bigint(20) NOT NULL,
  `account_balance` bigint(20) NULL DEFAULT 0,
  `account_overdraft` bigint(20) NULL DEFAULT 0,
  `reward_points` bigint(20) NULL DEFAULT 0,
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK31aele3dintsmmlfodaki8r3b`(`user_id`) USING BTREE,
  CONSTRAINT `FK31aele3dintsmmlfodaki8r3b` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checking_accounts
-- ----------------------------
INSERT INTO `checking_accounts` VALUES (1, 1, 2828271, 100000, 30000, 50000, '2024-03-07 11:55:08', '2024-03-07 18:21:39');
INSERT INTO `checking_accounts` VALUES (3, 803, 5571892, 100000, 30000, 9000, '2024-03-07 16:54:25', '2024-03-07 18:21:49');

-- ----------------------------
-- Table structure for checking_accounts_seq
-- ----------------------------
DROP TABLE IF EXISTS `checking_accounts_seq`;
CREATE TABLE `checking_accounts_seq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checking_accounts_seq
-- ----------------------------
INSERT INTO `checking_accounts_seq` VALUES (201);

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` bigint(20) NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int(4) NOT NULL,
  `sku` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `properties` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `created_at` datetime(0) NOT NULL,
  `updated_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (1, 'Taladro Makita', 20000, 'HERRAMIENTAS', 29, 'AHJKWW1', '{\r\n	\"description\" : \"Taladro percutor\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p001.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 11:25:43', '2024-03-08 12:39:11');
INSERT INTO `products` VALUES (2, 'Labial ESIKA', 3000, 'COSTMETICOS', 143, 'SJIICWO', '{\r\n	\"description\" : \"Labial color rojo\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p002.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 12:12:07', '2024-03-08 16:59:19');
INSERT INTO `products` VALUES (3, 'Gift Card $5000', 4000, 'GIFTCARDS', 500, 'GFIOXXOQ', '{\r\n	\"description\" : \"Giftcard\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p003.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 16:48:03', '2024-03-08 17:01:29');
INSERT INTO `products` VALUES (4, 'Gift Card $30000', 25000, 'GIFTCARDS', 500, 'GFISZZLD', '{\r\n	\"description\" : \"Giftcard\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p004.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 17:00:20', '2024-03-08 17:01:33');
INSERT INTO `products` VALUES (5, 'Amazon 5th gen', 34000, 'TECNOLOGÍA', 40, 'FCCOAAP', '{\r\n	\"description\" : \"Giftcard\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p005.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 17:03:43', '2024-03-08 17:04:02');
INSERT INTO `products` VALUES (6, 'Galaxy Watch 6', 64000, 'TECNOLOGÍA', 20, 'AIEOOOXL', '{\r\n	\"description\" : \"Giftcard\",\r\n	\"coments\" : [\r\n		{\r\n			\"name\" : \"Pedro\",\r\n			\"lastname\" : \"Perez\",\r\n			\"image\" : \"src/bla/bla.jpg\",\r\n			\"stars\" : 3,\r\n			\"comment\" : \"Ma o menos no más, como que taladra chueco\"\r\n		}\r\n	],\r\n	\"images\" : [\r\n		\"/assets/products/p006.jpg\",\r\n		\"src/bla/bla3.jpg\"\r\n	],\r\n	\"brand\" : \"Makita\"\r\n}', '2024-03-08 17:08:47', '2024-03-08 17:08:59');

-- ----------------------------
-- Table structure for products_seq
-- ----------------------------
DROP TABLE IF EXISTS `products_seq`;
CREATE TABLE `products_seq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products_seq
-- ----------------------------
INSERT INTO `products_seq` VALUES (1);

-- ----------------------------
-- Table structure for transfers
-- ----------------------------
DROP TABLE IF EXISTS `transfers`;
CREATE TABLE `transfers`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `checking_account_id` bigint(20) NOT NULL,
  `amount` bigint(20) NOT NULL,
  `hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `checking_account_destination` bigint(255) NOT NULL,
  `bank_destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name_destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(0) NOT NULL,
  `updated_at` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKk8oxyghiv9562obrcusx2h94c`(`checking_account_id`) USING BTREE,
  INDEX `FKcvgnuaekhfu7jkgfdjr2rsy6w`(`user_id`) USING BTREE,
  CONSTRAINT `FKcvgnuaekhfu7jkgfdjr2rsy6w` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKk8oxyghiv9562obrcusx2h94c` FOREIGN KEY (`checking_account_id`) REFERENCES `checking_accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for transfers_seq
-- ----------------------------
DROP TABLE IF EXISTS `transfers_seq`;
CREATE TABLE `transfers_seq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfers_seq
-- ----------------------------
INSERT INTO `transfers_seq` VALUES (101);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lastname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(0) NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 903 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'rafo0183@gmail.com', '$2a$10$oLwTA4Pgz6OnGi.PKXfvZuT24ysvcHcWdoc60K0NWzoQDhNcyU2Di', 'Ricardo', 'Fuentes', '2024-03-06 11:02:11', '2024-03-07 15:56:40', 'ADMIN');
INSERT INTO `users` VALUES (803, 'cliente@client.com', '$2a$10$USrLCL7s3m2jWd28SfblcOCY4NVp2rpTWShGeD8X.BZ2NOkhQOQ8u', 'Cliennn', 'Clilastname', '2024-03-07 16:54:25', '2024-03-07 17:10:11', 'CLIENT');

-- ----------------------------
-- Table structure for users_seq
-- ----------------------------
DROP TABLE IF EXISTS `users_seq`;
CREATE TABLE `users_seq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_seq
-- ----------------------------
INSERT INTO `users_seq` VALUES (1001);

SET FOREIGN_KEY_CHECKS = 1;
