package com.mobin.thread;

/**
 * @Author: wpp
 * @Date: 2020/6/20 13:15
 */
public class TestThread {

    public static void main(String[] args) {

        Thread t1 = new Thread(()-> {
            System.out.println("t111");
            System.out.println(Thread.currentThread().getName());
        },"T1");

        t1.start();


        new Thread(()->{
            System.out.println("t2");
            System.out.println("t2");
            System.out.println("t2");
        },"t2").start();

    }
}
