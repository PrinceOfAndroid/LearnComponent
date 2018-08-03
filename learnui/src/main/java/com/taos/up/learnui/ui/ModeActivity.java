package com.taos.up.learnui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taos.up.baseproject.mode.strategy.StrategyA;
import com.taos.up.baseproject.mvp.SimpleActivity;
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

    static {
        uiList = new ArrayList<>();
        uiList.add("策略模式");

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_mode;
    }

    @Override
    protected void initData() {

    }

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
                }
            }
        });

    }


}
