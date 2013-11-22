/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50613
 Source Host           : localhost
 Source Database       : user

 Target Server Type    : MySQL
 Target Server Version : 50613
 File Encoding         : utf-8

 Date: 11/22/2013 16:30:34 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `user_id` int(10) NOT NULL COMMENT '主键',
  `email` varchar(50) DEFAULT NULL COMMENT '帐号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_login`
-- ----------------------------
BEGIN;
INSERT INTO `user_login` VALUES ('1', 'chengcheng222e@sina.com', '111111', '0', '15818575619');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
