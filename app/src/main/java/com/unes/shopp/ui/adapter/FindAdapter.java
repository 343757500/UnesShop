package com.unes.shopp.ui.adapter;


import android.content.Context;
import android.view.ViewGroup;

import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.FetchItemsByIdInfo;
import com.unes.shopp.ui.holder.FindHolder;

import java.util.List;

public class FindAdapter extends BaseAdapterRV<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> {
    public FindAdapter(Context context, List<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new FindHolder(context,parent,this,viewType);
    }
}
