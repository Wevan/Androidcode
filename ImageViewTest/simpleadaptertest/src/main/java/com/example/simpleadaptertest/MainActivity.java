package com.example.simpleadaptertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] names=new String[]{
            "小灰灰","妞妞","端午"
    };
    private String[] descs=new String[]{
            "可爱的小宝宝","小屁孩儿","伟大的萌妹纸~"
    };
    private int[] imageIds=new int[]{
            R.drawable.xiaohuihiu,R.drawable.niuniu,R.drawable.duanwu
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem= new HashMap<String, Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header","desc"},new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list= (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
    }
}
