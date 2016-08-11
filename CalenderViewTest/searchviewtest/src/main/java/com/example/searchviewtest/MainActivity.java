package com.example.searchviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView sv;
    private ListView lv;
    private final String[] mStrings={"aaaa","bbbb","cccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mStrings));
        lv.setTextFilterEnabled(true);
        sv= (SearchView) findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"您的选择是"+query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    lv.clearTextFilter();
                }
                else {
                    lv.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
