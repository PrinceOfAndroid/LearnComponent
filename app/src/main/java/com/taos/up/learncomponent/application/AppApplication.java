package com.taos.up.learncomponent.application;

import com.taos.up.baseproject.application.MyApplication;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by PrinceOfAndroid on 2018/6/25 0025.
 */

public class AppApplication extends MyApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
