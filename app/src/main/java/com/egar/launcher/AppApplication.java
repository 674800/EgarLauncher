package com.egar.launcher;

import android.app.Application;
import android.content.Context;

/**
 * Created by ybf on 2019/4/11.
 */
public class AppApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getInstence(){
        return  mContext;
    }
}
