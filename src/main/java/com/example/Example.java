package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
        // 是否开启重启支持
        System.setProperty("spring.devtools.restart.enabled", "true");

        // SpringApplication 将引导我们的应用，启动 Spring
        // 我们需要将Example.class作为参数传递给run方法，以此告诉SpringApplication谁是主要的Spring组件
        SpringApplication.run(Example.class, args);
    }

}
