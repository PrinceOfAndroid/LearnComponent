package com.taos.up.learnui.ui;

import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;
import com.taos.up.learnui.adapters.BannerAdapter;
import com.taos.up.learnui.adapters.BannerAdapter2;
import com.taos.up.learnui.widgets.BannerLayoutManager;
import com.taos.up.learnui.widgets.GalleryLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerActivity extends SimpleActivity {
    @BindView(R2.id.re_banner)
    RecyclerView reBanner;

    private List<Integer> banners = new ArrayList<>();
    private BannerAdapter2 bannerAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_banner;
    }

    @Override
    protected void initData() {
        banners.add(R.mipmap.banner_1);
        banners.add(R.mipmap.banner_2);
        banners.add(R.mipmap.banner_3);
        banners.add(R.mipmap.banner_4);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        reBanner.setLayoutManager(new BannerLayoutManager());
        bannerAdapter = new BannerAdapter2(banners);
        reBanner.setAdapter(bannerAdapter);
    }

    @Override
    protected void initEventLoadData() {

    }


}
