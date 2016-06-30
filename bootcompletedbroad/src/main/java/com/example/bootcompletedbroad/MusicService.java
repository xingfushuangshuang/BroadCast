package com.example.bootcompletedbroad;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;


public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("MusicService:", "onCreate");

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.lemonree);
            mediaPlayer.setLooping(false);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MusicService:", "onStartCommand");

        int operate = -1;
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            operate = bundle.getInt("operate");
            switch (operate) {
                case 1:
                    play();
                    break;
                case 2:
                    stop();
                    break;
                case 3:
                    pause();
                    break;
                default:
                    break;
            }
        }
        return operate;
    }

    @Override
    public void onDestroy() {
        Log.i("MusicService:", "onDestroy");

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }


    public void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }


    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }


    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            try {

                mediaPlayer.prepare();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
