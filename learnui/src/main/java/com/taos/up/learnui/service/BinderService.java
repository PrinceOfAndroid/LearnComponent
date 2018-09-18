package com.taos.up.learnui.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;

public class BinderService extends Service {

    private int serviceValue = 1;

    public int getServiceValue() {
        return serviceValue;
    }

    @Override
    public void onCreate() {
        LogUtils.e("serviceCreated");
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public class LocalBinder extends Binder {
        public BinderService getService() {
            return BinderService.this;
        }
    }
}
