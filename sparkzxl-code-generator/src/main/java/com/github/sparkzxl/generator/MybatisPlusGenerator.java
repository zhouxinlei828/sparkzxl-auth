package com.github.sparkzxl.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * description: 代码生成类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:20:58
 */
public class MybatisPlusGenerator {

    /**
     * 读取控制台内容
     *
     * @param tip
     * @return String[]
     * @author charles.zhou
     * @date 2020-04-12 14:06:32
     */
    public static String[] scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt.split(",");
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        String[] moduleNames = scanner("模块相对路径，例如格式为sparkzxl-workflow/sparkzxl-workflow-server");
        if (ArrayUtils.isEmpty(moduleNames)) {
            throw new RuntimeException("模块名称为空");
        }
        projectPath = projectPath.concat("/").concat(moduleNames[0]);
        gc.setOutputDir(projectPath.concat("/src/main/java"));
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setSwagger2(true);
        gc.setDateType(DateType.TIME_PACK);
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setOpen(true);
        gc.setAuthor("zhouxinlei");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://47.114.40.129:3340/sparkzxl_workflow?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.github.sparkzxl.workflow");
        pc.setController("interfaces.controller");
        pc.setService("application.service");
        pc.setServiceImpl("domain.service");
        pc.setMapper("infrastructure.mapper");
        pc.setEntity("infrastructure.entity");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        String finalProjectPath = projectPath;
        fileOutConfigList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return finalProjectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        mpg.setCfg(injectionConfig);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.github.sparkzxl.entity.data.Entity");
        strategy.setSuperMapperClass("com.github.sparkzxl.database.base.mapper.SuperMapper");
        strategy.setSuperServiceClass("com.github.sparkzxl.database.base.service.SuperCacheService");
        strategy.setSuperServiceImplClass("com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl");

        strategy.setSuperControllerClass("com.github.sparkzxl.database.base.controller.SuperCacheController");
        strategy.setEntitySerialVersionUID(true);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        String[] tableNames = scanner("表名，多个英文逗号分割");
        System.out.println(Arrays.toString(tableNames));
        strategy.setInclude(tableNames);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}

