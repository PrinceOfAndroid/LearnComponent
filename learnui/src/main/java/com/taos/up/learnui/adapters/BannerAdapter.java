package com.taos.up.learnui.adapters;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taos.up.learnui.R;

import java.util.List;

public class BannerAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    public BannerAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setImageResource(R.id.iv_banner, item);
    }
}
