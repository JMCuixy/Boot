package com.example;

import com.example.config.ApplicationArgumentsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1、建议将应用的main类放在其他类所在包的顶层（root package），并
 * 将 @EnableAutoConfiguration 注解到你的main类上，这样就隐式地定
 * 义了一个基础的包搜索路径。
 * 2、采用root package方式，你就可以使用@ComponentScan注解而不需要
 * 指定basePackage属性。另外，@ComponentScan 可以自动收集所有的 Spring
 * 组件，包括 @Configuration 类。
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Example {

    public static void main(String[] args) {
        // 是否开启重启支持（需要强制关闭自重启时使用）
        System.setProperty("spring.devtools.restart.enabled", "true");

        // 1、SpringApplication 将尝试为你创建正确类型的 ApplicationContext，默认情况下，根据你开发的是否为web应用决定使用AnnotationConfigApplicationContext或AnnotationConfigEmbeddedWebApplicationContext。
        // 我们需要将Example.class作为参数传递给run方法，以此告诉SpringApplication谁是主要的Spring组件
        SpringApplication app = new SpringApplication(Example.class);
        // 设置打印 Banner 的方式
        app.setBannerMode(Banner.Mode.LOG);
        // 2、手动调用setWebApplicationType() 指定为 web 应用，可不配置
        app.setWebApplicationType(WebApplicationType.SERVLET);
        ConfigurableApplicationContext run = app.run(args);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                SpringApplication.exit(run, (ExitCodeGenerator) run.getBean("applicationArgumentsBean"));
            }
        });

    }

}
