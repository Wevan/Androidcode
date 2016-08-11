package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Wean on 2016/7/5.
 */
public class Main2 extends Activity {
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        textView= (TextView) findViewById(R.id.textView);
        editText= (EditText) findViewById(R.id.editText);
        textView.setText("共享的数据是："+((App)getApplicationContext()));
        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((App)getApplicationContext()).setTextData(editText.getText().toString());
                textView.setText("共享的数据是："+editText.getText().toString());
            }
        });
    }
}
