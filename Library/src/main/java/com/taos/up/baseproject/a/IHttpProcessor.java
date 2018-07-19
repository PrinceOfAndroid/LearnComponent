package com.taos.up.baseproject.a;

import java.util.Map;

/**
 * Created by PrinceOfAndroid on 2018/7/12 0012.
 */

public interface IHttpProcessor {
    void post(String url, Map<String, Object> params, ICallBack callBack);

    void get(String url, Map<String, Object> params, ICallBack callBack);
}
