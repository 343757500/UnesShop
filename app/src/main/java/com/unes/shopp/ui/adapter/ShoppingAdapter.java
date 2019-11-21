package com.unes.shopp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.ui.activity.MainActivity;
import com.unes.shopp.ui.holder.ShoppingHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingAdapter extends BaseAdapterRV<ShoppingCartInfo.ResultBean.ItemsBean> {
    //这个是checkbox的Hashmap集合
    private HashMap<Integer, Boolean> map = new HashMap<>();
    //这个是数据集合
    private  List<ShoppingCartInfo.ResultBean.ItemsBean> list;


    public ShoppingAdapter(Context context, List<ShoppingCartInfo.ResultBean.ItemsBean> listData) {
        super(context, listData);

    }


    //这个方法在 notifyDataSetChanged();的时候不会执行，所以会导致holder 点击删除的 时候（map.remove(positon)）map出现问题
    @Override
    public BaseHolderRV<ShoppingCartInfo.ResultBean.ItemsBean> createViewHolder(Context context, ViewGroup parent, int viewType) {
       // SharedPreUtil.saveInt(context, "allPrice", 0);
        this.list=listData;
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getItemId(), false);
        }

        Gson gson=new Gson();
        String checkMap = SharedPreUtil.getString(context, "checkMap", "");
        if (!checkMap.equals("")){
            try {
                HashMap<Integer, Boolean> mapNew = gson.fromJson(checkMap, new TypeToken<Map<Integer, Boolean>>() {}.getType());
                for (int i = 0; i < list.size(); i++) {
                    Boolean aBoolean = mapNew.get(list.get(i).getItemId());
                    if (aBoolean==null){
                        map.put(list.get(i).getItemId(),false);
                    }else{
                        map.put(list.get(i).getItemId(),mapNew.get(list.get(i).getItemId()));
                    }

                }
            }catch (Exception e){
                Log.e("111",e.getMessage());
                Log.e("111",e.getMessage());
            }

        }

        return new ShoppingHolder(context,parent,this,viewType,map);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * 全选
     */
    public void All(Context context) {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(true);
        }

        Gson gson=new Gson();
        String checkMap = gson.toJson(map);
        SharedPreUtil.saveString(context,"checkMap",checkMap);

        notifyDataSetChanged();
    }

    /**
     * 反选
     */
    public void neverall(Context context) {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(false);
        }

        Gson gson=new Gson();
        String checkMap = gson.toJson(map);
        SharedPreUtil.saveString(context,"checkMap",checkMap);

        notifyDataSetChanged();
    }

    /**
     * 单选
     *
     * @param postion
     */
    public void singlesel(int postion) {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(false);
        }
        map.put(postion, true);
        notifyDataSetChanged();
    }


}
