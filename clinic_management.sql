/*
 Navicat Premium Data Transfer

 Source Server         : k
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : clinic_management

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 09/07/2022 17:46:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin_info
-- ----------------------------

-- ----------------------------
-- Table structure for checkreport
-- ----------------------------
DROP TABLE IF EXISTS `checkreport`;
CREATE TABLE `checkreport`  (
  `report_id` int NOT NULL AUTO_INCREMENT COMMENT '检查报告id',
  `patient_id` int NOT NULL COMMENT '患者id',
  `consultation_id` int NULL DEFAULT NULL COMMENT '就诊记录ID',
  `inspectionItem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查项目',
  `attachment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `check_time` datetime NULL DEFAULT NULL COMMENT '检查时间',
  `department_id` int NULL DEFAULT NULL COMMENT '就诊科室',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结果描述',
  `conclusion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结论',
  `issue_doctor_id` int NULL DEFAULT NULL COMMENT '开单医生',
  `conduct_doctor_id` int NULL DEFAULT NULL COMMENT '检查医生',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '检查报告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of checkreport
-- ----------------------------

-- ----------------------------
-- Table structure for consultation
-- ----------------------------
DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation`  (
  `consultation_id` int NOT NULL AUTO_INCREMENT COMMENT '坐诊记录ID',
  `doctor_id` int NOT NULL COMMENT '医生ID',
  `doctor_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `department_id` int NOT NULL COMMENT '科室ID',
  `dates` date NOT NULL DEFAULT '1970-01-01' COMMENT '日期',
  `time_slot` int NULL DEFAULT NULL COMMENT '时间段',
  `patient_id` int NULL DEFAULT NULL COMMENT '病人ID',
  `patient_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病人姓名',
  `avail_status` int NULL DEFAULT NULL COMMENT '可用状态 0.可预约 1.等待确认 2.不可用',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `charge` decimal(11, 1) NOT NULL DEFAULT 0.0 COMMENT '收费',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`consultation_id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `dates`(`dates`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '坐诊表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consultation
-- ----------------------------
INSERT INTO `consultation` VALUES (1, 1, 'Alex', 1, '2022-07-01', 0, 1, 'fred', 0, NULL, 111.0, 1);
INSERT INTO `consultation` VALUES (2, 1, 'Alex', 1, '2022-07-02', 1, 1, 'fred', 1, NULL, 2.0, 1);
INSERT INTO `consultation` VALUES (3, 1, 'Alex', 1, '2022-07-02', 2, 1, 'fred', 2, NULL, 3333.0, 1);
INSERT INTO `consultation` VALUES (4, 1, 'Alex', 1, '2022-07-05', 1, NULL, 'fred', 1, NULL, 0.0, 0);
INSERT INTO `consultation` VALUES (9, 1, 'Alex', 1, '2022-07-02', 3, NULL, 'fred', 0, NULL, 0.0, 0);
INSERT INTO `consultation` VALUES (10, 1, 'Alex', 1, '2022-07-03', 0, NULL, 'fred', 0, NULL, 0.0, 0);
INSERT INTO `consultation` VALUES (24, 1, 'Alex', 1, '2022-07-05', 3, NULL, 'fred', NULL, NULL, 2.0, 1);
INSERT INTO `consultation` VALUES (25, 1, 'Alex', 1, '2022-07-05', 2, NULL, NULL, 1, 'null', 1.0, 0);

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info`  (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名称',
  `affliation_id` int NULL DEFAULT NULL COMMENT '隶属id',
  `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科室简介',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`department_id`) USING BTREE,
  UNIQUE INDEX `department_name`(`department_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '科室信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES (1, '牙科', NULL, NULL, 0);
INSERT INTO `department_info` VALUES (2, '脑科', NULL, NULL, 0);

-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info`  (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `department_id` int NULL DEFAULT NULL COMMENT '科室ID',
  `title_id` int NULL DEFAULT NULL COMMENT '职称ID',
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `headimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件照',
  `avail_state` int NOT NULL COMMENT '启用状态 0.禁用 1.启用',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`doctor_id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
  INDEX `doctor_name`(`doctor_name`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '医生信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
INSERT INTO `doctor_info` VALUES (1, 'Alex', '123', NULL, '123', NULL, 1, NULL, NULL, NULL, 0, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (2, 'Bill', '123', NULL, '1232', NULL, 2, NULL, NULL, NULL, 0, NULL, NULL, 0);

-- ----------------------------
-- Table structure for login_ticket
-- ----------------------------
DROP TABLE IF EXISTS `login_ticket`;
CREATE TABLE `login_ticket`  (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `ticket` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` int NULL DEFAULT NULL COMMENT '0-用户;1-医生;2-管理员',
  `status` int NULL DEFAULT NULL COMMENT '0-valid; 1-invalid',
  `expired` timestamp NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录令牌' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of login_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for medicalrecord
-- ----------------------------
DROP TABLE IF EXISTS `medicalrecord`;
CREATE TABLE `medicalrecord`  (
  `record_id` int NOT NULL AUTO_INCREMENT COMMENT '病历ID',
  `patient_id` int NOT NULL COMMENT '病人ID',
  `patient_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者性别',
  `symptom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要症状',
  `drugsused` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所用药物',
  `doctor_id` int NULL DEFAULT NULL COMMENT '医生ID',
  `doctor_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `preconsultation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预问诊',
  `report_id` int NULL DEFAULT NULL COMMENT '检查报告id',
  `diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断',
  `prescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方',
  `department_id` int NULL DEFAULT NULL COMMENT '科室ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL COMMENT '病历状态 0自行预约 1智能导诊 2已诊断',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `patient_id`(`patient_id`) USING BTREE,
  INDEX `doctor_id`(`doctor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '病历表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicalrecord
-- ----------------------------
INSERT INTO `medicalrecord` VALUES (17, 2, 'Alan', '0', '高烧不退，还有经常性的咳嗽', NULL, NULL, NULL, NULL, NULL, '如果确诊是感冒咳嗽，需要吃中药，配合西药治疗效果不错。', NULL, 13, NULL, NULL, 2, 0);
INSERT INTO `medicalrecord` VALUES (23, 1, 'fred', '1', '高烧不退，还有经常性的咳嗽', NULL, NULL, NULL, NULL, NULL, '你好，考虑感冒症状。服用清热解毒之类中成药。', NULL, 13, NULL, NULL, 2, 0);
INSERT INTO `medicalrecord` VALUES (24, 1, 'fred', '1', '高烧不退，还有经常性的咳嗽', NULL, NULL, NULL, NULL, NULL, '你好，考虑感冒症状。服用清热解毒之类中成药。', NULL, 13, NULL, NULL, 2, 0);

-- ----------------------------
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info`  (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '病人姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别 0.女 1.男',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`patient_id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
  INDEX `patient_name`(`patient_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '病人信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patient_info
-- ----------------------------
INSERT INTO `patient_info` VALUES (1, 'fred', '123', '1', '123', NULL, '2000-07-07 16:23:33', '0', NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (2, 'Alan', '123', '2', '1', NULL, '1999-07-07 17:23:40', '0', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
