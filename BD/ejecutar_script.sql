/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : pruebatecnica

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 12/03/2024 23:32:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checking_accounts
-- ----------------------------
DROP TABLE IF EXISTS `checking_accounts`;
CREATE TABLE `checking_accounts`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NOT NULL,
  `account_number` bigint(0) NOT NULL,
  `account_balance` bigint(0) NULL DEFAULT 0,
  `account_overdraft` bigint(0) NULL DEFAULT 0,
  `reward_points` bigint(0) NULL DEFAULT 0,
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
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checking_accounts_seq
-- ----------------------------
INSERT INTO `checking_accounts_seq` VALUES (301);

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` bigint(0) NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int(0) NOT NULL,
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
  `next_val` bigint(0) NULL DEFAULT NULL
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
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NOT NULL,
  `checking_account_id` bigint(0) NOT NULL,
  `amount` bigint(0) NOT NULL,
  `hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `checking_account_destination` bigint(0) NOT NULL,
  `bank_destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name_destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(0) NOT NULL,
  `updated_at` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKk8oxyghiv9562obrcusx2h94c`(`checking_account_id`) USING BTREE,
  INDEX `FKcvgnuaekhfu7jkgfdjr2rsy6w`(`user_id`) USING BTREE,
  CONSTRAINT `FKcvgnuaekhfu7jkgfdjr2rsy6w` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKk8oxyghiv9562obrcusx2h94c` FOREIGN KEY (`checking_account_id`) REFERENCES `checking_accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfers
-- ----------------------------
INSERT INTO `transfers` VALUES (1, 803, 3, 500000, 'desdebd', 12345656, 'DESDEBD', 'No se', '2024-03-09 00:43:32', '2024-03-09 00:43:35');
INSERT INTO `transfers` VALUES (2, 803, 3, 10000, 'desdedb', 12334465, 'ajskdjkasd', 'no ', '2024-03-09 00:48:04', '2024-03-09 00:48:07');
INSERT INTO `transfers` VALUES (52, 803, 3, 123123, '054ea4ac-b88f-4352-a175-c12714b94aac', 124124, 'Banco Credito e Inversiones', 'asd', '2024-03-09 01:26:41', '2024-03-09 01:26:41');
INSERT INTO `transfers` VALUES (53, 803, 3, 51, '7fbbcb0a-3192-41d7-9c33-194e910b844a', 124, 'Banco Citi', 'fsd', '2024-03-09 01:26:47', '2024-03-09 01:26:47');
INSERT INTO `transfers` VALUES (54, 803, 3, 233, 'ce91575e-889f-4080-9c13-5dbe565112b7', 67675675, 'Banco Credito e Inversiones', 'fds', '2024-03-09 01:26:54', '2024-03-09 01:26:54');
INSERT INTO `transfers` VALUES (55, 803, 3, 125125, 'c3dc0989-1f0c-4beb-a53d-519649c1993b', 12124, 'Banco Estado', 'asdasd', '2024-03-09 01:27:01', '2024-03-09 01:27:01');
INSERT INTO `transfers` VALUES (56, 803, 3, 345345, 'adc03b43-fa6e-498d-b6c8-cec3efe04b80', 2362346, 'Banco Credito e Inversiones', 'fgdfgd', '2024-03-09 01:27:07', '2024-03-09 01:27:07');
INSERT INTO `transfers` VALUES (57, 803, 3, 236523, '3f16390c-355e-4bbd-b4a5-0109bc2e6bd4', 23532523, 'Banco Citi', 'fgdfgdgdf', '2024-03-09 01:27:13', '2024-03-09 01:27:13');
INSERT INTO `transfers` VALUES (58, 803, 3, 3463467, '481b8adb-fc0a-4b48-9c0e-c8d64f4efd51', 67856785, 'Banco Credito e Inversiones', 'fdfsd', '2024-03-09 01:27:20', '2024-03-09 01:27:20');
INSERT INTO `transfers` VALUES (59, 803, 3, 232, '9211fb80-ff37-4088-8d32-d6a56ed9356b', 346346, 'Banco Ahorrador', 'ntynnty', '2024-03-09 01:27:26', '2024-03-09 01:27:26');
INSERT INTO `transfers` VALUES (60, 803, 3, 73234, 'a5476d00-98ac-4196-962d-43c4073f7003', 347734, 'Banco Credito e Inversiones', 'ghghgh', '2024-03-09 01:27:33', '2024-03-09 01:27:33');
INSERT INTO `transfers` VALUES (61, 803, 3, 1231234, 'b8c9f96f-33d2-40ff-84b9-aff85063aa57', 345, 'Banco Citi', 'fjytytyjhy', '2024-03-09 01:27:41', '2024-03-09 01:27:41');
INSERT INTO `transfers` VALUES (63, 803, 3, 82892, 'desdebd', 91203901, 'bd', 'jasdjkasd', '2024-03-09 01:59:13', '2024-03-09 01:59:19');

-- ----------------------------
-- Table structure for transfers_seq
-- ----------------------------
DROP TABLE IF EXISTS `transfers_seq`;
CREATE TABLE `transfers_seq`  (
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfers_seq
-- ----------------------------
INSERT INTO `transfers_seq` VALUES (151);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lastname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 903 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'rafo0183@gmail.com', '$2a$10$oLwTA4Pgz6OnGi.PKXfvZuT24ysvcHcWdoc60K0NWzoQDhNcyU2Di', 'Ricardo', 'Fuentes', 0, '2024-03-06 11:02:11', '2024-03-13 00:38:09', 'ADMIN');
INSERT INTO `users` VALUES (803, 'cliente@client.cl', '$2a$10$oLwTA4Pgz6OnGi.PKXfvZuT24ysvcHcWdoc60K0NWzoQDhNcyU2Di', 'ClientePrueba', 'PruebaLast', 0, '2024-03-07 16:54:25', '2024-03-13 02:28:55', 'CLIENT');

-- ----------------------------
-- Table structure for users_seq
-- ----------------------------
DROP TABLE IF EXISTS `users_seq`;
CREATE TABLE `users_seq`  (
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_seq
-- ----------------------------
INSERT INTO `users_seq` VALUES (1151);

SET FOREIGN_KEY_CHECKS = 1;
