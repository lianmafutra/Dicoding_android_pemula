package com.sikesalnew.dicoding_android_pemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyViewAndViews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Google Pixel");
        }
    }
}
