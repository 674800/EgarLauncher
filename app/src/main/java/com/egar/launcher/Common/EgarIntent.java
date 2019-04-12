package com.egar.launcher.Common;

import android.content.Intent;

/**
 * Created by ybf on 2019/4/12.
 */
public class EgarIntent {
    public static final String TESt = "com.test.receiver";
    public static final String BOOT_COMPLETED = Intent.ACTION_BOOT_COMPLETED;
    public static final String ACTION_SHUTDOWN = Intent.ACTION_SHUTDOWN;
    public static final String MEDIA_MOUNTED = Intent.ACTION_MEDIA_MOUNTED;
    public static final String MEDIA_UNMOUNTED = Intent.ACTION_MEDIA_UNMOUNTED;

    public static final String PACKAGE_ADDED = Intent.ACTION_PACKAGE_ADDED;
    public static final String PACKAGE_REMOVED = Intent.ACTION_PACKAGE_REMOVED;
    public static final String PACKAGE_REPLACED = Intent.ACTION_PACKAGE_REPLACED;


    public static final String BluetoothOhoneState = "android.bluetooth.headsetclient.profile.action.CONNECTION_STATE_CHANGED";
    public static final String A2DP_CONNECT_CHANGE = "com.tricheer.bt.a2dp_change";
    public static final String HOME_KEY_DOWNE="com.lct.KEYCODE_HOME";
}
