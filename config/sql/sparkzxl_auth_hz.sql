/*
 Navicat Premium Data Transfer

 Source Server         : 测试数据库
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 47.114.40.129:3340
 Source Schema         : sparkzxl_auth_hz

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 24/07/2021 14:00:18
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysArea
-- ----------------------------
DROP TABLE IF EXISTS `sysArea`;
CREATE TABLE `sysArea`
(
    `id`          bigint                                                        NOT NULL COMMENT 'id',
    `code`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '编码',
    `label`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `sort_number`  int                                                                    DEFAULT '1' COMMENT '排序',
    `level`       varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '行政区级\n\n',
    `parent_id`   bigint                                                                 DEFAULT '0' COMMENT '父ID',
    `create_time` datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `create_user` bigint                                                                 DEFAULT '0' COMMENT '创建人',
    `update_time` datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `update_user` bigint                                                                 DEFAULT '0' COMMENT '更新人',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL COMMENT '租户code',
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `IDX_PARENT_ID` (`parent_id`,`label`) USING BTREE,
    KEY           `UN_CODE` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='地区表';

-- ----------------------------
-- Records of sysArea
-- ----------------------------
BEGIN;
INSERT INTO `sysArea`
VALUES (11, '', '北京市', 0, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-02-20 21:21:38', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (12, '', '天津市', 1, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (13, '', '河北省', 2, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (14, '', '山西省', 3, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (15, '', '内蒙古自治区', 4, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (21, '', '辽宁省', 5, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (22, '', '吉林省', 6, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (23, '', '黑龙江省', 7, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (31, '', '上海市', 8, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (32, '', '江苏省', 9, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (33, '', '浙江省', 10, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (34, '', '安徽省', 11, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (35, '', '福建省', 12, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (36, '', '江西省', 13, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (37, '', '山东省', 14, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (41, '', '河南省', 15, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (42, '', '湖北省', 16, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (43, '', '湖南省', 17, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (44, '', '广东省', 18, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (45, '', '广西壮族自治区', 19, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (46, '', '海南省', 20, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (50, '', '重庆市', 21, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (51, '', '四川省', 22, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (52, '', '贵州省', 23, 'PROVINCE', 0, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (53, '', '云南省', 24, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (54, '', '西藏自治区', 25, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (61, '', '陕西省', 26, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (62, '', '甘肃省', 27, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (63, '', '青海省', 28, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (64, '', '宁夏回族自治区', 29, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (65, '', '新疆维吾尔自治区', 30, 'PROVINCE', 0, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1101, '', '市辖区', 0, 'CITY', 11, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1201, '', '市辖区', 1, 'CITY', 12, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1301, '', '石家庄市', 2, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1302, '', '唐山市', 3, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1303, '', '秦皇岛市', 4, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1304, '', '邯郸市', 5, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1305, '', '邢台市', 6, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1306, '', '保定市', 7, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1307, '', '张家口市', 8, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1308, '', '承德市', 9, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1309, '', '沧州市', 10, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1310, '', '廊坊市', 11, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1311, '', '衡水市', 12, 'CITY', 13, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1401, '', '太原市', 13, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1402, '', '大同市', 14, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1403, '', '阳泉市', 15, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1404, '', '长治市', 16, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1405, '', '晋城市', 17, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1406, '', '朔州市', 18, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1407, '', '晋中市', 19, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1408, '', '运城市', 20, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1409, '', '忻州市', 21, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1410, '', '临汾市', 22, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1411, '', '吕梁市', 23, 'CITY', 14, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1501, '', '呼和浩特市', 24, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1502, '', '包头市', 25, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1503, '', '乌海市', 26, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1504, '', '赤峰市', 27, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1505, '', '通辽市', 28, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1506, '', '鄂尔多斯市', 29, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1507, '', '呼伦贝尔市', 30, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1508, '', '巴彦淖尔市', 31, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1509, '', '乌兰察布市', 32, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1522, '', '兴安盟', 33, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1525, '', '锡林郭勒盟', 34, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (1529, '', '阿拉善盟', 35, 'CITY', 15, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2101, '', '沈阳市', 36, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2102, '', '大连市', 37, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2103, '', '鞍山市', 38, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2104, '', '抚顺市', 39, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2105, '', '本溪市', 40, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2106, '', '丹东市', 41, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2107, '', '锦州市', 42, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2108, '', '营口市', 43, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2109, '', '阜新市', 44, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2110, '', '辽阳市', 45, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2111, '', '盘锦市', 46, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2112, '', '铁岭市', 47, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2113, '', '朝阳市', 48, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2114, '', '葫芦岛市', 49, 'CITY', 21, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2201, '', '长春市', 50, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2202, '', '吉林市', 51, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2203, '', '四平市', 52, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2204, '', '辽源市', 53, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2205, '', '通化市', 54, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2206, '', '白山市', 55, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2207, '', '松原市', 56, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2208, '', '白城市', 57, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2224, '', '延边朝鲜族自治州', 58, 'CITY', 22, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2301, '', '哈尔滨市', 59, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2302, '', '齐齐哈尔市', 60, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2303, '', '鸡西市', 61, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2304, '', '鹤岗市', 62, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2305, '', '双鸭山市', 63, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2306, '', '大庆市', 64, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2307, '', '伊春市', 65, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2308, '', '佳木斯市', 66, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2309, '', '七台河市', 67, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2310, '', '牡丹江市', 68, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2311, '', '黑河市', 69, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2312, '', '绥化市', 70, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (2327, '', '大兴安岭地区', 71, 'CITY', 23, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3101, '', '市辖区', 72, 'CITY', 31, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3201, '', '南京市', 73, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3202, '', '无锡市', 74, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3203, '', '徐州市', 75, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3204, '', '常州市', 76, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3205, '', '苏州市', 77, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3206, '', '南通市', 78, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3207, '', '连云港市', 79, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3208, '', '淮安市', 80, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3209, '', '盐城市', 81, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3210, '', '扬州市', 82, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3211, '', '镇江市', 83, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3212, '', '泰州市', 84, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3213, '', '宿迁市', 85, 'CITY', 32, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3301, '', '杭州市', 86, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3302, '', '宁波市', 87, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3303, '', '温州市', 88, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3304, '', '嘉兴市', 89, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3305, '', '湖州市', 90, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3306, '', '绍兴市', 91, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3307, '', '金华市', 92, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3308, '', '衢州市', 93, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3309, '', '舟山市', 94, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3310, '', '台州市', 95, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3311, '', '丽水市', 96, 'CITY', 33, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3401, '', '合肥市', 97, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3402, '', '芜湖市', 98, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3403, '', '蚌埠市', 99, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3404, '', '淮南市', 100, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3405, '', '马鞍山市', 101, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3406, '', '淮北市', 102, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3407, '', '铜陵市', 103, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3408, '', '安庆市', 104, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3410, '', '黄山市', 105, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3411, '', '滁州市', 106, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3412, '', '阜阳市', 107, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3413, '', '宿州市', 108, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3415, '', '六安市', 109, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3416, '', '亳州市', 110, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3417, '', '池州市', 111, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3418, '', '宣城市', 112, 'CITY', 34, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3501, '', '福州市', 113, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3502, '', '厦门市', 114, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3503, '', '莆田市', 115, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3504, '', '三明市', 116, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3505, '', '泉州市', 117, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3506, '', '漳州市', 118, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3507, '', '南平市', 119, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3508, '', '龙岩市', 120, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3509, '', '宁德市', 121, 'CITY', 35, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3601, '', '南昌市', 122, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3602, '', '景德镇市', 123, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3603, '', '萍乡市', 124, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3604, '', '九江市', 125, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3605, '', '新余市', 126, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3606, '', '鹰潭市', 127, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3607, '', '赣州市', 128, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3608, '', '吉安市', 129, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3609, '', '宜春市', 130, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3610, '', '抚州市', 131, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3611, '', '上饶市', 132, 'CITY', 36, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3701, '', '济南市', 133, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3702, '', '青岛市', 134, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3703, '', '淄博市', 135, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3704, '', '枣庄市', 136, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3705, '', '东营市', 137, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3706, '', '烟台市', 138, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3707, '', '潍坊市', 139, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3708, '', '济宁市', 140, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3709, '', '泰安市', 141, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3710, '', '威海市', 142, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3711, '', '日照市', 143, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3713, '', '临沂市', 144, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3714, '', '德州市', 145, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3715, '', '聊城市', 146, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3716, '', '滨州市', 147, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (3717, '', '菏泽市', 148, 'CITY', 37, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4101, '', '郑州市', 149, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4102, '', '开封市', 150, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4103, '', '洛阳市', 151, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4104, '', '平顶山市', 152, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4105, '', '安阳市', 153, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4106, '', '鹤壁市', 154, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4107, '', '新乡市', 155, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4108, '', '焦作市', 156, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4109, '', '濮阳市', 157, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4110, '', '许昌市', 158, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4111, '', '漯河市', 159, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4112, '', '三门峡市', 160, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4113, '', '南阳市', 161, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4114, '', '商丘市', 162, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4115, '', '信阳市', 163, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4116, '', '周口市', 164, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4117, '', '驻马店市', 165, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4190, '', '省直辖县级行政区划', 166, 'CITY', 41, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4201, '', '武汉市', 167, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4202, '', '黄石市', 168, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4203, '', '十堰市', 169, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4205, '', '宜昌市', 170, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4206, '', '襄阳市', 171, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4207, '', '鄂州市', 172, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4208, '', '荆门市', 173, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4209, '', '孝感市', 174, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4210, '', '荆州市', 175, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4211, '', '黄冈市', 176, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4212, '', '咸宁市', 177, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4213, '', '随州市', 178, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4228, '', '恩施土家族苗族自治州', 179, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4290, '', '省直辖县级行政区划', 180, 'CITY', 42, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4301, '', '长沙市', 181, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4302, '', '株洲市', 182, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4303, '', '湘潭市', 183, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4304, '', '衡阳市', 184, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4305, '', '邵阳市', 185, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4306, '', '岳阳市', 186, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4307, '', '常德市', 187, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4308, '', '张家界市', 188, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4309, '', '益阳市', 189, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4310, '', '郴州市', 190, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4311, '', '永州市', 191, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4312, '', '怀化市', 192, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4313, '', '娄底市', 193, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4331, '', '湘西土家族苗族自治州', 194, 'CITY', 43, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4401, '', '广州市', 195, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4402, '', '韶关市', 196, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4403, '', '深圳市', 197, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4404, '', '珠海市', 198, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4405, '', '汕头市', 199, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4406, '', '佛山市', 200, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4407, '', '江门市', 201, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4408, '', '湛江市', 202, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4409, '', '茂名市', 203, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4412, '', '肇庆市', 204, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4413, '', '惠州市', 205, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4414, '', '梅州市', 206, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4415, '', '汕尾市', 207, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4416, '', '河源市', 208, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4417, '', '阳江市', 209, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4418, '', '清远市', 210, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4419, '', '东莞市', 211, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4420, '', '中山市', 212, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4451, '', '潮州市', 213, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4452, '', '揭阳市', 214, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4453, '', '云浮市', 215, 'CITY', 44, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4501, '', '南宁市', 216, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4502, '', '柳州市', 217, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4503, '', '桂林市', 218, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4504, '', '梧州市', 219, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4505, '', '北海市', 220, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4506, '', '防城港市', 221, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4507, '', '钦州市', 222, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4508, '', '贵港市', 223, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4509, '', '玉林市', 224, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4510, '', '百色市', 225, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4511, '', '贺州市', 226, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4512, '', '河池市', 227, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4513, '', '来宾市', 228, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4514, '', '崇左市', 229, 'CITY', 45, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4601, '', '海口市', 230, 'CITY', 46, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4602, '', '三亚市', 231, 'CITY', 46, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4603, '', '三沙市', 232, 'CITY', 46, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4604, '', '儋州市', 233, 'CITY', 46, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (4690, '', '省直辖县级行政区划', 234, 'CITY', 46, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5001, '', '市辖区', 235, 'CITY', 50, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5002, '', '县', 236, 'CITY', 50, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5101, '', '成都市', 237, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5103, '', '自贡市', 238, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5104, '', '攀枝花市', 239, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5105, '', '泸州市', 240, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5106, '', '德阳市', 241, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5107, '', '绵阳市', 242, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5108, '', '广元市', 243, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5109, '', '遂宁市', 244, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5110, '', '内江市', 245, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5111, '', '乐山市', 246, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5113, '', '南充市', 247, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5114, '', '眉山市', 248, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5115, '', '宜宾市', 249, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5116, '', '广安市', 250, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5117, '', '达州市', 251, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5118, '', '雅安市', 252, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5119, '', '巴中市', 253, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5120, '', '资阳市', 254, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5132, '', '阿坝藏族羌族自治州', 255, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5133, '', '甘孜藏族自治州', 256, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5134, '', '凉山彝族自治州', 257, 'CITY', 51, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5201, '', '贵阳市', 258, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5202, '', '六盘水市', 259, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5203, '', '遵义市', 260, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5204, '', '安顺市', 261, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5205, '', '毕节市', 262, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5206, '', '铜仁市', 263, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5223, '', '黔西南布依族苗族自治州', 264, 'CITY', 52, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5226, '', '黔东南苗族侗族自治州', 265, 'CITY', 52, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5227, '', '黔南布依族苗族自治州', 266, 'CITY', 52, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5301, '', '昆明市', 267, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5303, '', '曲靖市', 268, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5304, '', '玉溪市', 269, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5305, '', '保山市', 270, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5306, '', '昭通市', 271, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5307, '', '丽江市', 272, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5308, '', '普洱市', 273, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5309, '', '临沧市', 274, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5323, '', '楚雄彝族自治州', 275, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5325, '', '红河哈尼族彝族自治州', 276, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5326, '', '文山壮族苗族自治州', 277, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5328, '', '西双版纳傣族自治州', 278, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5329, '', '大理白族自治州', 279, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5331, '', '德宏傣族景颇族自治州', 280, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5333, '', '怒江傈僳族自治州', 281, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5334, '', '迪庆藏族自治州', 282, 'CITY', 53, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5401, '', '拉萨市', 283, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5402, '', '日喀则市', 284, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5403, '', '昌都市', 285, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5404, '', '林芝市', 286, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5405, '', '山南市', 287, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5406, '', '那曲市', 288, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (5425, '', '阿里地区', 289, 'CITY', 54, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6101, '', '西安市', 290, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6102, '', '铜川市', 291, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6103, '', '宝鸡市', 292, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6104, '', '咸阳市', 293, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6105, '', '渭南市', 294, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6106, '', '延安市', 295, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6107, '', '汉中市', 296, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6108, '', '榆林市', 297, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6109, '', '安康市', 298, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6110, '', '商洛市', 299, 'CITY', 61, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6201, '', '兰州市', 300, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6202, '', '嘉峪关市', 301, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6203, '', '金昌市', 302, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6204, '', '白银市', 303, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6205, '', '天水市', 304, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6206, '', '武威市', 305, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6207, '', '张掖市', 306, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6208, '', '平凉市', 307, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6209, '', '酒泉市', 308, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6210, '', '庆阳市', 309, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6211, '', '定西市', 310, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6212, '', '陇南市', 311, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6229, '', '临夏回族自治州', 312, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6230, '', '甘南藏族自治州', 313, 'CITY', 62, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6301, '', '西宁市', 314, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6302, '', '海东市', 315, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6322, '', '海北藏族自治州', 316, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6323, '', '黄南藏族自治州', 317, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6325, '', '海南藏族自治州', 318, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6326, '', '果洛藏族自治州', 319, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6327, '', '玉树藏族自治州', 320, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6328, '', '海西蒙古族藏族自治州', 321, 'CITY', 63, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6401, '', '银川市', 322, 'CITY', 64, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6402, '', '石嘴山市', 323, 'CITY', 64, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6403, '', '吴忠市', 324, 'CITY', 64, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6404, '', '固原市', 325, 'CITY', 64, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6405, '', '中卫市', 326, 'CITY', 64, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6501, '', '乌鲁木齐市', 327, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6502, '', '克拉玛依市', 328, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6504, '', '吐鲁番市', 329, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6505, '', '哈密市', 330, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6523, '', '昌吉回族自治州', 331, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6527, '', '博尔塔拉蒙古自治州', 332, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6528, '', '巴音郭楞蒙古自治州', 333, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6529, '', '阿克苏地区', 334, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6530, '', '克孜勒苏柯尔克孜自治州', 335, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6531, '', '喀什地区', 336, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6532, '', '和田地区', 337, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6540, '', '伊犁哈萨克自治州', 338, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6542, '', '塔城地区', 339, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6543, '', '阿勒泰地区', 340, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (6590, '', '自治区直辖县级行政区划', 341, 'CITY', 65, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110101, '', '东城区', 0, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110102, '', '西城区', 1, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110105, '', '朝阳区', 2, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110106, '', '丰台区', 3, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110107, '', '石景山区', 4, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110108, '', '海淀区', 5, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110109, '', '门头沟区', 6, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110111, '', '房山区', 7, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110112, '', '通州区', 8, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110113, '', '顺义区', 9, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110114, '', '昌平区', 10, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110115, '', '大兴区', 11, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110116, '', '怀柔区', 12, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110117, '', '平谷区', 13, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110118, '', '密云区', 14, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (110119, '', '延庆区', 15, 'COUNTY', 1101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120101, '', '和平区', 16, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120102, '', '河东区', 17, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120103, '', '河西区', 18, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120104, '', '南开区', 19, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120105, '', '河北区', 20, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120106, '', '红桥区', 21, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120110, '', '东丽区', 22, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120111, '', '西青区', 23, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120112, '', '津南区', 24, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120113, '', '北辰区', 25, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120114, '', '武清区', 26, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120115, '', '宝坻区', 27, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120116, '', '滨海新区', 28, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120117, '', '宁河区', 29, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120118, '', '静海区', 30, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (120119, '', '蓟州区', 31, 'COUNTY', 1201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130102, '', '长安区', 32, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130104, '', '桥西区', 33, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130105, '', '新华区', 34, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130107, '', '井陉矿区', 35, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130108, '', '裕华区', 36, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130109, '', '藁城区', 37, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130110, '', '鹿泉区', 38, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130111, '', '栾城区', 39, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130121, '', '井陉县', 40, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130123, '', '正定县', 41, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130125, '', '行唐县', 42, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130126, '', '灵寿县', 43, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130127, '', '高邑县', 44, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130128, '', '深泽县', 45, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130129, '', '赞皇县', 46, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130130, '', '无极县', 47, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130131, '', '平山县', 48, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130132, '', '元氏县', 49, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130133, '', '赵县', 50, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130171, '', '石家庄高新技术产业开发区', 51, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130172, '', '石家庄循环化工园区', 52, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130181, '', '辛集市', 53, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130183, '', '晋州市', 54, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130184, '', '新乐市', 55, 'COUNTY', 1301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130202, '', '路南区', 56, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130203, '', '路北区', 57, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130204, '', '古冶区', 58, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130205, '', '开平区', 59, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130207, '', '丰南区', 60, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130208, '', '丰润区', 61, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130209, '', '曹妃甸区', 62, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130224, '', '滦南县', 63, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130225, '', '乐亭县', 64, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130227, '', '迁西县', 65, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130229, '', '玉田县', 66, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130271, '', '河北唐山芦台经济开发区', 67, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130272, '', '唐山市汉沽管理区', 68, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130273, '', '唐山高新技术产业开发区', 69, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130274, '', '河北唐山海港经济开发区', 70, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130281, '', '遵化市', 71, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130283, '', '迁安市', 72, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130284, '', '滦州市', 73, 'COUNTY', 1302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130302, '', '海港区', 74, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130303, '', '山海关区', 75, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130304, '', '北戴河区', 76, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130306, '', '抚宁区', 77, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130321, '', '青龙满族自治县', 78, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130322, '', '昌黎县', 79, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130324, '', '卢龙县', 80, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130371, '', '秦皇岛市经济技术开发区', 81, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130372, '', '北戴河新区', 82, 'COUNTY', 1303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130402, '', '邯山区', 83, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130403, '', '丛台区', 84, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130404, '', '复兴区', 85, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130406, '', '峰峰矿区', 86, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130407, '', '肥乡区', 87, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130408, '', '永年区', 88, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130423, '', '临漳县', 89, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130424, '', '成安县', 90, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130425, '', '大名县', 91, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130426, '', '涉县', 92, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130427, '', '磁县', 93, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130430, '', '邱县', 94, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130431, '', '鸡泽县', 95, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130432, '', '广平县', 96, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130433, '', '馆陶县', 97, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130434, '', '魏县', 98, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130435, '', '曲周县', 99, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130471, '', '邯郸经济技术开发区', 100, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130473, '', '邯郸冀南新区', 101, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130481, '', '武安市', 102, 'COUNTY', 1304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130502, '', '桥东区', 103, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130503, '', '桥西区', 104, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130521, '', '邢台县', 105, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130522, '', '临城县', 106, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130523, '', '内丘县', 107, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130524, '', '柏乡县', 108, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130525, '', '隆尧县', 109, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130526, '', '任县', 110, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130527, '', '南和县', 111, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130528, '', '宁晋县', 112, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130529, '', '巨鹿县', 113, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130530, '', '新河县', 114, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130531, '', '广宗县', 115, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130532, '', '平乡县', 116, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130533, '', '威县', 117, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130534, '', '清河县', 118, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130535, '', '临西县', 119, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130571, '', '河北邢台经济开发区', 120, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130581, '', '南宫市', 121, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130582, '', '沙河市', 122, 'COUNTY', 1305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130602, '', '竞秀区', 123, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130606, '', '莲池区', 124, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130607, '', '满城区', 125, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130608, '', '清苑区', 126, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130609, '', '徐水区', 127, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130623, '', '涞水县', 128, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130624, '', '阜平县', 129, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130626, '', '定兴县', 130, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130627, '', '唐县', 131, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130628, '', '高阳县', 132, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130629, '', '容城县', 133, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130630, '', '涞源县', 134, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130631, '', '望都县', 135, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130632, '', '安新县', 136, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130633, '', '易县', 137, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130634, '', '曲阳县', 138, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130635, '', '蠡县', 139, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130636, '', '顺平县', 140, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130637, '', '博野县', 141, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130638, '', '雄县', 142, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130671, '', '保定高新技术产业开发区', 143, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130672, '', '保定白沟新城', 144, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130681, '', '涿州市', 145, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130682, '', '定州市', 146, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130683, '', '安国市', 147, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130684, '', '高碑店市', 148, 'COUNTY', 1306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130702, '', '桥东区', 149, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130703, '', '桥西区', 150, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130705, '', '宣化区', 151, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130706, '', '下花园区', 152, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130708, '', '万全区', 153, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130709, '', '崇礼区', 154, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130722, '', '张北县', 155, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130723, '', '康保县', 156, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130724, '', '沽源县', 157, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130725, '', '尚义县', 158, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130726, '', '蔚县', 159, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130727, '', '阳原县', 160, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130728, '', '怀安县', 161, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130730, '', '怀来县', 162, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130731, '', '涿鹿县', 163, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130732, '', '赤城县', 164, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130771, '', '张家口经济开发区', 165, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130772, '', '张家口市察北管理区', 166, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130773, '', '张家口市塞北管理区', 167, 'COUNTY', 1307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130802, '', '双桥区', 168, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130803, '', '双滦区', 169, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130804, '', '鹰手营子矿区', 170, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130821, '', '承德县', 171, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130822, '', '兴隆县', 172, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130824, '', '滦平县', 173, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130825, '', '隆化县', 174, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130826, '', '丰宁满族自治县', 175, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130827, '', '宽城满族自治县', 176, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130828, '', '围场满族蒙古族自治县', 177, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130871, '', '承德高新技术产业开发区', 178, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130881, '', '平泉市', 179, 'COUNTY', 1308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130902, '', '新华区', 180, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130903, '', '运河区', 181, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130921, '', '沧县', 182, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130922, '', '青县', 183, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130923, '', '东光县', 184, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130924, '', '海兴县', 185, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130925, '', '盐山县', 186, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130926, '', '肃宁县', 187, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130927, '', '南皮县', 188, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130928, '', '吴桥县', 189, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130929, '', '献县', 190, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130930, '', '孟村回族自治县', 191, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130971, '', '河北沧州经济开发区', 192, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130972, '', '沧州高新技术产业开发区', 193, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130973, '', '沧州渤海新区', 194, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130981, '', '泊头市', 195, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130982, '', '任丘市', 196, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130983, '', '黄骅市', 197, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (130984, '', '河间市', 198, 'COUNTY', 1309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131002, '', '安次区', 199, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131003, '', '广阳区', 200, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131022, '', '固安县', 201, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131023, '', '永清县', 202, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131024, '', '香河县', 203, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131025, '', '大城县', 204, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131026, '', '文安县', 205, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131028, '', '大厂回族自治县', 206, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131071, '', '廊坊经济技术开发区', 207, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131081, '', '霸州市', 208, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131082, '', '三河市', 209, 'COUNTY', 1310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131102, '', '桃城区', 210, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131103, '', '冀州区', 211, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131121, '', '枣强县', 212, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131122, '', '武邑县', 213, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131123, '', '武强县', 214, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131124, '', '饶阳县', 215, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131125, '', '安平县', 216, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131126, '', '故城县', 217, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131127, '', '景县', 218, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131128, '', '阜城县', 219, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131171, '', '河北衡水高新技术产业开发区', 220, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131172, '', '衡水滨湖新区', 221, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (131182, '', '深州市', 222, 'COUNTY', 1311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140105, '', '小店区', 223, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140106, '', '迎泽区', 224, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140107, '', '杏花岭区', 225, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140108, '', '尖草坪区', 226, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140109, '', '万柏林区', 227, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140110, '', '晋源区', 228, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140121, '', '清徐县', 229, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140122, '', '阳曲县', 230, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140123, '', '娄烦县', 231, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140171, '', '山西转型综合改革示范区', 232, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140181, '', '古交市', 233, 'COUNTY', 1401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140212, '', '新荣区', 234, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140213, '', '平城区', 235, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140214, '', '云冈区', 236, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140215, '', '云州区', 237, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140221, '', '阳高县', 238, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140222, '', '天镇县', 239, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140223, '', '广灵县', 240, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140224, '', '灵丘县', 241, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140225, '', '浑源县', 242, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140226, '', '左云县', 243, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140271, '', '山西大同经济开发区', 244, 'COUNTY', 1402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140302, '', '城区', 245, 'COUNTY', 1403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140303, '', '矿区', 246, 'COUNTY', 1403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140311, '', '郊区', 247, 'COUNTY', 1403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140321, '', '平定县', 248, 'COUNTY', 1403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140322, '', '盂县', 249, 'COUNTY', 1403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140403, '', '潞州区', 250, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140404, '', '上党区', 251, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140405, '', '屯留区', 252, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140406, '', '潞城区', 253, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140423, '', '襄垣县', 254, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140425, '', '平顺县', 255, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140426, '', '黎城县', 256, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140427, '', '壶关县', 257, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140428, '', '长子县', 258, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140429, '', '武乡县', 259, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140430, '', '沁县', 260, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140431, '', '沁源县', 261, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140471, '', '山西长治高新技术产业园区', 262, 'COUNTY', 1404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140502, '', '城区', 263, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140521, '', '沁水县', 264, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140522, '', '阳城县', 265, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140524, '', '陵川县', 266, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140525, '', '泽州县', 267, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140581, '', '高平市', 268, 'COUNTY', 1405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140602, '', '朔城区', 269, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140603, '', '平鲁区', 270, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140621, '', '山阴县', 271, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140622, '', '应县', 272, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140623, '', '右玉县', 273, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140671, '', '山西朔州经济开发区', 274, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140681, '', '怀仁市', 275, 'COUNTY', 1406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140702, '', '榆次区', 276, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140721, '', '榆社县', 277, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140722, '', '左权县', 278, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140723, '', '和顺县', 279, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140724, '', '昔阳县', 280, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140725, '', '寿阳县', 281, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140726, '', '太谷县', 282, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140727, '', '祁县', 283, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140728, '', '平遥县', 284, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140729, '', '灵石县', 285, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140781, '', '介休市', 286, 'COUNTY', 1407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140802, '', '盐湖区', 287, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140821, '', '临猗县', 288, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140822, '', '万荣县', 289, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140823, '', '闻喜县', 290, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140824, '', '稷山县', 291, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140825, '', '新绛县', 292, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140826, '', '绛县', 293, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140827, '', '垣曲县', 294, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140828, '', '夏县', 295, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140829, '', '平陆县', 296, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140830, '', '芮城县', 297, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140881, '', '永济市', 298, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140882, '', '河津市', 299, 'COUNTY', 1408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140902, '', '忻府区', 300, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140921, '', '定襄县', 301, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140922, '', '五台县', 302, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140923, '', '代县', 303, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140924, '', '繁峙县', 304, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140925, '', '宁武县', 305, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140926, '', '静乐县', 306, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140927, '', '神池县', 307, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140928, '', '五寨县', 308, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140929, '', '岢岚县', 309, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140930, '', '河曲县', 310, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140931, '', '保德县', 311, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140932, '', '偏关县', 312, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140971, '', '五台山风景名胜区', 313, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (140981, '', '原平市', 314, 'COUNTY', 1409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141002, '', '尧都区', 315, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141021, '', '曲沃县', 316, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141022, '', '翼城县', 317, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141023, '', '襄汾县', 318, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141024, '', '洪洞县', 319, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141025, '', '古县', 320, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141026, '', '安泽县', 321, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141027, '', '浮山县', 322, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141028, '', '吉县', 323, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141029, '', '乡宁县', 324, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141030, '', '大宁县', 325, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141031, '', '隰县', 326, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141032, '', '永和县', 327, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141033, '', '蒲县', 328, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141034, '', '汾西县', 329, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141081, '', '侯马市', 330, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141082, '', '霍州市', 331, 'COUNTY', 1410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141102, '', '离石区', 332, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141121, '', '文水县', 333, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141122, '', '交城县', 334, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141123, '', '兴县', 335, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141124, '', '临县', 336, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141125, '', '柳林县', 337, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141126, '', '石楼县', 338, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141127, '', '岚县', 339, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141128, '', '方山县', 340, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141129, '', '中阳县', 341, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141130, '', '交口县', 342, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141181, '', '孝义市', 343, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (141182, '', '汾阳市', 344, 'COUNTY', 1411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150102, '', '新城区', 345, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150103, '', '回民区', 346, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150104, '', '玉泉区', 347, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150105, '', '赛罕区', 348, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150121, '', '土默特左旗', 349, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150122, '', '托克托县', 350, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150123, '', '和林格尔县', 351, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150124, '', '清水河县', 352, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150125, '', '武川县', 353, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150171, '', '呼和浩特金海工业园区', 354, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150172, '', '呼和浩特经济技术开发区', 355, 'COUNTY', 1501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150202, '', '东河区', 356, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150203, '', '昆都仑区', 357, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150204, '', '青山区', 358, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150205, '', '石拐区', 359, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150206, '', '白云鄂博矿区', 360, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150207, '', '九原区', 361, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150221, '', '土默特右旗', 362, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150222, '', '固阳县', 363, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150223, '', '达尔罕茂明安联合旗', 364, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150271, '', '包头稀土高新技术产业开发区', 365, 'COUNTY', 1502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150302, '', '海勃湾区', 366, 'COUNTY', 1503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150303, '', '海南区', 367, 'COUNTY', 1503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150304, '', '乌达区', 368, 'COUNTY', 1503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150402, '', '红山区', 369, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150403, '', '元宝山区', 370, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150404, '', '松山区', 371, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150421, '', '阿鲁科尔沁旗', 372, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150422, '', '巴林左旗', 373, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150423, '', '巴林右旗', 374, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150424, '', '林西县', 375, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150425, '', '克什克腾旗', 376, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150426, '', '翁牛特旗', 377, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150428, '', '喀喇沁旗', 378, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150429, '', '宁城县', 379, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150430, '', '敖汉旗', 380, 'COUNTY', 1504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150502, '', '科尔沁区', 381, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150521, '', '科尔沁左翼中旗', 382, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150522, '', '科尔沁左翼后旗', 383, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150523, '', '开鲁县', 384, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150524, '', '库伦旗', 385, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150525, '', '奈曼旗', 386, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150526, '', '扎鲁特旗', 387, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150571, '', '通辽经济技术开发区', 388, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150581, '', '霍林郭勒市', 389, 'COUNTY', 1505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150602, '', '东胜区', 390, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150603, '', '康巴什区', 391, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150621, '', '达拉特旗', 392, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150622, '', '准格尔旗', 393, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150623, '', '鄂托克前旗', 394, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150624, '', '鄂托克旗', 395, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150625, '', '杭锦旗', 396, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150626, '', '乌审旗', 397, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150627, '', '伊金霍洛旗', 398, 'COUNTY', 1506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150702, '', '海拉尔区', 399, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150703, '', '扎赉诺尔区', 400, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150721, '', '阿荣旗', 401, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150722, '', '莫力达瓦达斡尔族自治旗', 402, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150723, '', '鄂伦春自治旗', 403, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150724, '', '鄂温克族自治旗', 404, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150725, '', '陈巴尔虎旗', 405, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150726, '', '新巴尔虎左旗', 406, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150727, '', '新巴尔虎右旗', 407, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150781, '', '满洲里市', 408, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150782, '', '牙克石市', 409, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150783, '', '扎兰屯市', 410, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150784, '', '额尔古纳市', 411, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150785, '', '根河市', 412, 'COUNTY', 1507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150802, '', '临河区', 413, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150821, '', '五原县', 414, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150822, '', '磴口县', 415, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150823, '', '乌拉特前旗', 416, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150824, '', '乌拉特中旗', 417, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150825, '', '乌拉特后旗', 418, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150826, '', '杭锦后旗', 419, 'COUNTY', 1508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150902, '', '集宁区', 420, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150921, '', '卓资县', 421, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150922, '', '化德县', 422, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150923, '', '商都县', 423, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150924, '', '兴和县', 424, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150925, '', '凉城县', 425, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150926, '', '察哈尔右翼前旗', 426, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150927, '', '察哈尔右翼中旗', 427, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150928, '', '察哈尔右翼后旗', 428, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150929, '', '四子王旗', 429, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (150981, '', '丰镇市', 430, 'COUNTY', 1509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152201, '', '乌兰浩特市', 431, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152202, '', '阿尔山市', 432, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152221, '', '科尔沁右翼前旗', 433, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152222, '', '科尔沁右翼中旗', 434, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152223, '', '扎赉特旗', 435, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152224, '', '突泉县', 436, 'COUNTY', 1522, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152501, '', '二连浩特市', 437, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152502, '', '锡林浩特市', 438, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152522, '', '阿巴嘎旗', 439, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152523, '', '苏尼特左旗', 440, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152524, '', '苏尼特右旗', 441, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152525, '', '东乌珠穆沁旗', 442, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152526, '', '西乌珠穆沁旗', 443, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152527, '', '太仆寺旗', 444, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152528, '', '镶黄旗', 445, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152529, '', '正镶白旗', 446, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152530, '', '正蓝旗', 447, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152531, '', '多伦县', 448, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152571, '', '乌拉盖管委会', 449, 'COUNTY', 1525, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152921, '', '阿拉善左旗', 450, 'COUNTY', 1529, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152922, '', '阿拉善右旗', 451, 'COUNTY', 1529, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152923, '', '额济纳旗', 452, 'COUNTY', 1529, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (152971, '', '内蒙古阿拉善经济开发区', 453, 'COUNTY', 1529, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210102, '', '和平区', 454, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210103, '', '沈河区', 455, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210104, '', '大东区', 456, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210105, '', '皇姑区', 457, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210106, '', '铁西区', 458, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210111, '', '苏家屯区', 459, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210112, '', '浑南区', 460, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210113, '', '沈北新区', 461, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210114, '', '于洪区', 462, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210115, '', '辽中区', 463, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210123, '', '康平县', 464, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210124, '', '法库县', 465, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210181, '', '新民市', 466, 'COUNTY', 2101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210202, '', '中山区', 467, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210203, '', '西岗区', 468, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210204, '', '沙河口区', 469, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210211, '', '甘井子区', 470, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210212, '', '旅顺口区', 471, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210213, '', '金州区', 472, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210214, '', '普兰店区', 473, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210224, '', '长海县', 474, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210281, '', '瓦房店市', 475, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210283, '', '庄河市', 476, 'COUNTY', 2102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210302, '', '铁东区', 477, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210303, '', '铁西区', 478, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210304, '', '立山区', 479, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210311, '', '千山区', 480, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210321, '', '台安县', 481, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210323, '', '岫岩满族自治县', 482, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210381, '', '海城市', 483, 'COUNTY', 2103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210402, '', '新抚区', 484, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210403, '', '东洲区', 485, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210404, '', '望花区', 486, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210411, '', '顺城区', 487, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210421, '', '抚顺县', 488, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210422, '', '新宾满族自治县', 489, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210423, '', '清原满族自治县', 490, 'COUNTY', 2104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210502, '', '平山区', 491, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210503, '', '溪湖区', 492, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210504, '', '明山区', 493, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210505, '', '南芬区', 494, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210521, '', '本溪满族自治县', 495, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210522, '', '桓仁满族自治县', 496, 'COUNTY', 2105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210602, '', '元宝区', 497, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210603, '', '振兴区', 498, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210604, '', '振安区', 499, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210624, '', '宽甸满族自治县', 500, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210681, '', '东港市', 501, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210682, '', '凤城市', 502, 'COUNTY', 2106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210702, '', '古塔区', 503, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210703, '', '凌河区', 504, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210711, '', '太和区', 505, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210726, '', '黑山县', 506, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210727, '', '义县', 507, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210781, '', '凌海市', 508, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210782, '', '北镇市', 509, 'COUNTY', 2107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210802, '', '站前区', 510, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210803, '', '西市区', 511, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210804, '', '鲅鱼圈区', 512, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210811, '', '老边区', 513, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210881, '', '盖州市', 514, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210882, '', '大石桥市', 515, 'COUNTY', 2108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210902, '', '海州区', 516, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210903, '', '新邱区', 517, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210904, '', '太平区', 518, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210905, '', '清河门区', 519, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210911, '', '细河区', 520, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210921, '', '阜新蒙古族自治县', 521, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (210922, '', '彰武县', 522, 'COUNTY', 2109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211002, '', '白塔区', 523, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211003, '', '文圣区', 524, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211004, '', '宏伟区', 525, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211005, '', '弓长岭区', 526, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211011, '', '太子河区', 527, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211021, '', '辽阳县', 528, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211081, '', '灯塔市', 529, 'COUNTY', 2110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211102, '', '双台子区', 530, 'COUNTY', 2111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211103, '', '兴隆台区', 531, 'COUNTY', 2111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211104, '', '大洼区', 532, 'COUNTY', 2111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211122, '', '盘山县', 533, 'COUNTY', 2111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211202, '', '银州区', 534, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211204, '', '清河区', 535, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211221, '', '铁岭县', 536, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211223, '', '西丰县', 537, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211224, '', '昌图县', 538, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211281, '', '调兵山市', 539, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211282, '', '开原市', 540, 'COUNTY', 2112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211302, '', '双塔区', 541, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211303, '', '龙城区', 542, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211321, '', '朝阳县', 543, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211322, '', '建平县', 544, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211324, '', '喀喇沁左翼蒙古族自治县', 545, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211381, '', '北票市', 546, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211382, '', '凌源市', 547, 'COUNTY', 2113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211402, '', '连山区', 548, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211403, '', '龙港区', 549, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211404, '', '南票区', 550, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211421, '', '绥中县', 551, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211422, '', '建昌县', 552, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (211481, '', '兴城市', 553, 'COUNTY', 2114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220102, '', '南关区', 554, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220103, '', '宽城区', 555, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220104, '', '朝阳区', 556, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220105, '', '二道区', 557, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220106, '', '绿园区', 558, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220112, '', '双阳区', 559, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220113, '', '九台区', 560, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220122, '', '农安县', 561, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220171, '', '长春经济技术开发区', 562, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220172, '', '长春净月高新技术产业开发区', 563, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220173, '', '长春高新技术产业开发区', 564, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220174, '', '长春汽车经济技术开发区', 565, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220182, '', '榆树市', 566, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220183, '', '德惠市', 567, 'COUNTY', 2201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220202, '', '昌邑区', 568, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220203, '', '龙潭区', 569, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220204, '', '船营区', 570, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220211, '', '丰满区', 571, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220221, '', '永吉县', 572, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220271, '', '吉林经济开发区', 573, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220272, '', '吉林高新技术产业开发区', 574, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220273, '', '吉林中国新加坡食品区', 575, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220281, '', '蛟河市', 576, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220282, '', '桦甸市', 577, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220283, '', '舒兰市', 578, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220284, '', '磐石市', 579, 'COUNTY', 2202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220302, '', '铁西区', 580, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220303, '', '铁东区', 581, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220322, '', '梨树县', 582, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220323, '', '伊通满族自治县', 583, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220381, '', '公主岭市', 584, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220382, '', '双辽市', 585, 'COUNTY', 2203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220402, '', '龙山区', 586, 'COUNTY', 2204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220403, '', '西安区', 587, 'COUNTY', 2204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220421, '', '东丰县', 588, 'COUNTY', 2204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220422, '', '东辽县', 589, 'COUNTY', 2204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220502, '', '东昌区', 590, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220503, '', '二道江区', 591, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220521, '', '通化县', 592, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220523, '', '辉南县', 593, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220524, '', '柳河县', 594, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220581, '', '梅河口市', 595, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220582, '', '集安市', 596, 'COUNTY', 2205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220602, '', '浑江区', 597, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220605, '', '江源区', 598, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220621, '', '抚松县', 599, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220622, '', '靖宇县', 600, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220623, '', '长白朝鲜族自治县', 601, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220681, '', '临江市', 602, 'COUNTY', 2206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220702, '', '宁江区', 603, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220721, '', '前郭尔罗斯蒙古族自治县', 604, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220722, '', '长岭县', 605, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220723, '', '乾安县', 606, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220771, '', '吉林松原经济开发区', 607, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220781, '', '扶余市', 608, 'COUNTY', 2207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220802, '', '洮北区', 609, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220821, '', '镇赉县', 610, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220822, '', '通榆县', 611, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220871, '', '吉林白城经济开发区', 612, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220881, '', '洮南市', 613, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (220882, '', '大安市', 614, 'COUNTY', 2208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222401, '', '延吉市', 615, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222402, '', '图们市', 616, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222403, '', '敦化市', 617, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222404, '', '珲春市', 618, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222405, '', '龙井市', 619, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222406, '', '和龙市', 620, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222424, '', '汪清县', 621, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (222426, '', '安图县', 622, 'COUNTY', 2224, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230102, '', '道里区', 623, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230103, '', '南岗区', 624, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230104, '', '道外区', 625, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230108, '', '平房区', 626, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230109, '', '松北区', 627, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230110, '', '香坊区', 628, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230111, '', '呼兰区', 629, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230112, '', '阿城区', 630, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230113, '', '双城区', 631, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230123, '', '依兰县', 632, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230124, '', '方正县', 633, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230125, '', '宾县', 634, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230126, '', '巴彦县', 635, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230127, '', '木兰县', 636, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230128, '', '通河县', 637, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230129, '', '延寿县', 638, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230183, '', '尚志市', 639, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230184, '', '五常市', 640, 'COUNTY', 2301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230202, '', '龙沙区', 641, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230203, '', '建华区', 642, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230204, '', '铁锋区', 643, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230205, '', '昂昂溪区', 644, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230206, '', '富拉尔基区', 645, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230207, '', '碾子山区', 646, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230208, '', '梅里斯达斡尔族区', 647, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230221, '', '龙江县', 648, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230223, '', '依安县', 649, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230224, '', '泰来县', 650, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230225, '', '甘南县', 651, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230227, '', '富裕县', 652, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230229, '', '克山县', 653, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230230, '', '克东县', 654, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230231, '', '拜泉县', 655, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230281, '', '讷河市', 656, 'COUNTY', 2302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230302, '', '鸡冠区', 657, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230303, '', '恒山区', 658, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230304, '', '滴道区', 659, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230305, '', '梨树区', 660, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230306, '', '城子河区', 661, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230307, '', '麻山区', 662, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230321, '', '鸡东县', 663, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230381, '', '虎林市', 664, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230382, '', '密山市', 665, 'COUNTY', 2303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230402, '', '向阳区', 666, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230403, '', '工农区', 667, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230404, '', '南山区', 668, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230405, '', '兴安区', 669, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230406, '', '东山区', 670, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230407, '', '兴山区', 671, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230421, '', '萝北县', 672, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230422, '', '绥滨县', 673, 'COUNTY', 2304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230502, '', '尖山区', 674, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230503, '', '岭东区', 675, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230505, '', '四方台区', 676, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230506, '', '宝山区', 677, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230521, '', '集贤县', 678, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230522, '', '友谊县', 679, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230523, '', '宝清县', 680, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230524, '', '饶河县', 681, 'COUNTY', 2305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230602, '', '萨尔图区', 682, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230603, '', '龙凤区', 683, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230604, '', '让胡路区', 684, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230605, '', '红岗区', 685, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230606, '', '大同区', 686, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230621, '', '肇州县', 687, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230622, '', '肇源县', 688, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230623, '', '林甸县', 689, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230624, '', '杜尔伯特蒙古族自治县', 690, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230671, '', '大庆高新技术产业开发区', 691, 'COUNTY', 2306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230717, '', '伊美区', 692, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230718, '', '乌翠区', 693, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230719, '', '友好区', 694, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230722, '', '嘉荫县', 695, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230723, '', '汤旺县', 696, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230724, '', '丰林县', 697, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230725, '', '大箐山县', 698, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230726, '', '南岔县', 699, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230751, '', '金林区', 700, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230781, '', '铁力市', 701, 'COUNTY', 2307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230803, '', '向阳区', 702, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230804, '', '前进区', 703, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230805, '', '东风区', 704, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230811, '', '郊区', 705, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230822, '', '桦南县', 706, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230826, '', '桦川县', 707, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230828, '', '汤原县', 708, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230881, '', '同江市', 709, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230882, '', '富锦市', 710, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230883, '', '抚远市', 711, 'COUNTY', 2308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230902, '', '新兴区', 712, 'COUNTY', 2309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230903, '', '桃山区', 713, 'COUNTY', 2309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230904, '', '茄子河区', 714, 'COUNTY', 2309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (230921, '', '勃利县', 715, 'COUNTY', 2309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231002, '', '东安区', 716, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231003, '', '阳明区', 717, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231004, '', '爱民区', 718, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231005, '', '西安区', 719, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231025, '', '林口县', 720, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231071, '', '牡丹江经济技术开发区', 721, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231081, '', '绥芬河市', 722, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231083, '', '海林市', 723, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231084, '', '宁安市', 724, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231085, '', '穆棱市', 725, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231086, '', '东宁市', 726, 'COUNTY', 2310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231102, '', '爱辉区', 727, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231123, '', '逊克县', 728, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231124, '', '孙吴县', 729, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231181, '', '北安市', 730, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231182, '', '五大连池市', 731, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231183, '', '嫩江市', 732, 'COUNTY', 2311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231202, '', '北林区', 733, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231221, '', '望奎县', 734, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231222, '', '兰西县', 735, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231223, '', '青冈县', 736, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231224, '', '庆安县', 737, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231225, '', '明水县', 738, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231226, '', '绥棱县', 739, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231281, '', '安达市', 740, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231282, '', '肇东市', 741, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (231283, '', '海伦市', 742, 'COUNTY', 2312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232701, '', '漠河市', 743, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232721, '', '呼玛县', 744, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232722, '', '塔河县', 745, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232761, '', '加格达奇区', 746, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232762, '', '松岭区', 747, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232763, '', '新林区', 748, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (232764, '', '呼中区', 749, 'COUNTY', 2327, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310101, '', '黄浦区', 750, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310104, '', '徐汇区', 751, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310105, '', '长宁区', 752, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310106, '', '静安区', 753, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310107, '', '普陀区', 754, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310109, '', '虹口区', 755, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310110, '', '杨浦区', 756, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310112, '', '闵行区', 757, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310113, '', '宝山区', 758, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310114, '', '嘉定区', 759, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310115, '', '浦东新区', 760, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310116, '', '金山区', 761, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310117, '', '松江区', 762, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310118, '', '青浦区', 763, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310120, '', '奉贤区', 764, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (310151, '', '崇明区', 765, 'COUNTY', 3101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320102, '', '玄武区', 766, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320104, '', '秦淮区', 767, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320105, '', '建邺区', 768, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320106, '', '鼓楼区', 769, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320111, '', '浦口区', 770, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320113, '', '栖霞区', 771, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320114, '', '雨花台区', 772, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320115, '', '江宁区', 773, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320116, '', '六合区', 774, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320117, '', '溧水区', 775, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320118, '', '高淳区', 776, 'COUNTY', 3201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320205, '', '锡山区', 777, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320206, '', '惠山区', 778, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320211, '', '滨湖区', 779, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320213, '', '梁溪区', 780, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320214, '', '新吴区', 781, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320281, '', '江阴市', 782, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320282, '', '宜兴市', 783, 'COUNTY', 3202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320302, '', '鼓楼区', 784, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320303, '', '云龙区', 785, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320305, '', '贾汪区', 786, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320311, '', '泉山区', 787, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320312, '', '铜山区', 788, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320321, '', '丰县', 789, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320322, '', '沛县', 790, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320324, '', '睢宁县', 791, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320371, '', '徐州经济技术开发区', 792, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320381, '', '新沂市', 793, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320382, '', '邳州市', 794, 'COUNTY', 3203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320402, '', '天宁区', 795, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320404, '', '钟楼区', 796, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320411, '', '新北区', 797, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320412, '', '武进区', 798, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320413, '', '金坛区', 799, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320481, '', '溧阳市', 800, 'COUNTY', 3204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320505, '', '虎丘区', 801, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320506, '', '吴中区', 802, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320507, '', '相城区', 803, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320508, '', '姑苏区', 804, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320509, '', '吴江区', 805, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320571, '', '苏州工业园区', 806, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320581, '', '常熟市', 807, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320582, '', '张家港市', 808, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320583, '', '昆山市', 809, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320585, '', '太仓市', 810, 'COUNTY', 3205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320602, '', '崇川区', 811, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320611, '', '港闸区', 812, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320612, '', '通州区', 813, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320623, '', '如东县', 814, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320671, '', '南通经济技术开发区', 815, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320681, '', '启东市', 816, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320682, '', '如皋市', 817, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320684, '', '海门市', 818, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320685, '', '海安市', 819, 'COUNTY', 3206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320703, '', '连云区', 820, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320706, '', '海州区', 821, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320707, '', '赣榆区', 822, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320722, '', '东海县', 823, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320723, '', '灌云县', 824, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320724, '', '灌南县', 825, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320771, '', '连云港经济技术开发区', 826, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320772, '', '连云港高新技术产业开发区', 827, 'COUNTY', 3207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320803, '', '淮安区', 828, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320804, '', '淮阴区', 829, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320812, '', '清江浦区', 830, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320813, '', '洪泽区', 831, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320826, '', '涟水县', 832, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320830, '', '盱眙县', 833, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320831, '', '金湖县', 834, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320871, '', '淮安经济技术开发区', 835, 'COUNTY', 3208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320902, '', '亭湖区', 836, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320903, '', '盐都区', 837, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320904, '', '大丰区', 838, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320921, '', '响水县', 839, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320922, '', '滨海县', 840, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320923, '', '阜宁县', 841, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320924, '', '射阳县', 842, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320925, '', '建湖县', 843, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320971, '', '盐城经济技术开发区', 844, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (320981, '', '东台市', 845, 'COUNTY', 3209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321002, '', '广陵区', 846, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321003, '', '邗江区', 847, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321012, '', '江都区', 848, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321023, '', '宝应县', 849, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321071, '', '扬州经济技术开发区', 850, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321081, '', '仪征市', 851, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321084, '', '高邮市', 852, 'COUNTY', 3210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321102, '', '京口区', 853, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321111, '', '润州区', 854, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321112, '', '丹徒区', 855, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321171, '', '镇江新区', 856, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321181, '', '丹阳市', 857, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321182, '', '扬中市', 858, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321183, '', '句容市', 859, 'COUNTY', 3211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321202, '', '海陵区', 860, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321203, '', '高港区', 861, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321204, '', '姜堰区', 862, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321271, '', '泰州医药高新技术产业开发区', 863, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321281, '', '兴化市', 864, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321282, '', '靖江市', 865, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321283, '', '泰兴市', 866, 'COUNTY', 3212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321302, '', '宿城区', 867, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321311, '', '宿豫区', 868, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321322, '', '沭阳县', 869, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321323, '', '泗阳县', 870, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321324, '', '泗洪县', 871, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (321371, '', '宿迁经济技术开发区', 872, 'COUNTY', 3213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330102, '', '上城区', 873, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330103, '', '下城区', 874, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330104, '', '江干区', 875, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330105, '', '拱墅区', 876, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330106, '', '西湖区', 877, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330108, '', '滨江区', 878, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330109, '', '萧山区', 879, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330110, '', '余杭区', 880, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330111, '', '富阳区', 881, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330112, '', '临安区', 882, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330122, '', '桐庐县', 883, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330127, '', '淳安县', 884, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330182, '', '建德市', 885, 'COUNTY', 3301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330203, '', '海曙区', 886, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330205, '', '江北区', 887, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330206, '', '北仑区', 888, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330211, '', '镇海区', 889, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330212, '', '鄞州区', 890, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330213, '', '奉化区', 891, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330225, '', '象山县', 892, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330226, '', '宁海县', 893, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330281, '', '余姚市', 894, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330282, '', '慈溪市', 895, 'COUNTY', 3302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330302, '', '鹿城区', 896, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330303, '', '龙湾区', 897, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330304, '', '瓯海区', 898, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330305, '', '洞头区', 899, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330324, '', '永嘉县', 900, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330326, '', '平阳县', 901, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330327, '', '苍南县', 902, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330328, '', '文成县', 903, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330329, '', '泰顺县', 904, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330371, '', '温州经济技术开发区', 905, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330381, '', '瑞安市', 906, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330382, '', '乐清市', 907, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330383, '', '龙港市', 908, 'COUNTY', 3303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330402, '', '南湖区', 909, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330411, '', '秀洲区', 910, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330421, '', '嘉善县', 911, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330424, '', '海盐县', 912, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330481, '', '海宁市', 913, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330482, '', '平湖市', 914, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330483, '', '桐乡市', 915, 'COUNTY', 3304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330502, '', '吴兴区', 916, 'COUNTY', 3305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330503, '', '南浔区', 917, 'COUNTY', 3305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330521, '', '德清县', 918, 'COUNTY', 3305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330522, '', '长兴县', 919, 'COUNTY', 3305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330523, '', '安吉县', 920, 'COUNTY', 3305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330602, '', '越城区', 921, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330603, '', '柯桥区', 922, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330604, '', '上虞区', 923, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330624, '', '新昌县', 924, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330681, '', '诸暨市', 925, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330683, '', '嵊州市', 926, 'COUNTY', 3306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330702, '', '婺城区', 927, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330703, '', '金东区', 928, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330723, '', '武义县', 929, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330726, '', '浦江县', 930, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330727, '', '磐安县', 931, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330781, '', '兰溪市', 932, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330782, '', '义乌市', 933, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330783, '', '东阳市', 934, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330784, '', '永康市', 935, 'COUNTY', 3307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330802, '', '柯城区', 936, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330803, '', '衢江区', 937, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330822, '', '常山县', 938, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330824, '', '开化县', 939, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330825, '', '龙游县', 940, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330881, '', '江山市', 941, 'COUNTY', 3308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330902, '', '定海区', 942, 'COUNTY', 3309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330903, '', '普陀区', 943, 'COUNTY', 3309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330921, '', '岱山县', 944, 'COUNTY', 3309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (330922, '', '嵊泗县', 945, 'COUNTY', 3309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331002, '', '椒江区', 946, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331003, '', '黄岩区', 947, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331004, '', '路桥区', 948, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331022, '', '三门县', 949, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331023, '', '天台县', 950, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331024, '', '仙居县', 951, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331081, '', '温岭市', 952, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331082, '', '临海市', 953, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331083, '', '玉环市', 954, 'COUNTY', 3310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331102, '', '莲都区', 955, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331121, '', '青田县', 956, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331122, '', '缙云县', 957, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331123, '', '遂昌县', 958, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331124, '', '松阳县', 959, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331125, '', '云和县', 960, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331126, '', '庆元县', 961, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331127, '', '景宁畲族自治县', 962, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (331181, '', '龙泉市', 963, 'COUNTY', 3311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340102, '', '瑶海区', 964, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340103, '', '庐阳区', 965, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340104, '', '蜀山区', 966, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340111, '', '包河区', 967, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340121, '', '长丰县', 968, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340122, '', '肥东县', 969, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340123, '', '肥西县', 970, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340124, '', '庐江县', 971, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340171, '', '合肥高新技术产业开发区', 972, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340172, '', '合肥经济技术开发区', 973, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340173, '', '合肥新站高新技术产业开发区', 974, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340181, '', '巢湖市', 975, 'COUNTY', 3401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340202, '', '镜湖区', 976, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340203, '', '弋江区', 977, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340207, '', '鸠江区', 978, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340208, '', '三山区', 979, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340221, '', '芜湖县', 980, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340222, '', '繁昌县', 981, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340223, '', '南陵县', 982, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340225, '', '无为县', 983, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340271, '', '芜湖经济技术开发区', 984, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340272, '', '安徽芜湖长江大桥经济开发区', 985, 'COUNTY', 3402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340302, '', '龙子湖区', 986, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340303, '', '蚌山区', 987, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340304, '', '禹会区', 988, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340311, '', '淮上区', 989, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340321, '', '怀远县', 990, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340322, '', '五河县', 991, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340323, '', '固镇县', 992, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340371, '', '蚌埠市高新技术开发区', 993, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340372, '', '蚌埠市经济开发区', 994, 'COUNTY', 3403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340402, '', '大通区', 995, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340403, '', '田家庵区', 996, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340404, '', '谢家集区', 997, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340405, '', '八公山区', 998, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340406, '', '潘集区', 999, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340421, '', '凤台县', 1000, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340422, '', '寿县', 1001, 'COUNTY', 3404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340503, '', '花山区', 1002, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340504, '', '雨山区', 1003, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340506, '', '博望区', 1004, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340521, '', '当涂县', 1005, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340522, '', '含山县', 1006, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340523, '', '和县', 1007, 'COUNTY', 3405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340602, '', '杜集区', 1008, 'COUNTY', 3406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340603, '', '相山区', 1009, 'COUNTY', 3406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340604, '', '烈山区', 1010, 'COUNTY', 3406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340621, '', '濉溪县', 1011, 'COUNTY', 3406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340705, '', '铜官区', 1012, 'COUNTY', 3407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340706, '', '义安区', 1013, 'COUNTY', 3407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340711, '', '郊区', 1014, 'COUNTY', 3407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340722, '', '枞阳县', 1015, 'COUNTY', 3407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340802, '', '迎江区', 1016, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340803, '', '大观区', 1017, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340811, '', '宜秀区', 1018, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340822, '', '怀宁县', 1019, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340825, '', '太湖县', 1020, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340826, '', '宿松县', 1021, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340827, '', '望江县', 1022, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340828, '', '岳西县', 1023, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340871, '', '安徽安庆经济开发区', 1024, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340881, '', '桐城市', 1025, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (340882, '', '潜山市', 1026, 'COUNTY', 3408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341002, '', '屯溪区', 1027, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341003, '', '黄山区', 1028, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341004, '', '徽州区', 1029, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341021, '', '歙县', 1030, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341022, '', '休宁县', 1031, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341023, '', '黟县', 1032, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341024, '', '祁门县', 1033, 'COUNTY', 3410, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341102, '', '琅琊区', 1034, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341103, '', '南谯区', 1035, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341122, '', '来安县', 1036, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341124, '', '全椒县', 1037, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341125, '', '定远县', 1038, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341126, '', '凤阳县', 1039, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341171, '', '苏滁现代产业园', 1040, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341172, '', '滁州经济技术开发区', 1041, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341181, '', '天长市', 1042, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341182, '', '明光市', 1043, 'COUNTY', 3411, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341202, '', '颍州区', 1044, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341203, '', '颍东区', 1045, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341204, '', '颍泉区', 1046, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341221, '', '临泉县', 1047, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341222, '', '太和县', 1048, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341225, '', '阜南县', 1049, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341226, '', '颍上县', 1050, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341271, '', '阜阳合肥现代产业园区', 1051, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341272, '', '阜阳经济技术开发区', 1052, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341282, '', '界首市', 1053, 'COUNTY', 3412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341302, '', '埇桥区', 1054, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341321, '', '砀山县', 1055, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341322, '', '萧县', 1056, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341323, '', '灵璧县', 1057, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341324, '', '泗县', 1058, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341371, '', '宿州马鞍山现代产业园区', 1059, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341372, '', '宿州经济技术开发区', 1060, 'COUNTY', 3413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341502, '', '金安区', 1061, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341503, '', '裕安区', 1062, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341504, '', '叶集区', 1063, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341522, '', '霍邱县', 1064, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341523, '', '舒城县', 1065, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341524, '', '金寨县', 1066, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341525, '', '霍山县', 1067, 'COUNTY', 3415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341602, '', '谯城区', 1068, 'COUNTY', 3416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341621, '', '涡阳县', 1069, 'COUNTY', 3416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341622, '', '蒙城县', 1070, 'COUNTY', 3416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341623, '', '利辛县', 1071, 'COUNTY', 3416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341702, '', '贵池区', 1072, 'COUNTY', 3417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341721, '', '东至县', 1073, 'COUNTY', 3417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341722, '', '石台县', 1074, 'COUNTY', 3417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341723, '', '青阳县', 1075, 'COUNTY', 3417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341802, '', '宣州区', 1076, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341821, '', '郎溪县', 1077, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341823, '', '泾县', 1078, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341824, '', '绩溪县', 1079, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341825, '', '旌德县', 1080, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341871, '', '宣城市经济开发区', 1081, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341881, '', '宁国市', 1082, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (341882, '', '广德市', 1083, 'COUNTY', 3418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350102, '', '鼓楼区', 1084, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350103, '', '台江区', 1085, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350104, '', '仓山区', 1086, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350105, '', '马尾区', 1087, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350111, '', '晋安区', 1088, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350112, '', '长乐区', 1089, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350121, '', '闽侯县', 1090, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350122, '', '连江县', 1091, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350123, '', '罗源县', 1092, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350124, '', '闽清县', 1093, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350125, '', '永泰县', 1094, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350128, '', '平潭县', 1095, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350181, '', '福清市', 1096, 'COUNTY', 3501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350203, '', '思明区', 1097, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350205, '', '海沧区', 1098, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350206, '', '湖里区', 1099, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350211, '', '集美区', 1100, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350212, '', '同安区', 1101, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350213, '', '翔安区', 1102, 'COUNTY', 3502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350302, '', '城厢区', 1103, 'COUNTY', 3503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350303, '', '涵江区', 1104, 'COUNTY', 3503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350304, '', '荔城区', 1105, 'COUNTY', 3503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350305, '', '秀屿区', 1106, 'COUNTY', 3503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350322, '', '仙游县', 1107, 'COUNTY', 3503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350402, '', '梅列区', 1108, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350403, '', '三元区', 1109, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350421, '', '明溪县', 1110, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350423, '', '清流县', 1111, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350424, '', '宁化县', 1112, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350425, '', '大田县', 1113, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350426, '', '尤溪县', 1114, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350427, '', '沙县', 1115, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350428, '', '将乐县', 1116, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350429, '', '泰宁县', 1117, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350430, '', '建宁县', 1118, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350481, '', '永安市', 1119, 'COUNTY', 3504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350502, '', '鲤城区', 1120, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350503, '', '丰泽区', 1121, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350504, '', '洛江区', 1122, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350505, '', '泉港区', 1123, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350521, '', '惠安县', 1124, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350524, '', '安溪县', 1125, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350525, '', '永春县', 1126, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350526, '', '德化县', 1127, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350527, '', '金门县', 1128, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350581, '', '石狮市', 1129, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350582, '', '晋江市', 1130, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350583, '', '南安市', 1131, 'COUNTY', 3505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350602, '', '芗城区', 1132, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350603, '', '龙文区', 1133, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350622, '', '云霄县', 1134, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350623, '', '漳浦县', 1135, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350624, '', '诏安县', 1136, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350625, '', '长泰县', 1137, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350626, '', '东山县', 1138, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350627, '', '南靖县', 1139, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350628, '', '平和县', 1140, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350629, '', '华安县', 1141, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350681, '', '龙海市', 1142, 'COUNTY', 3506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350702, '', '延平区', 1143, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350703, '', '建阳区', 1144, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350721, '', '顺昌县', 1145, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350722, '', '浦城县', 1146, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350723, '', '光泽县', 1147, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350724, '', '松溪县', 1148, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350725, '', '政和县', 1149, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350781, '', '邵武市', 1150, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350782, '', '武夷山市', 1151, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350783, '', '建瓯市', 1152, 'COUNTY', 3507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350802, '', '新罗区', 1153, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350803, '', '永定区', 1154, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350821, '', '长汀县', 1155, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350823, '', '上杭县', 1156, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350824, '', '武平县', 1157, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350825, '', '连城县', 1158, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350881, '', '漳平市', 1159, 'COUNTY', 3508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350902, '', '蕉城区', 1160, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350921, '', '霞浦县', 1161, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350922, '', '古田县', 1162, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350923, '', '屏南县', 1163, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350924, '', '寿宁县', 1164, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350925, '', '周宁县', 1165, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350926, '', '柘荣县', 1166, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350981, '', '福安市', 1167, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (350982, '', '福鼎市', 1168, 'COUNTY', 3509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360102, '', '东湖区', 1169, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360103, '', '西湖区', 1170, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360104, '', '青云谱区', 1171, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360105, '', '湾里区', 1172, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360111, '', '青山湖区', 1173, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360112, '', '新建区', 1174, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360121, '', '南昌县', 1175, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360123, '', '安义县', 1176, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360124, '', '进贤县', 1177, 'COUNTY', 3601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360202, '', '昌江区', 1178, 'COUNTY', 3602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360203, '', '珠山区', 1179, 'COUNTY', 3602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360222, '', '浮梁县', 1180, 'COUNTY', 3602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360281, '', '乐平市', 1181, 'COUNTY', 3602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360302, '', '安源区', 1182, 'COUNTY', 3603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360313, '', '湘东区', 1183, 'COUNTY', 3603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360321, '', '莲花县', 1184, 'COUNTY', 3603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360322, '', '上栗县', 1185, 'COUNTY', 3603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360323, '', '芦溪县', 1186, 'COUNTY', 3603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360402, '', '濂溪区', 1187, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360403, '', '浔阳区', 1188, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360404, '', '柴桑区', 1189, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360423, '', '武宁县', 1190, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360424, '', '修水县', 1191, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360425, '', '永修县', 1192, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360426, '', '德安县', 1193, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360428, '', '都昌县', 1194, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360429, '', '湖口县', 1195, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360430, '', '彭泽县', 1196, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360481, '', '瑞昌市', 1197, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360482, '', '共青城市', 1198, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360483, '', '庐山市', 1199, 'COUNTY', 3604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360502, '', '渝水区', 1200, 'COUNTY', 3605, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360521, '', '分宜县', 1201, 'COUNTY', 3605, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360602, '', '月湖区', 1202, 'COUNTY', 3606, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360603, '', '余江区', 1203, 'COUNTY', 3606, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360681, '', '贵溪市', 1204, 'COUNTY', 3606, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360702, '', '章贡区', 1205, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360703, '', '南康区', 1206, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360704, '', '赣县区', 1207, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360722, '', '信丰县', 1208, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360723, '', '大余县', 1209, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360724, '', '上犹县', 1210, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360725, '', '崇义县', 1211, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360726, '', '安远县', 1212, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360727, '', '龙南县', 1213, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360728, '', '定南县', 1214, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360729, '', '全南县', 1215, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360730, '', '宁都县', 1216, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360731, '', '于都县', 1217, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360732, '', '兴国县', 1218, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360733, '', '会昌县', 1219, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360734, '', '寻乌县', 1220, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360735, '', '石城县', 1221, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360781, '', '瑞金市', 1222, 'COUNTY', 3607, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360802, '', '吉州区', 1223, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360803, '', '青原区', 1224, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360821, '', '吉安县', 1225, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360822, '', '吉水县', 1226, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360823, '', '峡江县', 1227, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360824, '', '新干县', 1228, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360825, '', '永丰县', 1229, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360826, '', '泰和县', 1230, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360827, '', '遂川县', 1231, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360828, '', '万安县', 1232, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360829, '', '安福县', 1233, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360830, '', '永新县', 1234, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360881, '', '井冈山市', 1235, 'COUNTY', 3608, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360902, '', '袁州区', 1236, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360921, '', '奉新县', 1237, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360922, '', '万载县', 1238, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360923, '', '上高县', 1239, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360924, '', '宜丰县', 1240, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360925, '', '靖安县', 1241, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360926, '', '铜鼓县', 1242, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360981, '', '丰城市', 1243, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360982, '', '樟树市', 1244, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (360983, '', '高安市', 1245, 'COUNTY', 3609, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361002, '', '临川区', 1246, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361003, '', '东乡区', 1247, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361021, '', '南城县', 1248, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361022, '', '黎川县', 1249, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361023, '', '南丰县', 1250, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361024, '', '崇仁县', 1251, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361025, '', '乐安县', 1252, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361026, '', '宜黄县', 1253, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361027, '', '金溪县', 1254, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361028, '', '资溪县', 1255, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361030, '', '广昌县', 1256, 'COUNTY', 3610, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361102, '', '信州区', 1257, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361103, '', '广丰区', 1258, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361104, '', '广信区', 1259, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361123, '', '玉山县', 1260, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361124, '', '铅山县', 1261, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361125, '', '横峰县', 1262, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361126, '', '弋阳县', 1263, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361127, '', '余干县', 1264, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361128, '', '鄱阳县', 1265, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361129, '', '万年县', 1266, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361130, '', '婺源县', 1267, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (361181, '', '德兴市', 1268, 'COUNTY', 3611, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370102, '', '历下区', 1269, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370103, '', '市中区', 1270, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370104, '', '槐荫区', 1271, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370105, '', '天桥区', 1272, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370112, '', '历城区', 1273, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370113, '', '长清区', 1274, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370114, '', '章丘区', 1275, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370115, '', '济阳区', 1276, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370116, '', '莱芜区', 1277, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370117, '', '钢城区', 1278, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370124, '', '平阴县', 1279, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370126, '', '商河县', 1280, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370171, '', '济南高新技术产业开发区', 1281, 'COUNTY', 3701, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370202, '', '市南区', 1282, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370203, '', '市北区', 1283, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370211, '', '黄岛区', 1284, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370212, '', '崂山区', 1285, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370213, '', '李沧区', 1286, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370214, '', '城阳区', 1287, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370215, '', '即墨区', 1288, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370271, '', '青岛高新技术产业开发区', 1289, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370281, '', '胶州市', 1290, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370283, '', '平度市', 1291, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370285, '', '莱西市', 1292, 'COUNTY', 3702, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370302, '', '淄川区', 1293, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370303, '', '张店区', 1294, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370304, '', '博山区', 1295, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370305, '', '临淄区', 1296, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370306, '', '周村区', 1297, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370321, '', '桓台县', 1298, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370322, '', '高青县', 1299, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370323, '', '沂源县', 1300, 'COUNTY', 3703, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370402, '', '市中区', 1301, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370403, '', '薛城区', 1302, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370404, '', '峄城区', 1303, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370405, '', '台儿庄区', 1304, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370406, '', '山亭区', 1305, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370481, '', '滕州市', 1306, 'COUNTY', 3704, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370502, '', '东营区', 1307, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370503, '', '河口区', 1308, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370505, '', '垦利区', 1309, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370522, '', '利津县', 1310, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370523, '', '广饶县', 1311, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370571, '', '东营经济技术开发区', 1312, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370572, '', '东营港经济开发区', 1313, 'COUNTY', 3705, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370602, '', '芝罘区', 1314, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370611, '', '福山区', 1315, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370612, '', '牟平区', 1316, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370613, '', '莱山区', 1317, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370634, '', '长岛县', 1318, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370671, '', '烟台高新技术产业开发区', 1319, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370672, '', '烟台经济技术开发区', 1320, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370681, '', '龙口市', 1321, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370682, '', '莱阳市', 1322, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370683, '', '莱州市', 1323, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370684, '', '蓬莱市', 1324, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370685, '', '招远市', 1325, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370686, '', '栖霞市', 1326, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370687, '', '海阳市', 1327, 'COUNTY', 3706, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370702, '', '潍城区', 1328, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370703, '', '寒亭区', 1329, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370704, '', '坊子区', 1330, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370705, '', '奎文区', 1331, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370724, '', '临朐县', 1332, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370725, '', '昌乐县', 1333, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370772, '', '潍坊滨海经济技术开发区', 1334, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370781, '', '青州市', 1335, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370782, '', '诸城市', 1336, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370783, '', '寿光市', 1337, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370784, '', '安丘市', 1338, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370785, '', '高密市', 1339, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370786, '', '昌邑市', 1340, 'COUNTY', 3707, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370811, '', '任城区', 1341, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370812, '', '兖州区', 1342, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370826, '', '微山县', 1343, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370827, '', '鱼台县', 1344, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370828, '', '金乡县', 1345, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370829, '', '嘉祥县', 1346, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370830, '', '汶上县', 1347, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370831, '', '泗水县', 1348, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370832, '', '梁山县', 1349, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370871, '', '济宁高新技术产业开发区', 1350, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370881, '', '曲阜市', 1351, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370883, '', '邹城市', 1352, 'COUNTY', 3708, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370902, '', '泰山区', 1353, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370911, '', '岱岳区', 1354, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370921, '', '宁阳县', 1355, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370923, '', '东平县', 1356, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370982, '', '新泰市', 1357, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (370983, '', '肥城市', 1358, 'COUNTY', 3709, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371002, '', '环翠区', 1359, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371003, '', '文登区', 1360, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371071, '', '威海火炬高技术产业开发区', 1361, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371072, '', '威海经济技术开发区', 1362, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371073, '', '威海临港经济技术开发区', 1363, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371082, '', '荣成市', 1364, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371083, '', '乳山市', 1365, 'COUNTY', 3710, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371102, '', '东港区', 1366, 'COUNTY', 3711, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371103, '', '岚山区', 1367, 'COUNTY', 3711, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371121, '', '五莲县', 1368, 'COUNTY', 3711, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371122, '', '莒县', 1369, 'COUNTY', 3711, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371171, '', '日照经济技术开发区', 1370, 'COUNTY', 3711, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371302, '', '兰山区', 1371, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371311, '', '罗庄区', 1372, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371312, '', '河东区', 1373, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371321, '', '沂南县', 1374, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371322, '', '郯城县', 1375, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371323, '', '沂水县', 1376, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371324, '', '兰陵县', 1377, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371325, '', '费县', 1378, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371326, '', '平邑县', 1379, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371327, '', '莒南县', 1380, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371328, '', '蒙阴县', 1381, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371329, '', '临沭县', 1382, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371371, '', '临沂高新技术产业开发区', 1383, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371372, '', '临沂经济技术开发区', 1384, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371373, '', '临沂临港经济开发区', 1385, 'COUNTY', 3713, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371402, '', '德城区', 1386, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371403, '', '陵城区', 1387, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371422, '', '宁津县', 1388, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371423, '', '庆云县', 1389, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371424, '', '临邑县', 1390, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371425, '', '齐河县', 1391, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371426, '', '平原县', 1392, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371427, '', '夏津县', 1393, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371428, '', '武城县', 1394, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371471, '', '德州经济技术开发区', 1395, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371472, '', '德州运河经济开发区', 1396, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371481, '', '乐陵市', 1397, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371482, '', '禹城市', 1398, 'COUNTY', 3714, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371502, '', '东昌府区', 1399, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371503, '', '茌平区', 1400, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371521, '', '阳谷县', 1401, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371522, '', '莘县', 1402, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371524, '', '东阿县', 1403, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371525, '', '冠县', 1404, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371526, '', '高唐县', 1405, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371581, '', '临清市', 1406, 'COUNTY', 3715, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371602, '', '滨城区', 1407, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371603, '', '沾化区', 1408, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371621, '', '惠民县', 1409, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371622, '', '阳信县', 1410, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371623, '', '无棣县', 1411, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371625, '', '博兴县', 1412, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371681, '', '邹平市', 1413, 'COUNTY', 3716, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371702, '', '牡丹区', 1414, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371703, '', '定陶区', 1415, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371721, '', '曹县', 1416, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371722, '', '单县', 1417, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371723, '', '成武县', 1418, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371724, '', '巨野县', 1419, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371725, '', '郓城县', 1420, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371726, '', '鄄城县', 1421, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371728, '', '东明县', 1422, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371771, '', '菏泽经济技术开发区', 1423, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (371772, '', '菏泽高新技术开发区', 1424, 'COUNTY', 3717, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410102, '', '中原区', 1425, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410103, '', '二七区', 1426, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410104, '', '管城回族区', 1427, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410105, '', '金水区', 1428, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410106, '', '上街区', 1429, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410108, '', '惠济区', 1430, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410122, '', '中牟县', 1431, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410171, '', '郑州经济技术开发区', 1432, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410172, '', '郑州高新技术产业开发区', 1433, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410173, '', '郑州航空港经济综合实验区', 1434, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410181, '', '巩义市', 1435, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410182, '', '荥阳市', 1436, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410183, '', '新密市', 1437, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410184, '', '新郑市', 1438, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410185, '', '登封市', 1439, 'COUNTY', 4101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410202, '', '龙亭区', 1440, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410203, '', '顺河回族区', 1441, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410204, '', '鼓楼区', 1442, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410205, '', '禹王台区', 1443, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410212, '', '祥符区', 1444, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410221, '', '杞县', 1445, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410222, '', '通许县', 1446, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410223, '', '尉氏县', 1447, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410225, '', '兰考县', 1448, 'COUNTY', 4102, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410302, '', '老城区', 1449, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410303, '', '西工区', 1450, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410304, '', '瀍河回族区', 1451, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410305, '', '涧西区', 1452, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410306, '', '吉利区', 1453, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410311, '', '洛龙区', 1454, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410322, '', '孟津县', 1455, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410323, '', '新安县', 1456, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410324, '', '栾川县', 1457, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410325, '', '嵩县', 1458, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410326, '', '汝阳县', 1459, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410327, '', '宜阳县', 1460, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410328, '', '洛宁县', 1461, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410329, '', '伊川县', 1462, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410371, '', '洛阳高新技术产业开发区', 1463, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410381, '', '偃师市', 1464, 'COUNTY', 4103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410402, '', '新华区', 1465, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410403, '', '卫东区', 1466, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410404, '', '石龙区', 1467, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410411, '', '湛河区', 1468, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410421, '', '宝丰县', 1469, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410422, '', '叶县', 1470, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410423, '', '鲁山县', 1471, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410425, '', '郏县', 1472, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410471, '', '平顶山高新技术产业开发区', 1473, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410472, '', '平顶山市城乡一体化示范区', 1474, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410481, '', '舞钢市', 1475, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410482, '', '汝州市', 1476, 'COUNTY', 4104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410502, '', '文峰区', 1477, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410503, '', '北关区', 1478, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410505, '', '殷都区', 1479, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410506, '', '龙安区', 1480, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410522, '', '安阳县', 1481, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410523, '', '汤阴县', 1482, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410526, '', '滑县', 1483, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410527, '', '内黄县', 1484, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410571, '', '安阳高新技术产业开发区', 1485, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410581, '', '林州市', 1486, 'COUNTY', 4105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410602, '', '鹤山区', 1487, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410603, '', '山城区', 1488, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410611, '', '淇滨区', 1489, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410621, '', '浚县', 1490, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410622, '', '淇县', 1491, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410671, '', '鹤壁经济技术开发区', 1492, 'COUNTY', 4106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410702, '', '红旗区', 1493, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410703, '', '卫滨区', 1494, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410704, '', '凤泉区', 1495, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410711, '', '牧野区', 1496, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410721, '', '新乡县', 1497, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410724, '', '获嘉县', 1498, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410725, '', '原阳县', 1499, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410726, '', '延津县', 1500, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410727, '', '封丘县', 1501, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410771, '', '新乡高新技术产业开发区', 1502, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410772, '', '新乡经济技术开发区', 1503, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410773, '', '新乡市平原城乡一体化示范区', 1504, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410781, '', '卫辉市', 1505, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410782, '', '辉县市', 1506, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410783, '', '长垣市', 1507, 'COUNTY', 4107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410802, '', '解放区', 1508, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410803, '', '中站区', 1509, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410804, '', '马村区', 1510, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410811, '', '山阳区', 1511, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410821, '', '修武县', 1512, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410822, '', '博爱县', 1513, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410823, '', '武陟县', 1514, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410825, '', '温县', 1515, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410871, '', '焦作城乡一体化示范区', 1516, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410882, '', '沁阳市', 1517, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410883, '', '孟州市', 1518, 'COUNTY', 4108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410902, '', '华龙区', 1519, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410922, '', '清丰县', 1520, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410923, '', '南乐县', 1521, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410926, '', '范县', 1522, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410927, '', '台前县', 1523, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410928, '', '濮阳县', 1524, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410971, '', '河南濮阳工业园区', 1525, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (410972, '', '濮阳经济技术开发区', 1526, 'COUNTY', 4109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411002, '', '魏都区', 1527, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411003, '', '建安区', 1528, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411024, '', '鄢陵县', 1529, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411025, '', '襄城县', 1530, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411071, '', '许昌经济技术开发区', 1531, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411081, '', '禹州市', 1532, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411082, '', '长葛市', 1533, 'COUNTY', 4110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411102, '', '源汇区', 1534, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411103, '', '郾城区', 1535, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411104, '', '召陵区', 1536, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411121, '', '舞阳县', 1537, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411122, '', '临颍县', 1538, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411171, '', '漯河经济技术开发区', 1539, 'COUNTY', 4111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411202, '', '湖滨区', 1540, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411203, '', '陕州区', 1541, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411221, '', '渑池县', 1542, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411224, '', '卢氏县', 1543, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411271, '', '河南三门峡经济开发区', 1544, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411281, '', '义马市', 1545, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411282, '', '灵宝市', 1546, 'COUNTY', 4112, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411302, '', '宛城区', 1547, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411303, '', '卧龙区', 1548, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411321, '', '南召县', 1549, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411322, '', '方城县', 1550, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411323, '', '西峡县', 1551, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411324, '', '镇平县', 1552, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411325, '', '内乡县', 1553, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411326, '', '淅川县', 1554, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411327, '', '社旗县', 1555, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411328, '', '唐河县', 1556, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411329, '', '新野县', 1557, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411330, '', '桐柏县', 1558, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411371, '', '南阳高新技术产业开发区', 1559, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411372, '', '南阳市城乡一体化示范区', 1560, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411381, '', '邓州市', 1561, 'COUNTY', 4113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411402, '', '梁园区', 1562, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411403, '', '睢阳区', 1563, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411421, '', '民权县', 1564, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411422, '', '睢县', 1565, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411423, '', '宁陵县', 1566, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411424, '', '柘城县', 1567, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411425, '', '虞城县', 1568, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411426, '', '夏邑县', 1569, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411471, '', '豫东综合物流产业聚集区', 1570, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411472, '', '河南商丘经济开发区', 1571, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411481, '', '永城市', 1572, 'COUNTY', 4114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411502, '', '浉河区', 1573, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411503, '', '平桥区', 1574, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411521, '', '罗山县', 1575, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411522, '', '光山县', 1576, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411523, '', '新县', 1577, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411524, '', '商城县', 1578, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411525, '', '固始县', 1579, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411526, '', '潢川县', 1580, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411527, '', '淮滨县', 1581, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411528, '', '息县', 1582, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411571, '', '信阳高新技术产业开发区', 1583, 'COUNTY', 4115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411602, '', '川汇区', 1584, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411603, '', '淮阳区', 1585, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411621, '', '扶沟县', 1586, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411622, '', '西华县', 1587, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411623, '', '商水县', 1588, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411624, '', '沈丘县', 1589, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411625, '', '郸城县', 1590, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411627, '', '太康县', 1591, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411628, '', '鹿邑县', 1592, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411671, '', '河南周口经济开发区', 1593, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411681, '', '项城市', 1594, 'COUNTY', 4116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411702, '', '驿城区', 1595, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411721, '', '西平县', 1596, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411722, '', '上蔡县', 1597, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411723, '', '平舆县', 1598, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411724, '', '正阳县', 1599, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411725, '', '确山县', 1600, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411726, '', '泌阳县', 1601, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411727, '', '汝南县', 1602, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411728, '', '遂平县', 1603, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411729, '', '新蔡县', 1604, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (411771, '', '河南驻马店经济开发区', 1605, 'COUNTY', 4117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (419001, '', '济源市', 1606, 'COUNTY', 4190, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420102, '', '江岸区', 1607, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420103, '', '江汉区', 1608, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420104, '', '硚口区', 1609, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420105, '', '汉阳区', 1610, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420106, '', '武昌区', 1611, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420107, '', '青山区', 1612, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420111, '', '洪山区', 1613, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420112, '', '东西湖区', 1614, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420113, '', '汉南区', 1615, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420114, '', '蔡甸区', 1616, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420115, '', '江夏区', 1617, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420116, '', '黄陂区', 1618, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420117, '', '新洲区', 1619, 'COUNTY', 4201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420202, '', '黄石港区', 1620, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420203, '', '西塞山区', 1621, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420204, '', '下陆区', 1622, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420205, '', '铁山区', 1623, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420222, '', '阳新县', 1624, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420281, '', '大冶市', 1625, 'COUNTY', 4202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420302, '', '茅箭区', 1626, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420303, '', '张湾区', 1627, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420304, '', '郧阳区', 1628, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420322, '', '郧西县', 1629, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420323, '', '竹山县', 1630, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420324, '', '竹溪县', 1631, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420325, '', '房县', 1632, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420381, '', '丹江口市', 1633, 'COUNTY', 4203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420502, '', '西陵区', 1634, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420503, '', '伍家岗区', 1635, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420504, '', '点军区', 1636, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420505, '', '猇亭区', 1637, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420506, '', '夷陵区', 1638, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420525, '', '远安县', 1639, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420526, '', '兴山县', 1640, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420527, '', '秭归县', 1641, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420528, '', '长阳土家族自治县', 1642, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420529, '', '五峰土家族自治县', 1643, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420581, '', '宜都市', 1644, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420582, '', '当阳市', 1645, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420583, '', '枝江市', 1646, 'COUNTY', 4205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420602, '', '襄城区', 1647, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420606, '', '樊城区', 1648, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420607, '', '襄州区', 1649, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420624, '', '南漳县', 1650, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420625, '', '谷城县', 1651, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420626, '', '保康县', 1652, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420682, '', '老河口市', 1653, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420683, '', '枣阳市', 1654, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420684, '', '宜城市', 1655, 'COUNTY', 4206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420702, '', '梁子湖区', 1656, 'COUNTY', 4207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420703, '', '华容区', 1657, 'COUNTY', 4207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420704, '', '鄂城区', 1658, 'COUNTY', 4207, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420802, '', '东宝区', 1659, 'COUNTY', 4208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420804, '', '掇刀区', 1660, 'COUNTY', 4208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420822, '', '沙洋县', 1661, 'COUNTY', 4208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420881, '', '钟祥市', 1662, 'COUNTY', 4208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420882, '', '京山市', 1663, 'COUNTY', 4208, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420902, '', '孝南区', 1664, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420921, '', '孝昌县', 1665, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420922, '', '大悟县', 1666, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420923, '', '云梦县', 1667, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420981, '', '应城市', 1668, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420982, '', '安陆市', 1669, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (420984, '', '汉川市', 1670, 'COUNTY', 4209, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421002, '', '沙市区', 1671, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421003, '', '荆州区', 1672, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421022, '', '公安县', 1673, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421023, '', '监利县', 1674, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421024, '', '江陵县', 1675, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421071, '', '荆州经济技术开发区', 1676, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421081, '', '石首市', 1677, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421083, '', '洪湖市', 1678, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421087, '', '松滋市', 1679, 'COUNTY', 4210, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421102, '', '黄州区', 1680, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421121, '', '团风县', 1681, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421122, '', '红安县', 1682, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421123, '', '罗田县', 1683, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421124, '', '英山县', 1684, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421125, '', '浠水县', 1685, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421126, '', '蕲春县', 1686, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421127, '', '黄梅县', 1687, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421171, '', '龙感湖管理区', 1688, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421181, '', '麻城市', 1689, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421182, '', '武穴市', 1690, 'COUNTY', 4211, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421202, '', '咸安区', 1691, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421221, '', '嘉鱼县', 1692, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421222, '', '通城县', 1693, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421223, '', '崇阳县', 1694, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421224, '', '通山县', 1695, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421281, '', '赤壁市', 1696, 'COUNTY', 4212, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421303, '', '曾都区', 1697, 'COUNTY', 4213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421321, '', '随县', 1698, 'COUNTY', 4213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (421381, '', '广水市', 1699, 'COUNTY', 4213, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422801, '', '恩施市', 1700, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422802, '', '利川市', 1701, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422822, '', '建始县', 1702, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422823, '', '巴东县', 1703, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422825, '', '宣恩县', 1704, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422826, '', '咸丰县', 1705, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422827, '', '来凤县', 1706, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (422828, '', '鹤峰县', 1707, 'COUNTY', 4228, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (429004, '', '仙桃市', 1708, 'COUNTY', 4290, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (429005, '', '潜江市', 1709, 'COUNTY', 4290, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (429006, '', '天门市', 1710, 'COUNTY', 4290, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (429021, '', '神农架林区', 1711, 'COUNTY', 4290, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430102, '', '芙蓉区', 1712, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430103, '', '天心区', 1713, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430104, '', '岳麓区', 1714, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430105, '', '开福区', 1715, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430111, '', '雨花区', 1716, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430112, '', '望城区', 1717, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430121, '', '长沙县', 1718, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430181, '', '浏阳市', 1719, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430182, '', '宁乡市', 1720, 'COUNTY', 4301, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430202, '', '荷塘区', 1721, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430203, '', '芦淞区', 1722, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430204, '', '石峰区', 1723, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430211, '', '天元区', 1724, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430212, '', '渌口区', 1725, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430223, '', '攸县', 1726, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430224, '', '茶陵县', 1727, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430225, '', '炎陵县', 1728, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430271, '', '云龙示范区', 1729, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430281, '', '醴陵市', 1730, 'COUNTY', 4302, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430302, '', '雨湖区', 1731, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430304, '', '岳塘区', 1732, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430321, '', '湘潭县', 1733, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430371, '', '湖南湘潭高新技术产业园区', 1734, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430372, '', '湘潭昭山示范区', 1735, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430373, '', '湘潭九华示范区', 1736, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430381, '', '湘乡市', 1737, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430382, '', '韶山市', 1738, 'COUNTY', 4303, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430405, '', '珠晖区', 1739, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430406, '', '雁峰区', 1740, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430407, '', '石鼓区', 1741, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430408, '', '蒸湘区', 1742, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430412, '', '南岳区', 1743, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430421, '', '衡阳县', 1744, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430422, '', '衡南县', 1745, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430423, '', '衡山县', 1746, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430424, '', '衡东县', 1747, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430426, '', '祁东县', 1748, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430471, '', '衡阳综合保税区', 1749, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430472, '', '湖南衡阳高新技术产业园区', 1750, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430473, '', '湖南衡阳松木经济开发区', 1751, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430481, '', '耒阳市', 1752, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430482, '', '常宁市', 1753, 'COUNTY', 4304, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430502, '', '双清区', 1754, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430503, '', '大祥区', 1755, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430511, '', '北塔区', 1756, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430522, '', '新邵县', 1757, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430523, '', '邵阳县', 1758, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430524, '', '隆回县', 1759, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430525, '', '洞口县', 1760, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430527, '', '绥宁县', 1761, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430528, '', '新宁县', 1762, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430529, '', '城步苗族自治县', 1763, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430581, '', '武冈市', 1764, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430582, '', '邵东市', 1765, 'COUNTY', 4305, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430602, '', '岳阳楼区', 1766, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430603, '', '云溪区', 1767, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430611, '', '君山区', 1768, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430621, '', '岳阳县', 1769, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430623, '', '华容县', 1770, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430624, '', '湘阴县', 1771, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430626, '', '平江县', 1772, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430671, '', '岳阳市屈原管理区', 1773, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430681, '', '汨罗市', 1774, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430682, '', '临湘市', 1775, 'COUNTY', 4306, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430702, '', '武陵区', 1776, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430703, '', '鼎城区', 1777, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430721, '', '安乡县', 1778, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430722, '', '汉寿县', 1779, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430723, '', '澧县', 1780, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430724, '', '临澧县', 1781, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430725, '', '桃源县', 1782, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430726, '', '石门县', 1783, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430771, '', '常德市西洞庭管理区', 1784, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430781, '', '津市市', 1785, 'COUNTY', 4307, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430802, '', '永定区', 1786, 'COUNTY', 4308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430811, '', '武陵源区', 1787, 'COUNTY', 4308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430821, '', '慈利县', 1788, 'COUNTY', 4308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430822, '', '桑植县', 1789, 'COUNTY', 4308, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430902, '', '资阳区', 1790, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430903, '', '赫山区', 1791, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430921, '', '南县', 1792, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430922, '', '桃江县', 1793, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430923, '', '安化县', 1794, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430971, '', '益阳市大通湖管理区', 1795, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430972, '', '湖南益阳高新技术产业园区', 1796, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (430981, '', '沅江市', 1797, 'COUNTY', 4309, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431002, '', '北湖区', 1798, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431003, '', '苏仙区', 1799, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431021, '', '桂阳县', 1800, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431022, '', '宜章县', 1801, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431023, '', '永兴县', 1802, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431024, '', '嘉禾县', 1803, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431025, '', '临武县', 1804, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431026, '', '汝城县', 1805, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431027, '', '桂东县', 1806, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431028, '', '安仁县', 1807, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431081, '', '资兴市', 1808, 'COUNTY', 4310, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431102, '', '零陵区', 1809, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431103, '', '冷水滩区', 1810, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431121, '', '祁阳县', 1811, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431122, '', '东安县', 1812, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431123, '', '双牌县', 1813, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431124, '', '道县', 1814, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431125, '', '江永县', 1815, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431126, '', '宁远县', 1816, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431127, '', '蓝山县', 1817, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431128, '', '新田县', 1818, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431129, '', '江华瑶族自治县', 1819, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431171, '', '永州经济技术开发区', 1820, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431172, '', '永州市金洞管理区', 1821, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431173, '', '永州市回龙圩管理区', 1822, 'COUNTY', 4311, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431202, '', '鹤城区', 1823, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431221, '', '中方县', 1824, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431222, '', '沅陵县', 1825, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431223, '', '辰溪县', 1826, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431224, '', '溆浦县', 1827, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431225, '', '会同县', 1828, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431226, '', '麻阳苗族自治县', 1829, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431227, '', '新晃侗族自治县', 1830, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431228, '', '芷江侗族自治县', 1831, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431229, '', '靖州苗族侗族自治县', 1832, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431230, '', '通道侗族自治县', 1833, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431271, '', '怀化市洪江管理区', 1834, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431281, '', '洪江市', 1835, 'COUNTY', 4312, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431302, '', '娄星区', 1836, 'COUNTY', 4313, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431321, '', '双峰县', 1837, 'COUNTY', 4313, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431322, '', '新化县', 1838, 'COUNTY', 4313, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431381, '', '冷水江市', 1839, 'COUNTY', 4313, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (431382, '', '涟源市', 1840, 'COUNTY', 4313, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433101, '', '吉首市', 1841, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433122, '', '泸溪县', 1842, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433123, '', '凤凰县', 1843, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433124, '', '花垣县', 1844, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433125, '', '保靖县', 1845, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433126, '', '古丈县', 1846, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433127, '', '永顺县', 1847, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433130, '', '龙山县', 1848, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (433173, '', '湖南永顺经济开发区', 1849, 'COUNTY', 4331, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440103, '', '荔湾区', 1850, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440104, '', '越秀区', 1851, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440105, '', '海珠区', 1852, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440106, '', '天河区', 1853, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440111, '', '白云区', 1854, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440112, '', '黄埔区', 1855, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440113, '', '番禺区', 1856, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440114, '', '花都区', 1857, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440115, '', '南沙区', 1858, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440117, '', '从化区', 1859, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440118, '', '增城区', 1860, 'COUNTY', 4401, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440203, '', '武江区', 1861, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440204, '', '浈江区', 1862, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440205, '', '曲江区', 1863, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440222, '', '始兴县', 1864, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440224, '', '仁化县', 1865, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440229, '', '翁源县', 1866, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440232, '', '乳源瑶族自治县', 1867, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440233, '', '新丰县', 1868, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440281, '', '乐昌市', 1869, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440282, '', '南雄市', 1870, 'COUNTY', 4402, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440303, '', '罗湖区', 1871, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440304, '', '福田区', 1872, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440305, '', '南山区', 1873, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440306, '', '宝安区', 1874, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440307, '', '龙岗区', 1875, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440308, '', '盐田区', 1876, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440309, '', '龙华区', 1877, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440310, '', '坪山区', 1878, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440311, '', '光明区', 1879, 'COUNTY', 4403, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440402, '', '香洲区', 1880, 'COUNTY', 4404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440403, '', '斗门区', 1881, 'COUNTY', 4404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440404, '', '金湾区', 1882, 'COUNTY', 4404, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440507, '', '龙湖区', 1883, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440511, '', '金平区', 1884, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440512, '', '濠江区', 1885, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440513, '', '潮阳区', 1886, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440514, '', '潮南区', 1887, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440515, '', '澄海区', 1888, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440523, '', '南澳县', 1889, 'COUNTY', 4405, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440604, '', '禅城区', 1890, 'COUNTY', 4406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440605, '', '南海区', 1891, 'COUNTY', 4406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440606, '', '顺德区', 1892, 'COUNTY', 4406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440607, '', '三水区', 1893, 'COUNTY', 4406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440608, '', '高明区', 1894, 'COUNTY', 4406, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440703, '', '蓬江区', 1895, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440704, '', '江海区', 1896, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440705, '', '新会区', 1897, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440781, '', '台山市', 1898, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440783, '', '开平市', 1899, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440784, '', '鹤山市', 1900, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440785, '', '恩平市', 1901, 'COUNTY', 4407, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440802, '', '赤坎区', 1902, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440803, '', '霞山区', 1903, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440804, '', '坡头区', 1904, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440811, '', '麻章区', 1905, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440823, '', '遂溪县', 1906, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440825, '', '徐闻县', 1907, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440881, '', '廉江市', 1908, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440882, '', '雷州市', 1909, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440883, '', '吴川市', 1910, 'COUNTY', 4408, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440902, '', '茂南区', 1911, 'COUNTY', 4409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440904, '', '电白区', 1912, 'COUNTY', 4409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440981, '', '高州市', 1913, 'COUNTY', 4409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440982, '', '化州市', 1914, 'COUNTY', 4409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (440983, '', '信宜市', 1915, 'COUNTY', 4409, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441202, '', '端州区', 1916, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441203, '', '鼎湖区', 1917, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441204, '', '高要区', 1918, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441223, '', '广宁县', 1919, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441224, '', '怀集县', 1920, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441225, '', '封开县', 1921, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441226, '', '德庆县', 1922, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441284, '', '四会市', 1923, 'COUNTY', 4412, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441302, '', '惠城区', 1924, 'COUNTY', 4413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441303, '', '惠阳区', 1925, 'COUNTY', 4413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441322, '', '博罗县', 1926, 'COUNTY', 4413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441323, '', '惠东县', 1927, 'COUNTY', 4413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441324, '', '龙门县', 1928, 'COUNTY', 4413, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441402, '', '梅江区', 1929, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441403, '', '梅县区', 1930, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441422, '', '大埔县', 1931, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441423, '', '丰顺县', 1932, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441424, '', '五华县', 1933, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441426, '', '平远县', 1934, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441427, '', '蕉岭县', 1935, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441481, '', '兴宁市', 1936, 'COUNTY', 4414, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441502, '', '城区', 1937, 'COUNTY', 4415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441521, '', '海丰县', 1938, 'COUNTY', 4415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441523, '', '陆河县', 1939, 'COUNTY', 4415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441581, '', '陆丰市', 1940, 'COUNTY', 4415, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441602, '', '源城区', 1941, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441621, '', '紫金县', 1942, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441622, '', '龙川县', 1943, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441623, '', '连平县', 1944, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441624, '', '和平县', 1945, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441625, '', '东源县', 1946, 'COUNTY', 4416, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441702, '', '江城区', 1947, 'COUNTY', 4417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441704, '', '阳东区', 1948, 'COUNTY', 4417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441721, '', '阳西县', 1949, 'COUNTY', 4417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441781, '', '阳春市', 1950, 'COUNTY', 4417, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441802, '', '清城区', 1951, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441803, '', '清新区', 1952, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441821, '', '佛冈县', 1953, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441823, '', '阳山县', 1954, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441825, '', '连山壮族瑶族自治县', 1955, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441826, '', '连南瑶族自治县', 1956, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441881, '', '英德市', 1957, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441882, '', '连州市', 1958, 'COUNTY', 4418, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445102, '', '湘桥区', 2018, 'COUNTY', 4451, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445103, '', '潮安区', 2019, 'COUNTY', 4451, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445122, '', '饶平县', 2020, 'COUNTY', 4451, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445202, '', '榕城区', 2021, 'COUNTY', 4452, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445203, '', '揭东区', 2022, 'COUNTY', 4452, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445222, '', '揭西县', 2023, 'COUNTY', 4452, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445224, '', '惠来县', 2024, 'COUNTY', 4452, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445281, '', '普宁市', 2025, 'COUNTY', 4452, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445302, '', '云城区', 2026, 'COUNTY', 4453, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445303, '', '云安区', 2027, 'COUNTY', 4453, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445321, '', '新兴县', 2028, 'COUNTY', 4453, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445322, '', '郁南县', 2029, 'COUNTY', 4453, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (445381, '', '罗定市', 2030, 'COUNTY', 4453, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450102, '', '兴宁区', 2031, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450103, '', '青秀区', 2032, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450105, '', '江南区', 2033, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450107, '', '西乡塘区', 2034, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450108, '', '良庆区', 2035, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450109, '', '邕宁区', 2036, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450110, '', '武鸣区', 2037, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450123, '', '隆安县', 2038, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450124, '', '马山县', 2039, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450125, '', '上林县', 2040, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450126, '', '宾阳县', 2041, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450127, '', '横县', 2042, 'COUNTY', 4501, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450202, '', '城中区', 2043, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450203, '', '鱼峰区', 2044, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450204, '', '柳南区', 2045, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450205, '', '柳北区', 2046, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450206, '', '柳江区', 2047, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450222, '', '柳城县', 2048, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450223, '', '鹿寨县', 2049, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450224, '', '融安县', 2050, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450225, '', '融水苗族自治县', 2051, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450226, '', '三江侗族自治县', 2052, 'COUNTY', 4502, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450302, '', '秀峰区', 2053, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450303, '', '叠彩区', 2054, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450304, '', '象山区', 2055, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450305, '', '七星区', 2056, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450311, '', '雁山区', 2057, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450312, '', '临桂区', 2058, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450321, '', '阳朔县', 2059, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450323, '', '灵川县', 2060, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450324, '', '全州县', 2061, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450325, '', '兴安县', 2062, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450326, '', '永福县', 2063, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450327, '', '灌阳县', 2064, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450328, '', '龙胜各族自治县', 2065, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450329, '', '资源县', 2066, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450330, '', '平乐县', 2067, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450332, '', '恭城瑶族自治县', 2068, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450381, '', '荔浦市', 2069, 'COUNTY', 4503, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450403, '', '万秀区', 2070, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450405, '', '长洲区', 2071, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450406, '', '龙圩区', 2072, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450421, '', '苍梧县', 2073, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450422, '', '藤县', 2074, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450423, '', '蒙山县', 2075, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450481, '', '岑溪市', 2076, 'COUNTY', 4504, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450502, '', '海城区', 2077, 'COUNTY', 4505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450503, '', '银海区', 2078, 'COUNTY', 4505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450512, '', '铁山港区', 2079, 'COUNTY', 4505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450521, '', '合浦县', 2080, 'COUNTY', 4505, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450602, '', '港口区', 2081, 'COUNTY', 4506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450603, '', '防城区', 2082, 'COUNTY', 4506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450621, '', '上思县', 2083, 'COUNTY', 4506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450681, '', '东兴市', 2084, 'COUNTY', 4506, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450702, '', '钦南区', 2085, 'COUNTY', 4507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450703, '', '钦北区', 2086, 'COUNTY', 4507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450721, '', '灵山县', 2087, 'COUNTY', 4507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450722, '', '浦北县', 2088, 'COUNTY', 4507, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450802, '', '港北区', 2089, 'COUNTY', 4508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450803, '', '港南区', 2090, 'COUNTY', 4508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450804, '', '覃塘区', 2091, 'COUNTY', 4508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450821, '', '平南县', 2092, 'COUNTY', 4508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450881, '', '桂平市', 2093, 'COUNTY', 4508, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450902, '', '玉州区', 2094, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450903, '', '福绵区', 2095, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450921, '', '容县', 2096, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450922, '', '陆川县', 2097, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450923, '', '博白县', 2098, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450924, '', '兴业县', 2099, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (450981, '', '北流市', 2100, 'COUNTY', 4509, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451002, '', '右江区', 2101, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451003, '', '田阳区', 2102, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451022, '', '田东县', 2103, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451023, '', '平果县', 2104, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451024, '', '德保县', 2105, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451026, '', '那坡县', 2106, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451027, '', '凌云县', 2107, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451028, '', '乐业县', 2108, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451029, '', '田林县', 2109, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451030, '', '西林县', 2110, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451031, '', '隆林各族自治县', 2111, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451081, '', '靖西市', 2112, 'COUNTY', 4510, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451102, '', '八步区', 2113, 'COUNTY', 4511, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451103, '', '平桂区', 2114, 'COUNTY', 4511, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451121, '', '昭平县', 2115, 'COUNTY', 4511, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451122, '', '钟山县', 2116, 'COUNTY', 4511, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451123, '', '富川瑶族自治县', 2117, 'COUNTY', 4511, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451202, '', '金城江区', 2118, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451203, '', '宜州区', 2119, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451221, '', '南丹县', 2120, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451222, '', '天峨县', 2121, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451223, '', '凤山县', 2122, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451224, '', '东兰县', 2123, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451225, '', '罗城仫佬族自治县', 2124, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451226, '', '环江毛南族自治县', 2125, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451227, '', '巴马瑶族自治县', 2126, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451228, '', '都安瑶族自治县', 2127, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451229, '', '大化瑶族自治县', 2128, 'COUNTY', 4512, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451302, '', '兴宾区', 2129, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451321, '', '忻城县', 2130, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451322, '', '象州县', 2131, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451323, '', '武宣县', 2132, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451324, '', '金秀瑶族自治县', 2133, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451381, '', '合山市', 2134, 'COUNTY', 4513, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451402, '', '江州区', 2135, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451421, '', '扶绥县', 2136, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451422, '', '宁明县', 2137, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451423, '', '龙州县', 2138, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451424, '', '大新县', 2139, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451425, '', '天等县', 2140, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (451481, '', '凭祥市', 2141, 'COUNTY', 4514, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460105, '', '秀英区', 2142, 'COUNTY', 4601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460106, '', '龙华区', 2143, 'COUNTY', 4601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460107, '', '琼山区', 2144, 'COUNTY', 4601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460108, '', '美兰区', 2145, 'COUNTY', 4601, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460202, '', '海棠区', 2146, 'COUNTY', 4602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460203, '', '吉阳区', 2147, 'COUNTY', 4602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460204, '', '天涯区', 2148, 'COUNTY', 4602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460205, '', '崖州区', 2149, 'COUNTY', 4602, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460321, '', '西沙群岛', 2150, 'COUNTY', 4603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460322, '', '南沙群岛', 2151, 'COUNTY', 4603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460323, '', '中沙群岛的岛礁及其海域', 2152, 'COUNTY', 4603, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469001, '', '五指山市', 2171, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469002, '', '琼海市', 2172, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469005, '', '文昌市', 2173, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469006, '', '万宁市', 2174, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469007, '', '东方市', 2175, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469021, '', '定安县', 2176, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469022, '', '屯昌县', 2177, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469023, '', '澄迈县', 2178, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469024, '', '临高县', 2179, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469025, '', '白沙黎族自治县', 2180, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469026, '', '昌江黎族自治县', 2181, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469027, '', '乐东黎族自治县', 2182, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469028, '', '陵水黎族自治县', 2183, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469029, '', '保亭黎族苗族自治县', 2184, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (469030, '', '琼中黎族苗族自治县', 2185, 'COUNTY', 4690, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500101, '', '万州区', 2186, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500102, '', '涪陵区', 2187, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500103, '', '渝中区', 2188, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500104, '', '大渡口区', 2189, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500105, '', '江北区', 2190, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500106, '', '沙坪坝区', 2191, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500107, '', '九龙坡区', 2192, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500108, '', '南岸区', 2193, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500109, '', '北碚区', 2194, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500110, '', '綦江区', 2195, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500111, '', '大足区', 2196, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500112, '', '渝北区', 2197, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500113, '', '巴南区', 2198, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500114, '', '黔江区', 2199, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500115, '', '长寿区', 2200, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500116, '', '江津区', 2201, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500117, '', '合川区', 2202, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500118, '', '永川区', 2203, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500119, '', '南川区', 2204, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500120, '', '璧山区', 2205, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500151, '', '铜梁区', 2206, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500152, '', '潼南区', 2207, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500153, '', '荣昌区', 2208, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500154, '', '开州区', 2209, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500155, '', '梁平区', 2210, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500156, '', '武隆区', 2211, 'COUNTY', 5001, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500229, '', '城口县', 2212, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500230, '', '丰都县', 2213, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500231, '', '垫江县', 2214, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500233, '', '忠县', 2215, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500235, '', '云阳县', 2216, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500236, '', '奉节县', 2217, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500237, '', '巫山县', 2218, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500238, '', '巫溪县', 2219, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500240, '', '石柱土家族自治县', 2220, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500241, '', '秀山土家族苗族自治县', 2221, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500242, '', '酉阳土家族苗族自治县', 2222, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (500243, '', '彭水苗族土家族自治县', 2223, 'COUNTY', 5002, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510104, '', '锦江区', 2224, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510105, '', '青羊区', 2225, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510106, '', '金牛区', 2226, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510107, '', '武侯区', 2227, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510108, '', '成华区', 2228, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510112, '', '龙泉驿区', 2229, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510113, '', '青白江区', 2230, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510114, '', '新都区', 2231, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510115, '', '温江区', 2232, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510116, '', '双流区', 2233, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510117, '', '郫都区', 2234, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510121, '', '金堂县', 2235, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510129, '', '大邑县', 2236, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510131, '', '蒲江县', 2237, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510132, '', '新津县', 2238, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510181, '', '都江堰市', 2239, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510182, '', '彭州市', 2240, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510183, '', '邛崃市', 2241, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510184, '', '崇州市', 2242, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510185, '', '简阳市', 2243, 'COUNTY', 5101, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510302, '', '自流井区', 2244, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510303, '', '贡井区', 2245, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510304, '', '大安区', 2246, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510311, '', '沿滩区', 2247, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510321, '', '荣县', 2248, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510322, '', '富顺县', 2249, 'COUNTY', 5103, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510402, '', '东区', 2250, 'COUNTY', 5104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510403, '', '西区', 2251, 'COUNTY', 5104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510411, '', '仁和区', 2252, 'COUNTY', 5104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510421, '', '米易县', 2253, 'COUNTY', 5104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510422, '', '盐边县', 2254, 'COUNTY', 5104, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510502, '', '江阳区', 2255, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510503, '', '纳溪区', 2256, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510504, '', '龙马潭区', 2257, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510521, '', '泸县', 2258, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510522, '', '合江县', 2259, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510524, '', '叙永县', 2260, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510525, '', '古蔺县', 2261, 'COUNTY', 5105, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510603, '', '旌阳区', 2262, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510604, '', '罗江区', 2263, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510623, '', '中江县', 2264, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510681, '', '广汉市', 2265, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510682, '', '什邡市', 2266, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510683, '', '绵竹市', 2267, 'COUNTY', 5106, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510703, '', '涪城区', 2268, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510704, '', '游仙区', 2269, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510705, '', '安州区', 2270, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510722, '', '三台县', 2271, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510723, '', '盐亭县', 2272, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510725, '', '梓潼县', 2273, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510726, '', '北川羌族自治县', 2274, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510727, '', '平武县', 2275, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510781, '', '江油市', 2276, 'COUNTY', 5107, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510802, '', '利州区', 2277, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510811, '', '昭化区', 2278, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510812, '', '朝天区', 2279, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510821, '', '旺苍县', 2280, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510822, '', '青川县', 2281, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510823, '', '剑阁县', 2282, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510824, '', '苍溪县', 2283, 'COUNTY', 5108, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510903, '', '船山区', 2284, 'COUNTY', 5109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510904, '', '安居区', 2285, 'COUNTY', 5109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510921, '', '蓬溪县', 2286, 'COUNTY', 5109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510923, '', '大英县', 2287, 'COUNTY', 5109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (510981, '', '射洪市', 2288, 'COUNTY', 5109, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511002, '', '市中区', 2289, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511011, '', '东兴区', 2290, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511024, '', '威远县', 2291, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511025, '', '资中县', 2292, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511071, '', '内江经济开发区', 2293, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511083, '', '隆昌市', 2294, 'COUNTY', 5110, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511102, '', '市中区', 2295, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511111, '', '沙湾区', 2296, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511112, '', '五通桥区', 2297, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511113, '', '金口河区', 2298, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511123, '', '犍为县', 2299, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511124, '', '井研县', 2300, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511126, '', '夹江县', 2301, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511129, '', '沐川县', 2302, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511132, '', '峨边彝族自治县', 2303, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511133, '', '马边彝族自治县', 2304, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511181, '', '峨眉山市', 2305, 'COUNTY', 5111, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511302, '', '顺庆区', 2306, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511303, '', '高坪区', 2307, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511304, '', '嘉陵区', 2308, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511321, '', '南部县', 2309, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511322, '', '营山县', 2310, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511323, '', '蓬安县', 2311, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511324, '', '仪陇县', 2312, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511325, '', '西充县', 2313, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511381, '', '阆中市', 2314, 'COUNTY', 5113, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511402, '', '东坡区', 2315, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511403, '', '彭山区', 2316, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511421, '', '仁寿县', 2317, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511423, '', '洪雅县', 2318, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511424, '', '丹棱县', 2319, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511425, '', '青神县', 2320, 'COUNTY', 5114, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511502, '', '翠屏区', 2321, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511503, '', '南溪区', 2322, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511504, '', '叙州区', 2323, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511523, '', '江安县', 2324, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511524, '', '长宁县', 2325, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511525, '', '高县', 2326, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511526, '', '珙县', 2327, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511527, '', '筠连县', 2328, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511528, '', '兴文县', 2329, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511529, '', '屏山县', 2330, 'COUNTY', 5115, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511602, '', '广安区', 2331, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511603, '', '前锋区', 2332, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511621, '', '岳池县', 2333, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511622, '', '武胜县', 2334, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511623, '', '邻水县', 2335, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511681, '', '华蓥市', 2336, 'COUNTY', 5116, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511702, '', '通川区', 2337, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511703, '', '达川区', 2338, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511722, '', '宣汉县', 2339, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511723, '', '开江县', 2340, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511724, '', '大竹县', 2341, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511725, '', '渠县', 2342, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511771, '', '达州经济开发区', 2343, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511781, '', '万源市', 2344, 'COUNTY', 5117, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511802, '', '雨城区', 2345, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511803, '', '名山区', 2346, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511822, '', '荥经县', 2347, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511823, '', '汉源县', 2348, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511824, '', '石棉县', 2349, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511825, '', '天全县', 2350, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511826, '', '芦山县', 2351, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511827, '', '宝兴县', 2352, 'COUNTY', 5118, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511902, '', '巴州区', 2353, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511903, '', '恩阳区', 2354, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511921, '', '通江县', 2355, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511922, '', '南江县', 2356, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511923, '', '平昌县', 2357, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (511971, '', '巴中经济开发区', 2358, 'COUNTY', 5119, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (512002, '', '雁江区', 2359, 'COUNTY', 5120, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (512021, '', '安岳县', 2360, 'COUNTY', 5120, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (512022, '', '乐至县', 2361, 'COUNTY', 5120, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513201, '', '马尔康市', 2362, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513221, '', '汶川县', 2363, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513222, '', '理县', 2364, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513223, '', '茂县', 2365, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513224, '', '松潘县', 2366, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513225, '', '九寨沟县', 2367, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513226, '', '金川县', 2368, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513227, '', '小金县', 2369, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513228, '', '黑水县', 2370, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513230, '', '壤塘县', 2371, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513231, '', '阿坝县', 2372, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513232, '', '若尔盖县', 2373, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513233, '', '红原县', 2374, 'COUNTY', 5132, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513301, '', '康定市', 2375, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513322, '', '泸定县', 2376, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513323, '', '丹巴县', 2377, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513324, '', '九龙县', 2378, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513325, '', '雅江县', 2379, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513326, '', '道孚县', 2380, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513327, '', '炉霍县', 2381, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513328, '', '甘孜县', 2382, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513329, '', '新龙县', 2383, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513330, '', '德格县', 2384, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513331, '', '白玉县', 2385, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513332, '', '石渠县', 2386, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513333, '', '色达县', 2387, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513334, '', '理塘县', 2388, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513335, '', '巴塘县', 2389, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513336, '', '乡城县', 2390, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513337, '', '稻城县', 2391, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513338, '', '得荣县', 2392, 'COUNTY', 5133, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513401, '', '西昌市', 2393, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513422, '', '木里藏族自治县', 2394, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513423, '', '盐源县', 2395, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513424, '', '德昌县', 2396, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513425, '', '会理县', 2397, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513426, '', '会东县', 2398, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513427, '', '宁南县', 2399, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513428, '', '普格县', 2400, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513429, '', '布拖县', 2401, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513430, '', '金阳县', 2402, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513431, '', '昭觉县', 2403, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513432, '', '喜德县', 2404, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513433, '', '冕宁县', 2405, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513434, '', '越西县', 2406, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513435, '', '甘洛县', 2407, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513436, '', '美姑县', 2408, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (513437, '', '雷波县', 2409, 'COUNTY', 5134, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520102, '', '南明区', 2410, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520103, '', '云岩区', 2411, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520111, '', '花溪区', 2412, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520112, '', '乌当区', 2413, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520113, '', '白云区', 2414, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520115, '', '观山湖区', 2415, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520121, '', '开阳县', 2416, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520122, '', '息烽县', 2417, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520123, '', '修文县', 2418, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520181, '', '清镇市', 2419, 'COUNTY', 5201, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520201, '', '钟山区', 2420, 'COUNTY', 5202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520203, '', '六枝特区', 2421, 'COUNTY', 5202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520221, '', '水城县', 2422, 'COUNTY', 5202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520281, '', '盘州市', 2423, 'COUNTY', 5202, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520302, '', '红花岗区', 2424, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520303, '', '汇川区', 2425, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520304, '', '播州区', 2426, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520322, '', '桐梓县', 2427, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520323, '', '绥阳县', 2428, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520324, '', '正安县', 2429, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520325, '', '道真仡佬族苗族自治县', 2430, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520326, '', '务川仡佬族苗族自治县', 2431, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520327, '', '凤冈县', 2432, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520328, '', '湄潭县', 2433, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520329, '', '余庆县', 2434, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520330, '', '习水县', 2435, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520381, '', '赤水市', 2436, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520382, '', '仁怀市', 2437, 'COUNTY', 5203, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520402, '', '西秀区', 2438, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520403, '', '平坝区', 2439, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520422, '', '普定县', 2440, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520423, '', '镇宁布依族苗族自治县', 2441, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520424, '', '关岭布依族苗族自治县', 2442, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520425, '', '紫云苗族布依族自治县', 2443, 'COUNTY', 5204, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520502, '', '七星关区', 2444, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520521, '', '大方县', 2445, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520522, '', '黔西县', 2446, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520523, '', '金沙县', 2447, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520524, '', '织金县', 2448, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520525, '', '纳雍县', 2449, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520526, '', '威宁彝族回族苗族自治县', 2450, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520527, '', '赫章县', 2451, 'COUNTY', 5205, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520602, '', '碧江区', 2452, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520603, '', '万山区', 2453, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520621, '', '江口县', 2454, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520622, '', '玉屏侗族自治县', 2455, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520623, '', '石阡县', 2456, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520624, '', '思南县', 2457, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520625, '', '印江土家族苗族自治县', 2458, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520626, '', '德江县', 2459, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520627, '', '沿河土家族自治县', 2460, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (520628, '', '松桃苗族自治县', 2461, 'COUNTY', 5206, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522301, '', '兴义市', 2462, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522302, '', '兴仁市', 2463, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522323, '', '普安县', 2464, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522324, '', '晴隆县', 2465, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522325, '', '贞丰县', 2466, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522326, '', '望谟县', 2467, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522327, '', '册亨县', 2468, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522328, '', '安龙县', 2469, 'COUNTY', 5223, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522601, '', '凯里市', 2470, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522622, '', '黄平县', 2471, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522623, '', '施秉县', 2472, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522624, '', '三穗县', 2473, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522625, '', '镇远县', 2474, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522626, '', '岑巩县', 2475, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522627, '', '天柱县', 2476, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522628, '', '锦屏县', 2477, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522629, '', '剑河县', 2478, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522630, '', '台江县', 2479, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522631, '', '黎平县', 2480, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522632, '', '榕江县', 2481, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522633, '', '从江县', 2482, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522634, '', '雷山县', 2483, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522635, '', '麻江县', 2484, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522636, '', '丹寨县', 2485, 'COUNTY', 5226, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522701, '', '都匀市', 2486, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522702, '', '福泉市', 2487, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522722, '', '荔波县', 2488, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522723, '', '贵定县', 2489, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522725, '', '瓮安县', 2490, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522726, '', '独山县', 2491, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522727, '', '平塘县', 2492, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522728, '', '罗甸县', 2493, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522729, '', '长顺县', 2494, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522730, '', '龙里县', 2495, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522731, '', '惠水县', 2496, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (522732, '', '三都水族自治县', 2497, 'COUNTY', 5227, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530102, '', '五华区', 2498, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530103, '', '盘龙区', 2499, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530111, '', '官渡区', 2500, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530112, '', '西山区', 2501, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530113, '', '东川区', 2502, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530114, '', '呈贡区', 2503, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530115, '', '晋宁区', 2504, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530124, '', '富民县', 2505, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530125, '', '宜良县', 2506, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530126, '', '石林彝族自治县', 2507, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530127, '', '嵩明县', 2508, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530128, '', '禄劝彝族苗族自治县', 2509, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530129, '', '寻甸回族彝族自治县', 2510, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530181, '', '安宁市', 2511, 'COUNTY', 5301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530302, '', '麒麟区', 2512, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530303, '', '沾益区', 2513, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530304, '', '马龙区', 2514, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530322, '', '陆良县', 2515, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530323, '', '师宗县', 2516, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530324, '', '罗平县', 2517, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530325, '', '富源县', 2518, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530326, '', '会泽县', 2519, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530381, '', '宣威市', 2520, 'COUNTY', 5303, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530402, '', '红塔区', 2521, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530403, '', '江川区', 2522, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530422, '', '澄江县', 2523, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530423, '', '通海县', 2524, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530424, '', '华宁县', 2525, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530425, '', '易门县', 2526, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530426, '', '峨山彝族自治县', 2527, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530427, '', '新平彝族傣族自治县', 2528, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530428, '', '元江哈尼族彝族傣族自治县', 2529, 'COUNTY', 5304, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530502, '', '隆阳区', 2530, 'COUNTY', 5305, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530521, '', '施甸县', 2531, 'COUNTY', 5305, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530523, '', '龙陵县', 2532, 'COUNTY', 5305, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530524, '', '昌宁县', 2533, 'COUNTY', 5305, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530581, '', '腾冲市', 2534, 'COUNTY', 5305, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530602, '', '昭阳区', 2535, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530621, '', '鲁甸县', 2536, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530622, '', '巧家县', 2537, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530623, '', '盐津县', 2538, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530624, '', '大关县', 2539, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530625, '', '永善县', 2540, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530626, '', '绥江县', 2541, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530627, '', '镇雄县', 2542, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530628, '', '彝良县', 2543, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530629, '', '威信县', 2544, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530681, '', '水富市', 2545, 'COUNTY', 5306, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530702, '', '古城区', 2546, 'COUNTY', 5307, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530721, '', '玉龙纳西族自治县', 2547, 'COUNTY', 5307, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530722, '', '永胜县', 2548, 'COUNTY', 5307, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530723, '', '华坪县', 2549, 'COUNTY', 5307, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530724, '', '宁蒗彝族自治县', 2550, 'COUNTY', 5307, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530802, '', '思茅区', 2551, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530821, '', '宁洱哈尼族彝族自治县', 2552, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530822, '', '墨江哈尼族自治县', 2553, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530823, '', '景东彝族自治县', 2554, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530824, '', '景谷傣族彝族自治县', 2555, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530825, '', '镇沅彝族哈尼族拉祜族自治县', 2556, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530826, '', '江城哈尼族彝族自治县', 2557, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530827, '', '孟连傣族拉祜族佤族自治县', 2558, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530828, '', '澜沧拉祜族自治县', 2559, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530829, '', '西盟佤族自治县', 2560, 'COUNTY', 5308, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530902, '', '临翔区', 2561, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530921, '', '凤庆县', 2562, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530922, '', '云县', 2563, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530923, '', '永德县', 2564, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530924, '', '镇康县', 2565, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530925, '', '双江拉祜族佤族布朗族傣族自治县', 2566, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530926, '', '耿马傣族佤族自治县', 2567, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (530927, '', '沧源佤族自治县', 2568, 'COUNTY', 5309, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532301, '', '楚雄市', 2569, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532322, '', '双柏县', 2570, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532323, '', '牟定县', 2571, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532324, '', '南华县', 2572, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532325, '', '姚安县', 2573, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532326, '', '大姚县', 2574, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532327, '', '永仁县', 2575, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532328, '', '元谋县', 2576, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532329, '', '武定县', 2577, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532331, '', '禄丰县', 2578, 'COUNTY', 5323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532501, '', '个旧市', 2579, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532502, '', '开远市', 2580, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532503, '', '蒙自市', 2581, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532504, '', '弥勒市', 2582, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532523, '', '屏边苗族自治县', 2583, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532524, '', '建水县', 2584, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532525, '', '石屏县', 2585, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532527, '', '泸西县', 2586, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532528, '', '元阳县', 2587, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532529, '', '红河县', 2588, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532530, '', '金平苗族瑶族傣族自治县', 2589, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532531, '', '绿春县', 2590, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532532, '', '河口瑶族自治县', 2591, 'COUNTY', 5325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532601, '', '文山市', 2592, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532622, '', '砚山县', 2593, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532623, '', '西畴县', 2594, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532624, '', '麻栗坡县', 2595, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532625, '', '马关县', 2596, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532626, '', '丘北县', 2597, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532627, '', '广南县', 2598, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532628, '', '富宁县', 2599, 'COUNTY', 5326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532801, '', '景洪市', 2600, 'COUNTY', 5328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532822, '', '勐海县', 2601, 'COUNTY', 5328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532823, '', '勐腊县', 2602, 'COUNTY', 5328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532901, '', '大理市', 2603, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532922, '', '漾濞彝族自治县', 2604, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532923, '', '祥云县', 2605, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532924, '', '宾川县', 2606, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532925, '', '弥渡县', 2607, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532926, '', '南涧彝族自治县', 2608, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532927, '', '巍山彝族回族自治县', 2609, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532928, '', '永平县', 2610, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532929, '', '云龙县', 2611, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532930, '', '洱源县', 2612, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532931, '', '剑川县', 2613, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (532932, '', '鹤庆县', 2614, 'COUNTY', 5329, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533102, '', '瑞丽市', 2615, 'COUNTY', 5331, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533103, '', '芒市', 2616, 'COUNTY', 5331, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533122, '', '梁河县', 2617, 'COUNTY', 5331, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533123, '', '盈江县', 2618, 'COUNTY', 5331, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533124, '', '陇川县', 2619, 'COUNTY', 5331, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533301, '', '泸水市', 2620, 'COUNTY', 5333, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533323, '', '福贡县', 2621, 'COUNTY', 5333, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533324, '', '贡山独龙族怒族自治县', 2622, 'COUNTY', 5333, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533325, '', '兰坪白族普米族自治县', 2623, 'COUNTY', 5333, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533401, '', '香格里拉市', 2624, 'COUNTY', 5334, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533422, '', '德钦县', 2625, 'COUNTY', 5334, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (533423, '', '维西傈僳族自治县', 2626, 'COUNTY', 5334, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540102, '', '城关区', 2627, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540103, '', '堆龙德庆区', 2628, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540104, '', '达孜区', 2629, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540121, '', '林周县', 2630, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540122, '', '当雄县', 2631, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540123, '', '尼木县', 2632, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540124, '', '曲水县', 2633, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540127, '', '墨竹工卡县', 2634, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540171, '', '格尔木藏青工业园区', 2635, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540172, '', '拉萨经济技术开发区', 2636, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540173, '', '西藏文化旅游创意园区', 2637, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540174, '', '达孜工业园区', 2638, 'COUNTY', 5401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540202, '', '桑珠孜区', 2639, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540221, '', '南木林县', 2640, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540222, '', '江孜县', 2641, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540223, '', '定日县', 2642, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540224, '', '萨迦县', 2643, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540225, '', '拉孜县', 2644, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540226, '', '昂仁县', 2645, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540227, '', '谢通门县', 2646, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540228, '', '白朗县', 2647, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540229, '', '仁布县', 2648, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540230, '', '康马县', 2649, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540231, '', '定结县', 2650, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540232, '', '仲巴县', 2651, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540233, '', '亚东县', 2652, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540234, '', '吉隆县', 2653, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540235, '', '聂拉木县', 2654, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540236, '', '萨嘎县', 2655, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540237, '', '岗巴县', 2656, 'COUNTY', 5402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540302, '', '卡若区', 2657, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540321, '', '江达县', 2658, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540322, '', '贡觉县', 2659, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540323, '', '类乌齐县', 2660, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540324, '', '丁青县', 2661, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540325, '', '察雅县', 2662, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540326, '', '八宿县', 2663, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540327, '', '左贡县', 2664, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540328, '', '芒康县', 2665, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540329, '', '洛隆县', 2666, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540330, '', '边坝县', 2667, 'COUNTY', 5403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540402, '', '巴宜区', 2668, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540421, '', '工布江达县', 2669, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540422, '', '米林县', 2670, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540423, '', '墨脱县', 2671, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540424, '', '波密县', 2672, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540425, '', '察隅县', 2673, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540426, '', '朗县', 2674, 'COUNTY', 5404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540502, '', '乃东区', 2675, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540521, '', '扎囊县', 2676, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540522, '', '贡嘎县', 2677, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540523, '', '桑日县', 2678, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540524, '', '琼结县', 2679, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540525, '', '曲松县', 2680, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540526, '', '措美县', 2681, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540527, '', '洛扎县', 2682, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540528, '', '加查县', 2683, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540529, '', '隆子县', 2684, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540530, '', '错那县', 2685, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540531, '', '浪卡子县', 2686, 'COUNTY', 5405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540602, '', '色尼区', 2687, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540621, '', '嘉黎县', 2688, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540622, '', '比如县', 2689, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540623, '', '聂荣县', 2690, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540624, '', '安多县', 2691, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540625, '', '申扎县', 2692, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540626, '', '索县', 2693, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540627, '', '班戈县', 2694, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540628, '', '巴青县', 2695, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540629, '', '尼玛县', 2696, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (540630, '', '双湖县', 2697, 'COUNTY', 5406, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542521, '', '普兰县', 2698, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542522, '', '札达县', 2699, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542523, '', '噶尔县', 2700, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542524, '', '日土县', 2701, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542525, '', '革吉县', 2702, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542526, '', '改则县', 2703, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (542527, '', '措勤县', 2704, 'COUNTY', 5425, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610102, '', '新城区', 2705, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610103, '', '碑林区', 2706, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610104, '', '莲湖区', 2707, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610111, '', '灞桥区', 2708, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610112, '', '未央区', 2709, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610113, '', '雁塔区', 2710, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610114, '', '阎良区', 2711, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610115, '', '临潼区', 2712, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610116, '', '长安区', 2713, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610117, '', '高陵区', 2714, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610118, '', '鄠邑区', 2715, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610122, '', '蓝田县', 2716, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610124, '', '周至县', 2717, 'COUNTY', 6101, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610202, '', '王益区', 2718, 'COUNTY', 6102, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610203, '', '印台区', 2719, 'COUNTY', 6102, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610204, '', '耀州区', 2720, 'COUNTY', 6102, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610222, '', '宜君县', 2721, 'COUNTY', 6102, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610302, '', '渭滨区', 2722, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610303, '', '金台区', 2723, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610304, '', '陈仓区', 2724, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610322, '', '凤翔县', 2725, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610323, '', '岐山县', 2726, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610324, '', '扶风县', 2727, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610326, '', '眉县', 2728, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610327, '', '陇县', 2729, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610328, '', '千阳县', 2730, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610329, '', '麟游县', 2731, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610330, '', '凤县', 2732, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610331, '', '太白县', 2733, 'COUNTY', 6103, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610402, '', '秦都区', 2734, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610403, '', '杨陵区', 2735, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610404, '', '渭城区', 2736, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610422, '', '三原县', 2737, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610423, '', '泾阳县', 2738, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610424, '', '乾县', 2739, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610425, '', '礼泉县', 2740, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610426, '', '永寿县', 2741, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610428, '', '长武县', 2742, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610429, '', '旬邑县', 2743, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610430, '', '淳化县', 2744, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610431, '', '武功县', 2745, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610481, '', '兴平市', 2746, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610482, '', '彬州市', 2747, 'COUNTY', 6104, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610502, '', '临渭区', 2748, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610503, '', '华州区', 2749, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610522, '', '潼关县', 2750, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610523, '', '大荔县', 2751, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610524, '', '合阳县', 2752, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610525, '', '澄城县', 2753, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610526, '', '蒲城县', 2754, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610527, '', '白水县', 2755, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610528, '', '富平县', 2756, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610581, '', '韩城市', 2757, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610582, '', '华阴市', 2758, 'COUNTY', 6105, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610602, '', '宝塔区', 2759, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610603, '', '安塞区', 2760, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610621, '', '延长县', 2761, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610622, '', '延川县', 2762, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610625, '', '志丹县', 2763, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610626, '', '吴起县', 2764, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610627, '', '甘泉县', 2765, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610628, '', '富县', 2766, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610629, '', '洛川县', 2767, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610630, '', '宜川县', 2768, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610631, '', '黄龙县', 2769, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610632, '', '黄陵县', 2770, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610681, '', '子长市', 2771, 'COUNTY', 6106, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610702, '', '汉台区', 2772, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610703, '', '南郑区', 2773, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610722, '', '城固县', 2774, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610723, '', '洋县', 2775, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610724, '', '西乡县', 2776, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610725, '', '勉县', 2777, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610726, '', '宁强县', 2778, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610727, '', '略阳县', 2779, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610728, '', '镇巴县', 2780, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610729, '', '留坝县', 2781, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610730, '', '佛坪县', 2782, 'COUNTY', 6107, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610802, '', '榆阳区', 2783, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610803, '', '横山区', 2784, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610822, '', '府谷县', 2785, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610824, '', '靖边县', 2786, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610825, '', '定边县', 2787, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610826, '', '绥德县', 2788, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610827, '', '米脂县', 2789, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610828, '', '佳县', 2790, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610829, '', '吴堡县', 2791, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610830, '', '清涧县', 2792, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610831, '', '子洲县', 2793, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610881, '', '神木市', 2794, 'COUNTY', 6108, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610902, '', '汉滨区', 2795, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610921, '', '汉阴县', 2796, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610922, '', '石泉县', 2797, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610923, '', '宁陕县', 2798, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610924, '', '紫阳县', 2799, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610925, '', '岚皋县', 2800, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610926, '', '平利县', 2801, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610927, '', '镇坪县', 2802, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610928, '', '旬阳县', 2803, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (610929, '', '白河县', 2804, 'COUNTY', 6109, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611002, '', '商州区', 2805, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611021, '', '洛南县', 2806, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611022, '', '丹凤县', 2807, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611023, '', '商南县', 2808, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611024, '', '山阳县', 2809, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611025, '', '镇安县', 2810, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (611026, '', '柞水县', 2811, 'COUNTY', 6110, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620102, '', '城关区', 2812, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620103, '', '七里河区', 2813, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620104, '', '西固区', 2814, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620105, '', '安宁区', 2815, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620111, '', '红古区', 2816, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620121, '', '永登县', 2817, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620122, '', '皋兰县', 2818, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620123, '', '榆中县', 2819, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620171, '', '兰州新区', 2820, 'COUNTY', 6201, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620302, '', '金川区', 2827, 'COUNTY', 6203, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620321, '', '永昌县', 2828, 'COUNTY', 6203, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620402, '', '白银区', 2829, 'COUNTY', 6204, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620403, '', '平川区', 2830, 'COUNTY', 6204, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620421, '', '靖远县', 2831, 'COUNTY', 6204, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620422, '', '会宁县', 2832, 'COUNTY', 6204, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620423, '', '景泰县', 2833, 'COUNTY', 6204, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620502, '', '秦州区', 2834, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620503, '', '麦积区', 2835, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620521, '', '清水县', 2836, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620522, '', '秦安县', 2837, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620523, '', '甘谷县', 2838, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620524, '', '武山县', 2839, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620525, '', '张家川回族自治县', 2840, 'COUNTY', 6205, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620602, '', '凉州区', 2841, 'COUNTY', 6206, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620621, '', '民勤县', 2842, 'COUNTY', 6206, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620622, '', '古浪县', 2843, 'COUNTY', 6206, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620623, '', '天祝藏族自治县', 2844, 'COUNTY', 6206, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620702, '', '甘州区', 2845, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620721, '', '肃南裕固族自治县', 2846, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620722, '', '民乐县', 2847, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620723, '', '临泽县', 2848, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620724, '', '高台县', 2849, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620725, '', '山丹县', 2850, 'COUNTY', 6207, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620802, '', '崆峒区', 2851, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620821, '', '泾川县', 2852, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620822, '', '灵台县', 2853, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620823, '', '崇信县', 2854, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620825, '', '庄浪县', 2855, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620826, '', '静宁县', 2856, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620881, '', '华亭市', 2857, 'COUNTY', 6208, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620902, '', '肃州区', 2858, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620921, '', '金塔县', 2859, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620922, '', '瓜州县', 2860, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620923, '', '肃北蒙古族自治县', 2861, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620924, '', '阿克塞哈萨克族自治县', 2862, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620981, '', '玉门市', 2863, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620982, '', '敦煌市', 2864, 'COUNTY', 6209, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621002, '', '西峰区', 2865, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621021, '', '庆城县', 2866, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621022, '', '环县', 2867, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621023, '', '华池县', 2868, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621024, '', '合水县', 2869, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621025, '', '正宁县', 2870, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621026, '', '宁县', 2871, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621027, '', '镇原县', 2872, 'COUNTY', 6210, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621102, '', '安定区', 2873, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621121, '', '通渭县', 2874, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621122, '', '陇西县', 2875, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621123, '', '渭源县', 2876, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621124, '', '临洮县', 2877, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621125, '', '漳县', 2878, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621126, '', '岷县', 2879, 'COUNTY', 6211, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621202, '', '武都区', 2880, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621221, '', '成县', 2881, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621222, '', '文县', 2882, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621223, '', '宕昌县', 2883, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621224, '', '康县', 2884, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621225, '', '西和县', 2885, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621226, '', '礼县', 2886, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621227, '', '徽县', 2887, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (621228, '', '两当县', 2888, 'COUNTY', 6212, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622901, '', '临夏市', 2889, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622921, '', '临夏县', 2890, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622922, '', '康乐县', 2891, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622923, '', '永靖县', 2892, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622924, '', '广河县', 2893, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622925, '', '和政县', 2894, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622926, '', '东乡族自治县', 2895, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (622927, '', '积石山保安族东乡族撒拉族自治县', 2896, 'COUNTY', 6229, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623001, '', '合作市', 2897, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623021, '', '临潭县', 2898, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623022, '', '卓尼县', 2899, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623023, '', '舟曲县', 2900, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623024, '', '迭部县', 2901, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623025, '', '玛曲县', 2902, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623026, '', '碌曲县', 2903, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (623027, '', '夏河县', 2904, 'COUNTY', 6230, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630102, '', '城东区', 2905, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630103, '', '城中区', 2906, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630104, '', '城西区', 2907, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630105, '', '城北区', 2908, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630121, '', '大通回族土族自治县', 2909, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630122, '', '湟中县', 2910, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630123, '', '湟源县', 2911, 'COUNTY', 6301, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630202, '', '乐都区', 2912, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630203, '', '平安区', 2913, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630222, '', '民和回族土族自治县', 2914, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630223, '', '互助土族自治县', 2915, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630224, '', '化隆回族自治县', 2916, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (630225, '', '循化撒拉族自治县', 2917, 'COUNTY', 6302, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632221, '', '门源回族自治县', 2918, 'COUNTY', 6322, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632222, '', '祁连县', 2919, 'COUNTY', 6322, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632223, '', '海晏县', 2920, 'COUNTY', 6322, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632224, '', '刚察县', 2921, 'COUNTY', 6322, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632321, '', '同仁县', 2922, 'COUNTY', 6323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632322, '', '尖扎县', 2923, 'COUNTY', 6323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632323, '', '泽库县', 2924, 'COUNTY', 6323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632324, '', '河南蒙古族自治县', 2925, 'COUNTY', 6323, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632521, '', '共和县', 2926, 'COUNTY', 6325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632522, '', '同德县', 2927, 'COUNTY', 6325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632523, '', '贵德县', 2928, 'COUNTY', 6325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632524, '', '兴海县', 2929, 'COUNTY', 6325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632525, '', '贵南县', 2930, 'COUNTY', 6325, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632621, '', '玛沁县', 2931, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632622, '', '班玛县', 2932, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632623, '', '甘德县', 2933, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632624, '', '达日县', 2934, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632625, '', '久治县', 2935, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632626, '', '玛多县', 2936, 'COUNTY', 6326, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632701, '', '玉树市', 2937, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632722, '', '杂多县', 2938, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632723, '', '称多县', 2939, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632724, '', '治多县', 2940, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632725, '', '囊谦县', 2941, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632726, '', '曲麻莱县', 2942, 'COUNTY', 6327, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632801, '', '格尔木市', 2943, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632802, '', '德令哈市', 2944, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632803, '', '茫崖市', 2945, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632821, '', '乌兰县', 2946, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632822, '', '都兰县', 2947, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632823, '', '天峻县', 2948, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (632857, '', '大柴旦行政委员会', 2949, 'COUNTY', 6328, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640104, '', '兴庆区', 2950, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640105, '', '西夏区', 2951, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640106, '', '金凤区', 2952, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640121, '', '永宁县', 2953, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640122, '', '贺兰县', 2954, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640181, '', '灵武市', 2955, 'COUNTY', 6401, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640202, '', '大武口区', 2956, 'COUNTY', 6402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640205, '', '惠农区', 2957, 'COUNTY', 6402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640221, '', '平罗县', 2958, 'COUNTY', 6402, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640302, '', '利通区', 2959, 'COUNTY', 6403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640303, '', '红寺堡区', 2960, 'COUNTY', 6403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640323, '', '盐池县', 2961, 'COUNTY', 6403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640324, '', '同心县', 2962, 'COUNTY', 6403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640381, '', '青铜峡市', 2963, 'COUNTY', 6403, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640402, '', '原州区', 2964, 'COUNTY', 6404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640422, '', '西吉县', 2965, 'COUNTY', 6404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640423, '', '隆德县', 2966, 'COUNTY', 6404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640424, '', '泾源县', 2967, 'COUNTY', 6404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640425, '', '彭阳县', 2968, 'COUNTY', 6404, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640502, '', '沙坡头区', 2969, 'COUNTY', 6405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640521, '', '中宁县', 2970, 'COUNTY', 6405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (640522, '', '海原县', 2971, 'COUNTY', 6405, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650102, '', '天山区', 2972, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650103, '', '沙依巴克区', 2973, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650104, '', '新市区', 2974, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650105, '', '水磨沟区', 2975, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650106, '', '头屯河区', 2976, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650107, '', '达坂城区', 2977, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650109, '', '米东区', 2978, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650121, '', '乌鲁木齐县', 2979, 'COUNTY', 6501, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650202, '', '独山子区', 2980, 'COUNTY', 6502, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650203, '', '克拉玛依区', 2981, 'COUNTY', 6502, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650204, '', '白碱滩区', 2982, 'COUNTY', 6502, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650205, '', '乌尔禾区', 2983, 'COUNTY', 6502, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650402, '', '高昌区', 2984, 'COUNTY', 6504, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650421, '', '鄯善县', 2985, 'COUNTY', 6504, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650422, '', '托克逊县', 2986, 'COUNTY', 6504, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650502, '', '伊州区', 2987, 'COUNTY', 6505, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650521, '', '巴里坤哈萨克自治县', 2988, 'COUNTY', 6505, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (650522, '', '伊吾县', 2989, 'COUNTY', 6505, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652301, '', '昌吉市', 2990, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652302, '', '阜康市', 2991, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652323, '', '呼图壁县', 2992, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652324, '', '玛纳斯县', 2993, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652325, '', '奇台县', 2994, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652327, '', '吉木萨尔县', 2995, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652328, '', '木垒哈萨克自治县', 2996, 'COUNTY', 6523, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652701, '', '博乐市', 2997, 'COUNTY', 6527, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652702, '', '阿拉山口市', 2998, 'COUNTY', 6527, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652722, '', '精河县', 2999, 'COUNTY', 6527, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652723, '', '温泉县', 3000, 'COUNTY', 6527, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652801, '', '库尔勒市', 3001, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652822, '', '轮台县', 3002, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652823, '', '尉犁县', 3003, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652824, '', '若羌县', 3004, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652825, '', '且末县', 3005, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652826, '', '焉耆回族自治县', 3006, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652827, '', '和静县', 3007, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652828, '', '和硕县', 3008, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652829, '', '博湖县', 3009, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652871, '', '库尔勒经济技术开发区', 3010, 'COUNTY', 6528, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652901, '', '阿克苏市', 3011, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652922, '', '温宿县', 3012, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652923, '', '库车县', 3013, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652924, '', '沙雅县', 3014, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652925, '', '新和县', 3015, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652926, '', '拜城县', 3016, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652927, '', '乌什县', 3017, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652928, '', '阿瓦提县', 3018, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (652929, '', '柯坪县', 3019, 'COUNTY', 6529, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653001, '', '阿图什市', 3020, 'COUNTY', 6530, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653022, '', '阿克陶县', 3021, 'COUNTY', 6530, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653023, '', '阿合奇县', 3022, 'COUNTY', 6530, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653024, '', '乌恰县', 3023, 'COUNTY', 6530, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653101, '', '喀什市', 3024, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653121, '', '疏附县', 3025, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653122, '', '疏勒县', 3026, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653123, '', '英吉沙县', 3027, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653124, '', '泽普县', 3028, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653125, '', '莎车县', 3029, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653126, '', '叶城县', 3030, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653127, '', '麦盖提县', 3031, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653128, '', '岳普湖县', 3032, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653129, '', '伽师县', 3033, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653130, '', '巴楚县', 3034, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653131, '', '塔什库尔干塔吉克自治县', 3035, 'COUNTY', 6531, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653201, '', '和田市', 3036, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653221, '', '和田县', 3037, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653222, '', '墨玉县', 3038, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653223, '', '皮山县', 3039, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653224, '', '洛浦县', 3040, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653225, '', '策勒县', 3041, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653226, '', '于田县', 3042, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (653227, '', '民丰县', 3043, 'COUNTY', 6532, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654002, '', '伊宁市', 3044, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654003, '', '奎屯市', 3045, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654004, '', '霍尔果斯市', 3046, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654021, '', '伊宁县', 3047, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654022, '', '察布查尔锡伯自治县', 3048, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654023, '', '霍城县', 3049, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654024, '', '巩留县', 3050, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654025, '', '新源县', 3051, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654026, '', '昭苏县', 3052, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654027, '', '特克斯县', 3053, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654028, '', '尼勒克县', 3054, 'COUNTY', 6540, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654201, '', '塔城市', 3055, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654202, '', '乌苏市', 3056, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654221, '', '额敏县', 3057, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654223, '', '沙湾县', 3058, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654224, '', '托里县', 3059, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654225, '', '裕民县', 3060, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654226, '', '和布克赛尔蒙古自治县', 3061, 'COUNTY', 6542, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654301, '', '阿勒泰市', 3062, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654321, '', '布尔津县', 3063, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654322, '', '富蕴县', 3064, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654323, '', '福海县', 3065, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654324, '', '哈巴河县', 3066, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654325, '', '青河县', 3067, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (654326, '', '吉木乃县', 3068, 'COUNTY', 6543, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (659001, '', '石河子市', 3069, 'COUNTY', 6590, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (659002, '', '阿拉尔市', 3070, 'COUNTY', 6590, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (659003, '', '图木舒克市', 3071, 'COUNTY', 6590, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (659004, '', '五家渠市', 3072, 'COUNTY', 6590, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (659006, '', '铁门关市', 3073, 'COUNTY', 6590, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900003, '', '东城街道', 1959, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900004, '', '南城街道', 1960, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900005, '', '万江街道', 1961, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900006, '', '莞城街道', 1962, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900101, '', '石碣镇', 1963, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900102, '', '石龙镇', 1964, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900103, '', '茶山镇', 1965, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900104, '', '石排镇', 1966, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900105, '', '企石镇', 1967, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900106, '', '横沥镇', 1968, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900107, '', '桥头镇', 1969, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900108, '', '谢岗镇', 1970, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900109, '', '东坑镇', 1971, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900110, '', '常平镇', 1972, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900111, '', '寮步镇', 1973, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900112, '', '樟木头镇', 1974, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900113, '', '大朗镇', 1975, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900114, '', '黄江镇', 1976, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900115, '', '清溪镇', 1977, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900116, '', '塘厦镇', 1978, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900117, '', '凤岗镇', 1979, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900118, '', '大岭山镇', 1980, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900119, '', '长安镇', 1981, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900121, '', '虎门镇', 1982, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900122, '', '厚街镇', 1983, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900123, '', '沙田镇', 1984, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900124, '', '道滘镇', 1985, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900125, '', '洪梅镇', 1986, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900126, '', '麻涌镇', 1987, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900127, '', '望牛墩镇', 1988, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900128, '', '中堂镇', 1989, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900129, '', '高埗镇', 1990, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900401, '', '松山湖', 1991, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900402, '', '东莞港', 1992, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (441900403, '', '东莞生态园', 1993, 'COUNTY', 4419, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000001, '', '石岐街道', 1994, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000002, '', '东区街道', 1995, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000003, '', '中山港街道', 1996, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000004, '', '西区街道', 1997, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000005, '', '南区街道', 1998, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000006, '', '五桂山街道', 1999, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000100, '', '小榄镇', 2000, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000101, '', '黄圃镇', 2001, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000102, '', '民众镇', 2002, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000103, '', '东凤镇', 2003, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000104, '', '东升镇', 2004, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000105, '', '古镇镇', 2005, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000106, '', '沙溪镇', 2006, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000107, '', '坦洲镇', 2007, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000108, '', '港口镇', 2008, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000109, '', '三角镇', 2009, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000110, '', '横栏镇', 2010, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000111, '', '南头镇', 2011, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000112, '', '阜沙镇', 2012, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000113, '', '南朗镇', 2013, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000114, '', '三乡镇', 2014, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000115, '', '板芙镇', 2015, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000116, '', '大涌镇', 2016, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (442000117, '', '神湾镇', 2017, 'COUNTY', 4420, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400100, '', '那大镇', 2153, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400101, '', '和庆镇', 2154, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400102, '', '南丰镇', 2155, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400103, '', '大成镇', 2156, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400104, '', '雅星镇', 2157, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400105, '', '兰洋镇', 2158, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400106, '', '光村镇', 2159, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400107, '', '木棠镇', 2160, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400108, '', '海头镇', 2161, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400109, '', '峨蔓镇', 2162, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400111, '', '王五镇', 2163, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400112, '', '白马井镇', 2164, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400113, '', '中和镇', 2165, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400114, '', '排浦镇', 2166, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400115, '', '东成镇', 2167, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400116, '', '新州镇', 2168, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400499, '', '洋浦经济开发区', 2169, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (460400500, '', '华南热作学院', 2170, 'COUNTY', 4604, '2021-01-12 13:40:09', 0, '2021-01-12 13:40:09', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201100, '', '新城镇', 2821, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201101, '', '峪泉镇', 2822, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201102, '', '文殊镇', 2823, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201401, '', '雄关区', 2824, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201402, '', '镜铁区', 2825, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `sysArea`
VALUES (620201403, '', '长城区', 2826, 'COUNTY', 6202, '2021-01-12 13:40:10', 0, '2021-01-12 13:40:10', 0,
        '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for auth_application
-- ----------------------------
DROP TABLE IF EXISTS `auth_application`;
CREATE TABLE `auth_application`
(
    `id`                     bigint                                                        NOT NULL COMMENT 'ID',
    `name`                   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '应用名称',
    `website`                varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '应用访问地址',
    `icon`                   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '应用图标地址',
    `app_type`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '类型 SERVER:服务应用;APP:手机应用;PC:PC网页应用;WAP:手机网页应用',
    `describe_`              varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '应用简介',
    `health_check`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '健康检查路径',
    `health_status`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '应用健康状况：0健康，1死亡',
    `client_id`              varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '客户端id',
    `original_client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '客户端原始密钥',
    `tenant_code`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL,
    `create_user`            bigint                                                                 DEFAULT '0' COMMENT '创建人id',
    `create_time`            datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_user`            bigint                                                                 DEFAULT '0' COMMENT '更新人id',
    `update_time`            datetime                                                               DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY                      `idx_name_realm` (`name`,`tenant_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='应用';

-- ----------------------------
-- Records of auth_application
-- ----------------------------
BEGIN;
INSERT INTO `auth_application`
VALUES (1, 'sparkzxl-cloud应用', 'http://127.0.0.1:8000', '', 'SERVER', '', 'http://127.0.0.1:8800/actuator/health', '1',
        'sparkzxl', '123456', '6055fc0465a6f7ecf13fe03a', 0, '2021-03-06 19:37:04', 1248084109452902400,
        '2021-03-17 11:29:55');
INSERT INTO `auth_application`
VALUES (1372394008333254657, 'sparkzxl-resource应用', 'http://127.0.0.1:8892', '', 'SERVER', '', NULL, '0',
        'sparkzxl-resource', '123456', '6055fc0465a6f7ecf13fe03a', 1248084109452902400, '2021-03-18 11:46:44',
        1248084109452902400, '2021-03-18 11:55:56');
COMMIT;

-- ----------------------------
-- Table structure for auth_login_log
-- ----------------------------
DROP TABLE IF EXISTS `auth_login_log`;
CREATE TABLE `auth_login_log`
(
    `id`               bigint NOT NULL COMMENT '主键',
    `request_ip`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '登录IP',
    `user_id`          bigint                                                        DEFAULT NULL COMMENT '登录人ID',
    `user_name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '登录人姓名',
    `account`          varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '登录人账号',
    `description`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '登录描述',
    `login_date`       datetime                                                      DEFAULT NULL COMMENT '登录时间',
    `ua`               varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '浏览器请求头',
    `browser`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器名称',
    `browser_version`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器版本',
    `operating_system` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作系统',
    `location`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '登录地点',
    `create_time`      datetime                                                      DEFAULT NULL,
    `create_user`      bigint                                                        DEFAULT NULL,
    `tenant_code`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY                `IDX_ACCOUNT_IP` (`account`,`request_ip`) USING BTREE,
    KEY                `IDX_BROWSER` (`browser`) USING BTREE,
    KEY                `IDX_LOGIN_DATE` (`login_date`,`account`) USING BTREE,
    KEY                `IDX_OPERATING` (`operating_system`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='登录日志';

-- ----------------------------
-- Records of auth_login_log
-- ----------------------------
BEGIN;
INSERT INTO `auth_login_log`
VALUES (1413764901479120897, '192.168.3.14', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-10 15:39:54',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Safari/537.36',
        'Chrome', '91.0.4472.101', 'Windows Windows 10 or Windows Server 2016', '内网IP', '2021-07-10 15:39:54',
        1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1413767380560248833, '192.168.3.14', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-10 15:49:45',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Safari/537.36',
        'Chrome', '91.0.4472.101', 'Windows Windows 10 or Windows Server 2016', '内网IP', '2021-07-10 15:49:45',
        1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1414054671807676416, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-11 10:51:20',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Safari/537.36',
        'Chrome', '91.0.4472.101', 'Windows Windows 10 or Windows Server 2016', '内网IP', '2021-07-11 10:51:20',
        1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1414231459322134529, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-11 22:33:50',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Safari/537.36',
        'Chrome', '91.0.4472.101', 'Windows Windows 10 or Windows Server 2016', '内网IP', '2021-07-11 22:33:50',
        1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1414604821705785345, '127.0.0.1', 1248084109452902400, '周鑫磊', 'zhouxinlei', '登录成功', '2021-07-12 23:17:26',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Safari/537.36',
        'Chrome', '91.0.4472.101', 'Windows Windows 10 or Windows Server 2016', '内网IP', '2021-07-12 23:17:26',
        1248084109452902400, NULL);
INSERT INTO `auth_login_log`
VALUES (1414880683919409153, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-13 17:33:37',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-13 17:33:37', 1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1416197414155714561, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-17 08:45:50',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-17 08:45:50', 1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1416319517815209985, '127.0.0.1', 1248084109452902400, '周鑫磊', 'zhouxinlei', '登录成功', '2021-07-17 16:51:02',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-17 16:51:02', 1248084109452902400, NULL);
INSERT INTO `auth_login_log`
VALUES (1416565584867622913, '127.0.0.1', 1248084109452902400, '周鑫磊', 'zhouxinlei', '登录成功', '2021-07-18 09:08:49',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-18 09:08:49', 1248084109452902400, NULL);
INSERT INTO `auth_login_log`
VALUES (1416735692814548993, '127.0.0.1', 1248084109452902400, '周鑫磊', 'zhouxinlei', '登录成功', '2021-07-18 20:24:45',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-18 20:24:46', 1248084109452902400, NULL);
INSERT INTO `auth_login_log`
VALUES (1418424645175214081, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-23 12:16:03',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-23 12:16:03', 1413702958458339329, NULL);
INSERT INTO `auth_login_log`
VALUES (1418525676278120449, '127.0.0.1', 1413702958458339329, '管理员', 'admin', '登录成功', '2021-07-23 18:57:31',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36',
        'Chrome', '91.0.4472.77', 'Mac OSX', '内网IP', '2021-07-23 18:57:31', 1413702958458339329, NULL);
COMMIT;

-- ----------------------------
-- Table structure for auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu`
(
    `id`             bigint                                                       NOT NULL COMMENT '主键',
    `label`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单标题',
    `redirect`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '自动进行重定向',
    `hidden`         bit(1)                                                        DEFAULT NULL COMMENT '菜单是否可见',
    `icon`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
    `no_keep_alive`  bit(1)                                                        DEFAULT NULL COMMENT '菜单缓存',
    `path`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路由路径',
    `component_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件名称',
    `component`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件路径',
    `describe_`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
    `parent_id`      bigint                                                        DEFAULT '0' COMMENT '父级菜单ID',
    `sort_number`     int                                                           DEFAULT '1' COMMENT '排序',
    `is_enable`      bit(1)                                                        DEFAULT b'1' COMMENT '状态',
    `create_user`    bigint                                                        DEFAULT NULL COMMENT '创建人id',
    `create_time`    datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_user`    bigint                                                        DEFAULT NULL COMMENT '更新人id',
    `update_time`    datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `tenant_code`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY              `INX_STATUS` (`is_enable`) USING BTREE,
    KEY              `INX_SORT` (`sort_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='菜单';

-- ----------------------------
-- Records of auth_menu
-- ----------------------------
BEGIN;
INSERT INTO `auth_menu`
VALUES (102, '用户管理', NULL, b'0', 'icon-user', b'0', '/user', 'UserCenter', 'Layout', NULL, 0, 3, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 16:01:47',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (103, '权限管理', NULL, b'0', 'icon-quanxian2', b'0', '/permission', 'PermissonManage', 'Layout', NULL, 0, 2, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1248084109452902400, '2021-03-20 23:39:28',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (104, '系统配置', NULL, b'0', 'icon-xitongweihu', b'0', '/base', 'BaseManage', 'Layout', NULL, 0, 4, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-06-13 12:37:29',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (106, '文件中心', NULL, b'0', 'icon-manage-file', b'0', '/file', 'FileManage', 'Layout', NULL, 0, 8, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1248084109452902400, '2021-02-14 19:16:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (107, '流程管理', NULL, b'0', 'icon-process1', b'0', '/workflow', 'ProcessCenter', 'Layout', NULL, 0, 6, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-26 09:53:43',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (108, '菜单管理', NULL, b'0', NULL, b'0', '/permission/menu/resource', 'MenuResourceList',
        'permission/MenuResourceList', NULL, 103, 1, b'1', 1248084109452902400, '2021-02-04 17:24:26',
        1373086745500057600, '2021-03-21 15:59:43', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (109, '角色管理', NULL, b'0', NULL, b'0', '/permission/role', 'Role', 'permission/RoleList', NULL, 103, 2, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 15:55:22',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (110, '组织机构', NULL, b'0', NULL, b'0', '/user/org', 'Org', 'UserCenter/OrgList', NULL, 102, 1, b'0',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 16:33:25',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (111, '岗位管理', NULL, b'0', NULL, b'0', '/user/station', 'Station', 'UserCenter/StationList', NULL, 102, 2, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 16:33:30',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (112, '用户列表', NULL, b'0', NULL, b'0', '/user/user', 'User', 'UserCenter/UserList', NULL, 102, 3, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 16:33:36',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (113, '字典管理', NULL, b'0', NULL, b'0', '/base/dict', 'Dictionary', 'base/Dictionary', NULL, 104, 2, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-06-13 12:37:57',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (114, '地区管理', NULL, b'0', NULL, b'0', '/base/sysArea', 'Area', 'base/AreaList', NULL, 104, 1, b'1',
        1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-06-13 12:37:48',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (121, '文件存储', NULL, b'0', NULL, b'0', '/file/attachment', 'Attachment', 'file/AttachmentList', NULL, 106, 1,
        b'1', 1248084109452902400, '2021-02-04 17:24:26', 1373086745500057600, '2021-03-21 20:38:19',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (126, '流程模型', NULL, b'0', NULL, b'0', '/workflow/modelList', 'ModelList', 'workflow/ModelList', NULL, 107, 1,
        b'1', 1248084109452902400, '2021-02-04 17:24:26', 1413702958458339329, '2021-07-17 08:46:53',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (127, '流程实例', NULL, b'0', NULL, b'0', '/workflow/instanceList', 'InstanceList', 'workflow/InstanceList', NULL,
        107, 4, b'1', 1248084109452902400, '2021-02-04 17:24:26', 1413702958458339329, '2021-07-17 11:07:09',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (130, '应用管理', NULL, b'1', NULL, b'1', '/identity/app', 'ApplicationList', 'identity/ApplicationList', NULL, 137,
        1, b'1', 1248084109452902400, '2021-02-14 11:24:19', 1373086745500057600, '2021-03-21 16:00:15',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (131, '任务调度', NULL, b'1', 'icon-dingshirenwu', b'0', 'job', 'Job', 'Layout', NULL, 0, 7, b'1',
        1248084109452902400, '2021-03-08 11:30:27', 1373086745500057600, '2021-03-21 16:50:33',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (132, '运行报表', NULL, b'1', NULL, b'0', '/job/report', 'Report', 'job/report', NULL, 131, 1, b'1',
        1248084109452902400, '2021-03-08 11:33:12', 1248084109452902400, '2021-03-09 16:47:41',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (133, '任务管理', NULL, b'1', NULL, b'0', '/job/jobInfo', 'TobInfo', 'job/jobInfo', NULL, 131, 2, b'1',
        1248084109452902400, '2021-03-08 11:34:16', 1248084109452902400, '2021-03-09 16:47:51',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (134, '调度日志', NULL, b'1', NULL, b'1', '/job/jobLog', 'JobLog', 'job/jobLog', NULL, 131, 3, b'1',
        1248084109452902400, '2021-03-08 11:35:42', 1248084109452902400, '2021-03-10 09:30:21',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (135, '执行器管理', NULL, b'1', NULL, b'1', '/job/jobGroup', 'JobGroup', 'job/jobGroup', NULL, 131, 4, b'1',
        1248084109452902400, '2021-03-08 11:37:00', 1248084109452902400, '2021-03-09 16:50:27',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (137, '身份认证', NULL, b'1', 'icon-shenfenzheng', b'1', '/identity', 'IdentityAuth', 'Layout', NULL, 0, 1, b'1',
        1373086745500057600, '2021-03-21 15:17:52', 1373086745500057600, '2021-03-21 15:33:09',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (138, '审计日志', NULL, b'1', 'icon-rizhiguanli', b'1', '/audit', 'Audit', 'Layout', NULL, 0, 5, b'1',
        1373086745500057600, '2021-03-21 16:47:52', 1373086745500057600, '2021-03-21 16:50:51',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (140, '操作日志', NULL, b'1', NULL, b'1', '/audit/operateLog', 'OperateLog', 'Audit/OperateLog', NULL, 138, 2, b'1',
        1373086745500057600, '2021-03-21 16:53:46', 1373086745500057600, '2021-03-21 16:53:55',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (141, '登录日志', NULL, b'1', NULL, b'1', '/audit/loginLog', 'LoginLog', 'audit/LoginLog', NULL, 138, 3, b'1',
        1373086745500057600, '2021-03-21 16:55:48', 1373086745500057600, '2021-03-23 09:24:33',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (142, '监控预警', NULL, b'1', 'icon-jiankong1', b'1', '/monitor', 'Monitor', 'Layout', NULL, 0, 9, b'1',
        1373086745500057600, '2021-03-21 16:59:43', 1373086745500057600, '2021-03-21 17:00:00',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (143, '数据库监控', NULL, b'1', NULL, b'1', '/monitor/database', 'Database', 'monitor/database', NULL, 142, 1, b'1',
        1373086745500057600, '2021-03-21 17:01:24', 1373086745500057600, '2021-03-21 17:01:24',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (144, '缓存监控', NULL, b'1', NULL, b'1', '/monitor/cache', 'Cache', 'monitor/Cache', NULL, 142, 2, b'1',
        1373086745500057600, '2021-03-21 17:02:27', 1373086745500057600, '2021-03-21 17:02:36',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (145, '消息管理', NULL, b'1', 'icon-youjian', b'1', '/message', 'Message', 'Layout', NULL, 0, 10, b'1',
        1373086745500057600, '2021-03-21 17:04:46', 1373086745500057600, '2021-03-21 17:06:13',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (146, '邮件管理', NULL, b'1', NULL, b'1', '/message/email', 'Email', 'Message/Email', NULL, 145, 1, b'1',
        1373086745500057600, '2021-03-21 17:05:59', 1373086745500057600, '2021-03-21 17:05:59',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (147, '短信管理', NULL, b'1', NULL, b'1', '/message/sms', 'Sms', 'message/Sms', NULL, 145, 2, b'1',
        1373086745500057600, '2021-03-21 17:07:16', 1373086745500057600, '2021-03-21 17:07:24',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (364, '用户组管理', NULL, b'1', NULL, b'1', '/user/group', 'UserGroup', 'UserCenter/UserGroup', NULL, 102, 4, b'1',
        1373086745500057600, '2021-03-25 10:40:57', 1373086745500057600, '2021-03-25 14:45:36',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (367, '参数管理', NULL, b'1', NULL, b'1', '/base/parameter', 'Parameter', 'base/ParameterList', NULL, 104, 3, b'1',
        1373086745500057600, '2021-06-13 12:39:28', 1373086745500057600, '2021-06-13 14:10:37',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_menu`
VALUES (368, '流程角色', NULL, b'1', NULL, b'1', '/workflow/role', 'ProcessRole', 'workflow/RoleList', NULL, 107, 2, b'1',
        1413702958458339329, '2021-07-17 08:48:06', 1413702958458339329, '2021-07-17 08:58:13', NULL);
INSERT INTO `auth_menu`
VALUES (369, '流程用户', NULL, b'1', NULL, b'1', '/workflow/userList', 'ProcessUser', 'workflow/UserList', NULL, 107, 3,
        b'1', 1413702958458339329, '2021-07-17 11:06:55', 1413702958458339329, '2021-07-17 11:11:47', NULL);
COMMIT;

-- ----------------------------
-- Table structure for auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource`
(
    `id`          bigint                                                        NOT NULL COMMENT 'ID',
    `code`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '编码\n规则：\n链接：\n数据列：\n按钮：',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `menu_id`     bigint                                                                 DEFAULT NULL COMMENT '菜单ID\n#c_auth_menu',
    `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '请求路径',
    `describe_`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '描述',
    `create_user` bigint                                                                 DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint                                                                 DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`,`tenant_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='资源';

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
BEGIN;
INSERT INTO `auth_resource`
VALUES (1333707478991634433, 'station:list', '岗位查询', 111, '/station/list', '岗位查询', 1248084109452902400,
        '2020-12-01 17:40:17', 1248084109452902400, '2021-03-13 14:58:46', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333707688375484417, 'station:page', '岗位分页', 111, '/station/page', '岗位分页', 1248084109452902400,
        '2020-12-01 17:41:07', 1248084109452902400, '2021-03-13 14:59:20', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333708313947537409, 'station:update', '岗位修改', 111, '/station/update', '岗位修改', 1248084109452902400,
        '2020-12-01 17:43:36', 1248084109452902400, '2020-12-01 17:43:36', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333709698659254273, 'station:save', '岗位新增', 111, '/station/save', '岗位新增', 1248084109452902400,
        '2020-12-01 17:49:06', 1248084109452902400, '2021-03-13 14:59:43', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333709881254084609, 'station:export', '岗位导出', 111, '/station/export', '岗位导出', 1248084109452902400,
        '2020-12-01 17:49:49', 1248084109452902400, '2021-03-14 19:33:30', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333712661490434049, 'user:page', '用户分页', 112, '/user/page', '用户分页', 1248084109452902400, '2020-12-01 18:00:52',
        1248084109452902400, '2021-03-13 14:28:24', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713009403756545, 'user:save', '用户保存', 112, '/user/save', '用户保存', 1248084109452902400, '2020-12-01 18:02:15',
        1248084109452902400, '2021-03-13 14:33:10', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713151989121025, 'user:update', '用户更新', 112, '/user/update', '用户更新', 1248084109452902400,
        '2020-12-01 18:02:49', 1248084109452902400, '2021-03-13 14:33:42', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713298068340737, 'user:delete', '用户删除', 112, '/user/delete', '用户删除', 1248084109452902400,
        '2020-12-01 18:03:24', 1248084109452902400, '2021-03-12 18:17:13', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713474526904321, 'user:list', '用户列表', 112, '/user/list', '用户列表', 1248084109452902400, '2020-12-01 18:04:06',
        1248084109452902400, '2021-03-12 13:10:11', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713760196755457, 'role:save', '角色保存', 109, '/role/save', '角色保存', 1248084109452902400, '2020-12-01 18:05:14',
        1248084109452902400, '2020-12-01 18:05:14', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333713907152584705, 'role:page', '角色分页', 109, '/role/page', '角色分页', 1248084109452902400, '2020-12-01 18:05:49',
        1248084109452902400, '2020-12-01 18:05:49', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333714464302956545, 'role:update', '角色更新', 109, '/role/update', '角色更新', 1248084109452902400,
        '2020-12-01 18:08:02', 1248084109452902400, '2020-12-01 18:08:02', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333714573489078273, 'role:delete', '角色删除', 109, '/role/delete', '角色删除', 1248084109452902400,
        '2020-12-01 18:08:28', 1248084109452902400, '2020-12-01 18:08:28', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333714783397216257, 'role:user:list', '角色用户查询', 109, '/role/user/list', '角色用户查询', 1248084109452902400,
        '2020-12-01 18:09:18', 1248084109452902400, '2021-03-13 14:17:20', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333714950343098369, 'role:user:save', '角色用户保存', 109, '/role/user/save', '角色用户保存', 1248084109452902400,
        '2020-12-01 18:09:58', 1248084109452902400, '2021-03-13 14:17:39', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333715083059265537, 'role:user:delete', '角色用户删除', 109, '/role/user/delete', '角色用户删除', 1248084109452902400,
        '2020-12-01 18:10:30', 1248084109452902400, '2021-03-13 14:17:53', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333715414849683457, 'role:resource', '角色资源查询', 109, '/role/resource', '角色资源查询', 1248084109452902400,
        '2020-12-01 18:11:49', 1248084109452902400, '2021-03-13 14:18:40', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333715673105563649, 'role:authority:batch', '角色资源保存', 109, '/role/authority/batch', '角色资源保存',
        1248084109452902400, '2020-12-01 18:12:50', 1248084109452902400, '2021-03-13 14:19:43',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333715941356470273, 'resource:page', '资源分页', 108, '/resource/page', '资源分页', 1248084109452902400,
        '2020-12-01 18:13:54', 1248084109452902400, '2021-03-13 14:12:51', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333716065965047809, 'menu:tree', '菜单tree', 108, '/menu/tree', '菜单tree', 1248084109452902400,
        '2020-12-01 18:14:24', 1248084109452902400, '2021-03-13 14:12:33', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333947090859196417, 'modeler:page', '流程分页', 126, '/modeler/page', '流程分页', 1248084109452902400,
        '2020-12-02 09:32:25', 1373086745500057600, '2021-03-21 20:21:11', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333948051711328257, 'instance:page', '流程实例分页', 127, '/instance/page', '流程实例分页', 1248084109452902400,
        '2020-12-02 09:36:14', 1373086745500057600, '2021-03-21 20:16:28', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333948205231243265, 'rule:action', '流程动作查询', 126, '/process/rule/action', '', 1248084109452902400,
        '2020-12-02 09:36:50', 1373086745500057600, '2021-03-21 20:22:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1333948999447871489, 'process:detail', '查询流程节点信息', 126, '/process/detail/list', '', 1248084109452902400,
        '2020-12-02 09:40:00', 1373086745500057600, '2021-03-21 20:23:59', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339779642408828929, 'menu:delete', '菜单删除', 108, '/menu/delete', '', 1248084109452902400, '2020-12-18 11:48:53',
        1248084109452902400, '2021-03-13 14:04:12', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339779825620221953, 'resource:save', '资源保存', 108, '/resource/save', '', 1248084109452902400,
        '2020-12-18 11:49:37', 1248084109452902400, '2021-03-13 14:12:23', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339779967966511105, 'resource:delete', '资源删除', 108, '/resource/delete', '', 1248084109452902400,
        '2020-12-18 11:50:11', 1248084109452902400, '2021-03-13 14:12:07', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339780132370644993, 'resource:update', '资源修改', 108, '/resource/update', '', 1248084109452902400,
        '2020-12-18 11:50:50', 1248084109452902400, '2021-03-13 14:13:10', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339832275928612865, 'dictionary:page', '字典分页', 113, '/base/dictionary/page', '', 1248084109452902400,
        '2020-12-18 15:18:02', 1248084109452902400, '2020-12-18 15:18:02', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339832461555924993, 'dictionaryItem:list', '字典项查询', 113, '/base/dictionaryItem/list', '', 1248084109452902400,
        '2020-12-18 15:18:46', 1248084109452902400, '2021-03-13 14:45:57', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339832721527275521, 'dictionary:save', '字典保存', 113, '/base/dictionary/save', '', 1248084109452902400,
        '2020-12-18 15:19:48', 1248084109452902400, '2020-12-18 15:19:48', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339832890423508993, 'dictionary:delete', '字典删除', 113, '/base/dictionary/delete', '', 1248084109452902400,
        '2020-12-18 15:20:29', 1248084109452902400, '2020-12-18 15:20:29', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339833045776334849, 'dictionary:update', '字典更新', 113, '/base/dictionary/update', '', 1248084109452902400,
        '2020-12-18 15:21:06', 1248084109452902400, '2020-12-18 15:21:06', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339833989415043073, 'dictionaryItem:delete', '字典项删除', 113, '/base/dictionaryItem/delete', '',
        1248084109452902400, '2020-12-18 15:24:51', 1248084109452902400, '2020-12-18 15:24:51',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339834235599716353, 'dictionaryItem:save', '字典项新增', 113, '/base/dictionaryItem/save', '', 1248084109452902400,
        '2020-12-18 15:25:49', 1248084109452902400, '2020-12-18 15:25:49', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1339834408337932289, 'dictionaryItem:update', '字典项更新', 113, '/base/dictionaryItem/update', '',
        1248084109452902400, '2020-12-18 15:26:31', 1248084109452902400, '2020-12-18 15:26:31',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1340533221247680513, 'menu:update', '菜单修改', 108, '/menu/update', '', 1248084109452902400, '2020-12-20 13:43:21',
        1248084109452902400, '2020-12-20 13:43:21', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1343434888142127105, 'resource:list', '资源查询', 108, '/resource/list', '资源查询', 1248084109452902400,
        '2020-12-28 13:53:32', 1248084109452902400, '2021-03-13 14:13:25', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1345003382335864833, 'menu:save', '菜单保存', 108, '/menu/save', '', 1248084109452902400, '2021-01-01 21:46:10',
        1248084109452902400, '2021-03-13 14:03:13', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1345007620227072001, 'user:routers', '用户菜单', 112, '/user/routers', '', 1248084109452902400,
        '2021-01-01 22:03:00', 1248084109452902400, '2021-01-01 22:03:00', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1346294781727473665, 'user:import', '用户导入', 112, '/user/import', '', 1248084109452902400, '2021-01-05 11:17:44',
        1248084109452902400, '2021-03-13 14:39:14', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1347387178582540289, 'user:export', '用户导出', 112, '/user/export', '', 1248084109452902400, '2021-01-08 11:38:31',
        1248084109452902400, '2021-03-13 14:39:32', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1362952977690918912, 'application:save', '应用信息保存', 130, '/application/save', '', 1248084109452902400,
        '2021-02-20 10:31:27', 1248084109452902400, '2021-03-13 14:01:43', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1362953127410794497, 'application:update', '应用信息更新', 130, '/application/update', '', 1248084109452902400,
        '2021-02-20 10:32:03', 1248084109452902400, '2021-03-13 14:01:48', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1362953416884879361, 'application:delete', '应用信息删除', 130, '/application/delete', '', 1248084109452902400,
        '2021-02-20 10:33:12', 1248084109452902400, '2021-03-13 14:01:53', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1362953791432032257, 'application:page', '应用分页查询', 130, '/application/page', '', 1248084109452902400,
        '2021-02-20 10:34:41', 1248084109452902400, '2021-03-13 14:02:10', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363019714000060417, 'user:userinfo', '用户信息', 112, '/user/userinfo', '', 1248084109452902400,
        '2021-02-20 14:56:38', 1248084109452902400, '2021-03-12 13:10:48', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363116533560377345, 'sysArea:tree', '地区树查询', 114, '/base/sysArea/tree', '', 1248084109452902400,
        '2021-02-20 21:21:22', 1248084109452902400, '2021-02-20 21:21:22', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363116739676864513, 'sysArea:update', '地区更新', 114, '/base/sysArea/update', '', 1248084109452902400,
        '2021-02-20 21:22:11', 1248084109452902400, '2021-02-20 21:22:11', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363116839664877569, 'sysArea:save', '地区保存', 114, '/base/sysArea/save', '', 1248084109452902400,
        '2021-02-20 21:22:35', 1248084109452902400, '2021-02-20 21:22:35', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363116917527937025, 'sysArea:delete', '地区删除', 114, '/base/sysArea/delete', '', 1248084109452902400,
        '2021-02-20 21:22:53', 1248084109452902400, '2021-02-20 21:22:53', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363118667219599361, 'modeler:publish', '流程发布', 126, '/modeler/publish', '', 1248084109452902400,
        '2021-02-20 21:29:50', 1373086745500057600, '2021-03-21 20:24:18', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363118993129603073, 'modeler:backout', '流程发布撤销', 126, '/modeler/backout', '', 1248084109452902400,
        '2021-02-20 21:31:08', 1373086745500057600, '2021-03-21 20:24:30', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363119379978649601, 'modeler:delete', '流程删除', 126, '/modeler/delete', '', 1248084109452902400,
        '2021-02-20 21:32:40', 1373086745500057600, '2021-03-21 20:24:44', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363119813610962945, 'rule:save', '流程规则保存', 126, '/process/rule/save', '', 1248084109452902400,
        '2021-02-20 21:34:24', 1373086745500057600, '2021-03-21 20:25:22', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363121419677073409, 'instance:historyList', '流程历史查询', 127, '/instance/historyList', '', 1248084109452902400,
        '2021-02-20 21:40:47', 1373086745500057600, '2021-03-21 20:17:02', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363121629266444289, 'instance:flowChart', '流程图查看', 127, '/instance/flowChart', '', 1248084109452902400,
        '2021-02-20 21:41:37', 1373086745500057600, '2021-03-21 20:16:53', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363122019600957441, 'drive:process', '驱动业务流程', 127, '/drive/process', '', 1248084109452902400,
        '2021-02-20 21:43:10', 1373086745500057600, '2021-03-21 20:17:47', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363122191890382849, 'instance:busTaskInfo', '业务任务数据查询', 127, '/instance/busTaskInfo', '', 1248084109452902400,
        '2021-02-20 21:43:51', 1373086745500057600, '2021-03-21 20:18:56', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363122443552817153, 'instance:busTaskInfoList', '业务批量任务数据查询', 127, '/instance/busTaskInfoList', '',
        1248084109452902400, '2021-02-20 21:44:51', 1373086745500057600, '2021-03-21 20:18:35',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363122597181784065, 'process:suspend', '流程挂起', 127, '/drive/process/suspend', '', 1248084109452902400,
        '2021-02-20 21:45:27', 1373086745500057600, '2021-03-21 20:19:17', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363122778098892801, 'instance:delete', '流程实例删除', 127, '/drive/process/delete', '', 1248084109452902400,
        '2021-02-20 21:46:11', 1373086745500057600, '2021-03-21 20:20:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1363123293889232897, 'instance:nextUserTask', '获取下一步任务', 127, '/instance/nextUserTask', '', 1248084109452902400,
        '2021-02-20 21:48:14', 1373086745500057600, '2021-03-21 20:20:39', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1365887050633707520, 'org:tree', '组织树查询', 110, '/org/tree', '组织树查询', 1248084109452902400, '2019-11-11 13:39:28',
        1248084109452902400, '2021-03-13 14:51:08', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1365887050633707521, 'org:save', '组织保存', 110, '/org/save', '组织保存', 1248084109452902400, '2019-11-11 13:39:28',
        1248084109452902400, '2021-03-13 14:51:54', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1365887140677025792, 'org:delete', '组织删除', 110, '/org/org/batch', '组织删除', 1248084109452902400,
        '2019-11-11 13:39:28', 1248084109452902400, '2020-12-01 17:59:47', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1369923932665413633, 'menu:list', '菜单查询', 108, '/menu/list', '', 1280708543502401538, '2021-03-11 16:11:32',
        1248084109452902400, '2021-03-13 14:13:36', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1370357099020943361, 'role:authority:refresh', '角色资源刷新', 109, '/role/authority/refresh', '刷新角色权限',
        1248084109452902400, '2021-03-12 20:52:47', 1248084109452902400, '2021-03-13 14:19:56',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1370628774945882113, 'org:update', '组织更新', 110, '/org/update', '组织更新', 1248084109452902400,
        '2021-03-13 14:52:20', 1248084109452902400, '2021-03-13 14:52:20', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1371058565272567809, 'station:delete', '岗位删除', 111, '/station/delete', '', 1248084109452902400,
        '2021-03-14 19:20:10', 1248084109452902400, '2021-03-14 19:20:10', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1371062056502165505, 'station:import', '岗位导入', 111, '/station/import', '岗位导入', 1248084109452902400,
        '2021-03-14 19:34:02', 1248084109452902400, '2021-03-14 19:34:02', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1371275676662104065, 'modeler:save', '流程创建', 126, '/modeler/save', '', 1248084109452902400,
        '2021-03-15 09:42:53', 1373086745500057600, '2021-03-21 20:25:46', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1371345469176020993, 'rule:delete', '流程规则删除', 126, '/process/rule/delete', '', 1248084109452902400,
        '2021-03-15 14:20:13', 1373086745500057600, '2021-03-21 20:26:03', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1374192700983869441, 'loginLog:page', '登录日志分页', 141, '/login/log/page', '登录日志分页', 1373086745500057600,
        '2021-03-23 10:54:06', 1373086745500057600, '2021-03-23 10:54:06', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1374281312299646977, 'loginLog:delete', '登录日志删除', 141, '/login/log/delete', '登录日志删除', 1373086745500057600,
        '2021-03-23 16:46:12', 1373086745500057600, '2021-03-23 16:46:12', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1403946587827470337, 'param:save', '参数保存', 367, '/base/sys/save', '', 1373086745500057600,
        '2021-06-13 13:25:25', 1373086745500057600, '2021-06-13 13:25:25', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1403946666239983617, 'param:update', '参数更新', 367, '/base/sys/update', '', 1373086745500057600,
        '2021-06-13 13:25:44', 1373086745500057600, '2021-06-13 13:25:44', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1403946736079339521, 'param:delete', '参数删除', 367, '/base/sys/delete', '', 1373086745500057600,
        '2021-06-13 13:26:01', 1373086745500057600, '2021-06-13 13:26:01', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1403972517895602177, 'param:code', '参数获取', 367, '/base/parameter/getByCode', '', 1373086745500057600,
        '2021-06-13 15:08:27', 1373086745500057600, '2021-06-13 15:08:27', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_resource`
VALUES (1416198505723330561, 'process-role:save', '流程角色保存', 368, '/process/role/save', '', 1413702958458339329,
        '2021-07-17 08:50:10', 1413702958458339329, '2021-07-17 08:50:10', NULL);
INSERT INTO `auth_resource`
VALUES (1416198567845167105, 'process-role:update', '流程角色更新', 368, '/process/role/update', '', 1413702958458339329,
        '2021-07-17 08:50:25', 1413702958458339329, '2021-07-17 08:50:25', NULL);
INSERT INTO `auth_resource`
VALUES (1416198627416866817, 'process-role:delete', '流程角色删除', 368, '/process/role/delete', '', 1413702958458339329,
        '2021-07-17 08:50:39', 1413702958458339329, '2021-07-17 08:50:39', NULL);
INSERT INTO `auth_resource`
VALUES (1416198790604652545, 'process-role:page', '流程角色分页', 368, '/process/role/page', '', 1413702958458339329,
        '2021-07-17 08:51:18', 1413702958458339329, '2021-07-17 08:51:18', NULL);
INSERT INTO `auth_resource`
VALUES (1416233199542206465, 'process-user:save', '流程用户保存', 369, '/process/user/save', '', 1413702958458339329,
        '2021-07-17 11:08:02', 1413702958458339329, '2021-07-17 11:08:02', NULL);
INSERT INTO `auth_resource`
VALUES (1416233335248912385, 'process-user:update', '流程用户更新', 369, '/process/user/update', '', 1413702958458339329,
        '2021-07-17 11:08:34', 1413702958458339329, '2021-07-17 11:08:34', NULL);
INSERT INTO `auth_resource`
VALUES (1416233390026522625, 'process-user:delete', '流程用户删除', 369, '/process/user/delete', '', 1413702958458339329,
        '2021-07-17 11:08:47', 1413702958458339329, '2021-07-17 11:08:47', NULL);
INSERT INTO `auth_resource`
VALUES (1416233455487025153, 'process-user:list', '流程用户列表', 369, '/process/user/list', '', 1413702958458339329,
        '2021-07-17 11:09:03', 1413702958458339329, '2021-07-17 11:09:03', NULL);
INSERT INTO `auth_resource`
VALUES (1416233511418068993, 'process-user:page', '流程用户分页', 369, '/process/user/page', '', 1413702958458339329,
        '2021-07-17 11:09:16', 1413702958458339329, '2021-07-17 11:09:16', NULL);
COMMIT;

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`
(
    `id`          bigint                                                       NOT NULL,
    `name`        varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `code`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '编码',
    `describe_`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '描述',
    `status`      bit(1)                                                                DEFAULT b'1' COMMENT '状态',
    `create_user` bigint                                                                DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint                                                                DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime                                                              DEFAULT NULL COMMENT '更新时间',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`,`tenant_code`) USING BTREE,
    KEY           `idx_code_name` (`code`,`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色';

-- ----------------------------
-- Records of auth_role
-- ----------------------------
BEGIN;
INSERT INTO `auth_role`
VALUES (100, '管理员', 'ADMIN', '平台管理员', b'1', 1, '2019-10-25 13:46:00', 1373086745500057600, '2021-04-05 20:30:00',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_role`
VALUES (1248088058155237376, '员工', 'EMPLOYEES', '员工', b'1', 1248084109452902400, '2020-04-09 11:19:16',
        1373086745500057600, '2021-04-18 18:56:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_role`
VALUES (1400393338162552834, '11111', '1111', '1111', b'1', 1248084109452902400, '2021-06-03 18:06:09',
        1248084109452902400, '2021-06-03 18:06:09', '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for auth_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_authority`;
CREATE TABLE `auth_role_authority`
(
    `id`             bigint                                                       NOT NULL COMMENT '主键',
    `authority_id`   bigint                                                       NOT NULL COMMENT '资源id(菜单id)',
    `authority_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'MENU' COMMENT '权限类型MENU:菜单;RESOURCE:资源',
    `role_id`        bigint                                                       NOT NULL COMMENT '角色id',
    `create_time`    datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `create_user`    bigint                                                                DEFAULT '0' COMMENT '创建人',
    `tenant_code`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY              `IDX_KEY` (`role_id`,`authority_type`,`authority_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色的资源';

-- ----------------------------
-- Records of auth_role_authority
-- ----------------------------
BEGIN;
INSERT INTO `auth_role_authority`
VALUES (1416233562630520833, 1333715673105563649, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562630520835, 1333713474526904321, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562630520837, 1346294781727473665, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562630520839, 1333709881254084609, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562630520841, 1416233335248912385, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715137, 1339834408337932289, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715139, 1339779967966511105, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715141, 1363019714000060417, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715143, 1370628774945882113, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715145, 1339832461555924993, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715147, 1363118667219599361, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715149, 1345003382335864833, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715151, 1333715414849683457, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715153, 1333713760196755457, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715155, 1333712661490434049, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715157, 1333714783397216257, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715159, 1370357099020943361, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715161, 1403946587827470337, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715163, 1374281312299646977, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715165, 1339832275928612865, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562634715167, 1363122191890382849, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909441, 1416198627416866817, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909443, 1333947090859196417, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909445, 1363121629266444289, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909447, 1362953127410794497, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909449, 1333715083059265537, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909451, 1333948999447871489, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909453, 1333713151989121025, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909455, 1363122443552817153, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909457, 1416233455487025153, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909459, 1403946666239983617, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909461, 1333716065965047809, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909463, 1363119379978649601, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909465, 1365887050633707521, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909467, 1365887050633707520, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909469, 1333714464302956545, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909471, 1345007620227072001, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909473, 1416198790604652545, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562638909475, 1333948051711328257, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103745, 1333713298068340737, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103747, 1416198505723330561, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103749, 1362952977690918912, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103751, 1333713009403756545, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103753, 1365887140677025792, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103755, 1362953791432032257, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103757, 1363119813610962945, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103759, 1333714573489078273, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103761, 1333715941356470273, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103763, 1339833045776334849, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103765, 1333707688375484417, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103767, 1333948205231243265, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103769, 1363121419677073409, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103771, 1363116739676864513, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103773, 1363122778098892801, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103775, 1339832721527275521, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103777, 1416233511418068993, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103779, 1340533221247680513, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103781, 1371058565272567809, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562643103783, 1362953416884879361, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298049, 1363123293889232897, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298051, 1343434888142127105, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298053, 1369923932665413633, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298055, 1363116917527937025, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298057, 1371345469176020993, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298059, 1371275676662104065, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298061, 1339779825620221953, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298063, 1416233199542206465, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298065, 1347387178582540289, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298067, 1339832890423508993, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298069, 1339833989415043073, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298071, 1416198567845167105, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298073, 1339780132370644993, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298075, 1333713907152584705, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298077, 1339834235599716353, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298079, 1333709698659254273, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298081, 1403946736079339521, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298083, 1416233390026522625, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562647298085, 1333708313947537409, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492353, 1363116839664877569, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492355, 1333707478991634433, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492357, 1363122597181784065, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492359, 1333714950343098369, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492361, 1363116533560377345, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492363, 1374192700983869441, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492365, 1339779642408828929, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492367, 1371062056502165505, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492369, 1363122019600957441, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492371, 1403972517895602177, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492373, 1363118993129603073, 'RESOURCE', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492375, 130, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492377, 131, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492379, 132, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492381, 133, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492383, 134, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492385, 135, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492387, 137, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492389, 138, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492391, 140, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562651492393, 141, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686657, 142, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686659, 143, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686661, 144, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686663, 145, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686665, 146, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686667, 147, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686669, 102, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686671, 103, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686673, 104, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686675, 106, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686677, 107, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686679, 108, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686681, 364, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686683, 109, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686685, 110, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686687, 111, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686689, 367, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686691, 112, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686693, 368, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686695, 113, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686697, 369, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686699, 114, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562655686701, 121, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562659880961, 126, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
INSERT INTO `auth_role_authority`
VALUES (1416233562659880963, 127, 'MENU', 100, '2021-07-17 11:09:28', 1413702958458339329, NULL);
COMMIT;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`
(
    `id`                 bigint                                                       NOT NULL COMMENT 'ID',
    `account`            varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
    `password`           varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
    `name`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
    `superior_id`        bigint                                                       NOT NULL DEFAULT '0' COMMENT '上级id',
    `org_id`             bigint                                                                DEFAULT NULL COMMENT '组织ID',
    `station_id`         bigint                                                                DEFAULT NULL COMMENT '岗位ID',
    `email`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '邮箱',
    `mobile`             varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '手机',
    `sex`                int(1) unsigned zerofill DEFAULT NULL COMMENT '性别',
    `delete_flag`        bit(1)                                                       NOT NULL DEFAULT b'0' COMMENT '是否删除 1.已删除 0.未删除',
    `avatar`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '头像',
    `nation`             varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '民族',
    `education`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '学历',
    `position_status`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '职位状态',
    `work_describe`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '工作描述比如：  市长、管理员、局长等等   用于登陆展示',
    `password_error_num` int                                                                   DEFAULT '0' COMMENT '密码错误次数',
    `last_login_time`    datetime                                                              DEFAULT NULL COMMENT '最后登录时间',
    `status`             bit(1)                                                                DEFAULT b'0' COMMENT '状态 \n1启用 0禁用',
    `create_user`        bigint                                                                DEFAULT '0' COMMENT '创建人id',
    `create_time`        datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `update_user`        bigint                                                                DEFAULT '0' COMMENT '更新人id',
    `update_time`        datetime                                                              DEFAULT NULL COMMENT '更新时间',
    `tenant_code`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY                  `UN_ACCOUNT` (`account`,`name`,`tenant_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户';

-- ----------------------------
-- Records of auth_user
-- ----------------------------
BEGIN;
INSERT INTO `auth_user`
VALUES (1248084109452902400, 'zhouxinlei', '$2a$10$r4LbSmyEjXHn53iuoW4sMeq..akBe94fqzSBLOYUWp/J3/CpkU1xW', '周鑫磊', 0,
        109, 106, 'zhouxinlei298@163.com', '18817280664', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING',
        '生活不止眼前的苟且，还有诗和远方', 0, '2020-04-10 17:57:07', b'1', 1248084109452902400, '2020-04-09 11:03:35',
        1373086745500057600, '2021-04-18 17:30:23', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343600014987266, 'heyanbin', '$2a$10$vjjPkc9WCVNKyVOOtaROiOJYpXZ5UoJI4e2EGcpSoU8LqOM2tWloG', '何炎彬', 0, 109,
        106, 'heyanbin@163.com', '15929736675', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:08',
        1248084109452902400, '2020-12-25 13:50:34', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343600593801218, 'sunxinpeng', '$2a$10$mEf1vbW6PprvLSQyxe4TnuLWdkIoHeUF43uEgWUl9ITXWlSrrE37q', '孙鑫鹏', 0,
        109, 106, 'sunxinpeng@163.com', '15509442743', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:09', 1248084109452902400, '2020-12-25 13:37:09',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343601285861377, 'yanzhehan', '$2a$10$8hNSqWsoYKRZj4nd0j0tZeU8IslavN.qae3dI6dFu5ahb.qE0NVSu', '阎哲瀚', 0, 109,
        106, 'yanzhehan@163.com', '15572439770', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:09',
        1248084109452902400, '2020-12-25 13:50:43', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343601919201281, 'huyuze', '$2a$10$.7wQ9xUkegSXYAURxyN3t.6J6TO2ozdoLBKmJ3UPOfr0mv8oey1S2', '胡雨泽', 0, 109,
        106, 'huyuze@163.com', '13702114456', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:09',
        1248084109452902400, '2020-12-25 13:37:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343602560929794, 'jinweichen', '$2a$10$DtZPE3vbFcxOrVAvZV6aOuV2UFkP09a76LeSnY0QLBlE2OsXxsxYW', '金伟宸', 0,
        109, 106, 'jinweichen@163.com', '15629029594', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:09', 1248084109452902400, '2020-12-25 13:50:52',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343603861164034, 'huxinlei', '$2a$10$jMknlggxBTMtNjGEWvyryuDdrEXNIyrMYdhXrtoo4xshimZOEEGfO', '胡鑫磊', 0, 109,
        106, 'huxinlei@163.com', '14732081179', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:09',
        1248084109452902400, '2020-12-25 13:37:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343604477726721, 'shaopengxuan', '$2a$10$aj1GtXZ4B/YmKf.42AwgKuK2ufMOiA4DCqYDoJ15DW3xJDCAx1Kim', '邵鹏煊', 0,
        109, 106, 'shaopengxuan@163.com', '13616886497', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:10', 1248084109452902400, '2020-12-25 13:37:10',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343605153009665, 'yinshaohui', '$2a$10$6yxnxCo7JPQ2GCoCOmTjT.BLr5bvTx1/9ApoEATUEIuNnF1C23r.a', '尹绍辉', 0,
        109, 106, 'yinshaohui@163.com', '15334912815', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:10', 1248084109452902400, '2020-12-25 13:51:03',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343732915703810, 'xuxiaoran', '$2a$10$o40W7Pc6c4uJgdMwnjcGyOAdS5/MojNazigXmeRKwvXAsM.cSJuD2', '徐潇然', 0, 109,
        106, 'xuxiaoran@163.com', '15691874755', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:40',
        1248084109452902400, '2020-12-25 13:51:11', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343733637124097, 'jiangjianhui', '$2a$10$giTj2mIDXMYrkgk8TGk5FOHxmJSqaZwtuLTiTjqGautiZKwOSJ6ZK', '江建辉', 0,
        109, 106, 'jiangjianhui@163.com', '15238477595', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:40', 1248084109452902400, '2020-12-25 13:51:22',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343734253686786, 'zhusicong', '$2a$10$X54.aEnBO7oLByFVBfanF.bjbRC3Wf0c.y20HGeKFIDUBA7UlU6mu', '朱思聪', 0, 109,
        106, 'zhusicong@163.com', '17567723537', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:40',
        1248084109452902400, '2020-12-25 13:51:28', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343734920581121, 'maojinyu', '$2a$10$XBulPieneWU95CedtgQdpeG15OrYNM1gBLzdhyuc7YqSq0EYR.XaC', '毛瑾瑜', 0, 109,
        106, 'maojinyu@163.com', '15290014572', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:41',
        1248084109452902400, '2020-12-25 13:37:41', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343735528755202, 'yanyuanbo', '$2a$10$ZziXNcPgvKFmv5LrvDq86uDmyZbzZgyelkPoqhqMp7.Q5WW1uqRfy', '严苑博', 0, 109,
        106, 'yanyuanbo@163.com', '17182524008', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:41',
        1248084109452902400, '2020-12-25 13:37:41', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343736162095106, 'dongbochao', '$2a$10$9XbxH8AXo22hfw/PJ1IoTOAAJ5xwr5BYMZj6f7zDfWc9LkdAnHbWq', '董博超', 0,
        109, 106, 'dongbochao@163.com', '15816849987', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:41', 1248084109452902400, '2020-12-25 13:51:40',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343737307140098, 'yangwenhao', '$2a$10$wU1htg8iQOFSfnnIlZNih.LnJpswqReYsZamIsTXXxCoyqZg5MXY6', '杨文昊', 0,
        109, 106, 'yangwenhao@163.com', '15030148354', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:41', 1248084109452902400, '2020-12-25 13:37:41',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343738678677505, 'xulixuan', '$2a$10$y8zDN1s6pO5rDmXlC0juheioO1beIojoQRU92sz4JzpOSWZXTMlDW', '徐立轩', 0, 109,
        106, 'xulixuan@163.com', '17270137106', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:41',
        1248084109452902400, '2020-12-25 13:37:41', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343739844694018, 'hanxuesong', '$2a$10$9vdwFWnth22zMq1DasSeIO4DsMufpJ8I9EcmqhksAjkT3/SIzPn6a', '韩雪松', 0,
        109, 106, 'hanxuesong@163.com', '15210833619', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:37:42', 1248084109452902400, '2020-12-25 13:37:42',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342343740872298497, 'yuruiyuan', '$2a$10$oaORhVIVqcfj6HB0kMTP4OrvmPdycJal5GxZnvoZyYuZIxQdY9Jcm', '余睿渊', 0, 109,
        106, 'yuruiyuan@163.com', '18771044148', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:37:42',
        1248084109452902400, '2020-12-25 13:51:51', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345324360470529, 'laiwenhao', '$2a$10$2scbSEBRgWtb.uvcFzzIoO/CUyBiAxnor9MIPA.vqvjCjiLXwqZDG', '赖文昊', 0, 109,
        106, 'laiwenhao@163.com', '15873225721', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:00',
        1248084109452902400, '2020-12-25 13:44:00', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345325065113602, 'dingyutang', '$2a$10$1J3vocNz5dInJMXuckzIROSzL7O4qUqoWUN9h1sMaGVoKptdojjTW', '丁语堂', 0,
        109, 106, 'dingyutang@163.com', '17256233694', 2, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:44:00', 1248084109452902400, '2020-12-25 13:44:00',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345325664899073, 'tanxuesong', '$2a$10$Ha.6uhGaQxw7DBqnq/aOAeJd47yM8mRmhkqnlHgF0uaTFcC.Eyuym', '覃雪松', 0,
        109, 106, 'tanxuesong@163.com', '13835898635', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:44:00', 1248084109452902400, '2020-12-25 13:44:00',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345326562480129, 'yanzhize', '$2a$10$7Ih7V7LPnEMdnPjW5a88B.kVNVZh4RRQRPSogPe00yFnIpSWmfLKi', '阎志泽', 0, 109,
        106, 'yanzhize@163.com', '17117887242', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:00',
        1248084109452902400, '2020-12-25 13:52:00', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345327153876993, 'caihongxuan', '$2a$10$3py6lNpPyzApqmPUqIfYU.SR6qTmuUh9dT8BNZyGH6MVKUQhj1sGO', '蔡鸿煊', 0,
        109, 106, 'caihongxuan@163.com', '15110200091', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:44:00', 1248084109452902400, '2020-12-25 13:44:00',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345327762051074, 'liaoliguo', '$2a$10$sRaS5lxr2KsM2OFpnz7wEuPu6VVLBf5WA/1wXwfBKWB68Il16I65i', '廖立果', 0, 109,
        106, 'liaoliguo@163.com', '17057600288', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:00',
        1248084109452902400, '2020-12-25 13:44:00', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345328378613762, 'zoujinxin', '$2a$10$HRIqP6zof6R.159Sl/Ts3.HaEWZyAVBt4m5i2s.fumjo3.vAsr6s2', '邹金鑫', 0, 109,
        106, 'zoujinxin@163.com', '17762119604', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:01',
        1248084109452902400, '2020-12-25 13:44:01', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345329020342273, 'yuxiujie', '$2a$10$90TTReoOtxGAdQqfW538n.9Yfp0X4QxFk3YuChRPsnaDMSEZwMvA6', '余修杰', 0, 109,
        106, 'yuxiujie@163.com', '13007512258', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:01',
        1248084109452902400, '2020-12-25 13:52:10', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345329649487874, 'houhongtao', '$2a$10$W8SqHYbfqHnggZtHgry7bOiXO3IylGf3s4kj/seJSECjZZ.ubHy3a', '侯鸿涛', 0,
        109, 106, 'houhongtao@163.com', '15955566172', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2020-12-25 13:44:01', 1248084109452902400, '2020-12-25 13:44:01',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1342345330316382209, 'qinzihan', '$2a$10$.ZLw3f0aaib99eMbYt2oN.nzaUADuwwXG0crtwtupowyYrWFG879S', '秦子涵', 0, 109,
        106, 'qinzihan@163.com', '15368650725', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2020-12-25 13:44:01',
        1248084109452902400, '2020-12-25 13:44:01', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364425970667522, 'yaoxiaoran', '$2a$10$C5L6FQ.pg/Gn8oI7ehkTWu4Az/qH06Pn9oJE7JVMoHRVjt1x0E2qa', '姚潇然', 0,
        109, 106, 'yaoxiaoran@163.com', '17887794311', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2021-01-02 21:40:49', 1248084109452902400, '2021-01-02 21:42:13',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364426423652354, 'xiaominghui', '$2a$10$eiXAPgAT4oMF.ZfA6lMg7elVnT/8WJ0/T2JPd1yM8MNDcHUXEfV4O', '萧明辉', 0,
        109, 106, 'xiaominghui@163.com', '15235707327', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2021-01-02 21:40:50', 1248084109452902400, '2021-01-02 21:42:23',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364426775973890, 'zhaosiyuan', '$2a$10$sKTwQb/gRe7zyWPUHSUWueH/bA7bYtZwOy/lNmJRejQk4qlWljMb.', '赵思源', 0,
        109, 106, 'zhaosiyuan@163.com', '14760726346', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2021-01-02 21:40:50', 1248084109452902400, '2021-01-02 21:42:33',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364427128295425, 'xiahaotian', '$2a$10$L.ILf.z856IGtVacFZv3vuvpyMwkE7q.c2eHdvDxr.TkBLBgdbKTC', '夏昊天', 0,
        109, 106, 'xiahaotian@163.com', '17886546780', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2021-01-02 21:40:50', 1248084109452902400, '2021-01-02 21:42:40',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364427484811265, 'tanjinyu', '$2a$10$9GfGWSBU2EfIBHUvU85h.eEoCmmrZXTn.u.euo5VIUJHDwKgKYzzS', '覃瑾瑜', 0, 109,
        106, 'tanjinyu@163.com', '15204087984', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2021-01-02 21:40:50',
        1248084109452902400, '2021-01-02 21:43:03', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364427837132801, 'haozimo', '$2a$10$4yQmCbfZU6wN2JJ2l8atsexH/TTcXrUnm7XEDVAaq9i0TW1MiqP9K', '郝子默', 0, 109,
        106, 'haozimo@163.com', '15266563663', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2021-01-02 21:40:50',
        1248084109452902400, '2021-01-02 21:43:11', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364428181065730, 'xubotao', '$2a$10$y6C1VVuEOICiWRY4ayw1uOE77n9P5jAr9xSe6dLveAizUXq5VTuDi', '徐博涛', 0, 109,
        106, 'xubotao@163.com', '15791280316', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2021-01-02 21:40:50',
        1248084109452902400, '2021-01-02 21:43:20', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364428713742337, 'luwenxuan', '$2a$10$8Lo9mWILuvTrPgarudcSEuZUWYkuMwMkE3ZiUwKHKR05NeAuEw1PC', '陆文轩', 0, 109,
        106, 'luwenxuan@163.com', '14580449512', 1, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2021-01-02 21:40:50',
        1248084109452902400, '2021-01-02 21:43:26', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364429095424001, 'jiazhichen', '$2a$10$dKNVn1.EsoDAqFo7KjB/auWZB9EcgvIbOKT0eRamyVFCq3MgWPykG', '贾智宸', 0,
        109, 106, 'jiazhichen@163.com', '14766258045', 1, b'0',
        'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg', 'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL,
        b'1', 1248084109452902400, '2021-01-02 21:40:50', 1248084109452902400, '2021-01-02 21:43:33',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1345364429447745538, 'lifenghua', '$2a$10$En3Iz1qlZIjYEGl21pFHQOyuMgrPbPmbg5iNGBkNhfGklVEZ5yxOy', '黎风华', 0, 109,
        106, 'lifenghua@163.com', '13820334250', 2, b'0', 'https://oss.sparksys.top/halo/images-icon_1586839683912.jpg',
        'mz_hanz', 'BOSHIHOU', 'WORKING', NULL, 0, NULL, b'1', 1248084109452902400, '2021-01-02 21:40:50',
        1248084109452902400, '2021-01-02 21:43:38', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `auth_user`
VALUES (1413702958458339329, 'admin', '$2a$10$3brg3ncWOzLtezqQYe/7n.E2rbvyUahgyQlW03bWqGoK3qTdfQ9Qa', '管理员', 0, 100,
        100, 'admin@163.com', '18817280664', 1, b'0', '', 'mz_hanz', 'BOSHIHOU', 'WORKING', '', 0, NULL, b'1',
        1248084109452902400, '2021-07-10 11:33:45', 1248084109452902400, '2021-07-10 11:33:45', NULL);
COMMIT;

-- ----------------------------
-- Table structure for auth_user_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_group`;
CREATE TABLE `auth_user_group`
(
    `id`              bigint                                                        NOT NULL COMMENT '主键',
    `role_id`         bigint                                                        NOT NULL COMMENT '角色id',
    `name`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
    `attribute_key`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '属性key',
    `attribute_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值',
    `tenant_code`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `remark`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色属性';

-- ----------------------------
-- Records of auth_user_group
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`
(
    `id`          bigint NOT NULL,
    `role_id`     bigint NOT NULL                                              DEFAULT '0' COMMENT '角色ID\n#c_auth_role',
    `user_id`     bigint NOT NULL                                              DEFAULT '0' COMMENT '用户ID\n#c_core_accou',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `IDX_KEY` (`role_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色分配\r\n账号角色绑定';

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
BEGIN;
INSERT INTO `auth_user_role`
VALUES (1413703397188411393, 100, 1248084109452902400, NULL);
INSERT INTO `auth_user_role`
VALUES (1413703397188411394, 100, 1413702958458339329, NULL);
COMMIT;

-- ----------------------------
-- Table structure for core_org
-- ----------------------------
DROP TABLE IF EXISTS `core_org`;
CREATE TABLE `core_org`
(
    `id`           bigint                                                        NOT NULL COMMENT 'ID',
    `label`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `abbreviation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '简称',
    `parent_id`    bigint                                                                 DEFAULT '0' COMMENT '父ID',
    `tree_path`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT ',' COMMENT '树结构',
    `sort_number`   int                                                                    DEFAULT '1' COMMENT '排序',
    `status`       bit(1)                                                                 DEFAULT b'1' COMMENT '状态',
    `describe_`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '描述',
    `create_time`  datetime                                                               DEFAULT NULL,
    `create_user`  bigint                                                                 DEFAULT NULL,
    `update_time`  datetime                                                               DEFAULT NULL,
    `update_user`  bigint                                                                 DEFAULT NULL,
    `tenant_code`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    FULLTEXT KEY `FU_PATH` (`tree_path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='组织';

-- ----------------------------
-- Records of core_org
-- ----------------------------
BEGIN;
INSERT INTO `core_org`
VALUES (100, 'SparkAuth科技有限公司', 'SparkAuth科技', 0, NULL, 1, b'1', '初始化数据', '2019-07-10 17:02:18', 1248084109452902400,
        '2021-04-18 17:51:57', 1373086745500057600, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (101, 'SparkAuth科技有限公司杭州分公司', '杭州分公司', 100, NULL, 1, b'1', '初始化数据', '2019-08-06 09:10:53', 1248084109452902400,
        '2021-03-21 17:16:43', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (102, 'SparkAuth科技有限公司上海分公司', '上海分公司', 100, NULL, 2, b'1', '初始化数据', '2019-11-07 16:13:09', 1248084109452902400,
        '2021-03-21 17:16:52', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (103, '综合部', '综合部', 101, NULL, 1, b'1', '初始化数据', '2019-11-12 11:34:27', 1248084109452902400,
        '2021-02-05 13:56:40', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (109, '研发部', '研发部', 101, NULL, 2, b'1', '初始化数据', '2019-11-12 11:38:21', 1248084109452902400,
        '2021-03-08 17:41:33', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (110, '产品部', '产品部', 101, NULL, 3, b'1', '初始化数据', '2019-11-12 11:38:31', 1248084109452902400,
        '2021-03-08 17:41:38', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (111, '综合部', '综合部', 102, NULL, 1, b'1', '初始化数据', '2019-11-12 11:38:39', 1248084109452902400,
        '2021-03-08 17:41:51', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (112, '研发部', '研发部', 102, NULL, 2, b'1', '初始化数据', '2019-11-12 11:38:50', 1248084109452902400,
        '2021-03-08 17:41:57', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (113, '销售部', '销售部', 102, NULL, 3, b'1', '初始化数据', '2019-11-12 11:39:00', 1248084109452902400,
        '2021-03-08 17:42:01', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (114, '销售部', '销售部', 101, NULL, 4, b'1', '初始化数据', '2020-10-07 18:18:25', 1248084109452902400,
        '2021-03-08 17:41:43', 1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (117, '行政部', '行政部', 101, NULL, 1, b'1', '行政部', '2021-03-08 17:43:54', 1248084109452902400, '2021-03-08 17:43:54',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_org`
VALUES (118, '行政部', '行政部', 102, NULL, 1, b'1', '行政部', '2021-03-08 17:44:05', 1248084109452902400, '2021-03-08 17:44:05',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for core_station
-- ----------------------------
DROP TABLE IF EXISTS `core_station`;
CREATE TABLE `core_station`
(
    `id`          bigint                                                        NOT NULL COMMENT 'ID',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `org_id`      bigint                                                                 DEFAULT '0' COMMENT '组织ID\n#c_core_org',
    `status`      bit(1)                                                                 DEFAULT b'1' COMMENT '状态',
    `describe_`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '描述',
    `create_time` datetime                                                               DEFAULT NULL,
    `create_user` bigint                                                                 DEFAULT NULL,
    `update_time` datetime                                                               DEFAULT NULL,
    `update_user` bigint                                                                 DEFAULT NULL,
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='岗位';

-- ----------------------------
-- Records of core_station
-- ----------------------------
BEGIN;
INSERT INTO `core_station`
VALUES (100, '总经理', NULL, b'1', '总经理', '2019-07-10 17:03:03', 1248084109452902400, '2021-03-08 18:01:34',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (104, '产品经理', NULL, b'1', '产品经理', '2019-11-16 09:53:27', 1248084109452902400, '2021-03-08 18:00:55',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (105, '人事经理', NULL, b'1', '人事经理', '2019-11-16 09:54:43', 1248084109452902400, '2021-03-08 18:01:02',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (106, 'Java工程师', NULL, b'1', 'Java工程师', '2019-11-16 09:55:04', 1248084109452902400, '2021-03-08 18:01:08',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (107, '需求工程师', NULL, b'1', '需求工程师', '2019-11-16 09:55:27', 1248084109452902400, '2021-03-08 18:01:14',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (108, 'UI工程师', NULL, b'1', '普通员工', '2019-11-16 09:55:40', 1248084109452902400, '2019-11-16 09:55:40',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (112, '研发经理', NULL, b'1', '北京分公司研发经理', '2019-11-16 09:57:07', 1248084109452902400, '2021-03-21 16:34:46',
        1373086745500057600, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (114, '行政小姐姐', NULL, b'1', '行政小姐姐', '2019-11-16 09:57:59', 1248084109452902400, '2021-03-08 18:02:00',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (115, '前端工程师', NULL, b'1', '普通员工', '2019-11-16 09:58:11', 1248084109452902400, '2021-03-08 18:02:08',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (116, '销售员工', NULL, b'1', '普通员工', '2019-11-16 09:58:41', 1248084109452902400, '2019-11-16 09:58:41',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (117, '销售总监', NULL, b'1', '总部2把手', '2019-11-16 09:59:10', 1248084109452902400, '2019-11-16 09:59:10',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (118, '财务总监', NULL, b'1', '总部2把手', '2019-11-16 09:59:39', 1248084109452902400, '2019-11-16 09:59:39',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (119, '市场经理', NULL, b'1', '总部市场部老大', '2019-11-16 10:00:03', 1248084109452902400, '2019-11-16 10:00:03',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
INSERT INTO `core_station`
VALUES (122, '测试工程师', NULL, b'1', '主要负责测试系统功能', '2020-10-07 11:55:53', 1248084109452902400, '2020-10-07 11:55:53',
        1248084109452902400, '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`
(
    `id`          bigint                                                       NOT NULL,
    `type_`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码\r\n一颗树仅仅有一个统一的编码',
    `name`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `describe_`   varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '描述',
    `status_`     bit(1)                                                                DEFAULT b'1' COMMENT '状态',
    `create_user` bigint                                                                DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint                                                                DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime                                                              DEFAULT NULL COMMENT '更新时间',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字典类型';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
INSERT INTO `dictionary`
VALUES (1, 'NATION', '民族', '', b'1', 0, '2019-06-01 09:42:50', 0, '2021-03-14 15:08:42', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (2, 'POSITION_STATUS', '在职状态', '', b'1', 0, '2019-06-04 11:37:15', 0, '2019-06-04 11:37:15',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (3, 'EDUCATION', '学历', '', b'1', 0, '2019-06-04 11:33:52', 0, '2019-06-04 11:33:52', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (4, 'AREA_LEVEL', '行政区级', '', b'1', 0, '2020-01-20 15:12:05', 0, '2020-01-20 15:12:05',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (1348805491787300865, 'WORK_STATUS', '工作状态', '', b'1', 0, '2021-01-12 09:34:23', 0, '2021-01-12 09:34:23',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (1348809476380295169, 'HEALTH_STATUS', '健康状态', '', b'1', 0, '2021-01-12 09:50:13', 0, '2021-01-12 09:50:13',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (1348889297168891904, 'SOLUTIONS', '应对措施', '', b'1', 0, '2021-01-12 15:07:24', 0, '2021-01-12 15:07:24',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (1362970514755420161, 'AUTHORIZED_GRANT_TYPES', '授权模式', '', b'1', 0, '2021-02-20 11:41:08', 0,
        '2021-02-20 11:41:08', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary`
VALUES (1368134739555516417, 'APPLICATION_TYPE', '应用类型', '', b'1', 0, '2021-03-06 17:41:55', 0, '2021-03-06 17:41:55',
        '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_item`;
CREATE TABLE `dictionary_item`
(
    `id`              bigint                                                       NOT NULL COMMENT 'ID',
    `dictionary_id`   bigint                                                       NOT NULL COMMENT '类型ID',
    `dictionary_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
    `code`            varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
    `name`            varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `status_`         bit(1)                                                                DEFAULT b'1' COMMENT '状态',
    `describe_`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT '' COMMENT '描述',
    `sort_number`      int                                                                   DEFAULT '1' COMMENT '排序',
    `create_user`     bigint                                                                DEFAULT '0' COMMENT '创建人id',
    `create_time`     datetime                                                              DEFAULT NULL COMMENT '创建时间',
    `update_user`     bigint                                                                DEFAULT '0' COMMENT '更新人id',
    `update_time`     datetime                                                              DEFAULT NULL COMMENT '更新时间',
    `tenant_code`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY               `dict_code_item_code_uniq` (`dictionary_type`,`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字典项';

-- ----------------------------
-- Records of dictionary_item
-- ----------------------------
BEGIN;
INSERT INTO `dictionary_item`
VALUES (1, 4, 'AREA_LEVEL', 'COUNTRY', '国家', b'1', NULL, 1, 0, '2020-01-20 15:12:57', 0, '2020-01-20 15:12:57',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (2, 4, 'AREA_LEVEL', 'PROVINCE', '省份/直辖市', b'1', NULL, 2, 0, '2020-01-20 15:13:45', 0, '2020-01-20 15:13:45',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (3, 4, 'AREA_LEVEL', 'CITY', '地市', b'1', NULL, 3, 0, '2020-01-20 15:14:16', 0, '2020-01-20 15:14:16',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (4, 4, 'AREA_LEVEL', 'COUNTY', '区县', b'1', NULL, 4, 0, '2020-01-20 15:14:54', 0, '2020-01-20 15:14:54',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (38, 3, 'EDUCATION', 'ZHUANKE', '专科', b'1', NULL, 4, 0, '2019-06-04 11:36:29', 0, '2019-06-04 11:36:29',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (39, 3, 'EDUCATION', 'COLLEGE', '本科', b'1', NULL, 5, 0, '2019-06-04 11:36:19', 0, '2019-06-04 11:36:19',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (40, 3, 'EDUCATION', 'SUOSHI', '硕士', b'1', NULL, 6, 0, '2019-06-04 11:36:29', 0, '2019-06-04 11:36:29',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (41, 3, 'EDUCATION', 'BOSHI', '博士', b'1', NULL, 7, 0, '2019-06-04 11:36:29', 0, '2019-06-04 11:36:29',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (42, 3, 'EDUCATION', 'BOSHIHOU', '博士后', b'1', NULL, 8, 0, '2019-06-04 11:36:29', 0, '2019-06-04 11:36:29',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (43, 1, 'NATION', 'mz_hanz', '汉族', b'1', NULL, 0, 0, '2018-03-15 20:11:01', 0, '2021-03-14 15:08:39',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (44, 1, 'NATION', 'mz_zz', '壮族', b'1', NULL, 1, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (45, 1, 'NATION', 'mz_mz', '满族', b'1', NULL, 2, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (46, 1, 'NATION', 'mz_hz', '回族', b'1', NULL, 3, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (47, 1, 'NATION', 'mz_miaoz', '苗族', b'1', NULL, 4, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (48, 1, 'NATION', 'mz_wwez', '维吾尔族', b'1', NULL, 5, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (49, 1, 'NATION', 'mz_tjz', '土家族', b'1', NULL, 6, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (50, 1, 'NATION', 'mz_yz', '彝族', b'1', NULL, 7, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (51, 1, 'NATION', 'mz_mgz', '蒙古族', b'1', NULL, 8, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (52, 1, 'NATION', 'mz_zhangz', '藏族', b'1', NULL, 9, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (53, 1, 'NATION', 'mz_byz', '布依族', b'1', NULL, 10, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (54, 1, 'NATION', 'mz_dz', '侗族', b'1', NULL, 11, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (55, 1, 'NATION', 'mz_yaoz', '瑶族', b'1', NULL, 12, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (56, 1, 'NATION', 'mz_cxz', '朝鲜族', b'1', NULL, 13, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (57, 1, 'NATION', 'mz_bz', '白族', b'1', NULL, 14, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (58, 1, 'NATION', 'mz_hnz', '哈尼族', b'1', NULL, 15, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (59, 1, 'NATION', 'mz_hskz', '哈萨克族', b'1', NULL, 16, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (60, 1, 'NATION', 'mz_lz', '黎族', b'1', NULL, 17, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (61, 1, 'NATION', 'mz_daiz', '傣族', b'1', NULL, 18, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (62, 1, 'NATION', 'mz_sz', '畲族', b'1', NULL, 19, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (63, 1, 'NATION', 'mz_llz', '傈僳族', b'1', NULL, 20, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (64, 1, 'NATION', 'mz_glz', '仡佬族', b'1', NULL, 21, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (65, 1, 'NATION', 'mz_dxz', '东乡族', b'1', NULL, 22, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (66, 1, 'NATION', 'mz_gsz', '高山族', b'1', NULL, 23, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (67, 1, 'NATION', 'mz_lhz', '拉祜族', b'1', NULL, 24, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (68, 1, 'NATION', 'mz_shuiz', '水族', b'1', NULL, 25, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (69, 1, 'NATION', 'mz_wz', '佤族', b'1', NULL, 26, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (70, 1, 'NATION', 'mz_nxz', '纳西族', b'1', NULL, 27, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (71, 1, 'NATION', 'mz_qz', '羌族', b'1', NULL, 28, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (72, 1, 'NATION', 'mz_tz', '土族', b'1', NULL, 29, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (73, 1, 'NATION', 'mz_zlz', '仫佬族', b'1', NULL, 30, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (74, 1, 'NATION', 'mz_xbz', '锡伯族', b'1', NULL, 31, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (75, 1, 'NATION', 'mz_kehzz', '柯尔克孜族', b'1', NULL, 32, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (76, 1, 'NATION', 'mz_dwz', '达斡尔族', b'1', NULL, 33, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (77, 1, 'NATION', 'mz_jpz', '景颇族', b'1', NULL, 34, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (78, 1, 'NATION', 'mz_mlz', '毛南族', b'1', NULL, 35, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (79, 1, 'NATION', 'mz_slz', '撒拉族', b'1', NULL, 36, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (80, 1, 'NATION', 'mz_tjkz', '塔吉克族', b'1', NULL, 37, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (81, 1, 'NATION', 'mz_acz', '阿昌族', b'1', NULL, 38, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (82, 1, 'NATION', 'mz_pmz', '普米族', b'1', NULL, 39, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (83, 1, 'NATION', 'mz_ewkz', '鄂温克族', b'1', NULL, 40, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (84, 1, 'NATION', 'mz_nz', '怒族', b'1', NULL, 41, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (85, 1, 'NATION', 'mz_jz', '京族', b'1', NULL, 42, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (86, 1, 'NATION', 'mz_jnz', '基诺族', b'1', NULL, 43, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (87, 1, 'NATION', 'mz_daz', '德昂族', b'1', NULL, 44, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (88, 1, 'NATION', 'mz_baz', '保安族', b'1', NULL, 45, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (89, 1, 'NATION', 'mz_elsz', '俄罗斯族', b'1', NULL, 46, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (90, 1, 'NATION', 'mz_ygz', '裕固族', b'1', NULL, 47, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (91, 1, 'NATION', 'mz_wzbkz', '乌兹别克族', b'1', NULL, 48, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (92, 1, 'NATION', 'mz_mbz', '门巴族', b'1', NULL, 49, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (93, 1, 'NATION', 'mz_elcz', '鄂伦春族', b'1', NULL, 50, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (94, 1, 'NATION', 'mz_dlz', '独龙族', b'1', NULL, 51, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (95, 1, 'NATION', 'mz_tkez', '塔塔尔族', b'1', NULL, 52, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (96, 1, 'NATION', 'mz_hzz', '赫哲族', b'1', NULL, 53, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (97, 1, 'NATION', 'mz_lbz', '珞巴族', b'1', NULL, 54, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (98, 1, 'NATION', 'mz_blz', '布朗族', b'1', NULL, 55, 0, '2018-03-15 20:11:01', 0, '2018-03-15 20:11:04',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (99, 2, 'POSITION_STATUS', 'WORKING', '在职', b'1', NULL, 1, 0, '2019-06-04 11:38:16', 0, '2019-06-04 11:38:16',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (100, 2, 'POSITION_STATUS', 'QUIT', '离职', b'1', NULL, 2, 0, '2019-06-04 11:38:50', 0, '2019-06-04 11:38:50',
        '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237038877428940800, 4, 'AREA_LEVEL', 'TOWNS', '乡镇', b'1', NULL, 5, 0, '2020-03-09 23:33:46', 0,
        '2020-03-09 23:33:46', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237038991044247552, 3, 'EDUCATION', 'XIAOXUE', '小学', b'1', NULL, 1, 0, '2020-03-09 23:34:13', 0,
        '2020-03-09 23:34:13', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237039071537135616, 3, 'EDUCATION', 'ZHONGXUE', '中学', b'1', NULL, 2, 0, '2020-03-09 23:34:32', 0,
        '2020-03-09 23:34:32', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237039105171259392, 3, 'EDUCATION', 'GAOZHONG', '高中', b'1', NULL, 3, 0, '2020-03-09 23:34:40', 0,
        '2020-03-09 23:34:40', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237039160271831040, 3, 'EDUCATION', 'QITA', '其他', b'1', NULL, 20, 0, '2020-03-09 23:34:54', 0,
        '2020-03-09 23:34:54', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237040064488275968, 1, 'NATION', 'mz_qt', '其他', b'1', NULL, 100, 0, '2020-03-09 23:38:29', 0,
        '2020-03-09 23:38:29', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1237040319480987648, 2, 'POSITION_STATUS', 'LEAVE', '请假', b'1', NULL, 3, 0, '2020-03-09 23:39:30', 0,
        '2020-03-09 23:39:30', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348805759862046721, 1348805491787300865, 'WORK_STATUS', 'HOLIDAY_SEASON', '节假日/休假', b'1', NULL, 1, 0,
        '2021-01-12 09:35:27', 0, '2021-01-22 15:14:04', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348806953539993601, 1348805491787300865, 'WORK_STATUS', 'NORMAL_WORK', '职场办公', b'1', NULL, 1, 0,
        '2021-01-12 09:40:12', 0, '2021-01-22 15:14:20', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348808839999520769, 1348805491787300865, 'WORK_STATUS', 'TELECOMMUTING', '居家远程办公', b'1', NULL, 1, 0,
        '2021-01-12 09:47:42', 0, '2021-01-22 15:14:34', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348809561705021441, 1348809476380295169, 'HEALTH_STATUS', 'HEALTH', '健康', b'1', NULL, 1, 0,
        '2021-01-12 09:50:34', 0, '2021-01-23 18:20:03', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348809791372525569, 1348809476380295169, 'HEALTH_STATUS', 'FEVER_COUGH', '发烧咳嗽', b'1', NULL, 1, 0,
        '2021-01-12 09:51:29', 0, '2021-01-12 09:51:29', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348809979554168833, 1348809476380295169, 'HEALTH_STATUS', 'OTHER', '其他', b'1', NULL, 1, 0,
        '2021-01-12 09:52:13', 0, '2021-01-12 09:52:13', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1348815647833063425, 1348805491787300865, 'WORK_STATUS', 'HOME_QUARANTINE', '居家隔离无工作', b'1', NULL, 1, 0,
        '2021-01-12 10:14:45', 0, '2021-01-12 10:14:45', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1362971275224678401, 1362970514755420161, 'AUTHORIZED_GRANT_TYPES', 'authorization_code', '授权码模式', b'1', NULL,
        1, 0, '2021-02-20 11:44:09', 0, '2021-02-20 11:44:09', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1362971934514741249, 1362970514755420161, 'AUTHORIZED_GRANT_TYPES', 'implicit', '简化模式', b'1', NULL, 1, 0,
        '2021-02-20 11:46:47', 0, '2021-02-20 11:46:47', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1362980776577335297, 1362970514755420161, 'AUTHORIZED_GRANT_TYPES', 'refresh_token', '刷新token模式', b'1', NULL, 1,
        0, '2021-02-20 12:21:55', 0, '2021-02-20 12:21:55', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1362981107252068353, 1362970514755420161, 'AUTHORIZED_GRANT_TYPES', 'client_credentials', '客户端模式', b'1', NULL,
        1, 0, '2021-02-20 12:23:14', 0, '2021-02-20 12:23:14', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1362988022770171905, 1362970514755420161, 'AUTHORIZED_GRANT_TYPES', 'password', '密码模式', b'1', NULL, 1, 0,
        '2021-02-20 12:50:42', 0, '2021-02-20 12:51:34', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1368135033202933761, 1368134739555516417, 'APPLICATION_TYPE', 'SERVER', '服务端应用', b'1', NULL, 1, 0,
        '2021-03-06 17:43:05', 0, '2021-03-06 17:43:05', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1368135098395000833, 1368134739555516417, 'APPLICATION_TYPE', 'PC', 'PC网页应用', b'1', NULL, 2, 0,
        '2021-03-06 17:43:21', 0, '2021-03-06 17:43:21', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1368135194377453569, 1368134739555516417, 'APPLICATION_TYPE', 'APP', '手机应用', b'1', NULL, 3, 0,
        '2021-03-06 17:43:44', 0, '2021-03-06 17:43:44', '6055fc0465a6f7ecf13fe03a');
INSERT INTO `dictionary_item`
VALUES (1368135531918262273, 1368134739555516417, 'APPLICATION_TYPE', 'WAP', '手机网页应用', b'1', NULL, 4, 0,
        '2021-03-06 17:45:04', 0, '2021-03-06 17:45:04', '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`
(
    `token_id`          varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `token`             blob,
    `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `user_name`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `client_id`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `authentication`    blob,
    `refresh_token`     varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`
(
    `userId`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `clientId`       varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `scope`          varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `status`         varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `expiresAt`      datetime                                               DEFAULT NULL,
    `lastModifiedAt` datetime                                               DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`
(
    `client_id`               varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `resource_ids`            varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `client_secret`           varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `scope`                   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `authorized_grant_types`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `authorities`             varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    `access_token_validity`   int                                                     DEFAULT NULL,
    `refresh_token_validity`  int                                                     DEFAULT NULL,
    `additional_information`  varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `autoapprove`             varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL,
    PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details`
VALUES ('sparkzxl', NULL, '$2a$10$iRhabWUrqWeKHnMF02j84uu8LeBNQaGd5CzoXeoJmG25ef/96qcLy', 'all',
        'authorization_code,password,refresh_token,client_credentials', 'http://127.0.0.1:8000/jump', 'list', 28800,
        864000, NULL, 'false');
INSERT INTO `oauth_client_details`
VALUES ('sparkzxl-resource', NULL, '$2a$10$q6hxx0RpaMDy0BSQSWNAuOQyBMI81SqACCgsQLjuD7Dv2aGCSPpgW', 'all',
        'client_credentials,refresh_token,implicit,authorization_code,password', 'http://127.0.0.1:8892/login', NULL,
        7200, 864000, NULL, 'true');
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`
(
    `token_id`          varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `token`             blob,
    `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `user_name`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `client_id`         varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`
(
    `code`           varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`
(
    `token_id`       varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `token`          blob,
    `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log`
(
    `id`             bigint NOT NULL COMMENT '主键',
    `request_ip`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '操作IP',
    `type`           varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT 'OPT' COMMENT '日志类型\n#LogType{OPT:操作类型;EX:异常类型}',
    `user_name`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '操作人',
    `description`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '操作描述',
    `class_path`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '类路径',
    `action_method`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '请求方法',
    `request_uri`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT '' COMMENT '请求地址',
    `http_method`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT 'GET' COMMENT '请求类型\n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
    `params`         longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求参数',
    `result`         longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '返回值',
    `ex_desc`        longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '异常详情信息',
    `ex_detail`      longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '异常描述',
    `start_time`     timestamp NULL DEFAULT NULL COMMENT '开始时间',
    `finish_time`    timestamp NULL DEFAULT NULL COMMENT '完成时间',
    `consuming_time` bigint                                                        DEFAULT '0' COMMENT '消耗时间',
    `ua`             varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '浏览器',
    `create_time`    datetime                                                      DEFAULT NULL,
    `create_user`    bigint                                                        DEFAULT NULL,
    `tenant_code`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY              `index_type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系统日志';

-- ----------------------------
-- Records of operate_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for segment_id
-- ----------------------------
DROP TABLE IF EXISTS `segment_id`;
CREATE TABLE `segment_id`
(
    `business_tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务标记',
    `max_id`       bigint                                                        NOT NULL COMMENT '当前id值',
    `step`         int                                                           NOT NULL COMMENT '步长',
    `description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
    `update_time`  datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`business_tag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of segment_id
-- ----------------------------
BEGIN;
INSERT INTO `segment_id`
VALUES ('auth_menu', 369, 1, '菜单', '2021-07-17 11:06:55');
INSERT INTO `segment_id`
VALUES ('core_org', 120, 1, '组织', '2021-04-05 20:21:05');
INSERT INTO `segment_id`
VALUES ('core_station', 124, 1, '岗位', '2021-03-14 19:24:42');
COMMIT;

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter`
(
    `id`          bigint                                                        NOT NULL,
    `code`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数code',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数名称',
    `value`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参数值',
    `describe_`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '描述',
    `status`      bit(1)                                                                 DEFAULT b'0' COMMENT '状态0 禁用 1 启用',
    `readonly`    bit(1)                                                                 DEFAULT b'0' COMMENT '只读',
    `create_user` bigint                                                                 DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint                                                                 DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `idx_ param_key` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系统参数';

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
BEGIN;
INSERT INTO `sys_parameter`
VALUES (1, 'system_name', '系统名称', 'Sparkzxl Auth', '系统名称描述', b'1', b'0', 0, '2021-06-13 14:21:29', 0,
        '2021-06-13 14:21:32', '6055fc0465a6f7ecf13fe03a');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`
(
    `id`            bigint                                                  NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint                                                  NOT NULL,
    `xid`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `context`       varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `rollback_info` longblob                                                NOT NULL,
    `log_status`    int                                                     NOT NULL,
    `log_created`   datetime                                                NOT NULL,
    `log_modified`  datetime                                                NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET
FOREIGN_KEY_CHECKS = 1;
