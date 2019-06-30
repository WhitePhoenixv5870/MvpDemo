package com.jlkf.donglianrider.mvpprojectdemo.base;

/**
 * Created by win7 on 2019/6/5.
 */

public class BasePresentImpl<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresent<T> {
    public T mView;


    @Override
    public void addView(T t) {
        mView = t;
    }

    @Override
    public void desView() {
        mView = null;
    }
}
