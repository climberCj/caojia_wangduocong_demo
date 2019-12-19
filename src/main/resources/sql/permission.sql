/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-19 16:19:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `per_id` varchar(8) NOT NULL,
  `permission_name` varchar(32) DEFAULT NULL,
  `role_id` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'create', '001');
INSERT INTO `permission` VALUES ('2', 'delete', '001');
INSERT INTO `permission` VALUES ('3', 'update', '001');
INSERT INTO `permission` VALUES ('4', 'query', '001');
INSERT INTO `permission` VALUES ('5', 'exam', '002');
INSERT INTO `permission` VALUES ('6', 'view', '002');
