package com.taos.up.learnui.ui;

import android.os.Bundle;
import android.os.Handler;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;
import com.taos.up.learnui.widgets.SplashView;

import butterknife.BindView;

/**
 * Created by PrinceOfAndroid on 2018/7/19 0019.
 */

public class SplashUiActivity extends SimpleActivity {
    @BindView(R2.id.splash_view)
    SplashView splashView;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash_ui;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟数据加载完成
                splashView.splashDisappear();
            }
        }, 2000);
    }

    @Override
    protected void initEventLoadData() {

    }


}
