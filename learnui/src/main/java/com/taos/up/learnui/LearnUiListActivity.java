package com.taos.up.learnui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;

import butterknife.BindView;


@Route(path = "/learnui/LearnUiListActivity")
public class LearnUiListActivity extends SimpleActivity {


    @BindView(R2.id.base_title)
    BaseTitle baseTitle;
    @BindView(R2.id.re_ui_demo)
    RecyclerView reUiDemo;

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
    }

    @Override
    protected void initEventLoadData() {

    }


}
