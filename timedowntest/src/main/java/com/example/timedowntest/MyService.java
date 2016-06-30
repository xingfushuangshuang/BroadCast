package com.example.timedowntest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private Thread myThread = null;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myThread == null) {
            myThread = new Thread() {
                @Override
                public void run() {
                    //每休眠1s发送一条广播,倒计时10s
                    for (int i = 0; i <= 10; i++) {
                        Intent intent = new Intent("com.example.cutdown");
                        intent.putExtra("num", 10 - i);//
                        sendBroadcast(intent);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    myThread = null;
                }
            };
            myThread.start();
        }

        return super.onStartCommand(intent, flags, startId);
    }

}
