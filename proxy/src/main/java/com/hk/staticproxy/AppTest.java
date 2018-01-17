package com.hk.staticproxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class AppTest {
    public static void main(String[] args) {
        UserDao userDao=new UserDaoImp();
        StaticProxy s=new StaticProxy(userDao);
        s.save();
    }
}
