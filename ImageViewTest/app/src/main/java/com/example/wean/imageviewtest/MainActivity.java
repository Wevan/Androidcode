package com.example.wean.imageviewtest;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] images=new int[]{
            R.drawable.img1,
            R.drawable.go
    };
    int currentImg=0;
    private int alpha=225;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button plus= (Button) findViewById(R.id.plus);
        final Button minus= (Button) findViewById(R.id.minus);
        final ImageView image1= (ImageView) findViewById(R.id.img1);
        final ImageView image2= (ImageView) findViewById(R.id.img2);
        final Button next= (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setImageResource(images[++currentImg%images.length]);
            }
        });
        View.OnClickListener listener=new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(view==plus){
                    alpha+=20;
                }
                if (view==minus){
                    alpha-=20;
                }
                if(alpha>=225){
                    alpha=225;
                }
                if (alpha<=0){
                    alpha=0;
                }//ok  傻
                image1.setImageAlpha(alpha);
            }
        };
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable= (BitmapDrawable) image1.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                double scale=1.0*bitmap.getHeight()/image1.getHeight();
                int x=(int)(motionEvent.getX()*scale);
                int y=(int)(motionEvent.getY()*scale);
                if (x+120>bitmap.getWidth()){
                    x=bitmap.getWidth()-120;
                }
                if (y+120>bitmap.getWidth()){
                    y=bitmap.getWidth()-120;
                }
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
