package com.egar.launcher.presen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.egar.launcher.Bean.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ybf on 2019/4/11.
 * 获取数据
 */
public class LauncherModel {



    public ArrayList<AppInfo>  getShowApps(Context mContext){
        ArrayList<AppInfo> appInfos = new ArrayList<AppInfo>();
        PackageManager mPackageManager = mContext.getPackageManager();
        Intent mIntent = new Intent(Intent.ACTION_MAIN,null);
        mIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> allApps = mPackageManager.queryIntentActivities(mIntent,0);

        return  null;
    }
}
