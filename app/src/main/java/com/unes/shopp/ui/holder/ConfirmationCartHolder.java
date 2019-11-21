package com.unes.shopp.ui.holder;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.ShoppingCartInfo;


public class ConfirmationCartHolder extends BaseHolderRV<ShoppingCartInfo.ResultBean.ItemsBean> {


    private ImageView iv;
    private TextView tv_name;
    private TextView tv_pre;
    private TextView tv_count;

    public ConfirmationCartHolder(Context context, ViewGroup parent, BaseAdapterRV<ShoppingCartInfo.ResultBean.ItemsBean> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_confirmation_cart);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_pre = itemView.findViewById(R.id.tv_pre);
        tv_count = itemView.findViewById(R.id.tv_count);

    }

    @Override
    protected void onRefreshView(ShoppingCartInfo.ResultBean.ItemsBean bean, int position) {
        String substring="";
        try {
            substring = bean.getPics().substring(0, bean.getPics().indexOf(";"));
        }catch (Exception e){
            substring = bean.getPics();
        }
        Picasso.with(context).load(substring).into(iv);
        tv_name.setText(bean.getTitle());
        tv_pre.setText("￥"+(bean.getPrice()/100));
        tv_count.setText(bean.getCartCount()+"");
    }
}
