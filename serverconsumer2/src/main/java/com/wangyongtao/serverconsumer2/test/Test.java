package com.wangyongtao.serverconsumer2.test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author : wangyongtao
 * @Description : TODO
 * @Date : 2020/4/5 0005 13:23
 **/
public class Test {

    public synchronized void method1() {
        System.out.println("Hello World!");
    }


    public void method2() {
        synchronized(this){
            System.out.println("Hello World!");
        }
    }

    /**
     * new Comparator<Object>() {
     *                     @Override
     *                     public int compare(Object o1, Object o2) {
     *                         User user1 = (User)o1;
     *                         User user2 = (User)o2;
     *                         if(user1.value<user2.value)
     *                         {
     *                             return 1;
     *                         }else
     *                         {
     *                             return -1;
     *                         }
     *                     }
     *
     *                 }
     * @param args
     */

    public static void main(String[] args) {
        TreeSet<User> resultSet = new TreeSet<User>((Object o1, Object o2)->{
             User user1 = (User)o1;
             User user2 = (User)o2;
             if(user1.value<user2.value){
                 return 1;
             }else {
                 return -1;
             }
        });
    }
}
