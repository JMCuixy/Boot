package com.example.transaction;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/13 17:43
 * @Description: 基于 AOP 的事务操作
 */
public class TransactionProxy {
    //proxy为代理的接口
    public static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new
            ThreadLocal<Boolean>() {
                @Override
                protected Boolean initialValue() {
                    return false;
                }
            };


    }
