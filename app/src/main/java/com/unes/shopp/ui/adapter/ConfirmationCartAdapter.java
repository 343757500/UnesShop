package com.unes.shopp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.ui.holder.ConfirmationCartHolder;

import java.util.List;

public class ConfirmationCartAdapter extends BaseAdapterRV<ShoppingCartInfo.ResultBean.ItemsBean> {
    public ConfirmationCartAdapter(Context context, List<ShoppingCartInfo.ResultBean.ItemsBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<ShoppingCartInfo.ResultBean.ItemsBean> createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new ConfirmationCartHolder(context,parent,this,viewType);
    }
}
