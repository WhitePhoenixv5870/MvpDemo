package com.jlkf.donglianrider.mvpprojectdemo.present;

import android.util.Log;

import com.jlkf.donglianrider.mvpprojectdemo.base.BaseBean;
import com.jlkf.donglianrider.mvpprojectdemo.base.BasePresentImpl;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;
import com.jlkf.donglianrider.mvpprojectdemo.contract.HomeContract;
import com.jlkf.donglianrider.mvpprojectdemo.model.HomeModel;
import com.jlkf.donglianrider.mvpprojectdemo.net.RxSubscriber;


/**
 * Created by win7 on 2019/6/5.
 * 具体present功能实现类,继承basePresentImpl 基类,实现该
 */

public class HomePresentImpl extends BasePresentImpl<HomeContract.IHomeView> implements HomeContract.IHomePresent {

    private HomeContract.IHomeModel mIHomeModel;

    public HomePresentImpl() {
        mIHomeModel = new HomeModel();

    }

    @Override
    public void getData() {
        //这里要用到的参数,可以全部在mViewz中拿到



        mIHomeModel.getData(mView.getAccount(), mView.getPsw(), new RxSubscriber<LoginBean>(mView) {
            @Override
            public void netSuccess(LoginBean o) {
                if (mView != null) {
                    mView.refreshSuccess(o);
                }
            }

            @Override
            public void netError(Throwable e) {

            }
        });


    }
}
