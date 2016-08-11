package com.example.choosedate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NumberPicker np1,np2;
    int minPrice=25,maxPrice=75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np1= (NumberPicker) findViewById(R.id.np1);
        np2= (NumberPicker) findViewById(R.id.np2);
        np1.setMinValue(10);
        np1.setMaxValue(50);
        np1.setValue(minPrice);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                minPrice=i1;
                showSelectedPrice();
            }
        });
        np2.setMinValue(60);
        np2.setMaxValue(100);
        np2.setValue(maxPrice);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                maxPrice=i1;
                showSelectedPrice();
            }
        });
    }
    private void showSelectedPrice(){
        Toast.makeText(this,"您选择的最低价为："+minPrice+"\n"+"最高价为:"+maxPrice,Toast.LENGTH_SHORT).show();
    }
}
