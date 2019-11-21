package com.unes.shopp.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.SliderLayout;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;

import java.util.List;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeHeaderHolder extends BaseHolderRV {

    private SliderLayout sliderLayout;
    private RecyclerView recyclerView02;
    private ViewFlipper viewFlipper;

    public HomeHeaderHolder(Context context, ViewGroup parent,
                            BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_header);
    }

    @Override
    public void onFindViews(View itemView) {
        sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider_layout);
        recyclerView02 = (RecyclerView) itemView.findViewById(R.id.recycler_view_02);
        viewFlipper = (ViewFlipper) itemView.findViewById(R.id.view_flipper);

        // 轮播图

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
    }


}
