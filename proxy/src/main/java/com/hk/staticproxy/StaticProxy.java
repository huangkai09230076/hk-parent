package com.hk.staticproxy;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class StaticProxy implements  UserDao{
    private UserDao userDao;

    public StaticProxy(UserDao target){
        this.userDao=target;
    }

    public void save(){
        System.out.println("开始事务。。。。");
        userDao.save();
        System.out.println("结束事务。。。。");
    }
}
