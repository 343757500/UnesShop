package com.unes.shopp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.HomeFetchCatesInfo;
import com.unes.shopp.ui.holder.HomeHeaderHolder;
import com.unes.shopp.ui.holder.HomeMessage01Holder;

import java.util.List;

/**
 * @author WJQ
 */
public class HomeMessage01Adapter extends BaseAdapterRV<String> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SHOP_LIST = 1;
    private static final int TYPE_AD = 2;

    public HomeMessage01Adapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<String> createViewHolder(
            Context context, ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {      // 显示头部的Holder
            return new HomeMessage01Holder(context, parent, this, viewType);
        }
        return  new HomeMessage01Holder(context, parent, this, viewType);
    }

    // 返回列表项显示的类型
    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);

       if (obj instanceof HomeFetchCatesInfo.ResultBean.CatesBean) {
           // 头部item
            return TYPE_HEADER;
        }
        return TYPE_SHOP_LIST;
    }
}
