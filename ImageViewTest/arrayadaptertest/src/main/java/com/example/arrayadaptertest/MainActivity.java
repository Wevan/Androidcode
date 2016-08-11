package com.example.arrayadaptertest;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1= (ListView) findViewById(R.id.list1);
        String[] arr1={"红太郎","灰太狼","小灰灰"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr1);
        setListAdapter(adapter);
//        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.arrat_item,arr1);
//        list1.setAdapter(adapter1);
//        ListView list2= (ListView) findViewById(R.id.list2);
//        String[] arr2={"Baby","宝宝","灰酱"};
//        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.arrat_item,arr2);
//        list2.setAdapter(adapter2);

    }
}
