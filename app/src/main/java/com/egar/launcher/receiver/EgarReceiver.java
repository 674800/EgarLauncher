package com.egar.launcher.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.egar.launcher.Bean.ReceiverBean.InstallMessage;
import com.egar.launcher.Bean.ReceiverBean.ReplaceAppMessage;
import com.egar.launcher.Bean.ReceiverBean.UnInsatllMessage;
import com.egar.launcher.Common.EgarIntent;
import com.egar.launcher.Utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ybf on 2019/4/12.
 */
public class EgarReceiver extends BroadcastReceiver {
    private String TAG = getClass().getSimpleName();
    private String mAction;


    @Override
    public void onReceive(Context context, Intent intent) {
        mAction = intent.getAction();
        LogUtil.i(TAG, "action " + mAction);
        if (EgarIntent.BOOT_COMPLETED.equals(mAction)) {

        } else if (EgarIntent.ACTION_SHUTDOWN.equals(mAction)) {

        } else if (EgarIntent.MEDIA_MOUNTED.equals(mAction)) {

        } else if (EgarIntent.MEDIA_UNMOUNTED.equals(mAction)) {

        } else if (EgarIntent.PACKAGE_ADDED.equals(mAction)) {
            installApp(intent);
        } else if (EgarIntent.PACKAGE_REMOVED.equals(mAction)) {
            unInstallApp(intent);
        } else if (EgarIntent.PACKAGE_REPLACED.equals(mAction)) {
            replaceApp(intent);
        } else if (EgarIntent.TESt.equals(mAction)) {
            EventBus.getDefault().post("test");
        }
    }

    private void installApp(Intent intent) {
        String packageName = intent.getData().getSchemeSpecificPart();
        InstallMessage mInstallMessage = new InstallMessage();
        mInstallMessage.setmPackageName(packageName);
        EventBus.getDefault().post(mInstallMessage);
    }

    private void unInstallApp(Intent intent) {
        String packageName = intent.getData().getSchemeSpecificPart();
        UnInsatllMessage mUnInsatllMessage = new UnInsatllMessage();
        mUnInsatllMessage.setmPackageName(packageName);
        EventBus.getDefault().post(mUnInsatllMessage);
    }

    private void replaceApp(Intent intent) {
        String packageName = intent.getData().getSchemeSpecificPart();
        ReplaceAppMessage mReplaceAppMessage = new ReplaceAppMessage();
        mReplaceAppMessage.setmPackageName(packageName);
        EventBus.getDefault().post(mReplaceAppMessage);
    }
}
