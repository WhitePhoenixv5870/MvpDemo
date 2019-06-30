package com.jlkf.donglianrider.mvpprojectdemo.base;

import android.content.Context;

/**
 * Created by win7 on 2019/6/28.
 */

public interface IBaseContract {

      interface IBaseView {

        Context getContext();

    }

     interface IBaseMode {
    }

     interface IBasePresent<V extends IBaseContract.IBaseView> {
        void addView(V v);
        void desView();

    }


}
