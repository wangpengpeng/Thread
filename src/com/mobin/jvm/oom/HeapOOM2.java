package com.mobin.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wpp
 * @Date: 2021/2/7 20:35
 *
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/
 */

public class HeapOOM2 {

    public static void main(String[] args) {
        List<OOMObject> oomObjects=new ArrayList<>();

//        while (true) {
//            oomObjects.add(new OOMObject());
//        }


        new Thread(()->{
            System.out.println("4444");

            while (true) {
                oomObjects.add(new OOMObject());
            }
        },"t2").start();

    }



}