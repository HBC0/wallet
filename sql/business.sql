/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : business

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/10/2023 22:48:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `transaction_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型，例如充值、消费、退款等',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transactions
-- ----------------------------
INSERT INTO `transactions` VALUES (1, 1, '退款', 20.00, '2023-10-20 21:20:25');
INSERT INTO `transactions` VALUES (2, 1, '消费', 10.00, '2023-10-20 21:55:24');
INSERT INTO `transactions` VALUES (3, 1, '消费', 10.00, '2023-10-20 21:57:50');
INSERT INTO `transactions` VALUES (4, 1, '退款', 10.00, '2023-10-20 21:59:29');
INSERT INTO `transactions` VALUES (5, 1, '消费', 10.00, '2023-10-20 22:47:15');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'jack', '123', '2023-10-20 21:12:40', '2023-10-20 21:12:44');
INSERT INTO `users` VALUES (2, 'tom', '123', '2023-10-20 21:13:25', '2023-10-20 21:13:29');

-- ----------------------------
-- Table structure for wallets
-- ----------------------------
DROP TABLE IF EXISTS `wallets`;
CREATE TABLE `wallets`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '钱包id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '钱包余额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallets
-- ----------------------------
INSERT INTO `wallets` VALUES (1, 1, 940.00, '2023-10-20 21:21:10');
INSERT INTO `wallets` VALUES (2, 2, 300.00, '2023-10-20 21:21:32');

SET FOREIGN_KEY_CHECKS = 1;
