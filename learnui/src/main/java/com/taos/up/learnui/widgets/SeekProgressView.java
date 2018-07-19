package com.taos.up.learnui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.taos.up.learnui.R;


/**
 * Created by PrinceOfAndroid on 2018/7/4 0004.
 */

public class SeekProgressView extends View {
    private int progressColor;
    private int backgroundColor;
    private int seekBarColor;
    private Paint paint;
    private Paint seekPaint;

    private int max = 100;
    private int progress;
    private boolean isMeasure = true;

    private OnSeekChangeListener seekChangeListener;
    private int width;
    private int height;

    public SeekProgressView(Context context) {
        this(context, null);
    }

    public SeekProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeekProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        //获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SeekProgressView, defStyleAttr, 0);
        progressColor = array.getColor(R.styleable.SeekProgressView_spv_color, Color.BLUE);
        backgroundColor = array.getColor(R.styleable.SeekProgressView_spv_background, Color.WHITE);
        seekBarColor = array.getColor(R.styleable.SeekProgressView_spv_seekBar_color, Color.WHITE);
        //回收资源
        array.recycle();

        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(backgroundColor);
        paint.setStyle(Paint.Style.FILL);

        /**
         * 进度圆点
         */
        seekPaint = new Paint();
        seekPaint.setAntiAlias(true);
        seekPaint.setColor(seekBarColor);
        seekPaint.setStyle(Paint.Style.FILL);

    }

    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        LogUtils.e("width " + measureWidth(widthMeasureSpec) + "height" + measureHeight(heightMeasureSpec));

        width = measureWidth(widthMeasureSpec);
        height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }


    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float sx = getMeasuredHeight() / 2;
        float sy = getMeasuredHeight() / 4;
        float ex = getMeasuredWidth() - getMeasuredHeight() / 2;
        float ey = getMeasuredHeight() * 3 / 4;

        LogUtils.e(getMeasuredWidth() + "   " + getMeasuredHeight());
        float progressEnd = (getMeasuredWidth() - getMeasuredHeight()) * progress / max + getMeasuredHeight() / 2;



        /**
         * 创建一个图层
         */
        canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        RectF rectF = new RectF(sx, sy, ex, ey);
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rectF, getHeight() / 4, getHeight() / 4, paint);

        /**
         * 只在源图像和目标图像相交的地方绘制【源图像】
         */
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setColor(progressColor);
        RectF rectF2 = new RectF(sx, sy, progressEnd, ey);
        canvas.drawRect(rectF2, paint);
        paint.setXfermode(null);
        /**
         * 进度圆点
         */
        canvas.drawCircle(progressEnd, getHeight() / 2, getHeight() / 2, seekPaint);
    }

    private int measureWidth(int widthMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int parentMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            //父容器已获取到宽高
            return parentMeasureWidth;
        } else {
            //父容器未知宽高，但给了一个限定值
            return Math.min(ScreenUtils.getScreenWidth(), parentMeasureWidth);
        }
    }

    private int measureHeight(int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int parentMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            return parentMeasureHeight;
        } else {
            return Math.min(SizeUtils.dp2px(16), parentMeasureHeight);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int mPreX = (int) event.getX();
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        switch (event.getAction()) {
            /**
             * 按下
             */
            case MotionEvent.ACTION_DOWN:
                //通知父容器不要拦截事件
                getParent().requestDisallowInterceptTouchEvent(true);
                progress = (int) ((mPreX - height / 2) * max / (width - height));
                if (progress > max) {
                    progress = max;
                } else if (progress < 0) {
                    progress = 0;
                }
                if (seekChangeListener != null) {
                    seekChangeListener.onSeek(progress);
                }
                break;
            /**
             * 移动
             */
            case MotionEvent.ACTION_MOVE:
                progress = (int) ((mPreX - height / 2) * max / (width - height));
                if (progress > max) {
                    progress = max;
                } else if (progress < 0) {
                    progress = 0;
                }
                if (seekChangeListener != null) {
                    seekChangeListener.onSeek(progress);
                }
                break;
            /**
             * 抬起
             */
            case MotionEvent.ACTION_UP:
                //父容器拦截事件恢复
                getParent().requestDisallowInterceptTouchEvent(false);
                progress = (int) ((mPreX - height / 2) * max / (width - height));
                if (progress > max) {
                    progress = max;
                } else if (progress < 0) {
                    progress = 0;
                }
                if (seekChangeListener != null) {
                    seekChangeListener.onSeekOver(progress);
                }
                break;
        }
        invalidate();
        return true;
    }


    public interface OnSeekChangeListener {
        void onSeek(int progress);

        void onSeekOver(int progress);
    }

    public void setOnSeekChangeListener(OnSeekChangeListener seekChangeListener) {
        this.seekChangeListener = seekChangeListener;
    }


    public void setMax(int max) {
        this.max = max;
        invalidate();
    }


    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
