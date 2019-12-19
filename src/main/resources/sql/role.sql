/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-19 16:19:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(8) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('001', '教师', 'teacher');
INSERT INTO `role` VALUES ('002', '学生', 'student');
