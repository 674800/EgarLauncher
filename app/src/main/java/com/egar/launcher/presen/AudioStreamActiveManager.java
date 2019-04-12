package com.egar.launcher.presen;

import android.content.Context;
import android.media.AudioManager;
import android.media.IAudioStreamActiveListener;
import android.os.RemoteException;
import android.util.Log;

import java.lang.reflect.Method;

public class AudioStreamActiveManager {
    private String TAG = getClass().getSimpleName();
    private int CALLING_TYPE_CARPLAY = 3;
    private AudioManager mAudioManager;
    private CarPalyCall mCarPalyCall;
    private Context mContext;

    interface CarPalyCall {
        /**
         * Carplay 拨打电话中
         */
        void onCapplayCall(boolean iscall);
    }

    public void SetAudioStreamActiveManager(CarPalyCall mCarPalyCall, Context mContext) {
        this.mCarPalyCall = mCarPalyCall;
        this.mContext = mContext;
        /**
         * 注册监听
         */
        requestStreamActiveListener();
    }

    /**
     * 取消carpaly 监听
     */
    public void unSetAudioStreamAciveManager() {
        abandonStreamActiveListener();
    }

    private final IAudioStreamActiveListener mIAudioStreamActiveListener = new IAudioStreamActiveListener.Stub() {
        @Override
        public void onNavigationStreamActiveChanged(int type, boolean start) throws RemoteException {
            Log.d(TAG, "onNavigationStreamActiveChanged(" + type + ", " + start + ")");

        }

        @Override
        public void onVoiceAssistantStreamActiveChanged(int type, boolean start) throws RemoteException {
            Log.d(TAG, "onVoiceAssistantStreamActiveChanged(" + type + ", " + start + ")");
        }

        // 电话状态有更改时，系统会回调这个接口； 参数type请看CallingType；参数start，值为true代表当前类型的电话转为通话状态，值为false代表当前类型的电话转为非通话状态
        @Override
        public void onCallingStreamActiveChanged(int type, boolean start) throws RemoteException {
            Log.d(TAG, "onCallingStreamActiveChanged(" + type + ", " + start + ")");
            if (CALLING_TYPE_CARPLAY == type) {
                Log.e(TAG, "carPlay calling iscalling = " + start);
                mCarPalyCall.onCapplayCall(start);
            }
        }
    };


    /**
     * 注册carPaly电话拨打状态
     */
    public boolean requestStreamActiveListener() {
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        boolean flag = false;
        try {
            Class clazz = Class.forName("android.media.AudioManager");
            Method method = clazz.getDeclaredMethod("requestStreamActiveListener", IAudioStreamActiveListener.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            flag = (Boolean) method.invoke(mAudioManager, mIAudioStreamActiveListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "requestStreamActiveListener() flag=" + flag);
        return flag;
    }

    /**
     * 解绑
     */
    public boolean abandonStreamActiveListener() {
        boolean flag = false;
        try {
            Class clazz = Class.forName("android.media.AudioManager");
            Method method = clazz.getDeclaredMethod("abandonStreamActiveListener", IAudioStreamActiveListener.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            flag = (Boolean) method.invoke(mAudioManager, mIAudioStreamActiveListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 主动判断carPlay是否打电话中
     * int CALLING_TYPE_CARPLAY = 3;    // CarPlay电话
     */
    public boolean isCallingStreamActive() {    // 参数type传0（CallingType.ANY_ONE）
        boolean flag = false;
        try {
            Class clazz = Class.forName("android.media.AudioManager");
            Method method = clazz.getDeclaredMethod("isCallingStreamActive", int.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            flag = (Boolean) method.invoke(mAudioManager, CALLING_TYPE_CARPLAY);  // 返回值true代表当前处于通话中
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "isCallingStreamActive(" + 3 + ") flag=" + flag);
        return flag;
    }
}
