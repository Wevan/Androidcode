package com.example.sqlitedemo1;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db= openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        db.execSQL("creat table if not exists usertb(_id integer mrimary key autoincrement,name text not null,age integer not null,sex text not null )");
        db.execSQL("insert into usertb(name,sex,age)");
    }
}
