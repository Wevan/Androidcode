package com.example.actionbartest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    android.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getActionBar();
    }
    public void showActionBar(View source){
        actionBar.show();
    }
    public void hideActionBar(View source){
        actionBar.hide();
    }
}
