package com.example.mypracticeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CurrencyConverter extends AppCompatActivity {

    public void convert_currency(View view){
        EditText editText=findViewById(R.id.converter);
        Double rupee= Double.parseDouble(editText.getText().toString());
        Double doller=rupee*72.99;
        Toast.makeText(CurrencyConverter.this,doller.toString(),Toast.LENGTH_SHORT).show();
        Log.i("hello", "convert_currency Button ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
    }
}