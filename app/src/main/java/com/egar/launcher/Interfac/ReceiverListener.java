package com.egar.launcher.Interfac;

import com.egar.launcher.Bean.ReceiverBean.BootCompleteMessage;
import com.egar.launcher.Bean.ReceiverBean.HomeKeyMessage;
import com.egar.launcher.Bean.ReceiverBean.InstallMessage;
import com.egar.launcher.Bean.ReceiverBean.ReplaceAppMessage;
import com.egar.launcher.Bean.ReceiverBean.SdCardMountMessage;
import com.egar.launcher.Bean.ReceiverBean.ShoutDownMessage;
import com.egar.launcher.Bean.ReceiverBean.UnInsatllMessage;

/**
 * Created by ybf on 2019/4/12.
 */
public interface ReceiverListener {

    /**
     * Notify 收到开机广播
     */
     void onNotifyBootComplete(BootCompleteMessage message);

    /**
     * Notify 关机广播
     */
     void onNotifyShutDown(ShoutDownMessage message);

    /**
     * Notify 插入SD卡的广播
     */
     void onNotifySDCardMounted(SdCardMountMessage message);

    /**
     * 语音广播打开dvr
     */
     void notifyOpenDvr();


    /**
     * install app
      */

     void onNotifyAppAdded(InstallMessage message);

    /**
     *  uninstall app
     */

     void onNotifyAppRemove(UnInsatllMessage message);

    /**
     * change app
     * @param packagename
     */
     void onNotifyAppReplace(ReplaceAppMessage message);

     void  onHomeKeyChange(HomeKeyMessage message);
}
