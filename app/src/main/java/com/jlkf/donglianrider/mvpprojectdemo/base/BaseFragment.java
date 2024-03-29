package com.jlkf.donglianrider.mvpprojectdemo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by win7 on 2019/6/10.
 */

public abstract class BaseFragment extends Fragment {
    private String TAG = BaseFragment.class.getSimpleName();
    Unbinder unbinder;

    private View mRoot;

    /**
     * 是否执行了lazyLoad方法
     */
    private boolean isLoaded;
    /**
     * 是否创建了View
     */
    private boolean isCreateView;

    /**
     * 当从另一个activity回到fragment所在的activity
     * 当fragment回调onResume方法的时候，可以通过这个变量判断fragment是否可见，来决定是否要刷新数据
     */
    public boolean isVisible;

    /*
    * 此方法在viewpager嵌套fragment时会回调
    * 查看FragmentPagerAdapter源码中instantiateItem和setPrimaryItem会调用此方法
    * 在所有生命周期方法前调用
    * 这个基类适用于在viewpager嵌套少量的fragment页面
    * 该方法是第一个回调，可以将数据放在这里处理（viewpager默认会预加载一个页面）
    * 只在fragment可见时加载数据，加快响应速度
    * */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     * 设置fragment需要展示的布局ID
     */
    protected abstract int getContentView();


    /*
    * 防止view的重复加载 与FragmentPagerAdapter 中destroyItem方法取消调用父类的效果是一样的
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(getContentView(), null);
            unbinder = ButterKnife.bind(this, mRoot);
            isCreateView = true;
            initView(mRoot);
            initListener();
            onVisible();
        }else {
            unbinder = ButterKnife.bind(this, mRoot);
            isCreateView = true;
            initView(mRoot);
            initListener();
            onVisible();
        }
        return mRoot;
    }

    protected void onVisible() {

        isVisible = true;

        if (isLoaded) {
            refreshLoad();
        }
        if (!isLoaded && isCreateView && getUserVisibleHint()) {
            isLoaded = true;
            lazyLoad();
        }
    }

    protected void onInvisible() {
        isVisible = false;
    }


    protected abstract void initView(View root);

    protected abstract void initListener();

    /**
     * fragment第一次可见的时候回调此方法
     */
    protected abstract void lazyLoad();

    /**
     * 在Fragment第一次可见加载以后，每次Fragment滑动可见的时候会回调这个方法，
     * 子类可以重写这个方法做数据刷新操作
     */
    protected void refreshLoad() {
    }

}
