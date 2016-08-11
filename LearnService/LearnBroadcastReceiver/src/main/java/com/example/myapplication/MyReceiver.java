package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION="com.example.myapplication.intent.action.myreceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("接收到了消息"+intent.getStringExtra("data"));

    }
}
