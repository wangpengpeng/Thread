package com.mobin.thread.Example;

import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Mobin on 2017/8/5.
 */
public class DownloadTask implements Runnable {
    private final long lowerBound;
    private final long upperBound;
    private final DownloadBuffer xbuf;
    private final URL requestURL;
    private final AtomicBoolean cancelFlag;

    public DownloadTask(long lowerBound, long upperBound, URL requestURL,
                        Storage storage, AtomicBoolean cancelFlag){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.requestURL = requestURL;
        this.xbuf = new DownloadBuffer(lowerBound, upperBound,storage);
        this.cancelFlag =cancelFlag;
    }
    @Override
    public void run() {

    }
}
