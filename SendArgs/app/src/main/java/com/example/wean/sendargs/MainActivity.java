package com.example.wean.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,TheAty.class);
              //  i.putExtra("data","我好懵逼，麻麻叫我回家了= =先回家了");
//                Bundle b =new Bundle();//传数据包
//                b.putString("name","Geeker");
//                b.putInt("age",2);
//                b.putString("name1","Wean");
//                i.putExtra("data",b);
//               // i.putExtras(b);
                i.putExtra("user",new User("jike",2));
//                startActivity(i);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText("另一个Activity返回的数据是："+data.getStringExtra("data"));
    }
}
