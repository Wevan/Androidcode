package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        tv=new TextView(MainActivity.this);
//        tv.setText("Hello Android");
//        tv.setText(R.string.app_name);
//        setContentView(tv);
//        System.out.println(getResources().getText(R.string.app_name));
//        ImageView iv=new ImageView(this);
//        iv.setImageResource(R.mipmap.ic_launcher);
//        setContentView(iv);
        setContentView(R.layout.main1);
        textView= (TextView) findViewById(R.id.textView);
        editText= (EditText) findViewById(R.id.editText);
        textView.setText("共享的数据是："+editText.getText().toString());
        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((App)getApplicationContext()).setTextData(editText.getText().toString());
                textView.setText("共享的数据是："+editText.getText().toString());
            }
        });
    }
}
