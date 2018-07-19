package com.taos.up.baseproject.a;

import java.util.Map;

/**
 * Created by PrinceOfAndroid on 2018/7/12 0012.
 */

public class HttpHelper implements IHttpProcessor {
    private static IHttpProcessor mIHttpProcessor = null;
    private static HttpHelper instance;
    private Map<String, Object> params;

    public static HttpHelper obtain() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    //定义一个用于设置代理的接口

    public static void init(IHttpProcessor iHttpProcessor) {
        mIHttpProcessor = iHttpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        //url进行拼接
        String finalUrl = appendParams(url, params);
        mIHttpProcessor.post(url, params, callBack);
    }

    //将参数拼接到url上
    private String appendParams(String url, Map<String, Object> params) {
        return null;
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {

    }
}
