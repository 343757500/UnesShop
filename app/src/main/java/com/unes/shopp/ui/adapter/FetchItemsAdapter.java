package com.unes.shopp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.ui.holder.FetchItemsHolder;

import java.util.List;

public class FetchItemsAdapter  extends BaseAdapterRV<String>{
    public FetchItemsAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<String> createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new FetchItemsHolder(context,parent,this,viewType);
    }
}
