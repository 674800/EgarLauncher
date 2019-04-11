package com.egar.launcher;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.egar.launcher.Interfac.ISettings;
import com.egar.launcher.View.DraggableGridViewPager;
import com.egar.launcher.presen.SettingsObserver;

public class Launcher extends BaseActivity implements ISettings {
    private DraggableGridViewPager mDraggableGridViewPager;
    private LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mDraggableGridViewPager =  findViewById(R.id.DraggView_content);
        mLinearLayout = this.findViewById(R.id.page_num);
    }

    @Override
    public void initData() {
        SettingsObserver settingsObserver = new SettingsObserver(this,AppApplication.getInstence());
        settingsObserver.regiestSettingObserver();
    }

    @Override
    public void onThemeChange() {
        Log.e("change","change");
    }
}
