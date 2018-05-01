package com.example.yanglei.feedback;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String inpString ="";
    Button button;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inpString="";
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inpString = "test";
            }
        });

        video = (VideoView) findViewById(R.id.video);
        File file = new File("/storage/sdcard0/1.mp4");
        Log.i("Video path", Environment.getExternalStorageDirectory().getPath());
        MediaController mc = new MediaController(MainActivity.this);
        if(file.exists()){
            Log.i("Video path", "Found it");
            video.setVideoPath(file.getAbsolutePath());
            video.setMediaController(mc);
            video.requestFocus();
            try{
                video.start();
            }catch (Exception e){
                e.printStackTrace();
            }

            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                }
            });
            video.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        } else{
            Log.i("Video path", "No such file");
            Toast.makeText(MainActivity.this, "no such file", Toast.LENGTH_SHORT);
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(inpString.equals("")){

                }
                video.stopPlayback();
                inpString="";
                Intent intent = new Intent(MainActivity.this,FirstQuestion.class);
                startActivity(intent);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

