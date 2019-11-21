/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-21 16:35:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `sysid` varchar(32) NOT NULL COMMENT '主键',
  `stNo` varchar(2) DEFAULT NULL COMMENT '试题编号',
  `stTitle` varchar(128) DEFAULT NULL COMMENT '试题信息',
  `stOptionA` varchar(32) DEFAULT NULL COMMENT 'A',
  `stOptionB` varchar(32) DEFAULT NULL COMMENT 'B',
  `stOptionC` varchar(32) DEFAULT NULL COMMENT 'C',
  `stOptionD` varchar(32) DEFAULT NULL COMMENT 'D',
  `stAnswer` varchar(128) DEFAULT NULL COMMENT '答案',
  `stParse` varchar(128) DEFAULT NULL COMMENT '解析',
  `stStatus` varchar(2) DEFAULT NULL COMMENT '0：删除；1：正常',
  PRIMARY KEY (`sysid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
