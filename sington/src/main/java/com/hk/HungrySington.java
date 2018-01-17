package com.hk;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class HungrySington {
    private static HungrySington sington=new HungrySington();

    public HungrySington() { }

    public static HungrySington getInstance(){
            return sington;
    }
}
