/*
 Navicat Premium Data Transfer

 Source Server         : mysql_localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : mysql_springboot

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 03/09/2019 15:25:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_help
-- ----------------------------
DROP TABLE IF EXISTS `cms_help`;
CREATE TABLE `cms_help` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `read_count` int(1) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帮助表';

-- ----------------------------
-- Table structure for cms_help_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_help_category`;
CREATE TABLE `cms_help_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
  `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
  `show_status` int(2) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帮助分类表';

-- ----------------------------
-- Table structure for cms_member_report
-- ----------------------------
DROP TABLE IF EXISTS `cms_member_report`;
CREATE TABLE `cms_member_report` (
  `id` bigint(20) DEFAULT NULL,
  `report_type` int(1) DEFAULT NULL COMMENT '举报类型：0->商品评价；1->话题内容；2->用户评论',
  `report_member_name` varchar(100) DEFAULT NULL COMMENT '举报人',
  `create_time` datetime DEFAULT NULL,
  `report_object` varchar(100) DEFAULT NULL,
  `report_status` int(1) DEFAULT NULL COMMENT '举报状态：0->未处理；1->已处理',
  `handle_status` int(1) DEFAULT NULL COMMENT '处理结果：0->无效；1->有效；2->恶意',
  `note` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户举报表';

-- ----------------------------
-- Table structure for cms_prefrence_area
-- ----------------------------
DROP TABLE IF EXISTS `cms_prefrence_area`;
CREATE TABLE `cms_prefrence_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `pic` varbinary(500) DEFAULT NULL COMMENT '展示图片',
  `sort` int(11) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优选专区';

-- ----------------------------
-- Table structure for shy_group
-- ----------------------------
DROP TABLE IF EXISTS `shy_group`;
CREATE TABLE `shy_group` (
  `group_id` bigint(20) NOT NULL COMMENT '组ID',
  `group_name` varchar(64) DEFAULT NULL,
  `group_parent_id` int(11) DEFAULT NULL,
  `group_create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组表';

-- ----------------------------
-- Table structure for shy_group_right
-- ----------------------------
DROP TABLE IF EXISTS `shy_group_right`;
CREATE TABLE `shy_group_right` (
  `group_right_relation_id` bigint(20) DEFAULT NULL COMMENT '记录标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织权限关系表';

-- ----------------------------
-- Table structure for shy_group_role
-- ----------------------------
DROP TABLE IF EXISTS `shy_group_role`;
CREATE TABLE `shy_group_role` (
  `group_role_relation_id` bigint(20) DEFAULT NULL COMMENT '记录标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织角色关系表';

-- ----------------------------
-- Table structure for shy_log
-- ----------------------------
DROP TABLE IF EXISTS `shy_log`;
CREATE TABLE `shy_log` (
  `log_id` bigint(20) DEFAULT NULL COMMENT '日志识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Table structure for shy_organization
-- ----------------------------
DROP TABLE IF EXISTS `shy_organization`;
CREATE TABLE `shy_organization` (
  `organization_id` bigint(20) DEFAULT NULL COMMENT '记录标识',
  KEY `organization_id` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
-- Table structure for shy_right
-- ----------------------------
DROP TABLE IF EXISTS `shy_right`;
CREATE TABLE `shy_right` (
  `right_id` bigint(20) NOT NULL COMMENT '权限ID',
  `right_parent_id` bigint(20) DEFAULT NULL COMMENT '父权限',
  `right_name` varchar(255) DEFAULT NULL,
  `descrition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for shy_role
-- ----------------------------
DROP TABLE IF EXISTS `shy_role`;
CREATE TABLE `shy_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `role_parent_id` bigint(20) DEFAULT NULL COMMENT '父权限ID',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名',
  `role_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for shy_role_right
-- ----------------------------
DROP TABLE IF EXISTS `shy_role_right`;
CREATE TABLE `shy_role_right` (
  `role_right_id` bigint(20) NOT NULL COMMENT '记录标识',
  `Role__id` int(11) DEFAULT NULL,
  `right_id` int(11) DEFAULT NULL,
  `right_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Table structure for shy_user
-- ----------------------------
DROP TABLE IF EXISTS `shy_user`;
CREATE TABLE `shy_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `user_to_id` bigint(20) DEFAULT NULL COMMENT '所属组织',
  `user_login_name` varchar(64) DEFAULT NULL COMMENT '登录帐号',
  `user_password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `use_object` varchar(100) DEFAULT NULL,
  `use_status` int(1) DEFAULT NULL COMMENT '使用状态：0->不在使用；1->在处理',
  `user_create_time` datetime DEFAULT NULL,
  `user_mobile` varchar(64) DEFAULT NULL,
  `user_handle_status` int(1) DEFAULT NULL COMMENT '处理结果：0->无效；1->有效；2->恶意',
  `user_login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `user_last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `user_count` bigint(255) DEFAULT NULL COMMENT '登录次数',
  `user_e` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `外键` (`user_to_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of shy_user
-- ----------------------------
BEGIN;
INSERT INTO `shy_user` VALUES (1, 0, 'administrator', 'administrator', '管理员', '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (2, 2, 'yangguo', 'yangguo', '杨过', '普通', 1, '2019-09-02 00:00:00', '18811914454', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (3, 2, 'xln', 'xiaolongnv', '小龙女', '普通', 1, '2019-09-02 00:00:00', '18811914454', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (4, 3, 'nz', 'nezha', '哪吒', '普通', 0, '2019-09-02 00:00:00', '18811914454', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (5, 4, 'zrf', 'zhourunfa', '周润发', '普通', 1, '2019-09-02 00:00:00', '18811914454', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (6, 4, 'zxc', 'zhouxingchi', '周星驰', '普通', 1, '2019-09-02 00:00:00', '18811914454', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (7, 1, 'sunhaoyue', 'sunhaoyue', '孙浩月', '普通', 1, '2019-09-02 00:00:00', '15221211312', 2, '2019-09-02 00:00:00', NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (8, 0, 'shy', 'shy', 'shy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shy_user` VALUES (13, 10, '主键自增，删除后的记录也算主键，可以修改', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for shy_user_group
-- ----------------------------
DROP TABLE IF EXISTS `shy_user_group`;
CREATE TABLE `shy_user_group` (
  `user_group_relation_id` bigint(20) DEFAULT NULL COMMENT '记录标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组织关系表';

-- ----------------------------
-- Table structure for shy_user_right
-- ----------------------------
DROP TABLE IF EXISTS `shy_user_right`;
CREATE TABLE `shy_user_right` (
  `user_right_relation_id` bigint(20) DEFAULT NULL COMMENT '记录标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限关系表';

-- ----------------------------
-- Table structure for shy_user_role
-- ----------------------------
DROP TABLE IF EXISTS `shy_user_role`;
CREATE TABLE `shy_user_role` (
  `user_role_relation_id` bigint(20) DEFAULT NULL COMMENT '记录标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

SET FOREIGN_KEY_CHECKS = 1;
