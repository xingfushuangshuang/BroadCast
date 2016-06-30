package com.example.orderbroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String action = "android.zhidisoft.broad";
    private String permission = "android.zhidisoft.broad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action);
                intent.putExtra("msg", "activity发出");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent, permission);
            }
        });
    }
}
