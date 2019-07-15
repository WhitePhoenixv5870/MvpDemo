package com.jlkf.donglianrider.mvpprojectdemo.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.hjq.toast.ToastUtils;
import com.jlkf.donglianrider.mvpprojectdemo.net.LogUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by win7 on 2019/6/6.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);

        closeAndroidPDialog();

        // 在Application中初始化
        ToastUtils.init(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    //解决android9.0问题
    private void closeAndroidPDialog(){
        try {
            Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
