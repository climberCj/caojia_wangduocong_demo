/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-20 17:07:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `sysid` varchar(32) NOT NULL COMMENT '主键',
  `teacherId` varchar(32) DEFAULT NULL COMMENT '教师账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `teacherName` varchar(255) DEFAULT '' COMMENT '教师姓名',
  PRIMARY KEY (`sysid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
