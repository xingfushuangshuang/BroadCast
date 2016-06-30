package com.example.broadcasttest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btn_send;
    private MyBroadCast myreciver;
    private String action="com.example.myborad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myreciver=new MyBroadCast();
        btn_send= (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(action);
                intent.putExtra("msg","由activity发出消息");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter=new IntentFilter();
        filter.addAction(action);
        registerReceiver(myreciver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myreciver);
    }
}
