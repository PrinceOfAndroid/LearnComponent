package com.taos.up.learncomponent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/app/main")
public class MainActivity extends SimpleActivity {
    @BindView(R.id.base_title)
    BaseTitle baseTitle;
    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        baseTitle.setTitle("测试组件化");
    }

    @Override
    protected void initEventLoadData() {

    }


    @OnClick({R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                LogUtils.e("ssss");
                ARouter.getInstance().build("/learnui/LearnUiListActivity")
                        .navigation();
                break;
            case R.id.btn_two:
                break;
        }
    }
}
