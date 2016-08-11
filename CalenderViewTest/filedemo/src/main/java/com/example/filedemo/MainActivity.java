package com.example.filedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        File file=new File("/mnt/sdcard/test");
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            Toast.makeText(MainActivity.this,"文件已存在",1000);
//        }
//        File file=this.getCacheDir();
//        Log.i("info",file.toString());
        
    }
}
