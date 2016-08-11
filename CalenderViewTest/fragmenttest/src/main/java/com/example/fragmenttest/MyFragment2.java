package com.example.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Wean on 2016/7/24.
 */
public class MyFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //layout布局文件转换成View对象
       View view = inflater.inflate(R.layout.fragment,container,false);
        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText("动态加载Fragement");
        return view;
    }
}
