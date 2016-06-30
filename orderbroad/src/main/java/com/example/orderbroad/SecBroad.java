package com.example.orderbroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/30.
 */
public class SecBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i("info", "sec收到：" + msg);
        /**
         * 没有bundle数据的时候，ture创建换一个空bunlder，false返回一个null
         */
        Bundle bundler = getResultExtras(true);
        String extra = (String) bundler.get("extra");
        Log.i("info", "sec收到追加数据：" + extra);

    }
}
