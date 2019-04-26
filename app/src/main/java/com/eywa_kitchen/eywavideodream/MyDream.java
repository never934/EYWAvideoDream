package com.eywa_kitchen.eywavideodream;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.service.dreams.DreamService;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.VideoView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MyDream extends DreamService {
    public final String TAG = "MyLogger";
    VideoView mVideoView;
    DownloadManager downloadManager;
    String videourl = "file:///sdcard/Download/Demo.mov";


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        // add initial options
        setInteractive(true);
        setFullscreen(true);
        setScreenBright(true);
        // show the view on the screen
        setContentView(R.layout.dream_service);

        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/eywakitchen.appspot.com/o/Demo.mov?alt=media&token=408eacfe-b95b-4224-b52c-125834580cb5"));


        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {


                    mp.start();
                    mp.setLooping(true);


            }
        });

    }








}






