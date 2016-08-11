package com.example.gridviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    ImageView imageView;
    int[] imageIds=new int[]{
        R.drawable.img1,R.drawable.img2,R.drawable.img3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem=new HashMap<String, Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        imageView= (ImageView) findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        grid= (GridView) findViewById(R.id.grid01);
        grid.setAdapter(simpleAdapter);
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }
        });
    }
}
