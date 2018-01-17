package com.hk;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class LazySington {
    private static LazySington sington;

    public LazySington() { }

    public static LazySington getInstance(){
        if(sington==null){
            sington=new LazySington();
        }
        return sington;
    }
}
