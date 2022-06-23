package com.github.sparkzxl.generator;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.lang.TypeReference;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.*;
import java.util.function.Function;

/**
 * description: 代码生成
 *
 * @author zhouxinlei
 * @since 2022-03-02 18:59:08
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        extractCodeGenerator("sparkzxl-system-admin/system-admin-client", "sparkzxl-system-admin/system-admin-server", "com.github.sparkzxl.system.admin");
    }

    private static void extractCodeGenerator(String apiModule, String serverModule, String parentPackage) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // 代码生成器
        FastAutoGenerator.create(new DataSourceConfig
                        .Builder("jdbc:mysql://47.114.40.129:3340/sparkzxl-system-admin",
                        "root",
                        "123456"))
                .globalConfig((scanner, builder) -> builder.fileOverride()
                        .outputDir(serverModule.concat("/src/main/java"))
                        .author(scanner.apply("请输入作者名称？"))
                        .enableSwagger()
                        .dateType(DateType.TIME_PACK)
                        .commentDate(DatePattern.NORM_DATE_PATTERN)).packageConfig((scanner, builder) -> {
                    String mapperPath = projectPath.concat("/").concat(serverModule).concat("/src/main/resources/mapper");
                    Map<OutputFile, String> outputFileStringMap = Maps.newHashMap();
                    outputFileStringMap.put(OutputFile.mapperXml, mapperPath);
                    builder.parent(parentPackage)
                            .entity("infrastructure.entity")
                            .service("domain.repository")
                            .serviceImpl("infrastructure.repository")
                            .mapper("infrastructure.mapper")
                            .xml("mapper.xml")
                            .other("")
                            .controller("interfaces.controller")
                            .pathInfo(outputFileStringMap).build();
                })
                .strategyConfig(MybatisPlusGenerator::getStrategyConfig)
                .injectionConfig((scanner, builder) -> getInjectionConfig(parentPackage, apiModule, serverModule, builder))
                .templateEngine(getTemplateEngine())
                .templateConfig((builder) -> builder
                        .controller("/templates/ctx_controller.java")
                        .service("/templates/ctx_service.java")
                        .serviceImpl("/templates/ctx_serviceImpl.java"))
                .execute();
    }

    private static FreemarkerTemplateEngine getTemplateEngine() {
        return new FreemarkerTemplateEngine() {
            /**
             * 输出自定义模板文件
             *
             * @param customFile 自定义配置模板文件信息
             * @param tableInfo  表信息
             * @param objectMap  渲染数据
             * @since 3.5.1
             */
            @Override
            protected void outputCustomFile(@NotNull Map<String, String> customFile, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {

                Map<String, FileConfig> filePathMap = Convert.convert(new TypeReference<Map<String, FileConfig>>() {}, objectMap.get("customFileConfig"));
                customFile.forEach((key, value) -> {
                    FileConfig fileConfig = filePathMap.get(key);
                    String fileName = String.format((fileConfig.getFilePath() + File.separator + "%s"), fileConfig.getFileName());
                    outputFile(new File(fileName), objectMap, value);
                });
            }
        };
    }

    /**
     * 注入配置
     *
     * @param parentPackage 父包名
     * @param builder       注入构造
     */
    private static void getInjectionConfig(String parentPackage, String apiModule, String serverModule, InjectionConfig.Builder builder) {
        Map<String, FileConfig> filePathMap = Maps.newHashMap();
        Map<String, String> templateMap =
                ImmutableMap.<String, String>builder()
                        .put("dtoConfig", "/templates/ctx_dto.java.ftl")
                        .put("saveDtoFileConfig", "/templates/ctx_dto.java.ftl")
                        .put("updateDtoFileConfig", "/templates/ctx_dto.java.ftl")
                        .put("voConfig", "/templates/ctx_vo.java.ftl")
                        .put("convertConfig", "/templates/ctx_convert.java.ftl")
                        .put("insideServiceConfig", "/templates/ctx_inside_service.java.ftl")
                        .put("insideServiceImplConfig", "/templates/ctx_inside_serviceImpl.java.ftl")
                        .build();
        builder.beforeOutputFile((tableInfo, objectMap) -> {
                    String projectPath = System.getProperty("user.dir");
                    String packageName = parentPackage.replaceAll("\\.", "/");
                    String apiPath = projectPath.concat("/").concat(apiModule).concat("/src/main/java/").concat(packageName);
                    String serverPath = projectPath.concat("/").concat(serverModule).concat("/src/main/java/").concat(packageName);
                    // dto模板配置
                    FileConfig dtoFileConfig = new FileConfig();
                    dtoFileConfig.setFileName(tableInfo.getEntityName().concat("DTO.java"));
                    dtoFileConfig.setPackageName(parentPackage.concat(".api.model.dto.").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    dtoFileConfig.setFilePath(apiPath.concat("/api/model/dto/").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    filePathMap.put("dtoConfig", dtoFileConfig);
                    // saveDto模板配置
                    FileConfig saveDtoFileConfig = new FileConfig();
                    saveDtoFileConfig.setFileName(tableInfo.getEntityName().concat("SaveDTO.java"));
                    saveDtoFileConfig.setPackageName(parentPackage.concat(".api.model.dto.").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    saveDtoFileConfig.setFilePath(apiPath.concat("/api/model/dto/").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    filePathMap.put("saveDtoFileConfig", saveDtoFileConfig);
                    // updateDto模板配置
                    FileConfig updateDtoFileConfig = new FileConfig();
                    updateDtoFileConfig.setFileName(tableInfo.getEntityName().concat("UpdateDTO.java"));
                    updateDtoFileConfig.setPackageName(parentPackage.concat(".api.model.dto.").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    updateDtoFileConfig.setFilePath(apiPath.concat("/api/model/dto/").concat(tableInfo.getEntityName().toLowerCase(Locale.ROOT)));
                    filePathMap.put("updateDtoFileConfig", updateDtoFileConfig);
                    // VO模板配置
                    FileConfig voFileConfig = new FileConfig();
                    voFileConfig.setFileName(tableInfo.getEntityName().concat("VO.java"));
                    voFileConfig.setPackageName(parentPackage.concat(".api.model.vo"));
                    voFileConfig.setFilePath(apiPath.concat("/api/model/vo"));
                    filePathMap.put("voConfig", voFileConfig);
                    // convert模板配置
                    FileConfig convertFileConfig = new FileConfig();
                    convertFileConfig.setFileName(tableInfo.getEntityName().concat("Convert.java"));
                    convertFileConfig.setPackageName(parentPackage.concat(".domain.convert"));
                    convertFileConfig.setFilePath(serverPath.concat("/domain/convert/"));
                    filePathMap.put("convertConfig", convertFileConfig);

                    // insideService模板配置
                    FileConfig insideServiceConfig = new FileConfig();
                    insideServiceConfig.setFileName("I".concat(tableInfo.getEntityName()).concat("Service.java"));
                    insideServiceConfig.setPackageName(parentPackage.concat(".application.service"));
                    insideServiceConfig.setFilePath(serverPath.concat("/application/service"));
                    filePathMap.put("insideServiceConfig", insideServiceConfig);

                    // insideServiceImpl模板配置
                    FileConfig insideServiceImplConfig = new FileConfig();
                    insideServiceImplConfig.setFileName(tableInfo.getEntityName().concat("ServiceImpl.java"));
                    insideServiceImplConfig.setPackageName(parentPackage.concat(".domain.service"));
                    insideServiceImplConfig.setFilePath(serverPath.concat("/domain/service/"));
                    filePathMap.put("insideServiceImplConfig", insideServiceImplConfig);
                    objectMap.put("customFileConfig", filePathMap);
                })
                .customFile(templateMap)
                .build();
    }

    /**
     * 策略配置
     *
     * @param scanner 输入
     * @param builder 策略构造
     */
    private static void getStrategyConfig(Function<String, String> scanner, StrategyConfig.Builder builder) {
        List<IFill> propertyList = Lists.newArrayList();
        Property tenantIdProperty = new Property("tenantId", FieldFill.INSERT);
        propertyList.add(tenantIdProperty);
        Property createDateTimeProperty = new Property("createTime", FieldFill.INSERT);
        propertyList.add(createDateTimeProperty);
        Property createNameProperty = new Property("createUser", FieldFill.INSERT);
        propertyList.add(createNameProperty);
        Property modifyDateTimeProperty = new Property("updateTime", FieldFill.INSERT_UPDATE);
        propertyList.add(modifyDateTimeProperty);
        Property modifyNameProperty = new Property("updateUser", FieldFill.INSERT_UPDATE);
        propertyList.add(modifyNameProperty);
        builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                .addTablePrefix("sys_")
                .entityBuilder()
                .enableLombok()
                .enableChainModel()
                .enableTableFieldAnnotation()
                .logicDeleteColumnName("is_delete")
                .logicDeletePropertyName("isDelete")
                .addTableFills(propertyList)
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)
                .mapperBuilder()
                .enableMapperAnnotation()
                .serviceBuilder()
                .formatServiceFileName("I%sRepository")
                .formatServiceImplFileName("%sRepository")
                .build()
                .controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle()
                .build();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
