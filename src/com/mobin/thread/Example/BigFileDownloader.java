package com.mobin.thread.Example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Mobin on 2017/8/5.
 * 《Java多线程编程实战指南(核心篇)》Demo
 */
public class BigFileDownloader {
    protected final URL requestURL;
    protected final long fileSize;
    protected final Storage storage;//负责已经下载数据的存储
    protected final  AtomicBoolean taskCanceled = new AtomicBoolean(false);
    private static final Logger log = LoggerFactory.getLogger(BigFileDownloader.class);

    public static synchronized void initLog4j(){
        String log4jFile = System.getProperty("log4j");
        InputStream in = null;
        if (log4jFile !=null){
            try {
                in = new FileInputStream(log4jFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (in == null) {
            in = BigFileDownloader.class.getResourceAsStream("/log4j.properties");
        }
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("日志配置加载完成");
    }

    public BigFileDownloader(String strURL) throws Exception {
        requestURL = new URL(strURL);
        fileSize = retiveFileSize(requestURL);
        log.info("file total size: %s", fileSize);
        String fileName = strURL.substring(strURL.lastIndexOf("/") + 1);
        storage = new Storage(fileSize, fileName);
    }

    public void download(int taskCount, long reportInterval){
        long lowerBound = 0; //下载数据段的起始字节
        long upperBound = 0;//下载数据段的结束字节

    }

    private static long retiveFileSize(URL requestURL) throws Exception {
       long size = -1;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) requestURL.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();
            int statusCode = conn.getResponseCode();
            if (HttpURLConnection.HTTP_OK != statusCode){
                throw new Exception("Server exception,status code:"+ statusCode);
            }
            //文件大小
            String c1 = conn.getHeaderField("Content-Length");
            size = Long.valueOf(c1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != conn){
                conn.disconnect();
            }
        }
        return size;
    }

}
