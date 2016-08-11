package com.example.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private static int RQE_1=1;
    private static int RQE_2=2;
    private String mFilePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.iv);
        mFilePath= Environment.getExternalStorageDirectory().getPath();
        mFilePath=mFilePath+"/"+"temp.png";
    }
    public void startCamera(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,RQE_1);
    }
    public void startCamera2(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri photoUri=Uri.fromFile(new File(mFilePath));
        intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
        startActivityForResult(intent,RQE_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==RQE_1){
                Bundle bundle=data.getExtras();
                Bitmap bitmap= (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);
            }
            else if (requestCode==RQE_2){
                FileInputStream fis = null;
                try {
                    fis=new FileInputStream(mFilePath);
                    Bitmap bitmap= BitmapFactory.decodeStream(fis);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
