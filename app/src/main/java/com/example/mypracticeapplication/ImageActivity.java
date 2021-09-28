package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    public void changeImage(View view){
        ImageView imageView=findViewById(R.id.image1);
        imageView.setImageResource(R.drawable.mountian2);
        Log.i("info", "Button clicked");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }
}