package com.example.menutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int FONT_10=0x111;
    final int FONT_12=0x112;
    final int FONT_14=0x113;
    final int FONT_16=0x114;
    final int FONT_18=0x115;
    final int PLAIN_ITEM=0x11b;
    final int FONT_RED=0X116;
    final int FONT_BLUE=0x117;
    final int FONT_GREEN=0x118;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit= (EditText) findViewById(R.id.txt);
    }
    public boolean onCreatOptionsMenu(Menu menu){
        SubMenu fontMenu=menu.addSubMenu("字体大小");
        fontMenu.setIcon(R.drawable.font);
        fontMenu.setHeaderIcon(R.drawable.font);
        fontMenu.add(0,FONT_10,0,"10号字体");
        fontMenu.add(0,FONT_10,0,"12号字体");
        fontMenu.add(0,FONT_10,0,"14号字体");
        fontMenu.add(0,FONT_10,0,"16号字体");
        fontMenu.add(0,FONT_10,0,"18号字体");
        menu.add(0,PLAIN_ITEM,0,"普通菜单选项");
        SubMenu colorMenu=menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.color);
        colorMenu.setHeaderIcon(R.drawable.color);
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_GREEN,0,"绿色");
        colorMenu.add(0,FONT_BLUE,0,"蓝色");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case FONT_10:
                edit.setTextSize(10*2);
            case FONT_12:
                edit.setTextSize(12*2);
            case FONT_14:
                edit.setTextSize(14*2);
            case FONT_16:
                edit.setTextSize(16*2);
            case FONT_18:
                edit.setTextSize(18*2);
            case FONT_RED:
                edit.setTextColor(Color.RED);
            case FONT_GREEN:
                edit.setTextColor(Color.GREEN);
            case FONT_BLUE:
                edit.setTextColor(Color.BLUE);
            case PLAIN_ITEM:
                Toast toast=Toast.makeText(MainActivity.this,"您单机了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

}
