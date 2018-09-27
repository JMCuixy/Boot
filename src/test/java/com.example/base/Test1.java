package com.example.base;


import com.alibaba.druid.pool.DruidDataSource;
import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/*1. home目录下的devtools全局设置属性（~/.spring-boot-devtools.properties，如果devtools激活）。
  2. 测试用例上的 @TestPropertySource 注解。
  3. 测试用例上的 @SpringBootTest#properties 注解。
  4. 命令行参数
  5. 来自SPRING_APPLICATION_JSON 的属性（环境变量或系统属性中内嵌的内联JSON）。
  6. ServletConfig 初始化参数。
  7. ServletContext 初始化参数。
  8. 来自于 java:comp/env 的JNDI属性。
  9. Java系统属性（System.getProperties()）。
  10. 操作系统环境变量。
  11. RandomValuePropertySource，只包含random.*中的属性。
  12. 没有打进jar包的Profile-specific应用属性（application-{profile}.properties和YAML变量）。
  13. 打进jar包中的Profile-specific应用属性（application-{profile}.properties和YAML变量）。
  14. 没有打进jar包的应用配置（application.properties和YAML变量）。
  15. 打进jar包中的应用配置（application.properties和YAML变量）。
  16. @Configuration类上的@PropertySource注解。
  17. 默认属性（使用SpringApplication.setDefaultProperties指定）。
  */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class, properties = {"MAVEN_HOME:MAVEN_HOME2018"})
@TestPropertySource(locations = "classpath:public/file/resource.properties")
public class Test1 {

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Value("${MAVEN_HOME}")
    private String mavenHome;

    @Value("${logging.path}")
    private String loggingPath;

    @Value("${random.int(10)}")
    private int randomInt;
    @Value("${random.value}")
    private String randomStr;

    @Value("${server.address}")
    private String serverAddress;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() {
        logger.info("读取到的环境变量是：" + mavenHome);
        logger.info("读取到的环境变量是：" + loggingPath);
        logger.info("读取到的随机变量是：" + randomInt);
        logger.info("读取到的随机变量是：" + randomStr);
        logger.info("引入外部的yml文件：" + serverAddress);
        logger.info("@ConfigurationProperties 注解的实现效果：" + ((DruidDataSource) dataSource).getUrl());
    }

    @Test
    public void test2() {
        Properties properties = System.getProperties();
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            logger.info("System.getProperties() 读取到的环境变量是：{},{}", entry.getKey(), entry.getValue());
        }
    }


    @Test
    public void test3() {
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("public/file/my.yml"));
        Properties properties = yml.getObject();
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            logger.info("YamlPropertiesFactoryBean 读取的配置文件内容是:{}-{}", entry.getKey(), entry.getValue());
        }

        logger.info("--------华丽的分割线------------");

        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource("public/file/my.yml"));
        Map<String, Object> map = yamlMapFactoryBean.getObject();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            logger.info("YamlPropertiesFactoryBean 读取的配置文件内容是:{}-{}", entry.getKey(), entry.getValue());
        }
    }

}
