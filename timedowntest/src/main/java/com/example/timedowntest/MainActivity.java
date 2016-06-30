package com.example.timedowntest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_start;
    private TextView tv;
    private MyBroad myBroad;
    private String action = "com.example.cutdown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBroad = new MyBroad();
        btn_start = (Button) findViewById(R.id.btn_start);
        tv = (TextView) findViewById(R.id.tv_content);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(action);
        registerReceiver(myBroad, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(myBroad);
        super.onStop();
    }

    class MyBroad extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int num = intent.getIntExtra("num", 0);
            tv.setText("" + num);
        }
    }


}
