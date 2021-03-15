package com.example.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/13 17:43
 * @Description: 基于 AOP 的事务操作
 */
@Component
public class TransactionProxy {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 通过 PlatformTransactionManager 使用事务
     */
    public void test1() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            // do something
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transaction);
        }
        dataSourceTransactionManager.commit(transaction);
    }


    /**
     * 通过 TransactionTemplate 使用事务
     */
    public void test2() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager);
        Object execute = transactionTemplate.execute(status -> {
            // do something
            return new Object();
        });
    }


}
