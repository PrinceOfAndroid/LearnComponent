package com.taos.up.learnui.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;
import com.taos.up.learnui.adapters.FakeAdapter;
import com.taos.up.learnui.widgets.MyHorizontalScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by PrinceOfAndroid on 2018/7/18 0018.
 */

public class ScrollRecyclerViewActivity extends SimpleActivity {
    @BindView(R2.id.base_title)
    BaseTitle baseTitle;
    @BindView(R2.id.re_slide)
    MyHorizontalScrollRecyclerView reSlide;

    private static List<String> items;

    static {
        items = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            items.add(i + "");
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_recyclerview_touch;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        reSlide.setLayoutManager(new LinearLayoutManager(ScrollRecyclerViewActivity.this));
        reSlide.setAdapter(new FakeAdapter(R.layout.item_section, items));

        baseTitle.setTitle("recyclerView嵌套滑动")
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
