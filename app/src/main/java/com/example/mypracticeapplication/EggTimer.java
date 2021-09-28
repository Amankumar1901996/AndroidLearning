package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class EggTimer extends AppCompatActivity {
    SeekBar timerSeekBar;
    TextView timerTextView;
    Button controlerButton;
    Boolean counter = false;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("0.30");
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controlerButton.setText("Go!");
        timerSeekBar.setEnabled(true);
        counter=false;
    }

    public void updateTimer(int secondsLeft){
        int minutes = (int)secondsLeft/60;
        int seconds = secondsLeft - minutes*60;
        String secondString = Integer.toString(seconds);
      if(seconds<=9){
            secondString="0" + secondString;
        }
        timerTextView.setText(Integer.toString(minutes)+ ":" + secondString);
    }

    public void ClickTimer(View view){

        if(counter==false) {
            counter = true;
            timerSeekBar.setEnabled(false);
            controlerButton.setText("stop");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    timerTextView.setText("0.00");
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.laugh);
                    mplayer.start();
                }
            }.start();
        } else {
            resetTimer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);

        timerSeekBar =(SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.timerTextView);
        controlerButton=(Button)findViewById(R.id.startGobtn);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
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