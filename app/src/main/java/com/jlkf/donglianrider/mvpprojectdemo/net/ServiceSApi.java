package com.jlkf.donglianrider.mvpprojectdemo.net;


import com.jlkf.donglianrider.mvpprojectdemo.base.BaseBean;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by win7 on 2019/6/6.
 */

public interface ServiceSApi {

    @POST("login")
    Observable<BaseBean<LoginBean>> login(@Body RequestBody body);

}
