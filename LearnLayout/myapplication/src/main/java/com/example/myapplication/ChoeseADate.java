package com.example.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ChoeseADate extends AppCompatActivity {

    private Button btnChooseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choese_adate);

        btnChooseDate= (Button) findViewById(R.id.btnChooseDate);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ChoeseADate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String theDate=String.format("%d-%d-%d",i,i1+1,i2);

                        System.out.println(theDate);

                        btnChooseDate.setText(theDate);
                    }
                },2016,6,11).show();
            }
        });
    }
}
