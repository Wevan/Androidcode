package com.example.notificationtest;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int NOTIFICATION_ID=0x123;
    NotificationManager nm;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this,OtherActivity.class);
        PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,intent,0);
        Notification notify=new Notification.Builder(this).setAutoCancel(true).setTicker("有新消息").setSmallIcon(R.drawable.notify)
                .setContentTitle("恭喜您，您加薪了！")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi).build();
        nm.notify(NOTIFICATION_ID,notify);
    }
    public void del(View v){
        nm.cancel(NOTIFICATION_ID);
    }

}
