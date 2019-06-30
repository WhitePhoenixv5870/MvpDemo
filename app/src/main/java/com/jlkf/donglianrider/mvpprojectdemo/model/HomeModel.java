package com.jlkf.donglianrider.mvpprojectdemo.model;

import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;
import com.jlkf.donglianrider.mvpprojectdemo.contract.HomeContract;
import com.jlkf.donglianrider.mvpprojectdemo.net.HttpManager;
import com.jlkf.donglianrider.mvpprojectdemo.net.RxSubscriber;

/**
 * Created by win7 on 2019/6/6.
 */

public class HomeModel implements HomeContract.IHomeModel {


    @Override
    public void getData(String userName, String psw, RxSubscriber<LoginBean> rxSubscriber) {
        HttpManager.login(userName,psw,rxSubscriber);
    }

}
