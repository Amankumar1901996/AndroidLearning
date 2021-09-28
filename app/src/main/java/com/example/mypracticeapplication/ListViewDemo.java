package com.example.mypracticeapplication;


import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        ListView mylistview = findViewById(R.id.mylistview);

        ArrayList<String> mylist= new ArrayList<String>();
        mylist.add("Aman");
        mylist.add("Krishna");
        mylist.add("Ankita");
        mylist.add("Mahender");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist);
        mylistview.setAdapter(arrayAdapter);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("item clicked",mylist.get(position));
                Toast.makeText(getApplicationContext(),mylist.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}