package com.unes.shopp.ui.holder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.ui.activity.MainActivity;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingHolder extends BaseHolderRV<ShoppingCartInfo.ResultBean.ItemsBean> {

    private ImageView iv_shopping;
    private TextView tv_name;
    private TextView tv_type_all_price;
    private ImageButton ib_minus;
    private ImageButton ib_plus;
    private TextView tv_cart_goods_amount;
    private HashMap<Integer, Boolean> map ;
    private AppCompatCheckBox appCompatCheckBox;
    private ImageView iv_clean;


    public ShoppingHolder(Context context, ViewGroup parent, BaseAdapterRV<ShoppingCartInfo.ResultBean.ItemsBean> adapter, int itemType,HashMap<Integer, Boolean> mapp) {
        super(context, parent, adapter, itemType, R.layout.item_shopping_cart);
        map = new HashMap<>();
        map=mapp;
    }

    @Override
    public void onFindViews(View itemView) {
        iv_shopping = itemView.findViewById(R.id.iv_shopping);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_type_all_price = itemView.findViewById(R.id.tv_type_all_price);
        ib_minus = itemView.findViewById(R.id.ib_minus);
        ib_plus = itemView.findViewById(R.id.ib_plus);
        tv_cart_goods_amount = itemView.findViewById(R.id.tv_cart_goods_amount);
        appCompatCheckBox = itemView.findViewById(R.id.checkbox);
        iv_clean = itemView.findViewById(R.id.iv_clean);


    }

    @Override
    protected void onRefreshView(final ShoppingCartInfo.ResultBean.ItemsBean bean, final int position) {
            Boolean aBoolean = map.get(bean.getItemId());
            if (aBoolean!=null&&aBoolean) {
                int price = bean.getCartCount() * bean.getPrice() / 100;
                int allPrice = SharedPreUtil.getInt(context, "allPrice", 0);
                int newAllPrice = price + allPrice;
                SharedPreUtil.saveInt(context, "allPrice", newAllPrice);

                //点击+ -号传t = 1 清空集合   传type代表是否属于选择状态 true为选中则加入集合
                ((MainActivity) context).getShoppingCartFragment().selectCart(bean, true, 0);

            } else {
                ((MainActivity) context).getShoppingCartFragment().selectCart(bean, false, 0);
            }






            String substring="";
            try {
                substring = bean.getPics().substring(0, bean.getPics().indexOf(";"));
            }catch (Exception e){
                substring = bean.getPics();
            }

            //因为recyclerbiew 嵌套了scrolooview 为了解决checkbox显示才勾选   嵌套使recycleview直接全部数据加载了 虽然一次性加载数据不推荐，但是购物车特别
            //解决RecyclerView 使用Picasso加载图片调动notifyDataSetChanged()图片闪烁问题   https://blog.csdn.net/qq_36882793/article/details/82839801
            if (!substring.equals(this.iv_shopping.getTag(R.id.iv_shopping))) {
                // 加载图片
                Picasso.with(context).load(substring).config(Bitmap.Config.RGB_565).into(iv_shopping);
                this.iv_shopping.setTag(R.id.iv_shopping, substring);
            }
            tv_name.setText(bean.getTitle());
            tv_type_all_price.setText("￥"+(bean.getPrice()/100));
            tv_cart_goods_amount.setText(bean.getCartCount()+"");
            if (map.get(bean.getItemId())!=null) {
                appCompatCheckBox.setChecked(map.get(bean.getItemId()));
            }

            final int uid = SharedPreUtil.getInt(context, "Uid", 0);

            //如果checkbox有状态为false的，则设置全选checkbox为false   分为加载和点击
            setCheckAllBoxType(map,position);



            ib_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changePlus(uid,bean,-1);

                }
            });

            ib_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changePlus(uid,bean,1);
                }
            });

            //删除选择商品
            iv_clean.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        //弹出是否确定删除对话框
                        AlertDialog.Builder builder = new AlertDialog.Builder(context).setIcon(null).setTitle("移除商品").setMessage("是否确定移除商品").setPositiveButton("确定", new
                                                DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        map.remove(bean.getItemId());

                                                        Gson gson=new Gson();
                                                        String checkMap = gson.toJson(map);
                                                        SharedPreUtil.saveString(context,"checkMap",checkMap);
                                                        changePlus(uid,bean,-bean.getCartCount());
                                                    }
                                                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                //ToDo: 你想做的事情
                                                Toast.makeText(context, "关闭按钮", Toast.LENGTH_LONG).show();
                                                dialogInterface.dismiss();
                                            }
                                        });
                        builder.create().show();
                    }catch (Exception e){
                        Log.e("111",e.getMessage());
                    }
                }
            });

            appCompatCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreUtil.saveInt(context,"allPrice",0);
                    map.put(bean.getItemId(), !map.get(bean.getItemId()));
                    Gson gson=new Gson();
                    String checkMap = gson.toJson(map);
                    SharedPreUtil.saveString(context,"checkMap",checkMap);
                    setCheckAllBoxType(map,bean.getItemId());
                    //刷新适配器
                    adapter.notifyDataSetChanged();


                }
            });




        ((MainActivity) context).getShoppingCartFragment().allCount();

    }




    @Override
    protected void onItemClick(View itemView, int position, ShoppingCartInfo.ResultBean.ItemsBean bean) {
        super.onItemClick(itemView, position, bean);

    }





    private void changePlus(int uid, ShoppingCartInfo.ResultBean.ItemsBean bean, int i) {
        SharedPreUtil.saveInt(context, "allPrice", 0);
        ((MainActivity) context).getShoppingCartFragment().selectCart(bean,false,1);

        Map map= new HashMap();
        map.put("item_id",bean.getItemId());
        map.put("num",i);
        JSONObject json = new JSONObject(map);
        List result = new ArrayList();
        result.add(json.toString());


        AddShopCartInfo addShopCartInfo=new AddShopCartInfo();
        addShopCartInfo.setTicket(uid+"");
        addShopCartInfo.setItem_id(result.toString());


        ((MainActivity)context).getShoppingCartFragment().getShoppingCartPersenter().changeShoppingCartInfo(addShopCartInfo);

        //刷新适配器
        adapter.notifyDataSetChanged();



    }



    public void setCheckAllBoxType(HashMap<Integer,Boolean> maps,int position){
        if (!maps.containsValue(false)){
            HashMap<Integer,Boolean> hashMap= new HashMap<>();
            hashMap.put(0,true);
            Gson gsonAll=new Gson();
            String checkMapAll = gsonAll.toJson(hashMap);
            SharedPreUtil.saveString(context,"checkMapAll",checkMapAll);

            ((MainActivity)context).getShoppingCartFragment().setCheckAllTppe(false);
            ((MainActivity)context).getShoppingCartFragment().getCheckAll().setChecked(true);
        }else {
            HashMap<Integer,Boolean> hashMap= new HashMap<>();
            hashMap.put(0,false);
            Gson gsonAll=new Gson();
            String checkMapAll = gsonAll.toJson(hashMap);
            SharedPreUtil.saveString(context,"checkMapAll",checkMapAll);

            ((MainActivity)context).getShoppingCartFragment().setCheckAllTppe(true);
            ((MainActivity)context).getShoppingCartFragment().getCheckAll().setChecked(false);
        }
    }




}
