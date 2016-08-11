package com.example.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Wean on 2016/7/24.
 */
public class MainActivity2 extends Activity{
    private TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.main2);
        Button button= (Button) findViewById(R.id.button);
        tv= (TextView) findViewById(R.id.text);
        button.setText("改变");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("改变了");
            }
        });
    }
}
