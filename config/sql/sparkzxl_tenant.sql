/*
 Navicat Premium Data Transfer

 Source Server         : 测试数据库
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 47.114.40.129:3340
 Source Schema         : sparkzxl_tenant

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 24/07/2021 14:00:08
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`
(
    `id`             bigint NOT NULL COMMENT '主键ID',
    `tenant_user_id` bigint                                                        DEFAULT NULL COMMENT '领域用户id',
    `code`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '领域编码',
    `name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '领域名称',
    `logo`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT 'logo地址',
    `describe_`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '描述',
    `status`         bit(1)                                                        DEFAULT b'0' COMMENT '状态',
    `readonly`       bit(1) NOT NULL                                               DEFAULT b'0' COMMENT '内置领域池',
    `create_time`    datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `create_user`    bigint                                                        DEFAULT NULL COMMENT '创建人',
    `update_time`    datetime                                                      DEFAULT NULL COMMENT '修改时间',
    `update_user`    bigint                                                        DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='领域池';

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
BEGIN;
INSERT INTO `tenant_info`
VALUES (1362609400699944961, 1373086745500057600, 'hz', 'sparkzxl',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', '生活不止眼前的苟且，还有诗和远方', b'1', b'1',
        '2021-02-19 11:46:12', 1248084109452902400, '2021-03-20 16:45:48', 1373086745500057600);
COMMIT;

-- ----------------------------
-- Table structure for tenant_manager
-- ----------------------------
DROP TABLE IF EXISTS `tenant_manager`;
CREATE TABLE `tenant_manager`
(
    `id`              bigint                                                       NOT NULL COMMENT '主键',
    `account`         varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
    `password`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
    `name`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
    `email`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '邮箱',
    `mobile`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '手机',
    `avatar`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '头像',
    `status`          bit(1)                                                                DEFAULT b'0' COMMENT '状态 \n1启用 0禁用',
    `last_login_time` datetime                                                              DEFAULT NULL COMMENT '最后登录时间',
    `create_user`     bigint                                                                DEFAULT '0' COMMENT '创建人id',
    `create_time`     datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `update_user`     bigint                                                                DEFAULT '0' COMMENT '更新人id',
    `update_time`     datetime                                                              DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='领域管理员';

-- ----------------------------
-- Records of tenant_manager
-- ----------------------------
BEGIN;
INSERT INTO `tenant_manager`
VALUES (1373086745500057600, 'admin', '$2a$10$v7mPmtnDyNLtXScdWa366uBEcIrtcSgHMqBYszQhMHefwWZIHA1O.', '管理员',
        'admin@163.com', '18817280664', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', b'1',
        '2021-03-20 09:41:12', 0, '2021-03-19 21:50:54', 0, '2021-03-19 21:50:56');
COMMIT;

SET
FOREIGN_KEY_CHECKS = 1;
