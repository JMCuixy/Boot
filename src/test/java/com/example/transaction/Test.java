package com.example.transaction;

import com.example.Example;
import com.example.utils.SpringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/29 17:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @org.junit.Test
    public void test1() {
        // 默认的事务定义
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        PlatformTransactionManager transactionManager = SpringUtils.getBean(PlatformTransactionManager.class);
        // 开启事务
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            // do something
        } catch (Exception e) {
            // 事务回滚
            transactionManager.rollback(transactionStatus);
        }
        transactionManager.commit(transactionStatus);
    }


    @org.junit.Test
    public void test2() {
        PlatformTransactionManager transactionManager = SpringUtils.getBean(PlatformTransactionManager.class);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        Boolean execute = transactionTemplate.execute(transactionStatus -> {
            // do something
            return Boolean.TRUE;
        });
    }
}
