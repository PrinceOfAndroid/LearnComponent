package com.taos.up.baseproject.a;

import android.os.Bundle;

import com.taos.up.baseproject.R;
import com.taos.up.baseproject.mvp.SimpleActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PrinceOfAndroid on 2018/7/12 0012.
 */

public class HttpTestActivity extends SimpleActivity {
    private Map<String, Object> params = new HashMap<>();

    @Override
    protected int getLayout() {
        return R.layout.base_title;
    }

    @Override
    protected void initData() {
        HttpHelper.obtain().post("www.baidu.com", params, new HttpCallBack<String>() {
            @Override
            public void onSuccess(String obj) {

            }
        });
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initEventLoadData() {

    }
}
