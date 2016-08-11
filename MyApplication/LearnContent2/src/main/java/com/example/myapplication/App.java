package com.example.myapplication;

import android.app.Application;

/**
 * Created by Wean on 2016/7/5.
 */
public class App extends Application{
    private String textData="default";

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }

}
