package com.example.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent;
    private View etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput=findViewById(R.id.edInput);//qiangzhuan

        serviceIntent=new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.startservicefromanotherapp","com.example.startservicefromanotherapp.AppService"));


        findViewById(R.id.btnStartAppService).setOnClickListener(this);
        findViewById(R.id.btnStopAppService).setOnClickListener(this);
        findViewById(R.id.btnBindAppService).setOnClickListener(this);
        findViewById(R.id.btnUnbindAppService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartAppService:

                startService(serviceIntent);
                break;
            case R.id.btnStopAppService:
                stopService(serviceIntent);
                break;
            case R.id.btnBindAppService:
                bindService(serviceIntent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindAppService:
                unbindService(this);
                break;
            case R.id.btnSync:

        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        System.out.println("Bind Service");
        System.out.println(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
