package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
    }
    public void simple(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("简单对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                .setMessage("对话框的测试内容\n第二行内容");
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }
    private AlertDialog.Builder setPositiveButton(
            AlertDialog.Builder builder)
    {
        // 调用setPositiveButton方法添加“确定”按钮
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("单击了【确定】按钮！");
            }
        });
    }
    private AlertDialog.Builder setNegativeButton(
            AlertDialog.Builder builder)
    {
        // 调用setNegativeButton方法添加“取消”按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("单击了【取消】按钮！");
            }
        });
    }
}
