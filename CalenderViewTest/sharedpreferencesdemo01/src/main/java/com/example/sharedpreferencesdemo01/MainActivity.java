package com.example.sharedpreferencesdemo01;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etUserPass;
    CheckBox chk;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.etuserName);
        etUserPass = (EditText) findViewById(R.id.etuserpassword);
        chk = (CheckBox) findViewById(R.id.chkSaveName);
        pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editor = pref.edit();
        String name= pref.getString("useName","");
        if (name==null){
            chk.setChecked(false);
        }else {
            chk.setChecked(true);
            etUserName.setText(name);
        }
    }
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String name=etUserName.getText().toString().trim();
                String pass=etUserPass.getText().toString().trim();
                if ("admin".equals(name)&&"123456".equals(pass)) {
                    if (chk.isChecked()) {
                        editor.putString("userName",name);
                        editor.commit();
                    }
                    else {
                        editor.remove("userName");
                        editor.commit();
                    }
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }

}
