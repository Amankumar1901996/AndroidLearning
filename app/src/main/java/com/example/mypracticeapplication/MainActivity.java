package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    public void show(View view){
        textView.setText("Hi! Again");
        textView.setVisibility(View.VISIBLE);
    }

    public void hide(View view){
        textView.setVisibility((View.INVISIBLE));
    }

    /*public void clickfunction(View view){
        EditText editText=findViewById(R.id.username_edit);
        EditText editText1=findViewById(R.id.Password_edit);
        Log.i("info", editText.getText().toString());
        Log.i("info", editText1.getText().toString());
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.hiiEdit);
        /*new CountDownTimer(10000, 1000) {
            public void onTick(long milliseondsUntilDone){
                Log.i("Seconds left", String.valueOf(milliseondsUntilDone/1000));
            }
            public void onFinish(){
                Log.i("Done", "coundown timer finished");
                //counter is finished (after 10 seconds)
            }

        }.start();*/
    }
/*
        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Runnable has run!", "a second must have passed...");
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);
    }

*/
}