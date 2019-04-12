package com.egar.launcher.Utils;

import android.util.Log;

/**
 * Created by ybf on 2019/4/11.
 */

public class LogUtil {
    public static Boolean DEBUG = true;
    public static String tag = "LC_";

    public static void i(String TAG, String msg) {
        if (DEBUG) {
            Log.i(tag+TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (DEBUG) {
            Log.d(tag+TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (DEBUG) {
            Log.e(tag+TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (DEBUG) {
            Log.w(tag+TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (DEBUG) {
            Log.v(tag+TAG, msg);
        }
    }

    /**
     * 根据tag打印相关v信息
     * @param tag
     * @param msg
     */
    public static void V(String TAG,String msg)
    {
        if(DEBUG){
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>";
            android.util.Log.v(tag+TAG, traceInfo+msg);
        }
    }
    public static void E(String TAG,String msg)
    {
        if(DEBUG){
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>";
            android.util.Log.e(tag+TAG, traceInfo+msg);
        }
    }
}
