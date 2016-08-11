package com.example.sqlitepenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wean on 2016/7/28.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }
//首次向创建数据库调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("creat table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
        db.execSQL("insert into stutb(name,sex,age)values('Landy','male',18)");
    }
//数据库版本发生变化自动执行
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
