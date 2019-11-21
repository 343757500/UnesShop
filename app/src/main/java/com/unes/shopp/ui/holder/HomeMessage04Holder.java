package com.unes.shopp.ui.holder;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.AddShopCartInfo;
import com.unes.shopp.model.bean.HomeListItemsInfo;
import com.unes.shopp.presenter.ShoppingCartPersenter;
import com.unes.shopp.ui.activity.MainActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeMessage04Holder extends BaseHolderRV{

    private ImageView iv;
    private TextView tv_title;
    private TextView tv_refpre;
    private TextView tv_pre;
    private ImageView iv_shop;

    public HomeMessage04Holder(Context context, ViewGroup parent,
                               BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_message04);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_refpre = itemView.findViewById(R.id.tv_refpre);
        tv_pre = itemView.findViewById(R.id.tv_pre);
        iv_shop = itemView.findViewById(R.id.iv_shop);

    }

    @Override
    protected void onRefreshView(final Object bean, final int position) {
        try {


        HomeListItemsInfo.ResultBean.ItemsBean itemsBean= (HomeListItemsInfo.ResultBean.ItemsBean) bean;
        String pics = itemsBean.getPics();
        String substring = pics.substring(0, pics.indexOf(";"));


        Picasso.with(context).load(substring).into(iv);
        tv_title.setText(itemsBean.getTitle());
        tv_refpre.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_refpre.setText("￥"+(itemsBean.getRefPrice()/100));
        tv_pre.setText("￥"+(itemsBean.getPrice()/100));



        }catch (Exception e){
            Log.e("111",e.getMessage());
        }

        iv_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"加入购物车成功",Toast.LENGTH_LONG).show();
                Map map= new HashMap();
                map.put("item_id",((HomeListItemsInfo.ResultBean.ItemsBean) bean).getItemId());
                map.put("num",1);
                JSONObject json = new JSONObject(map);
                List result = new ArrayList();
                result.add(json.toString());

                int uid = SharedPreUtil.getInt(context, "Uid", 0);
                AddShopCartInfo addShopCartInfo=new AddShopCartInfo();
                addShopCartInfo.setTicket(uid+"");
                addShopCartInfo.setItem_id(result.toString());


                ShoppingCartPersenter shoppingCartPersenter = ((MainActivity) context).getHomePageFragment().getShoppingCartPersenter();
                shoppingCartPersenter.changeShoppingCartInfo(addShopCartInfo);

                /*HashMap<Integer, Boolean> hashMap = new HashMap<>();
                hashMap.put(0, false);
                Gson gson = new Gson();
                String checkMapAll = gson.toJson(hashMap);
                SharedPreUtil.saveString(context, "checkMapAll", checkMapAll);*/


            }
        });
    }



}
