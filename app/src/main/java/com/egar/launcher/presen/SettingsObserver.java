package com.egar.launcher.presen;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;

import com.egar.launcher.Common.SettingsString;
import com.egar.launcher.Interfac.ISettings;

/**
 * Created by ybf on 2019/4/11.
 */
public class SettingsObserver {
    private ISettings iSettings;
    private Context mContext;
    private ThemeContentObserver mThemeContentObserver;

    public SettingsObserver(ISettings iSettings,Context mContext){
        this.iSettings = iSettings;
        this.mContext = mContext;
        mThemeContentObserver = new ThemeContentObserver();
    }

    public void regiestSettingObserver() {
            mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(SettingsString.THEME_SETTING),
                    true,mThemeContentObserver);
    }


    /**
     * 监听主题改变
     */
    class ThemeContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public ThemeContentObserver(Handler handler) {
            super(handler);
        }

        public ThemeContentObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            iSettings.onThemeChange();
        }
    }
}
