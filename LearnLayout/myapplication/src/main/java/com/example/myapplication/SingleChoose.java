package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SingleChoose extends AppCompatActivity {

    private Button btnSubmit;
    private RadioButton rbA,rbB,rbC,rbD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choose);

        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        rbA= (RadioButton) findViewById(R.id.rbA);
        rbB= (RadioButton) findViewById(R.id.rbB);
        rbC= (RadioButton) findViewById(R.id.rbC);
        rbD= (RadioButton) findViewById(R.id.rbD);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbA.isChecked()){
                    Toast.makeText(SingleChoose.this,"过奖过奖~",Toast.LENGTH_SHORT);
                }
                else if (rbB.isChecked()){
                    Toast.makeText(SingleChoose.this,"哪里哪里~",Toast.LENGTH_SHORT);
                }
                else if (rbC.isChecked()){
                    Toast.makeText(SingleChoose.this,"没有没有~",Toast.LENGTH_SHORT);
                }
                else if (rbD.isChecked()){
                    Toast.makeText(SingleChoose.this,"啊哈哈哈~",Toast.LENGTH_SHORT);
                }

            }
        });
    }
}
