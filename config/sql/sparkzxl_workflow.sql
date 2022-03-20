/*
 Navicat Premium Data Transfer

 Source Server         : 测试数据库
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 47.114.40.129:3340
 Source Schema         : sparkzxl_workflow

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 24/07/2021 14:01:30
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ext_bus_datasource
-- ----------------------------
DROP TABLE IF EXISTS `ext_bus_datasource`;
CREATE TABLE `ext_bus_datasource`
(
    `id`                bigint NOT NULL COMMENT '主键',
    `name`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据源名称',
    `jdbc_url`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据源连接地址',
    `username`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '用户名',
    `password`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '密码',
    `driver_class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库驱动包',
    `create_time`       datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`       datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='业务数据源';

-- ----------------------------
-- Table structure for ext_bus_table
-- ----------------------------
DROP TABLE IF EXISTS `ext_bus_table`;
CREATE TABLE `ext_bus_table`
(
    `id`             bigint                                                        NOT NULL COMMENT '主键',
    `data_source_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据源',
    `describe_`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '描述',
    `alias`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '别名',
    `table_name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据库表名',
    `auto_generate`  bit(1)                                                        DEFAULT NULL COMMENT '自动生成表结构',
    `create_time`    datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='业务表结构';

-- ----------------------------
-- Table structure for ext_bus_table_column
-- ----------------------------
DROP TABLE IF EXISTS `ext_bus_table_column`;
CREATE TABLE `ext_bus_table_column`
(
    `id`            bigint NOT NULL COMMENT '主键',
    `table_id`      bigint NOT NULL COMMENT '表结构id',
    `name`          varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '属性名',
    `field`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库字段名',
    `field_type`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
    `primary_key`   bit(1)                                                        DEFAULT NULL COMMENT '是否是主键',
    `field_length`  int                                                           DEFAULT NULL COMMENT '字段长度',
    `required`      bit(1)                                                        DEFAULT NULL COMMENT '是否必填',
    `default_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '默认值',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='业务表字段';

-- ----------------------------
-- Table structure for ext_hi_task_status
-- ----------------------------
DROP TABLE IF EXISTS `ext_hi_task_status`;
CREATE TABLE `ext_hi_task_status`
(
    `id`                  bigint                                                        NOT NULL COMMENT '主键',
    `process_instance_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '流程实例id',
    `task_id`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务id',
    `task_def_key`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务定义key',
    `task_status`         int                                                           NOT NULL COMMENT '任务状态名称',
    `task_status_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
    `create_time`         datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`         datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='历史任务处理状态';

-- ----------------------------
-- Table structure for ext_process_task_detail
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_task_detail`;
CREATE TABLE `ext_process_task_detail`
(
    `id`                     bigint                                                        NOT NULL COMMENT '主键',
    `model_id`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '模型id',
    `process_definition_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程定义key',
    `process_name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '流程名称',
    `task_def_key`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务定义key',
    `task_name`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务名称',
    `type`                   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
    `create_time`            datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`            datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY                      `idx_model_id` (`model_id`),
    KEY                      `idx_process_id_name` (`process_definition_key`,`process_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='流程详情';

-- ----------------------------
-- Table structure for ext_process_form
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_form`;
CREATE TABLE `ext_process_form`
(
    `id`          bigint   NOT NULL COMMENT '主键',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模板名称',
    `form_type`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表单类型',
    `form_json`   text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '模板json',
    `status`      bit(1)   NOT NULL COMMENT '0:草稿，1:上架',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='流程表单';

-- ----------------------------
-- Table structure for ext_process_role
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_role`;
CREATE TABLE `ext_process_role`
(
    `id`          bigint   NOT NULL COMMENT '主键',
    `code`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '角色code',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
    `describe_`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '描述',
    `status`      bit(1)                                                        DEFAULT b'1' COMMENT '状态 \n1启用 0禁用',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ext_process_status
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_status`;
CREATE TABLE `ext_process_status`
(
    `id`                  bigint                                                        NOT NULL COMMENT 'id',
    `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '流程实例id',
    `process_name`        varchar(255) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '业务流程名称',
    `business_id`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务主键',
    `status`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '流程状态',
    `create_time`         datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`         datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_process_instance_id` (`process_instance_id`),
    KEY                   `idx_model_id` (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='流程状态记录';

-- ----------------------------
-- Table structure for ext_process_task_rule
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_task_rule`;
CREATE TABLE `ext_process_task_rule`
(
    `id`                bigint                                                        NOT NULL COMMENT '主键id',
    `process_detail_id` bigint                                                        NOT NULL COMMENT '流程详细节点id',
    `task_def_key`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '目标任务定义key',
    `task_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务名称',
    `act_type`          int                                                           NOT NULL COMMENT '流程类型',
    `create_time`       datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`       datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_process_task_key` (`process_detail_id`,`task_def_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='流程跳转规则';

-- ----------------------------
-- Table structure for ext_process_user
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_user`;
CREATE TABLE `ext_process_user`
(
    `id`          bigint                                                       NOT NULL COMMENT '主键',
    `account`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '用户姓名',
    `status`      bit(1)                                                       NOT NULL DEFAULT b'1' COMMENT '状态 \n1启用 0禁用',
    `create_time` datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                              DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ext_process_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ext_process_user_role`;
CREATE TABLE `ext_process_user_role`
(
    `id`      bigint NOT NULL COMMENT '主键',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

SET
FOREIGN_KEY_CHECKS = 1;
