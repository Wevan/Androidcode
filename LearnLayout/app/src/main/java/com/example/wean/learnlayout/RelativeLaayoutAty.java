package com.example.wean.learnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLaayoutAty extends AppCompatActivity {
    private RelativeLayout root;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        root=new RelativeLayout(this);
        setContentView(root);

        tv=new TextView(this);
        tv.setText("huier");

        RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        root.addView(tv,lp);
    }
}
