package com.egar.launcher.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.egar.launcher.Bean.ReceiverBean.HomeKeyMessage;
import com.egar.launcher.Common.EgarIntent;
import com.egar.launcher.Utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ybf on 2019/4/12.
 */
public class DynamicReceiver extends BroadcastReceiver {
    private String TAG = getClass().getSimpleName();
    private String mAction;
    private static DynamicReceiver mDynamicReceiver = new DynamicReceiver();

    public static DynamicReceiver getInstance() {
        return mDynamicReceiver;
    }

    public void regiestBroadcast(Context mContext) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(EgarIntent.BluetoothOhoneState);
        filter.addAction(EgarIntent.HOME_KEY_DOWNE);
        mContext.registerReceiver(mDynamicReceiver, filter);
    }

    public void unRegiestBroadcast(Context mContext) {
        mContext.unregisterReceiver(mDynamicReceiver);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        mAction = intent.getAction();
        LogUtil.i(TAG, "mAction=" + mAction);
        if (EgarIntent.HOME_KEY_DOWNE.equals(mAction)) {
            HomeKeyEvent(intent);
        }
    }
    public void HomeKeyEvent(Intent intent){
        HomeKeyMessage homeKeyMessage = new HomeKeyMessage();
        homeKeyMessage.setIntent(intent);
        EventBus.getDefault().post(homeKeyMessage);
    }
}
