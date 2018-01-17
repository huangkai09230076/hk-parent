package com.hk.cglibproxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class AppTest {
    public static void main(String[] args) {
        UserDaoImp userDaoImp = new UserDaoImp();
        UserDaoImp imp =(UserDaoImp)new CglibProxy(userDaoImp).getInstance();
        imp.save();
    }
}
