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

 Date: 31/07/2022 00:15:48
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
INSERT INTO `consultation` VALUES (1, 1, 'Alex', 1, '2022-07-01', 0, 1, 'fred', 1, NULL, 111.0, 1);
INSERT INTO `consultation` VALUES (2, 1, 'Alex', 1, '2022-07-02', 1, 1, 'fred', 1, NULL, 2.0, 1);
INSERT INTO `consultation` VALUES (3, 1, 'Alex', 1, '2022-07-02', 2, 1, 'fred', 2, NULL, 3333.0, 1);
INSERT INTO `consultation` VALUES (4, 1, 'Alex', 1, '2022-07-05', 1, NULL, 'fred', 1, NULL, 0.0, 0);
INSERT INTO `consultation` VALUES (9, 1, 'Alex', 1, '2022-07-02', 3, NULL, 'fred', 0, NULL, 0.0, 0);
INSERT INTO `consultation` VALUES (10, 1, 'Alex', 1, '2022-07-03', 0, NULL, 'fred', 0, NULL, 0.0, 0);

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info`  (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名称',
  `affliation_id` int NULL DEFAULT NULL COMMENT '隶属id',
  `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科室简介',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记 0.正常 1.删除',
  PRIMARY KEY (`department_id`) USING BTREE,
  UNIQUE INDEX `department_name`(`department_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '科室信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES (1, 'cataract', NULL, '白内障', 0);
INSERT INTO `department_info` VALUES (2, 'obstetrics', NULL, '产科', 0);
INSERT INTO `department_info` VALUES (3, 'prenatal examination department', NULL, '产前检查科', 0);
INSERT INTO `department_info` VALUES (4, 'otorhinolaryngology', NULL, '耳鼻喉科', 0);
INSERT INTO `department_info` VALUES (5, 'Pediatrics', NULL, '儿科', 0);
INSERT INTO `department_info` VALUES (6, 'pediatric dentistry', NULL, '儿童口腔科', 0);
INSERT INTO `department_info` VALUES (7, 'child intensive care unit', NULL, '儿童重症监护科', 0);
INSERT INTO `department_info` VALUES (8, 'obstetrics and Gynecology', NULL, '妇产科', 0);
INSERT INTO `department_info` VALUES (9, 'gynecology', NULL, '妇科', 0);
INSERT INTO `department_info` VALUES (10, 'gynecological endocrinology', NULL, '妇科内分泌', 0);
INSERT INTO `department_info` VALUES (11, 'gynecology and urology', NULL, '妇泌尿科', 0);
INSERT INTO `department_info` VALUES (12, 'hepatobiliary surgery', NULL, '肝胆外科', 0);
INSERT INTO `department_info` VALUES (13, 'anorectal surgery', NULL, '肛肠外科', 0);
INSERT INTO `department_info` VALUES (14, 'internal medicine of infection', NULL, '感染内科', 0);
INSERT INTO `department_info` VALUES (15, 'hyperbaric oxygen department', NULL, '高压氧科', 0);
INSERT INTO `department_info` VALUES (16, 'functional neurosurgery', NULL, '功能神经外科', 0);
INSERT INTO `department_info` VALUES (17, 'bone surgery', NULL, '骨外科', 0);
INSERT INTO `department_info` VALUES (18, 'osteoporosis department', NULL, '骨质疏松科', 0);
INSERT INTO `department_info` VALUES (19, 'bone oncology', NULL, '骨肿瘤科', 0);
INSERT INTO `department_info` VALUES (20, 'respiratory medicine', NULL, '呼吸内科', 0);
INSERT INTO `department_info` VALUES (21, 'department of cornea', NULL, '角膜科', 0);
INSERT INTO `department_info` VALUES (22, 'orthopaedics', NULL, '矫形骨科', 0);
INSERT INTO `department_info` VALUES (23, 'spine surgery', NULL, '脊柱外科', 0);
INSERT INTO `department_info` VALUES (24, 'oral emergency department', NULL, '口腔急诊科', 0);
INSERT INTO `department_info` VALUES (25, 'geriatric medicine', NULL, '老年病内科', 0);
INSERT INTO `department_info` VALUES (26, 'department of immunology', NULL, '免疫内科', 0);
INSERT INTO `department_info` VALUES (27, 'urology', NULL, '泌尿外科', 0);
INSERT INTO `department_info` VALUES (28, 'endocrinology department', NULL, '内分泌科', 0);
INSERT INTO `department_info` VALUES (29, 'dermatology', NULL, '皮肤科', 0);
INSERT INTO `department_info` VALUES (30, 'general internal medicine', NULL, '普通内科', 0);
INSERT INTO `department_info` VALUES (31, 'general surgery', NULL, '普通外科', 0);
INSERT INTO `department_info` VALUES (32, 'organ transplantation department', NULL, '器官移植科', 0);
INSERT INTO `department_info` VALUES (33, 'glaucoma', NULL, '青光眼', 0);
INSERT INTO `department_info` VALUES (34, 'refraction', NULL, '屈光', 0);
INSERT INTO `department_info` VALUES (35, 'breast surgery', NULL, '乳腺外科', 0);
INSERT INTO `department_info` VALUES (36, 'nephrology department', NULL, '肾病内科', 0);
INSERT INTO `department_info` VALUES (37, 'department of Neurology', NULL, '神经内科', 0);
INSERT INTO `department_info` VALUES (38, 'neurosurgery', NULL, '神经外科', 0);
INSERT INTO `department_info` VALUES (39, 'optometry', NULL, '视光科', 0);
INSERT INTO `department_info` VALUES (40, 'hand surgery', NULL, '手外科', 0);
INSERT INTO `department_info` VALUES (41, 'head and neck surgery', NULL, '头颈外科', 0);
INSERT INTO `department_info` VALUES (42, 'gastrointestinal surgery', NULL, '胃肠外科', 0);
INSERT INTO `department_info` VALUES (43, 'minimally invasive surgery', NULL, '微创外科', 0);
INSERT INTO `department_info` VALUES (44, 'pediatric otorhinolaryngology', NULL, '小儿耳鼻喉科', 0);
INSERT INTO `department_info` VALUES (45, 'pediatric gynecology', NULL, '小儿妇科', 0);
INSERT INTO `department_info` VALUES (46, 'pediatric infection department', NULL, '小儿感染科', 0);
INSERT INTO `department_info` VALUES (47, 'pediatric orthopaedics', NULL, '小儿骨科', 0);
INSERT INTO `department_info` VALUES (48, 'pediatric respiratory department', NULL, '小儿呼吸科', 0);
INSERT INTO `department_info` VALUES (49, 'pediatric psychiatry', NULL, '小儿精神科', 0);
INSERT INTO `department_info` VALUES (50, 'pediatric emergency department', NULL, '小儿急诊科', 0);
INSERT INTO `department_info` VALUES (51, 'pediatric rehabilitation department', NULL, '小儿康复科', 0);
INSERT INTO `department_info` VALUES (52, 'pediatric Immunology Department', NULL, '小儿免疫科', 0);
INSERT INTO `department_info` VALUES (53, 'pediatric urology', NULL, '小儿泌尿外科', 0);
INSERT INTO `department_info` VALUES (54, 'pediatric endocrinology department', NULL, '小儿内分泌科', 0);
INSERT INTO `department_info` VALUES (55, 'pediatric dermatology', NULL, '小儿皮肤科', 0);
INSERT INTO `department_info` VALUES (56, 'pediatric neurology', NULL, '小儿神经内科', 0);
INSERT INTO `department_info` VALUES (57, 'pediatric neurosurgery', NULL, '小儿神经外科', 0);
INSERT INTO `department_info` VALUES (58, 'pediatric nephrology', NULL, '小儿肾内科', 0);
INSERT INTO `department_info` VALUES (59, 'pediatric surgery', NULL, '小儿外科', 0);
INSERT INTO `department_info` VALUES (60, 'pediatric digestive department', NULL, '小儿消化科', 0);
INSERT INTO `department_info` VALUES (61, 'pediatric cardiology', NULL, '小儿心内科', 0);
INSERT INTO `department_info` VALUES (62, 'pediatric cardiac surgery', NULL, '小儿心外科', 0);
INSERT INTO `department_info` VALUES (63, 'pediatric thoracic surgery', NULL, '小儿胸外科', 0);
INSERT INTO `department_info` VALUES (64, 'pediatric hematology department', NULL, '小儿血液科', 0);
INSERT INTO `department_info` VALUES (65, 'pediatric ophthalmology', NULL, '小儿眼科', 0);
INSERT INTO `department_info` VALUES (66, 'pediatric nutrition and health care department', NULL, '小儿营养保健科', 0);
INSERT INTO `department_info` VALUES (67, 'pediatric plastic surgery', NULL, '小儿整形科', 0);
INSERT INTO `department_info` VALUES (68, 'gastroenterology', NULL, '消化内科', 0);
INSERT INTO `department_info` VALUES (69, 'std department', NULL, '性病科', 0);
INSERT INTO `department_info` VALUES (70, 'neonatology', NULL, '新生儿科', 0);
INSERT INTO `department_info` VALUES (71, 'neonatal surgery', NULL, '新生儿外科', 0);
INSERT INTO `department_info` VALUES (72, 'cardiovascular medicine', NULL, '心血管内科', 0);
INSERT INTO `department_info` VALUES (73, 'cardiovascular surgery', NULL, '心血管外科', 0);
INSERT INTO `department_info` VALUES (74, 'thoracic surgery', NULL, '胸外科', 0);
INSERT INTO `department_info` VALUES (75, 'vascular surgery', NULL, '血管外科', 0);
INSERT INTO `department_info` VALUES (76, 'hematology department', NULL, '血液内科', 0);
INSERT INTO `department_info` VALUES (77, 'fundus department', NULL, '眼底科', 0);
INSERT INTO `department_info` VALUES (78, 'ophthalmology', NULL, '眼科', 0);
INSERT INTO `department_info` VALUES (79, 'orbit and tumor', NULL, '眼眶及肿瘤', 0);
INSERT INTO `department_info` VALUES (80, 'department of ocular trauma', NULL, '眼外伤科', 0);
INSERT INTO `department_info` VALUES (81, 'inflammatory', NULL, '炎症性', 0);
INSERT INTO `department_info` VALUES (82, 'genetic counseling section', NULL, '遗传咨询科', 0);
INSERT INTO `department_info` VALUES (83, 'plastic surgery', NULL, '整形外科', 0);
INSERT INTO `department_info` VALUES (84, 'gynecological oncology', NULL, '肿瘤妇科', 0);
INSERT INTO `department_info` VALUES (85, 'oncology rehabilitation department', NULL, '肿瘤康复科', 0);
INSERT INTO `department_info` VALUES (86, 'medicine-oncology', NULL, '肿瘤内科', 0);
INSERT INTO `department_info` VALUES (87, 'tumor surgery', NULL, '肿瘤外科', 0);
INSERT INTO `department_info` VALUES (88, 'oncology department', NULL, '肿瘤科', 0);
INSERT INTO `department_info` VALUES (89, 'foot and ankle surgery', NULL, '足踝外科', 0);

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
INSERT INTO `doctor_info` VALUES (35, 'bill4', '123', NULL, '1437', NULL, 4, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (36, 'bill5', '123', NULL, '1438', NULL, 5, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (37, 'bill6', '123', NULL, '1439', NULL, 6, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (38, 'bill7', '123', NULL, '1440', NULL, 7, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (39, 'bill8', '123', NULL, '1441', NULL, 8, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (40, 'bill9', '123', NULL, '1442', NULL, 9, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (41, 'bill10', '123', NULL, '1443', NULL, 10, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (42, 'bill11', '123', NULL, '1444', NULL, 11, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (43, 'bill12', '123', NULL, '1445', NULL, 12, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (44, 'bill13', '123', NULL, '1446', NULL, 13, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (45, 'bill14', '123', NULL, '1447', NULL, 14, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (46, 'bill15', '123', NULL, '1448', NULL, 15, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (47, 'bill16', '123', NULL, '1449', NULL, 16, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (48, 'bill17', '123', NULL, '1450', NULL, 17, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (49, 'bill18', '123', NULL, '1451', NULL, 18, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (50, 'bill19', '123', NULL, '1452', NULL, 19, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (51, 'bill20', '123', NULL, '1453', NULL, 20, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (52, 'bill21', '123', NULL, '1454', NULL, 21, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (53, 'bill22', '123', NULL, '1455', NULL, 22, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (54, 'bill23', '123', NULL, '1456', NULL, 23, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (55, 'bill24', '123', NULL, '1457', NULL, 24, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (56, 'bill25', '123', NULL, '1458', NULL, 25, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (57, 'bill26', '123', NULL, '1459', NULL, 26, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (58, 'bill27', '123', NULL, '1460', NULL, 27, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (59, 'bill28', '123', NULL, '1461', NULL, 28, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (60, 'bill29', '123', NULL, '1462', NULL, 29, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (61, 'bill30', '123', NULL, '1463', NULL, 30, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (62, 'bill31', '123', NULL, '1464', NULL, 31, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (63, 'bill32', '123', NULL, '1465', NULL, 32, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (64, 'bill33', '123', NULL, '1466', NULL, 33, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (65, 'bill34', '123', NULL, '1467', NULL, 34, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (66, 'bill35', '123', NULL, '1468', NULL, 35, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (67, 'bill36', '123', NULL, '1469', NULL, 36, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (68, 'bill37', '123', NULL, '1470', NULL, 37, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (69, 'bill38', '123', NULL, '1471', NULL, 38, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (70, 'bill39', '123', NULL, '1472', NULL, 39, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (71, 'bill40', '123', NULL, '1473', NULL, 40, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (72, 'bill41', '123', NULL, '1474', NULL, 41, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (73, 'bill42', '123', NULL, '1475', NULL, 42, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (74, 'bill43', '123', NULL, '1476', NULL, 43, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (75, 'bill44', '123', NULL, '1477', NULL, 44, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (76, 'bill45', '123', NULL, '1478', NULL, 45, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (77, 'bill46', '123', NULL, '1479', NULL, 46, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (78, 'bill47', '123', NULL, '1480', NULL, 47, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (79, 'bill48', '123', NULL, '1481', NULL, 48, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (80, 'bill49', '123', NULL, '1482', NULL, 49, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (81, 'bill50', '123', NULL, '1483', NULL, 50, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (82, 'bill51', '123', NULL, '1484', NULL, 51, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (83, 'bill52', '123', NULL, '1485', NULL, 52, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (84, 'bill53', '123', NULL, '1486', NULL, 53, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (85, 'bill54', '123', NULL, '1487', NULL, 54, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (86, 'bill55', '123', NULL, '1488', NULL, 55, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (87, 'bill56', '123', NULL, '1489', NULL, 56, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (88, 'bill57', '123', NULL, '1490', NULL, 57, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (89, 'bill58', '123', NULL, '1491', NULL, 58, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (90, 'bill59', '123', NULL, '1492', NULL, 59, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (91, 'bill60', '123', NULL, '1493', NULL, 60, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (92, 'bill61', '123', NULL, '1494', NULL, 61, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (93, 'bill62', '123', NULL, '1495', NULL, 62, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (94, 'bill63', '123', NULL, '1496', NULL, 63, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (95, 'bill64', '123', NULL, '1497', NULL, 64, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (96, 'bill65', '123', NULL, '1498', NULL, 65, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (97, 'bill66', '123', NULL, '1499', NULL, 66, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (98, 'bill67', '123', NULL, '1500', NULL, 67, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (99, 'bill68', '123', NULL, '1501', NULL, 68, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (100, 'bill69', '123', NULL, '1502', NULL, 69, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (101, 'bill70', '123', NULL, '1503', NULL, 70, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (102, 'bill71', '123', NULL, '1504', NULL, 71, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (103, 'bill72', '123', NULL, '1505', NULL, 72, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (104, 'bill73', '123', NULL, '1506', NULL, 73, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (105, 'bill74', '123', NULL, '1507', NULL, 74, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (106, 'bill75', '123', NULL, '1508', NULL, 75, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (107, 'bill76', '123', NULL, '1509', NULL, 76, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (108, 'bill77', '123', NULL, '1510', NULL, 77, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (109, 'bill78', '123', NULL, '1511', NULL, 78, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (110, 'bill79', '123', NULL, '1512', NULL, 79, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (111, 'bill80', '123', NULL, '1513', NULL, 80, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (112, 'bill81', '123', NULL, '1514', NULL, 81, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (113, 'bill82', '123', NULL, '1515', NULL, 82, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (114, 'bill83', '123', NULL, '1516', NULL, 83, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (115, 'bill84', '123', NULL, '1517', NULL, 84, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (116, 'bill85', '123', NULL, '1518', NULL, 85, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (117, 'bill86', '123', NULL, '1519', NULL, 86, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (118, 'bill87', '123', NULL, '1520', NULL, 87, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (119, 'bill88', '123', NULL, '1521', NULL, 88, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (120, 'bill89', '123', NULL, '1522', NULL, 89, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `doctor_info` VALUES (121, 'kk', '123', NULL, '323', NULL, 3, NULL, NULL, NULL, 1, NULL, NULL, 0);

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
INSERT INTO `patient_info` VALUES (36, 'sssf', '123', NULL, '1232', NULL, '2019-02-20 00:00:00', '0', NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (37, 'YinChongyue', '123', NULL, '23123', NULL, '2022-07-01 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (41, 'sssf', '123', NULL, '123232', NULL, '2019-02-20 00:00:00', '0', NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (44, '2sssf', '123', NULL, '1232323', NULL, '2019-02-20 00:00:00', '0', NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (45, 'sb', '123', NULL, '133', NULL, '2022-07-05 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `patient_info` VALUES (46, 'fred1', '123', NULL, '32132', NULL, '2022-07-06 00:00:00', NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
