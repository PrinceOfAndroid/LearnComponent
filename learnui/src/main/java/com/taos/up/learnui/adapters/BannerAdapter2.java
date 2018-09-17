package com.taos.up.learnui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.taos.up.learnui.R;

import java.util.List;

public class BannerAdapter2 extends RecyclerView.Adapter<BannerAdapter2.BannerViewHolder> {
    private List<Integer> banners;

    public BannerAdapter2(List<Integer> banners) {
        this.banners = banners;
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, null);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        holder.ivBanner.setImageResource(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ivBanner = itemView.findViewById(R.id.iv_banner);
        }
    }
}
