/*
Navicat MySQL Data Transfer

Source Server         : caojia
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : examonlinedb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-21 16:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sysid` varchar(32) NOT NULL COMMENT '主键',
  `studentId` varchar(32) DEFAULT NULL COMMENT '学生账号',
  `studentName` varchar(64) DEFAULT NULL COMMENT '学生姓名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `result` int(32) DEFAULT NULL COMMENT '分数',
  `sclass` varchar(32) DEFAULT NULL COMMENT '班级',
  `teacherId` varchar(32) DEFAULT NULL COMMENT '教师账号',
  `stuStatus` varchar(2) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '0：删除状态，1：正常',
  `stuPic` varchar(255) DEFAULT NULL COMMENT '学生头像',
  PRIMARY KEY (`sysid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into student(sysid, studentId, studentName, password, result, sclass, teacherId, stuStatus) value ('005','叫我美女','小昭','dev',467,'高三五班','01','1')