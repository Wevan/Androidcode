package com.example.menurestest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PopupMenu popup=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onPopupButtonClick(View button){
        popup=new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.exit:
                        popup.dismiss();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"您单击了【"+item.getTitle()+"】菜单项",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        popup.show();
    }
}
