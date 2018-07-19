package com.taos.up.learnui.ui;

import android.os.Bundle;
import android.view.View;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PrinceOfAndroid on 2018/6/28 0028.
 */

public class DragBubbleActivity extends SimpleActivity {
    @BindView(R2.id.base_title)
    BaseTitle baseTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_drag_bubble;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        baseTitle.setTitle("气泡拖拽")
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
