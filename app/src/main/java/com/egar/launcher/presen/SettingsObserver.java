package com.egar.launcher.presen;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;

import com.egar.launcher.Bean.settingsBean.BtMuStateMessage;
import com.egar.launcher.Bean.settingsBean.CarLifeStateMessage;
import com.egar.launcher.Bean.settingsBean.FMStateMessage;
import com.egar.launcher.Bean.settingsBean.MusicStateMessage;
import com.egar.launcher.Bean.settingsBean.ThemeMessage;
import com.egar.launcher.Common.SettingsStrProvider;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ybf on 2019/4/11.
 */
public class SettingsObserver {
    private String TAG = getClass().getSimpleName();
    // private ISettingsCallBack iSettings;
    public Context mContext;
    private ThemeContentObserver mThemeContentObserver;
    private FMChangeContentObserver mFmChangeContentObserver;
    private BTMusicChangeContentObserver mBTMusicChangeContentObserver;
    private MusicChangContentObserver mMusicChangContentObserver;
    private CarLifeChangeContentObserver mCarLifeChangeContentObserver;
    private ThemeMessage mMessageEvent;
    private FMStateMessage mFMStateMessage;
    private BtMuStateMessage mBtMuStateMessage;
    private MusicStateMessage mMusicStateMessage;
    private CarLifeStateMessage mCarLifeStateMessage;

    public SettingsObserver(Context mContext) {

        this.mContext = mContext;
        mThemeContentObserver = new ThemeContentObserver();
        mFmChangeContentObserver = new FMChangeContentObserver();
        mBTMusicChangeContentObserver = new BTMusicChangeContentObserver();
        mMusicChangContentObserver = new MusicChangContentObserver();
        mCarLifeChangeContentObserver = new CarLifeChangeContentObserver();
        mMessageEvent = new ThemeMessage();
        mFMStateMessage = new FMStateMessage();
        mBtMuStateMessage = new BtMuStateMessage();
        mMusicStateMessage = new MusicStateMessage();
        mCarLifeStateMessage = new CarLifeStateMessage();
        regiestSettingObserver();
    }

    public void regiestSettingObserver() {
        mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(SettingsStrProvider.THEME_STATE),
                true, mThemeContentObserver);
        mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(SettingsStrProvider.FM_STATE),
                true, mFmChangeContentObserver);
        mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SettingsStrProvider.BT_MUSIC_STATE),
                true, mBTMusicChangeContentObserver);
        mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(SettingsStrProvider.MUSIC_STATE),
                true, mMusicChangContentObserver);
        mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SettingsStrProvider.CAR_LIFE_STATE),
                true, mCarLifeChangeContentObserver);
    }

    public void unRegiestSettingsObServer() {
        mContext.getContentResolver().unregisterContentObserver(mThemeContentObserver);
        mContext.getContentResolver().unregisterContentObserver(mFmChangeContentObserver);
        mContext.getContentResolver().unregisterContentObserver(mBTMusicChangeContentObserver);
        mContext.getContentResolver().unregisterContentObserver(mMusicChangContentObserver);
        mContext.getContentResolver().unregisterContentObserver(mCarLifeChangeContentObserver);
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
            int Theme = Settings.System.getInt(mContext.getContentResolver(), SettingsStrProvider.THEME_STATE, 0);
            mMessageEvent.setThemState(Theme);
            EventBus.getDefault().post(mMessageEvent);

        }
    }

    /**
     * 收音机状态改变
     */
    class FMChangeContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public FMChangeContentObserver(Handler handler) {
            super(handler);
        }

        public FMChangeContentObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            try {
                int fm_state = Settings.System.getInt(mContext.getContentResolver(), SettingsStrProvider.FM_STATE);
                mFMStateMessage.setFMState(fm_state);
                EventBus.getDefault().post(mFMStateMessage);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 蓝牙音乐
     */
    class BTMusicChangeContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public BTMusicChangeContentObserver(Handler handler) {
            super(handler);
        }

        public BTMusicChangeContentObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            try {
                int bt_mustic_state = Settings.Global.getInt(mContext.getContentResolver(), SettingsStrProvider.BT_MUSIC_STATE);
                mBtMuStateMessage.setBtMuState(bt_mustic_state);
                EventBus.getDefault().post(mBtMuStateMessage);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 音乐状态改变
     */
    class MusicChangContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MusicChangContentObserver(Handler handler) {
            super(handler);
        }

        public MusicChangContentObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            try {
                int music_state = Settings.System.getInt(mContext.getContentResolver(), SettingsStrProvider.MUSIC_STATE);
                mMusicStateMessage.setMusicState(music_state);
                EventBus.getDefault().post(mMusicStateMessage);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    class CarLifeChangeContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public CarLifeChangeContentObserver(Handler handler) {
            super(handler);
        }

        public CarLifeChangeContentObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            EventBus.getDefault().post(mCarLifeStateMessage);
        }
    }


}
