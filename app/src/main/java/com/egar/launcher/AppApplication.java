package com.egar.launcher;

import android.app.Application;
import android.content.Context;

import com.egar.launcher.Bean.WitheApp;
import com.egar.launcher.Utils.XmlUtilses;

import java.util.ArrayList;

/**
 * Created by ybf on 2019/4/11.
 */
public class AppApplication extends Application {
    public static Context mContext;
    private ArrayList<WitheApp> mWitheApps;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        try {
            mWitheApps =  XmlUtilses.getXmlList(mContext,R.xml.apps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context getInstace(){
        return  mContext;
    }

    public ArrayList<WitheApp> getWitheAppList(){
            return  mWitheApps;
    }
}
