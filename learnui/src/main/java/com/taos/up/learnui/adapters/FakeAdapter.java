package com.taos.up.learnui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taos.up.learnui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PrinceOfAndroid on 2018/7/18 0018.
 */

public class FakeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private List<String> items;

    public FakeAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(i + "");
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        RecyclerView rvHorizontal = helper.getView(R.id.rv_horizontal);
        rvHorizontal.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        rvHorizontal.setAdapter(new SectionAdapter(R.layout.item_card_hor, items));
    }
}
