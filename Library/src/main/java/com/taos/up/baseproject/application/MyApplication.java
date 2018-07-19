package com.taos.up.baseproject.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.taos.up.baseproject.BuildConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PrinceOfAndroid on 2018/4/10 0010.
 */

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {
    private static MyApplication myApplication = null;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(getInstance());
        LogUtils.e("application onCreate");
        //监听每个activity的生命周期
        registerActivityLifecycleCallbacks(this);
        Utils.init(this);
    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (allActivities != null) {
            allActivities.remove(activity);
        }
    }
}
