package com.mobin.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wpp
 * @Date: 2021/2/7 20:35
 */

public class HeapOOM {

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> oomObjects=new ArrayList<>();

        while (true) {
//            oomObjects.add(new OOMObject());
            Thread.sleep(10);
        }
    }
}