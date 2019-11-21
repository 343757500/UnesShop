package com.unes.shopp.ui.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.SliderLayout;
import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.HomeFetchCatesInfo;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeMessage01Holder extends BaseHolderRV {

    private SliderLayout sliderLayout;
    private RecyclerView recyclerView02;
    private ViewFlipper viewFlipper;
    private ImageView iv;
    private TextView tv;

    public HomeMessage01Holder(Context context, ViewGroup parent,
                               BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_message01);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);
        tv = itemView.findViewById(R.id.tv);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        HomeFetchCatesInfo.ResultBean.CatesBean homeFetchCatesInfo= (HomeFetchCatesInfo.ResultBean.CatesBean) bean;

        Picasso.with(context).load(homeFetchCatesInfo.getPic()).into(iv);
        tv.setText(homeFetchCatesInfo.getName());
    }


}
