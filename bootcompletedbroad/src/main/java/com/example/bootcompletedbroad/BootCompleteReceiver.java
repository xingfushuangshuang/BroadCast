package com.example.bootcompletedbroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MusicService.class);
        Bundle bundle  =new Bundle();
        bundle.putInt("operate", 1);
        service.putExtras(bundle);
        context.startService(service);
	}

}
