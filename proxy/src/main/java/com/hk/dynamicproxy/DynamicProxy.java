package com.hk.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class DynamicProxy implements InvocationHandler{
    private Object object;

    public DynamicProxy(Object object){
        this.object=object;
    }

    public Object getInstance(){
        return  object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is DynamicProxy事务开始。。。");
        Object returnValue=method.invoke(object,args);
        System.out.println("this is DynamicProxy事务结束。。。");
        return returnValue;
    }


//    public Object getInstance(){
//        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("this is DynamicProxy事务开始。。。");
//                Object obj=method.invoke(object,args);
//                System.out.println("this is DynamicProxy事务结束。。。");
//                return obj;
//            }
//        });
//    }
}
