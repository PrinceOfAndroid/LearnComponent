package com.taos.up.learnui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.adapters.UiDemoListAdapter;
import com.taos.up.learnui.ui.CommonUiActivity;
import com.taos.up.learnui.ui.DragBubbleActivity;
import com.taos.up.learnui.ui.ModeActivity;
import com.taos.up.learnui.ui.MyRecyclerViewActivity;
import com.taos.up.learnui.ui.ScrollRecyclerViewActivity;
import com.taos.up.learnui.ui.SplashUiActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


@Route(path = "/learnui/LearnUiListActivity")
public class LearnUiListActivity extends SimpleActivity {


    @BindView(R2.id.base_title)
    BaseTitle baseTitle;
    @BindView(R2.id.re_ui_demo)
    RecyclerView reUiDemo;

    public static List<String> uiList;
    private UiDemoListAdapter adapter;

    static {
        uiList = new ArrayList<>();
        uiList.add("仿qq聊天气泡");
        uiList.add("常见Ui");
        uiList.add("recyclerView滑动");
        uiList.add("splashUi");
        uiList.add("设计模式");
        uiList.add("自实行recyclerView");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_learn_ui_list;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        baseTitle.setTitle("高级Ui")
                .setLeftText("返回")
                .setOnLeftClickListener(new BaseTitle.OnLeftClickListener() {
                    @Override
                    public void leftClick(View view) {
                        finish();
                    }
                });

        adapter = new UiDemoListAdapter(R.layout.item_ui_demo, uiList);
        reUiDemo.setLayoutManager(new LinearLayoutManager(LearnUiListActivity.this));
        reUiDemo.setAdapter(adapter);
    }

    @Override
    protected void initEventLoadData() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(LearnUiListActivity.this, DragBubbleActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(LearnUiListActivity.this, CommonUiActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(LearnUiListActivity.this, ScrollRecyclerViewActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(LearnUiListActivity.this, SplashUiActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(LearnUiListActivity.this, ModeActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(LearnUiListActivity.this, MyRecyclerViewActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }


}
