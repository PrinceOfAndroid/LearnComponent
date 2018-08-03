package com.taos.up.learnui.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taos.up.baseproject.mvp.SimpleActivity;
import com.taos.up.baseproject.widgets.BaseTitle;
import com.taos.up.learnui.R;
import com.taos.up.learnui.R2;
import com.taos.up.learnui.widgets.re.Adapter;
import com.taos.up.learnui.widgets.re.RecyclerView;

import butterknife.BindView;

public class MyRecyclerViewActivity extends SimpleActivity {

    @BindView(R2.id.base_title)
    BaseTitle baseTitle;
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_recycler;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        recyclerView.setAdapter(new MyAdapter(this, 30));
    }

    @Override
    protected void initEventLoadData() {

    }


    class MyAdapter implements Adapter {
        LayoutInflater inflater;
        private int height;
        private int count;

        public MyAdapter(Context context, int count) {
            Resources resources = context.getResources();
            height = resources.getDimensionPixelSize(R.dimen.table_height);
            inflater = LayoutInflater.from(context);
            this.count = count;
        }

        @Override
        public int getCount() {
            return count;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_table1, parent, false);
            }
            //
            TextView textView = (TextView) convertView.findViewById(R.id.text1);
            textView.setText("第 " + position + "行");
            return convertView;
        }

        @Override
        public int getItemViewType(int row) {
            return 0;
        }

        @Override
        public int getHeight(int index) {
            return height;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }
    }

}
