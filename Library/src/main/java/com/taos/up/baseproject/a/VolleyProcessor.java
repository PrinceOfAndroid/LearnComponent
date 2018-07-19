package com.taos.up.baseproject.a;

import com.android.volley.RequestQueue;

import java.util.Map;

/**
 * Created by PrinceOfAndroid on 2018/7/12 0012.
 * 真正的实现者
 */

public class VolleyProcessor implements IHttpProcessor{
    private static RequestQueue queue;
    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {

    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {

    }
}
