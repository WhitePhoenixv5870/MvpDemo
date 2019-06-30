package com.jlkf.donglianrider.mvpprojectdemo.contract;

import com.jlkf.donglianrider.mvpprojectdemo.base.IBaseContract;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;
import com.jlkf.donglianrider.mvpprojectdemo.net.RxSubscriber;

/**
 * Created by win7 on 2019/6/5.
 * 契约类
 * 将View 的拓展功能全放在里面
 * 将Preseng的拓展功能全放这里
 * 将model的功能运算,如计算功能全放在这里
 */

public class HomeContract {

    public interface  IHomeModel extends IBaseContract.IBaseMode{
        void getData(String userName,String psw , RxSubscriber<LoginBean> rxSubscriber);
    }

    public interface IHomeView extends IBaseContract.IBaseView{
        //需要用到的功能
        void refreshSuccess(LoginBean content);

        void refreshError(String error);

        //需要用到的参数
        String getUserId();
        String getAccount();
        String getPsw();
    }

    public interface IHomePresent extends IBaseContract.IBasePresent<IHomeView>{
        void getData();
    }
}
