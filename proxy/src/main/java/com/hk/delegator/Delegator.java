package com.hk.delegator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public abstract class Delegator implements InvocationHandler{
    protected Object obj_orgin=null;
    protected Object obj_proxy=null;

    public Delegator() {
    }

    public Delegator(Object obj_orgin) {
        createProxy(obj_orgin);
    }

    protected  Object createProxy(Object obj_orgin){
        this.obj_orgin=obj_orgin;
        this.obj_proxy =  Proxy.newProxyInstance(obj_orgin.getClass().getClassLoader(),obj_orgin.getClass().getInterfaces(),this);
        return obj_proxy;
    }

    protected Object invokeSuper(Method method, Object[] args)throws  Throwable {
        return method.invoke(obj_orgin,args);
    }

    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        // 缺省实现：委托给obj_orgin完成对应的操作
        if (method.getName().equals("toString")) { //对其做额外处理
            return this.invokeSuper(method, args) + "$Proxy";
        } else { //注意，调用原始对象的方法，而不是代理的（obj==obj_proxy）
            return this.invokeSuper(method, args);
        }
    }
}
