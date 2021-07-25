DROP TABLE IF EXISTS ${itl_schema}.${itl_table_name};
CREATE TABLE `auth_user`(
<#list columns  as column>
    <#if itl_table_name == column.table_name>
        ${column.fieldName} ${column.fieldType} (${column.fieldLength}) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci <#if column.allowNull == 1>NOT NULL COMMENT '${column.comment}',
        </#if><#else>DEFAULT NULL COMMENT '${column.comment}',
    </#if>
</#list>
PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT=${itl_table_comment}';
SET FOREIGN_KEY_CHECKS = 1;