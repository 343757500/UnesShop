package com.unes.shopp.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.HomeBannerInfo;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeMessage03Holder extends BaseHolderRV {

    private ImageView iv;

    public HomeMessage03Holder(Context context, ViewGroup parent,
                               BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_message03);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        HomeBannerInfo.ResultBean.BannersBean._$421Bean _$421Bean= (HomeBannerInfo.ResultBean.BannersBean._$421Bean) bean;

        Picasso.with(context).load(_$421Bean.getPicUrl()).into(iv);
    }


}
