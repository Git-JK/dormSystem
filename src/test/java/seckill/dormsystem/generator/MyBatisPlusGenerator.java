package seckill.dormsystem.generator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;

public class MyBatisPlusGenerator {
    // static变量无法用@Value赋值
    private static String datasourceUrl = "jdbc:mysql://43.143.170.221:3306/dorm_system";
    private static String datasourceUsername = "dorm_system";
    private static String datasourcePassword = "jinke200098cs";
    /**
     * 代码生成
     * @param args
     */
    public static void main(String[] args) {
        // 代码生成器
        String projectPath = System.getProperty("user.dir");
        String outPutCodePath = projectPath + "/src/main/java";
        String outPutResourcePath = projectPath + "/src/main/resources";
        String authorName = "kk";
        String parentPackageName = "seckill.dormsystem";
        System.out.println(datasourceUrl);
        FastAutoGenerator.create(datasourceUrl, datasourceUsername, datasourcePassword)
                        // 全局配置
                                .globalConfig(builder -> {
                                    builder.author(authorName) // 设置author
                                            .enableSwagger() // 开启swagger模式
                                            .disableOpenDir() // 禁止打开目录
                                            .outputDir(outPutCodePath); // 指定输出目录
                                })
                                // 包配置
                                .packageConfig(builder -> {
                                    builder.parent(parentPackageName)
                                            .controller("controller")
                                            .service("service")
                                            .serviceImpl("service.impl")
                                            .mapper("dao")
                                            .xml("mapper")
                                            .entity("domain")
                                            .pathInfo(new HashMap<OutputFile, String>(){{
                                                put(OutputFile.xml, outPutResourcePath + "/mapper");
                                            }});
                                })
                                // 表配置
                                .strategyConfig((scanner, builder) -> {
                                    builder.addInclude(scanner.apply("请输入表名：")); // 设置需要生成的表名
                                    builder.entityBuilder().enableLombok().enableTableFieldAnnotation(); // 使用lombok，并且启用field注释
                                    builder.controllerBuilder().enableRestStyle(); // 生成Restful风格的controller
                                    builder.mapperBuilder().enableMapperAnnotation();
                                })
                                .templateEngine(new FreemarkerTemplateEngine()) //使用Freemarker引擎模板，默认为Velocity引擎模板
                                .execute();
        System.out.println("Success!");
    }
}
