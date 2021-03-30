package com.example.transaction;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/30 13:45
 * @Description:
 */
public class TracingInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}
