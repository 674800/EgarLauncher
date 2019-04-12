package com.egar.launcher.Interfac;


import com.egar.launcher.Bean.settingsBean.BtMuStateMessage;
import com.egar.launcher.Bean.settingsBean.FMStateMessage;
import com.egar.launcher.Bean.settingsBean.MusicStateMessage;
import com.egar.launcher.Bean.settingsBean.ThemeMessage;

/**
 * Created by ybf on 2019/4/11.
 */
public interface ISettingsCallBack {
    /**
     * 主题改变
     * 0 默认主题
     * 1 苹果主题
     */
    void onThemeChange(ThemeMessage message);
    /**
     * FM状态改变
     */
    void onFMChange(FMStateMessage message);
    /**
     * 蓝牙音乐
     */
    void onBTMusicChange(BtMuStateMessage message);
    /**
     * 音乐状态
     */
    void onMusicChang(MusicStateMessage message);
    /**
     * carlife状态改变
     */
    void onCarLifeChange();
}
