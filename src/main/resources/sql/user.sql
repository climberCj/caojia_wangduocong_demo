/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-19 16:19:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL,
  `china_name` varchar(32) DEFAULT NULL,
  `user_name` varchar(16) DEFAULT NULL,
  `user_pass` varchar(64) DEFAULT NULL,
  `user_role` varchar(8) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `role_id` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2342243241', '曹佳', 'caojia', '5bc17196448b632d7155127d0e7d7df4', 'student', '2019-12-19', '002');
INSERT INTO `user` VALUES ('432345343', '王多聪', 'heis', 'b2c67229b947b6595b3cc4021528b66c', 'teacher', '2019-12-19', '001');
