package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class AudioVideo extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    //play audio
    public void playAudio(View view){
        mediaPlayer=MediaPlayer.create(this,R.raw.laugh);
        mediaPlayer.start();
    }

    //stop audio
    public void stopAudio(View view){
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);

        //video integration
        VideoView videoView=(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()+ "/" + R.raw.butterfly);

        //video control
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        //audio integration
        mediaPlayer=MediaPlayer.create(this,R.raw.laugh);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //manage volume of audio
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //seekbar which change audio
        SeekBar volumeControl=(SeekBar)findViewById(R.id.seekBar1);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curVolume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Seekbar Value", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //seekbar which indicates duration change
        SeekBar scrubber=(SeekBar)findViewById(R.id.seekBar2);
        scrubber.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);     //1000 means with every 1 second seekbar will update
        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Seekbar duration", Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}