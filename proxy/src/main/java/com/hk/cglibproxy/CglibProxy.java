package com.hk.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;

    public CglibProxy(Object object) {
        this.object = object;
    }

    public Object getInstance(){
        Enhancer e=new Enhancer();
        e.setSuperclass(object.getClass());
        e.setCallback(this);
        return e.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxy处理事务开始。。。");
        method.invoke(object,objects);
        System.out.println("CglibProxy处理事务结束。。。");
        return object;
    }
}
