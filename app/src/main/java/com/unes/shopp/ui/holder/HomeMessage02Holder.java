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
import com.unes.shopp.model.bean.HomeBannerInfo;
import com.unes.shopp.model.bean.HomeFetchCatesInfo;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeMessage02Holder extends BaseHolderRV {

    private ImageView iv;

    public HomeMessage02Holder(Context context, ViewGroup parent,
                               BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_message02);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        HomeBannerInfo.ResultBean.BannersBean._$422Bean _$422Bean= (HomeBannerInfo.ResultBean.BannersBean._$422Bean) bean;

        Picasso.with(context).load(_$422Bean.getPicUrl()).into(iv);
    }


}
