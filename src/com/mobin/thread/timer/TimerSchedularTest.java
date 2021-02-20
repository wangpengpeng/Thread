package com.mobin.thread.timer;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @Author: wpp
 * @Date: 2021/2/19 15:54
 * 可以定时把数据库的数据调度到redis里。
 */




public class TimerSchedularTest {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 2000);
    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dddd");
    }
}