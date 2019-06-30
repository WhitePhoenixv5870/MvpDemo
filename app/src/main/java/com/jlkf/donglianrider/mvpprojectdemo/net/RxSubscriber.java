package com.jlkf.donglianrider.mvpprojectdemo.net;

import com.jlkf.donglianrider.mvpprojectdemo.base.BaseBean;
import com.jlkf.donglianrider.mvpprojectdemo.base.IBaseContract;
import com.jlkf.donglianrider.mvpprojectdemo.net.error.ExceptionHandle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by win7 on 2019/6/6.
 * 消费者
 */

public abstract class RxSubscriber<T> implements Observer<T> {
    IBaseContract.IBaseView mIBaseView;//为了获取当前界面的上下文,才能控制loading框的显示
    boolean isShowLoading = false;
    String loadtext = "加载中";


    public  RxSubscriber (IBaseContract.IBaseView mIBaseView){
        this.mIBaseView = mIBaseView;
    }



    public  RxSubscriber (IBaseContract.IBaseView mIBaseView, boolean isShowLoading, String loadtext){
        this.mIBaseView = mIBaseView;
    }


    @Override
    public void onSubscribe(Disposable d) {
        if (d.isDisposed()){
            LogUtil.d("=====================结束======================");
        }else {
            LogUtil.d("=====================开始======================");
            LogUtil.d("网络请求开始");
        }
    }

    @Override
    public void onNext(T o) {
        if (o instanceof BaseBean) {
            netSuccess((T)((BaseBean) o).getData());
        }

    }

    @Override
    public void onError(Throwable e) {
        netError(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void netSuccess(T o);
    public abstract void netError(Throwable e);
}
