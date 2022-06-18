/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : cloud_hospital

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 6/15/2022 21:08:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkReport
-- ----------------------------
DROP TABLE IF EXISTS `checkReport`;
CREATE TABLE `checkReport`  (
  `report_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '检查报告id',
  `patient_id` int(11) NOT NULL COMMENT '患者id',
  `consultation_id` int(11) NULL DEFAULT NULL COMMENT '就诊记录ID',
  `inspectionItem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查项目',
  `attachment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '检查时间',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '就诊科室',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结果描述',
  `conclusion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结论',
  `issue_doctor_id` int(11) NULL DEFAULT NULL COMMENT '开单医生',
  `conduct_doctor_id` int(11) NULL DEFAULT NULL COMMENT '检查医生',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '检查报告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of checkReport
-- ----------------------------

-- ----------------------------
-- Table structure for consultation
-- ----------------------------


DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation` (
  `consultation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '就诊记录ID',
  `doctor_id` int(11) NOT NULL ,
  `doctor_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `day_slot` int(11) NULL DEFAULT NULL COMMENT '星期几',
  `time_slot` int(11) NULL DEFAULT NULL COMMENT '时间段',
  `avail_status` int(11) NULL DEFAULT NULL COMMENT '可用状态 0.可预约 1.等待确认 2.不可用',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `charge` decimal(11,1) NOT NULL DEFAULT 0.0 COMMENT '收费',
  PRIMARY KEY (`consultation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '坐诊表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for medicalrecord
-- ----------------------------
DROP TABLE IF EXISTS `medicalrecord`;
CREATE TABLE `medicalrecord`  (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病历ID',
  `patient_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人ID',
  `patient_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '患者性别',
  `symptom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要症状',
  `drugsused` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所用药物',
  `doctor_id` int(11) NULL AUTO_INCREMENT COMMENT '医生ID',
  `doctor_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `preconsultation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预问诊',
  `report_id` int(11) NULL DEFAULT NULL COMMENT '检查报告id',
  `diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断',
  `prescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '病历状态 0自行预约 1智能导诊 2已诊断 3删除',
  PRIMARY KEY (`record_id`) USING BTREE
  UNIQUE INDEX `patient_id`(`patient_id`) USING BTREE,
  UNIQUE INDEX `doctor_id`(`doctor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '病历表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicalrecord
-- ----------------------------
-- INSERT INTO `consultation` VALUES (1, 'bob', '1', '呕吐', '止咳糖浆', 'qq', '22', 33, '2020-05-20 17:05:18', '2020-05-20 17:05:21', 0);
-- INSERT INTO `consultation` VALUES (2, 'sundy', '1', '头疼', '康比得', '11', '22', 34, '2020-05-20 17:06:13', '2020-05-20 17:06:15', 0);

-- ----------------------------
-- Table structure for departmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info`  (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名称',
  `affliation_id` int(11) NULL DEFAULT NULL COMMENT '隶属id',
  `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科室简介',

  PRIMARY KEY (`department_id`) USING BTREE,
  UNIQUE INDEX `department_name`(`department_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '科室信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of departmentinfo
-- ----------------------------
-- INSERT INTO `department_info` VALUES (33, 'orthopedic', NULL);  --骨科
-- INSERT INTO `department_info` VALUES (34, 'ophtalmology', NULL);  --眼科
-- INSERT INTO `department_info` VALUES (35, 'Endocrinology', NULL); --内分泌科
-- INSERT INTO `department_info` VALUES (36, 'obstetrics_and_gynecology', NULL); --妇科
-- INSERT INTO `department_info` VALUES (37, 'neurology', NULL); --神经科
-- INSERT INTO `department_info` VALUES (38, 'psychiatry', NULL);  --精神科



-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info`  (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  -- `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  `title_id` int(11) NULL DEFAULT NULL COMMENT '职称ID',
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `headimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件照',
  `avail_state` int(11) NOT NULL COMMENT '启用状态 0.禁用 1.启用',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`doctor_id`) USING BTREE,
  UNIQUE INDEX `doctor_name`(`doctor_name`) USING BTREE,
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
  UNIQUE INDEX `department_id`(`department_id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '医生信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
-- INSERT INTO `doctor_info` VALUES (33, '张医生', '111111', '2020-04-16 14:40:02', '15700085557', '河南-商丘-夏邑', 1, 33, 33, '医生界的一枝花，抗击新冠肺炎卓有成效', NULL, '5', 1, NULL, NULL);
-- INSERT INTO `doctor_info` VALUES (34, '王医生', '111111', '2020-04-01 15:35:20', '13734741053', '河南-郑州-金水', 1, 34, 33, '医生界的扛把子，抗击新冠肺炎一马当先', NULL, '10', 1, NULL, NULL);


-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info`  (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '病人姓名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别 0.女 1.男',
  -- `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `patient_name`(`patient_name`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
  UNIQUE INDEX `cid`(`cid`) USING BTREE,
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '病人信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `validatecode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for institutioninfo
-- ----------------------------
-- DROP TABLE IF EXISTS `institutioninfo`;
-- CREATE TABLE `institutioninfo`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `institution_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构名称',
--   `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
--   PRIMARY KEY (`id`) USING BTREE,
--   UNIQUE INDEX `institution_name`(`institution_name`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of institutioninfo
-- ----------------------------

-- ----------------------------
-- Table structure for medicalrecord
-- ----------------------------
-- DROP TABLE IF EXISTS `medicalrecord`;
-- CREATE TABLE `medicalrecord`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `record_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病历编号',
--   `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户手机号',
--   `department_id` int(11) NULL DEFAULT NULL COMMENT '就诊科室ID',
--   `seektime` datetime(0) NULL DEFAULT NULL COMMENT '就诊日期',
--   `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病情描述',
--   `checkinfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查结果',
--   `guomishi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过敏史',
--   `doc_id` int(11) NULL DEFAULT NULL COMMENT '医生id',
--   `diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
--   `prescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方',
--   `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用药详情',
--   `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
--   `createTime` datetime(0) NULL DEFAULT NULL,
--   `updateTime` datetime(0) NULL DEFAULT NULL,
--   `user_id` int(11) NOT NULL,
--   `diagnostictype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊断类型',
--   `state` int(11) NULL DEFAULT NULL COMMENT '状态  1 启用  0 禁用',
--   PRIMARY KEY (`id`) USING BTREE,
--   UNIQUE INDEX `phone`(`phone`) USING BTREE,
--   UNIQUE INDEX `record_code`(`record_code`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '电子病历信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicalrecord
-- ----------------------------
-- INSERT INTO `medicalrecord` VALUES (38, '03797049661', '1500000003', 34, '2019-10-12 00:00:00', '胃部炎症很严重7', NULL, '无过敏史', 33, '胃穿孔', '吃一些健胃消食片', '一次三片 一天三次', '注意不要喝酒', '2020-04-22 07:17:27', '2020-04-22 07:17:27', 33, NULL, 1);
-- INSERT INTO `medicalrecord` VALUES (39, '49222424520', '13734741053', 34, '2020-04-16 00:00:00', '眼睛很痛，东西看不清楚', NULL, '无过敏史', 34, '红眼病', '滴光明牌眼药水', '一天三次，一次5ml', '注意不要揉眼睛', '2020-04-22 07:30:08', '2020-04-22 07:30:08', 34, NULL, 0);
-- INSERT INTO `medicalrecord` VALUES (41, '67359425737', '13734741054', 37, '2020-04-16 00:00:00', '感觉很难受，很恍惚，不清醒', NULL, '无过敏史', 34, '神经衰弱', '住院治疗', '一天一次，一次20分钟', '注意不要情绪过激', '2020-04-22 08:01:28', '2020-04-22 08:01:28', 34, NULL, 1);
-- INSERT INTO `medicalrecord` VALUES (42, '01179565860', '13734741055', 38, '2020-04-16 00:00:00', '感觉很疼', NULL, '无过敏史', 34, '妇科炎症', '住院治疗', '一天一次，一次20分钟', '注意好好保养', '2020-04-22 08:02:21', '2020-04-22 08:02:21', 34, NULL, 1);
-- INSERT INTO `medicalrecord` VALUES (44, '38444916294', '13739999001', 38, '2020-01-27 00:00:00', '感冒发烧', NULL, '无过敏史', 34, '轻微感冒', '快克', '一天一次，一次一片', '不要着凉', '2020-04-27 07:09:56', '2020-04-27 07:09:56', 34, NULL, 0);

-- ----------------------------
-- Table structure for model
-- ----------------------------
-- DROP TABLE IF EXISTS `model`;
-- CREATE TABLE `model`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块ID',
--   `parent_id` int(11) NULL DEFAULT NULL COMMENT '父模块id',
--   `model_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块名称',
--   `model_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '跳转页面路径',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of model
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
-- DROP TABLE IF EXISTS `permission`;
-- CREATE TABLE `permission`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
--   `permission_name` int(11) NOT NULL COMMENT '权限名称',
--   `model_id` int(11) NOT NULL COMMENT '模块ID',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
-- DROP TABLE IF EXISTS `prescription`;
-- CREATE TABLE `prescription`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '处方ID',
--   `user_id` int(11) NOT NULL COMMENT '患者id',
--   `record_id` int(11) NOT NULL COMMENT '病历id',
--   `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处方内容',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '处方信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
-- DROP TABLE IF EXISTS `role`;
-- CREATE TABLE `role`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
-- DROP TABLE IF EXISTS `role_permission`;
-- CREATE TABLE `role_permission`  (
--   `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
--   `permission_id` int(11) NOT NULL COMMENT '权限ID',
--   PRIMARY KEY (`role_id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for subsystem
-- ----------------------------
-- DROP TABLE IF EXISTS `subsystem`;
-- CREATE TABLE `subsystem`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子系统ID',
--   `system_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统名称',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '子系统信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subsystem
-- ----------------------------

-- ----------------------------
-- Table structure for titleinfo
-- ----------------------------
-- DROP TABLE IF EXISTS `titleinfo`;
-- CREATE TABLE `titleinfo`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `titlename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职称名称',
--   PRIMARY KEY (`id`) USING BTREE,
--   UNIQUE INDEX `titlename`(`titlename`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职称信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of titleinfo
-- ----------------------------
-- INSERT INTO `titleinfo` VALUES (32, '主任');
-- INSERT INTO `titleinfo` VALUES (33, '医生');
-- INSERT INTO `titleinfo` VALUES (34, '护士');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
-- DROP TABLE IF EXISTS `user_role`;
-- CREATE TABLE `user_role`  (
--   `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
--   `role_id` int(11) NOT NULL COMMENT '角色ID',
--   PRIMARY KEY (`user_id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
-- DROP TABLE IF EXISTS `userinfo`;
-- CREATE TABLE `userinfo`  (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
--   `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
--   `roleid` int(11) NOT NULL COMMENT '角色ID 1.超级管理员 2.普通用户 3.医生 4.护士',
--   `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
--   `cid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
--   `birthday` datetime(0) NOT NULL COMMENT '出生日期',
--   `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别 0.女 1.男',
--   `di_type` int(11) NULL DEFAULT NULL COMMENT '1.检查/诊断 2. 治疗/手术 3.复诊',
--   `frontimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证正面照',
--   `backimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证反面照',
--   `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
--   `bedno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病床号',
--   `departmentid` int(11) NULL DEFAULT NULL COMMENT '科室id',
--   `doctorid` int(11) NULL DEFAULT NULL COMMENT '主治医生id',
--   `nurseid` int(11) NULL DEFAULT NULL COMMENT '责任护士id',
--   `instatus` int(11) NULL DEFAULT NULL COMMENT '住院状态 1.未住院 2.预住院 3.住院中 4.已出院',
--   `state` int(11) NOT NULL COMMENT '启用状态 0.禁用 1.启用',
--   PRIMARY KEY (`id`) USING BTREE,
--   UNIQUE INDEX `username`(`username`) USING BTREE,
--   UNIQUE INDEX `phone`(`phone`) USING BTREE,
--   UNIQUE INDEX `cid`(`cid`) USING BTREE,
--   UNIQUE INDEX `bedno`(`bedno`) USING BTREE,
--   UNIQUE INDEX `departmentid`(`departmentid`) USING BTREE,
--   UNIQUE INDEX `doctorid`(`doctorid`) USING BTREE,
--   UNIQUE INDEX `nurseid`(`nurseid`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
-- INSERT INTO `userinfo` VALUES (33, 'ykq632', '123456', 1, '1500000003', NULL, '2147483647', '2020-04-01 10:04:08', '1', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497380956,3644779616&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3387134982,2837425777&fm=26&gp=0.jpg', '河南省-商丘市', '', NULL, 33, NULL, NULL, 1);
-- INSERT INTO `userinfo` VALUES (34, 'lisa1', '123456', 1, '13734741054', NULL, '15262919956789003', '2020-04-01 15:33:30', '1', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497380956,3644779616&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3387134982,2837425777&fm=26&gp=0.jpg', '河南省-郑州市', NULL, NULL, 34, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
