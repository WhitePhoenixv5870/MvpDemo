package com.jlkf.donglianrider.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by win7 on 2019/5/20.
 * 瀑布流recyclerView
 */

public class StaggeredDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Context context;
    private int interval;
    private boolean isHeadView;

    public StaggeredDividerItemDecoration(Context context, int interval, boolean isHeadView) {
        this.context = context;
        this.interval = interval;
        this.isHeadView = isHeadView;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        // 获取item在span中的下标
        int spanIndex = params.getSpanIndex();
        //原代码
//        int interval = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                this.interval, context.getResources().getDisplayMetrics());

        //如果有头部,且位置为0,不做修改
        if (isHeadView && 0 == position) {
            // 下方间隔
            outRect.bottom = interval;
            return;
        }

        // 中间间隔
        if (spanIndex % 2 == 0) {
//            outRect.left = 0;
            outRect.right = interval / 2;
        } else {
            // item为奇数位，设置其左间隔为5dp
            outRect.left = interval / 2;
        }
        // 下方间隔
        outRect.bottom = interval;
    }
}
