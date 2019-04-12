package com.egar.launcher.Bean;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;


public class AppInfo {

    private ResolveInfo ResolveInfo;
    private String Title;
    private String MainClassName;
    private Drawable Icon;
    private int AppType;

    AppInfo() {
        ResolveInfo = null;
        Title = "";
        MainClassName = "";
        Icon = null;
        AppType = -1;
    }

    public android.content.pm.ResolveInfo getResolveInfo() {
        return ResolveInfo;
    }

    public void setResolveInfo(android.content.pm.ResolveInfo resolveInfo) {
        ResolveInfo = resolveInfo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMainClassName() {
        return MainClassName;
    }

    public void setMainClassName(String mainClassName) {
        MainClassName = mainClassName;
    }

    public Drawable getIcon() {
        return Icon;
    }

    public void setIcon(Drawable icon) {
        Icon = icon;
    }

    public int getAppType() {
        return AppType;
    }

    public void setAppType(int appType) {
        AppType = appType;
    }


}
