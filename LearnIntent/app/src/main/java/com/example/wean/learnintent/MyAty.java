package com.example.wean.learnintent;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Wean on 2016/7/5.
 */
public class MyAty extends Activity{
    public static final String ACTION="com.example.wean.learnintent.action.MyAty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
    }
}
