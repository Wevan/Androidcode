package com.example.filedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button but;
    TextView contentvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt= (EditText) findViewById(R.id.editText);
        but= (Button) findViewById(R.id.write);
        contentvalue= (TextView) findViewById(R.id.contentvalue);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteFiles(edt.getText().toString());
                contentvalue.setText(readFiles());
            }
        });

    }

    //保存文件内容
    public void WriteFiles(String content){

        try {
            FileOutputStream fos= openFileOutput("a.txt",MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取文件内容
    public  String readFiles(){
        String content=null;
        FileInputStream fis= null;
        try {
            fis = openFileInput("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        try {
            while ((len=fis.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        content =baos.toString();

        try {
            fis.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
