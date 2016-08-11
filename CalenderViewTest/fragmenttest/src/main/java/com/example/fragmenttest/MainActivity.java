package com.example.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group= (RadioGroup) findViewById(R.id.radiogroup);
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.first:
                Intent intent=new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.second:
                MyFragment2 fragment2=new MyFragment2();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction beginTransaction=fragmentManager.beginTransaction();
                beginTransaction.add(R.id.frame,fragment2);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.thrid:

                break;
            case R.id.fourth:

                break;
        }
    }
}
