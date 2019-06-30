package com.jlkf.donglianrider.mvpprojectdemo.net;

import com.jlkf.donglianrider.mvpprojectdemo.base.BaseBean;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by win7 on 2019/6/6.
 *
 */

public class HttpManager {

    private static void toSubscribe(Observable o, RxSubscriber s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 登录
     *
     * @param rxSubscriber
     */
    public static void login(String username ,String psw, RxSubscriber<LoginBean> rxSubscriber) {
        Map<String, Object> map = new HashMap<>();
//        {"phone":"13138895762","ltype":1,"password":"123456","deviceNum":"868583022564435","registerType":"1","oppenId":""}
//        {"code":null,"deviceNum":"868583022564435","openId":null,"password":"123456","phone":"13138895762","type":"1"}
        map.put("phone", username);
        map.put("password", psw);
        map.put("type", "1");
        map.put("deviceNum", "868583022564435");
        map.put("oppenId", "");
        toSubscribe(RetrofitFactory.getInstance().login(PostType.getRequestBody(map)), rxSubscriber);
    }

}
