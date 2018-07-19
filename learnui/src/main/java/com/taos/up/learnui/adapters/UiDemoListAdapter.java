package com.taos.up.learnui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taos.up.learnui.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by PrinceOfAndroid on 2018/6/28 0028.
 */

public class UiDemoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public UiDemoListAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        AutoUtils.autoSize(helper.getConvertView());
        helper.setText(R.id.tv_name, item);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = super.onCreateViewHolder(parent, viewType);
        AutoUtils.autoSize(holder.itemView);
        return holder;
    }
}
