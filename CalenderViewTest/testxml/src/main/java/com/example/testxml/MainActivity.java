package com.example.testxml;

import android.provider.DocumentsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.text);

        try {
            JSONObject root=new JSONObject();
            root.put("cat","it");
            JSONObject lan1=new JSONObject();
            lan1.put("id",1);
            lan1.put("ide","Eclipse");
            lan1.put("name","Java");

            JSONObject lan2=new JSONObject();
            lan1.put("id",2);
            lan1.put("ide","Xcode");
            lan1.put("name","Swift");

            JSONArray array=new JSONArray();
            array.put(lan1);
            array.put(lan2);

            root.put("languages",array);

            System.out.println(root.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
