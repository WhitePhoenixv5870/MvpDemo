package com.jlkf.donglianrider.mvpprojectdemo.net.interceptor;


import android.util.Log;

import com.jlkf.donglianrider.mvpprojectdemo.net.LogUtil;

public class Logger implements LoggingInterceptor.Logger {
 
    @Override
    public void log(String message) {
        LogUtil.i("http : " + message);
//        LogUtil.i("http : " + message);
    }
}
