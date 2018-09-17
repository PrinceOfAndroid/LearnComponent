package com.taos.up.learnui.widgets;

import android.graphics.Rect;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;

import java.util.HashMap;
import java.util.Map;

public class BannerLayoutManager extends RecyclerView.LayoutManager {
    private LinearSnapHelper linearSnapHelper;
    private RecyclerView recyclerView;
    private int currentPosition;
    private int lrShowDis = SizeUtils.dp2px(20);
    private int magrin = SizeUtils.dp2px(20);
    private int mOffsetAll;
    private Map<Integer, Rect> mAllItemFrames;


    //    public BannerLayoutManager(Context context) {
//        super(context);
//        setOrientation(HORIZONTAL);
//        this.linearSnapHelper = new LinearSnapHelper();
//        mAllItemFrames = new HashMap<>();
//
//    }


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        linearSnapHelper=new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(view);
        this.recyclerView = view;
        this.linearSnapHelper = new LinearSnapHelper();
        mAllItemFrames = new HashMap<>();
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        //        摆放
        if (getItemCount() <= 0) {
            return;
        }
        //preLayout主要支持动画，直接跳过
        if (state.isPreLayout()) {
            return;
        }
        LogUtils.e(getItemCount()+"");
        //将视图分离放入scrap缓存中，以准备重新对view进行排版


        detachAndScrapAttachedViews(recycler);

        //计算第一个Item X轴的起始位置坐标,这里第一个Item居中显示
        int mStartX = lrShowDis + magrin;

        for (int i = 0; i < getItemCount(); i++) { //存储所有item具体位置
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int mDecoratedChildHeight = getDecoratedMeasuredHeight(view);
            Rect frame = mAllItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            frame.set(mStartX, 0, mStartX + getWidth() - (magrin + lrShowDis) * 2, mDecoratedChildHeight);
            mAllItemFrames.put(i, frame);
            mStartX += getWidth() - (magrin + lrShowDis) * 2 + magrin;

        }
        detachAndScrapAttachedViews(recycler);
        layoutItems(recycler, state, 1); //布局Item

    }

    private void layoutItems(RecyclerView.Recycler recycler, RecyclerView.State state, int scrollDirection) {
//        detachAndScrapAttachedViews(recycler);
        Rect displayFrame = new Rect(mOffsetAll, 0, mOffsetAll + getWidth(), getHeight()); //获取当前显示的区域

        //回收或者更新已经显示的Item
        for (int i = 0; i < getItemCount(); i++) {
            View child = getChildAt(i);
//            int position = getPosition(child);

            if (!Rect.intersects(displayFrame, mAllItemFrames.get(i))) {
                //Item没有在显示区域，就说明需要回收
//                removeAndRecycleView(child, recycler); //回收滑出屏幕的View
            }
        }

        for (int i = 0; i < getItemCount(); i++) {
            if (Rect.intersects(displayFrame, mAllItemFrames.get(i))) { //加载可见范围内，并且还没有显示的Item
                View scrap = recycler.getViewForPosition(i);
                measureChildWithMargins(scrap, 0, 0);
                addView(scrap);
//                if (scrollDirection == 0) {
//                    //向左滚动，新增的Item需要添加在最前面
//                    addView(scrap, 0);
//                } else { //向右滚动，新增的item要添加在最后面
//                    addView(scrap);
//                }
                layoutItem(scrap, mAllItemFrames.get(i)); //将这个Item布局出来
            }
        }


    }

    private void layoutItem(View child, Rect frame) {
        LogUtils.e("left " + (frame.left - mOffsetAll) + "  " + frame.top + "   " + (frame.right - mOffsetAll) + "  " + frame.bottom);
        layoutDecorated(child,
                frame.left - mOffsetAll,
                frame.top,
                frame.right - mOffsetAll,
                frame.bottom);
//        child.setScaleX(computeScale(frame.left - mOffsetAll)); //缩放
//        child.setScaleY(computeScale(frame.left - mOffsetAll)); //缩放
    }


    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        mOffsetAll += dx;
        layoutItems(recycler, state, dx > 0 ? 1 : 0);
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    //    @Override
//    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
//
//        int travel = dx;
//        mOffsetAll += travel; //累计偏移量
//        layoutItems(recycler, state, dx > 0 ? 1 : 0);
//        return travel;
//    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
//        if (state == 0) {
//            if (pagerSnapHelper != null) {
//                View view = pagerSnapHelper.findSnapView(this);
//                currentPosition = getPosition(view);
//                LogUtils.e(currentPosition);
//            }
//        }

    }
}
