package com.jlkf.donglianrider.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Viewpager 适配内部fragment高度
 */

public class WrapContentHeightViewPager extends ViewPager {

    private int setHeight;

    public int getSetHeight() {
        return setHeight;
    }

    public void setSetHeight(int setHeight) {
        this.setHeight = setHeight;
    }

    public WrapContentHeightViewPager(Context context) {
        super(context);  
    }  

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }  

    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  

        int height = 0;  
//        for (int i = 0; i < getChildCount(); i++) {
//            View child = getChildAt(i);
//            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//            int h = child.getMeasuredHeight();
//
//            Log.d("WrapConte",i+"==hei=="+h);
//            if (h > height) height = h;
//        }
        int currentItem = getCurrentItem();
        if (getChildCount() > currentItem) {
            View child = getChildAt(currentItem);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            height = child.getMeasuredHeight();

            Log.d("WrapConte","==hei=="+height);
        }
        Log.d("WrapConte","==hei=="+height    +"         setHeight="+setHeight);
        if (height == 0||height<setHeight) {
            height = setHeight;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}  
