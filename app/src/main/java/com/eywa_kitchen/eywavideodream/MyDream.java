package com.eywa_kitchen.eywavideodream;


import android.media.MediaPlayer;
import android.net.Uri;
import android.service.dreams.DreamService;
import android.view.KeyEvent;
import android.widget.VideoView;


public class MyDream extends DreamService {
    VideoView mVideoView;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setInteractive(true);
        setFullscreen(true);
        setScreenBright(true);
        setContentView(R.layout.dream_service);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    mp.setLooping(true);
            }
        });
    }

    @Override
    public void onDreamingStarted(){
        super.onDreamingStarted();
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.demo);
        mVideoView.setVideoURI(video);
        mVideoView.start();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                finish();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                finish();
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                finish();
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                finish();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                finish();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                finish();
                return true;
            case KeyEvent.KEYCODE_ENTER:
                finish();
                return true;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                finish();
                return true;
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                finish();
                return true;
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                finish();
                return true;
            case KeyEvent.KEYCODE_ASSIST:
                finish();
                return true;
            case KeyEvent.KEYCODE_VOICE_ASSIST:
                finish();
                return true;
        }
        return super.dispatchKeyEvent(event);
    }
}






