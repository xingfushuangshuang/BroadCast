package com.example.orderbroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/30.
 */
public class FirstBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i("info", "first收到：" + msg);
        //终止广播的
//        abortBroadcast();
        Bundle bundle = new Bundle();
        bundle.putString("extra", "first追加");
        setResultExtras(bundle);

    }
}
