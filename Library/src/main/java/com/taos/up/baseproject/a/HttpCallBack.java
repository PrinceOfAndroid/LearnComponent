package com.taos.up.baseproject.a;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by PrinceOfAndroid on 2018/7/12 0012.
 * 回调接口的实现
 */

public abstract class HttpCallBack<Result> implements ICallBack {
    @Override
    public void onSuccess(String response) {
        Gson gson = new Gson();
        Class<?> clz = (Class<?>) analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(response, clz);
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result obj);

    @Override
    public void onFail(String e) {

    }

    private static Class<?> analysisClassInfo(Object obj) {
        //获取所有类型
        Type type = obj.getClass().getGenericSuperclass();

        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
