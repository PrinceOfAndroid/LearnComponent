package com.taos.up.baseproject.widgets;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.taos.up.baseproject.R;


/**
 * <pre>
 *     author   : PrinceOfAndroid
 *     created  : 2017/7/6 0006 9:23
 *     desc     : 头部标题
 * </pre>
 */

public class BaseTitle extends FrameLayout implements View.OnClickListener {
    TextView tvTitle;
    ImageView ivRightIcon;
    TextView tvRightText;
    LinearLayout llRight;
    ImageView ivLeftIcon;
    TextView tvLeftText;
    LinearLayout llLeft;
    RelativeLayout rlTitle;
    OnLeftClickListener onLeftClickListener;
    OnRightClickListener onRightClickListener;

    public BaseTitle(@NonNull Context context) {
        this(context, null);
    }

    public BaseTitle(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseTitle(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.base_title, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvRightText = (TextView) view.findViewById(R.id.tv_right_text);
        tvLeftText = (TextView) view.findViewById(R.id.tv_left_text);
        ivRightIcon = (ImageView) view.findViewById(R.id.iv_right_icon);
        ivLeftIcon = (ImageView) view.findViewById(R.id.iv_left_icon);
        llLeft = (LinearLayout) view.findViewById(R.id.ll_left);
        llRight = (LinearLayout) view.findViewById(R.id.ll_right);
        rlTitle = (RelativeLayout) view.findViewById(R.id.rl_title);

        llLeft.setOnClickListener(this);
        llRight.setOnClickListener(this);
        addView(view);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(72)));
    }


    public BaseTitle setTitle(String title) {
        tvTitle.setText(title);
        return this;
    }

    public BaseTitle setLeftText(String leftText) {
        tvLeftText.setText(leftText);
        return this;
    }

    public BaseTitle setRightText(String rightText) {
        tvRightText.setText(rightText);
        return this;
    }

    public BaseTitle setRighticon(int iconResId) {
        ivRightIcon.setImageResource(iconResId);
        return this;
    }

    public BaseTitle setLefticon(int iconResId) {
        ivLeftIcon.setImageResource(iconResId);
        return this;
    }

    public BaseTitle setOnLeftClickListener(OnLeftClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;
        return this;
    }

    public BaseTitle setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;
        return this;
    }

    public interface OnLeftClickListener {
        void leftClick(View view);
    }

    public interface OnRightClickListener {
        void rightClick(View view);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.ll_left) {
            if (onLeftClickListener != null) {
                onLeftClickListener.leftClick(view);
            }

        } else if (i == R.id.ll_right) {
            if (onRightClickListener != null) {
                onRightClickListener.rightClick(view);
            }

        }
    }

}
