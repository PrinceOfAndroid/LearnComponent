package com.taos.up.learnui.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taos.up.baseproject.mode.strategy.StrategyA;
import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.learnui.service.BinderService;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.R;
import com.taos.up.learnui.adapters.UiDemoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by PrinceOfAndroid on 2018/7/27 0027.
 */

public class ModeActivity extends SimpleActivity {
    @BindView(R.id.base_title)
    BaseTitle baseTitle;
    @BindView(R.id.re_mode)
    RecyclerView reMode;

    public static List<String> uiList;
    private UiDemoListAdapter adapter;
    private BinderService.LocalBinder myBinder;

    static {
        uiList = new ArrayList<>();
        uiList.add("策略模式");
        uiList.add("bindService取值");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_mode;
    }

    @Override
    protected void initData() {

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtils.e("??");
            myBinder = (BinderService.LocalBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtils.e("解绑回调");
            myBinder = null;
        }
    };

    @Override
    public void initView(Bundle savedInstanceState) {
        baseTitle.setTitle("设计模式")
                .setLeftText("返回")
                .setOnLeftClickListener(new BaseTitle.OnLeftClickListener() {
                    @Override
                    public void leftClick(View view) {
                        finish();
                    }
                });

        adapter = new UiDemoListAdapter(R.layout.item_ui_demo, uiList);
        reMode.setLayoutManager(new LinearLayoutManager(ModeActivity.this));
        reMode.setAdapter(adapter);

        LogUtils.e("zzzz");
        Intent intent = new Intent(this, BinderService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);

    }

    @Override
    protected void initEventLoadData() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        new StrategyA().show();
                        break;
                    case 1:
                        LogUtils.e("ssss");
                        if (myBinder != null) {
                            LogUtils.e("zzzzc");
                            LogUtils.e(myBinder.getService().getServiceValue() + "");
                            unbindService(connection);
                            myBinder = null;
                        }

                        break;
                }
            }
        });

    }


}
