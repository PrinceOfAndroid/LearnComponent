package com.taos.up.learnui.ui;

import android.os.Bundle;
import android.view.View;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;

import butterknife.BindView;

/**
 * Created by PrinceOfAndroid on 2018/6/28 0028.
 */

public class CommonUiActivity extends SimpleActivity {
    @BindView(R2.id.base_title)
    BaseTitle baseTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_common_ui;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        baseTitle.setTitle("普通ui")
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
