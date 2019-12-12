package com.unes.shopp.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;

import org.apache.commons.lang3.StringUtils;

public class FetchItemsHolder extends BaseHolderRV<String> {

    private ImageView iv;

    public FetchItemsHolder(Context context, ViewGroup parent, BaseAdapterRV<String> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.fentchitem);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);
    }

    @Override
    protected void onRefreshView(String bean, int position) {
        if (StringUtils.isNotBlank(bean)) {
            Picasso.with(context).load(bean).into(iv);
        }
    }
}
