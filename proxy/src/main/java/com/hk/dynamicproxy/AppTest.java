package com.hk.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class AppTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImp();
        DynamicProxy invocationHandlerImp = new DynamicProxy(userDao);
        UserDao u =(UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),invocationHandlerImp);
        u.save();
//        UserDao userDao = new UserDaoImp();
//        UserDao proxy = (UserDao) new DynamicProxy(userDao).getInstance();
//        proxy.save();
//
//        RoleDao roleDao=new RoleDaoImp();
//        RoleDao proxyRoleDao=(RoleDao) new DynamicProxy(roleDao).getInstance();
//        proxyRoleDao.updateRole();
    }
}
