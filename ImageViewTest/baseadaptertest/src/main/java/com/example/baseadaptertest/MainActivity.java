package com.example.baseadaptertest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList= (ListView) findViewById(R.id.myList);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout line=new LinearLayout(MainActivity.this);
                line.setOrientation(0);
                ImageView image=new ImageView(MainActivity.this);
                image.setImageAlpha(R.drawable.img);
                TextView text=new TextView(MainActivity.this);
                text.setText("The No."+(i+1)+"choosen");
                text.setTextSize(20);
                text.setTextColor(Color.BLUE);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}
