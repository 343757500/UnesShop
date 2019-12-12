package com.unes.shopp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.base.Const;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.HomeBannerInfo;
import com.unes.shopp.ui.activity.ProductDetailsActivity;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeMessage03Holder extends BaseHolderRV {

    private ImageView iv;
    private HomeBannerInfo.ResultBean.BannersBean._$421Bean _$421Bean;

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
        _$421Bean = (HomeBannerInfo.ResultBean.BannersBean._$421Bean) bean;

        Picasso.with(context).load(_$421Bean.getPicUrl()).into(iv);
    }


    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        super.onItemClick(itemView, position, bean);
        Toast.makeText(context,_$421Bean.getTitle(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context,ProductDetailsActivity.class);
        intent.putExtra(Const.PIDS,_$421Bean.getTarget());
        context.startActivity(intent);

    }
}
