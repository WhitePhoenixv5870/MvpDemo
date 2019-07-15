package com.jlkf.donglianrider.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.jlkf.donglianrider.ui.R;


/**
 * Created by win7 on 2019/2/27.
 * 自动滚动viewpager
 */

public class AutoScrollViewPager extends ViewPager {
    private final int default_duration = 2000;

    private int duration = default_duration;
    /**
     * 是否自动滚动
     */
    private boolean autoScroll = true;
    /**
     * 是否循环滚动
     */
    private boolean indeterminate = true;

    private float startX = 0;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoScrollViewPager);
        duration = typedArray.getInt(R.styleable.AutoScrollViewPager_duration, default_duration);
        setAutoScrollEnabled(typedArray.getBoolean(R.styleable.AutoScrollViewPager_autoScroll, true));
        indeterminate = typedArray.getBoolean(R.styleable.AutoScrollViewPager_indeterminate, true);

        typedArray.recycle();
    }

    private Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            if (getAdapter() == null) return;
            if (getCurrentItem() == getAdapter().getCount() - 1) {
//                currentItem = 0
                setCurrentItem(0, false);
            } else {
                setCurrentItem(getCurrentItem() + 1);
            }
            postDelayed(autoScrollRunnable, duration);
        }
    };

    public void setAutoScrollEnabled(boolean value) {
        autoScroll = value;

        if (autoScroll) {
            startAutoScroll();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setAutoScrollEnabled(autoScroll);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAutoScroll();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            setAutoScrollEnabled(autoScroll);
        } else {
            stopAutoScroll();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            switch (ev.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    //按下手指停止自动滚动
                    stopAutoScroll();
                    startX = ev.getX();
                    break;
                }
            }
            return super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            switch (ev.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP: {
                    //如果indeterminate为true则手指滑动到最后一个时再滑动则跳到一个view
                    if (indeterminate
                            && (getCurrentItem() == 0
                            || getCurrentItem() == getAdapter().getCount() - 1)) {

                        if (getCurrentItem() == getAdapter().getCount() - 1
                                && (ev.getX() < startX && startX - ev.getX() > 50)) {
                            postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    setCurrentItem(0, false);
                                }
                            }, 200);
                        }
                    }
                    //移开手指开始自动滚动
                    if (autoScroll) {
                        startAutoScroll();
                    }
                    break;
                }
            }
            return super.onTouchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void startAutoScroll() {
        stopAutoScroll();
        postDelayed(autoScrollRunnable, duration);
    }

    private void stopAutoScroll() {
        removeCallbacks(autoScrollRunnable);
    }
}
