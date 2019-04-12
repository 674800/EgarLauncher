package com.egar.launcher;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.egar.launcher.Bean.ReceiverBean.BootCompleteMessage;
import com.egar.launcher.Bean.ReceiverBean.HomeKeyMessage;
import com.egar.launcher.Bean.ReceiverBean.InstallMessage;
import com.egar.launcher.Bean.ReceiverBean.ReplaceAppMessage;
import com.egar.launcher.Bean.ReceiverBean.SdCardMountMessage;
import com.egar.launcher.Bean.ReceiverBean.ShoutDownMessage;
import com.egar.launcher.Bean.ReceiverBean.UnInsatllMessage;
import com.egar.launcher.Bean.settingsBean.BtMuStateMessage;
import com.egar.launcher.Bean.settingsBean.FMStateMessage;
import com.egar.launcher.Bean.settingsBean.MusicStateMessage;
import com.egar.launcher.Bean.settingsBean.ThemeMessage;
import com.egar.launcher.Interfac.ISettingsCallBack;
import com.egar.launcher.Interfac.ReceiverListener;
import com.egar.launcher.Utils.LogUtil;
import com.egar.launcher.View.DraggableGridViewPager;
import com.egar.launcher.presen.SettingsObserver;
import com.egar.launcher.receiver.DynamicReceiver;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Launcher extends BaseActivity implements ISettingsCallBack, ReceiverListener {

    private String TAG = "EgarLauncher";
    private DraggableGridViewPager mDraggableGridViewPager;
    private LinearLayout mLinearLayout;
    private SettingsObserver mSettingsObserver;
    private DynamicReceiver mDynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        initView();
        initData();

    }

    @Override
    public void initView() {
        mDraggableGridViewPager = findViewById(R.id.DraggView_content);
        mLinearLayout = this.findViewById(R.id.page_num);
    }

    @Override
    public void initData() {
        mSettingsObserver = new SettingsObserver(AppApplication.getInstace());
//         mDynamicReceiver = new DynamicReceiver();
//        mDynamicReceiver.regiestBroadcast(AppApplication.getInstace(),mDynamicReceiver);
        DynamicReceiver.getInstance().regiestBroadcast(AppApplication.getInstace());
    }



    /*---------------------settings start---------------------------------*/
    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onThemeChange(ThemeMessage message) {
        LogUtil.i(TAG, "onThemeChange=" + message.getThemState());

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFMChange(FMStateMessage message) {

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBTMusicChange(BtMuStateMessage message) {

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMusicChang(MusicStateMessage message) {

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCarLifeChange() {

    }
    /*---------------------end---------------------------------*/



    /*---------------------receiver start---------------------------------*/

    @Override
    public void onNotifyBootComplete(BootCompleteMessage message) {

    }

    @Override
    public void onNotifyShutDown(ShoutDownMessage message) {

    }

    @Override
    public void onNotifySDCardMounted(SdCardMountMessage message) {

    }

    @Override
    public void notifyOpenDvr() {

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotifyAppAdded(InstallMessage message) {
        LogUtil.i(TAG, "install app =" + message.getmPackageName());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotifyAppRemove(UnInsatllMessage message) {
        LogUtil.i(TAG, "uninstall app =" + message.getmPackageName());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotifyAppReplace(ReplaceAppMessage message) {

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomeKeyChange(HomeKeyMessage message) {
        LogUtil.i(TAG, "HomeKey =" + message.getIntent().getExtras().getBoolean("isLauncher",false));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void TestReciever(String st) {
        LogUtil.i(TAG, "st =" + st);
    }

    /*---------------------receiver end---------------------------------*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSettingsObserver.unRegiestSettingsObServer();
        DynamicReceiver.getInstance().unRegiestBroadcast(AppApplication.getInstace());
    }
}
