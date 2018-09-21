package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * 1、实现 CommandLineRunner 或者 ApplicationRunner 接口可以在 SpringApplication 启动后，run() 方法运行前执行一些特殊的代码
 * 2、实现 ExitCodeGenerator 接口可以在 Application 退出后返回特殊的特征码，用于 SpringApplication.exit() 时使用
 * 3、实现 DisposableBean 接口，用于在 SpringApplication 退出后（SpringApplication.exit()）实现自己的一些逻辑，或者使用 @PreDestroy 注解。
 */
@Component
public class ApplicationArgumentsBean implements CommandLineRunner, ApplicationRunner, ExitCodeGenerator, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationArgumentsBean.class);

    /**
     * 如果运行的时候使用 java -jar *.jar --debug logfile.txt
     * 则:debug = true,files=["logfile.txt"]
     *
     * @param args
     */
    @Autowired
    public ApplicationArgumentsBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("重写 ApplicationRunner 的 run 方法：{}", args.containsOption("debug"));
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("重写 CommandLineRunner 的 run 方法：{}", args);
    }

    @Override
    public int getExitCode() {
        return 0;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("重写 DisposableBean 的 destroy 方法，用于在 SpringApplication 退出后执行一些操作");
    }

    @PreDestroy
    public void predestroy() {
        logger.info("使用 @PreDestroy 用于在 SpringApplication 退出后执行一些操作");
    }
}

