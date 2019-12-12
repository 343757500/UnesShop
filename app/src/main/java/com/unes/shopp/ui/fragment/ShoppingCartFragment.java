package com.unes.shopp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseFragment;
import com.unes.shopp.common.base.Const;
import com.unes.shopp.common.base.OttoBus;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.ChangeShopCartInfo;
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.model.bean.TestBean;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.ShoppingCartPersenter;
import com.unes.shopp.ui.activity.ConfirmationActivity;
import com.unes.shopp.ui.adapter.ShoppingAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCartFragment extends BaseFragment {

    private RecyclerView rv_shopping;
    private ShoppingCartPersenter shoppingCartPersenter;
    private ShoppingAdapter shoppingAdapter;

    private LinearLayout llBottomCardLayout01;
    private TextView tvSendPrice;
    private LinearLayout llBottomCardLayout02;
    private TextView tvAmount;
    private TextView tvDeliveryFee;
    private TextView tvSubmit;
    private FrameLayout flMycartZoom;
    private TextView tvSelectCount;
    private ImageButton ibPlus;
    private ShoppingCartInfo shoppingCartInfo;
    private AppCompatCheckBox checkAll;




    public void setShoppingAdapter(){
        rv_shopping.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingAdapter = new ShoppingAdapter(getContext(),null);
        shoppingAdapter.setHasStableIds(true);
        ((DefaultItemAnimator) rv_shopping.getItemAnimator()).setSupportsChangeAnimations(false); // 取消动画效果
        rv_shopping.setAdapter(shoppingAdapter);




    }
    public  AppCompatCheckBox getCheckAll(){
        return  this.checkAll;
    }


    private Boolean checkAllTppe=false;

    //因为全选按钮在不勾选的时候会执行  shoppingAdapter.neverall(getContext());导致全部子checkbox不勾选，需要一个字段判断是点击的还是 依据子checkbox状态设置
    public  void setCheckAllTppe(boolean checkAllTppe){
         this.checkAllTppe=checkAllTppe;
    }


    public  ShoppingCartPersenter getShoppingCartPersenter(){
        return this.shoppingCartPersenter;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_shoppingcart;
    }

    @Override
    public void initView() {
        rv_shopping = findView(R.id.rv_shopping);
        rv_shopping.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingAdapter = new ShoppingAdapter(getContext(),null);

        shoppingAdapter.setHasStableIds(true);
        ((DefaultItemAnimator) rv_shopping.getItemAnimator()).setSupportsChangeAnimations(false); // 取消动画效果
        rv_shopping.setAdapter(shoppingAdapter);

        llBottomCardLayout01 = (LinearLayout) findView(R.id.ll_bottom_card_layout_01);
        llBottomCardLayout02 = (LinearLayout) findView(R.id.ll_bottom_card_layout_02);
        tvAmount = (TextView) findView(R.id.tv_amount);
        tvSendPrice = (TextView) findView(R.id.tv_send_price);
        tvDeliveryFee = (TextView) findView(R.id.tv_delivery_fee);
        tvSelectCount = (TextView) findView(R.id.tv_select_count);
        tvSubmit = (TextView) findView(R.id.tv_submit);
        checkAll = findView(R.id.checkAll);


        String checkMapAll1 = SharedPreUtil.getString(getContext(), "checkMapAll", "");
        if (!checkMapAll1.equals("")) {
            HashMap<Integer, Boolean> mapNew = new Gson().fromJson(checkMapAll1, new TypeToken<Map<Integer, Boolean>>() {
            }.getType());
            if (mapNew.get(0)) {
                checkAll.setChecked(true);
            } else {
                checkAll.setChecked(false);
            }
        }



    }



    @Override
    public void initListener() {
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(cartBeans);
                Intent intent=new Intent(getActivity(),
                        ConfirmationActivity.class);
                getActivity().startActivity(intent);
            }
        });



        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllTppe=false;
            }
        });
        checkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if (checkAllTppe){
                        shoppingAdapter.All(getContext());
                        //设置购物车选中总金额为0
                        SharedPreUtil.saveInt(getContext(), "allPrice", 0);

                        HashMap<Integer, Boolean> hashMap = new HashMap<>();
                        hashMap.put(0, b);
                        Gson gson = new Gson();
                        String checkMapAll = gson.toJson(hashMap);
                        SharedPreUtil.saveString(getContext(), "checkMapAll", checkMapAll);


                    }else {

                        //设置购物车选中总金额为0
                       // SharedPreUtil.saveInt(getContext(), "allPrice", 0);

                        HashMap<Integer, Boolean> hashMap = new HashMap<>();
                        hashMap.put(0, b);
                        Gson gson = new Gson();
                        String checkMapAll = gson.toJson(hashMap);
                        SharedPreUtil.saveString(getContext(), "checkMapAll", checkMapAll);

                    }
                }else{

                    if (checkAllTppe){
                        //设置购物车选中总金额为0
                        SharedPreUtil.saveInt(getContext(), "allPrice", 0);
                        HashMap<Integer, Boolean> hashMap = new HashMap<>();
                        hashMap.put(0, b);
                        Gson gson = new Gson();
                        String checkMapAll = gson.toJson(hashMap);
                        SharedPreUtil.saveString(getContext(), "checkMapAll", checkMapAll);
                    }else {
                        shoppingAdapter.neverall(getContext());
                        //设置购物车选中总金额为0
                        SharedPreUtil.saveInt(getContext(), "allPrice", 0);
                        HashMap<Integer, Boolean> hashMap = new HashMap<>();
                        hashMap.put(0, b);
                        Gson gson = new Gson();
                        String checkMapAll = gson.toJson(hashMap);
                        SharedPreUtil.saveString(getContext(), "checkMapAll", checkMapAll);
                    }


                }
                checkAllTppe=false;
            }
        });

    }

    @Override
    public void initData() {
        shoppingCartPersenter = new ShoppingCartPersenter(this);
        int uid = SharedPreUtil.getInt(getContext(), Const.TICKET, 0);
        shoppingCartPersenter.getShoppingCartInfo(uid+"");

    }

    @Override
    public void onClick(View v, int id) {
    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        //设置购物车选中总金额为0
        SharedPreUtil.saveInt(getContext(), "allPrice", 0);
        cartBeans.clear();
        if (reqType== IHttpService.TYPE_SHOPPINGCARTINFO){

            shoppingCartInfo = (ShoppingCartInfo) obj.obj;
            shoppingAdapter.setDatas(shoppingCartInfo.getResult().getItems());


        }else if (reqType==IHttpService.TYPE_CHANGESHOPPINGCARTINFO){
            ChangeShopCartInfo changeShopCartInfo= (ChangeShopCartInfo) obj.obj;

            shoppingCartPersenter = new ShoppingCartPersenter(this);
            int uid = SharedPreUtil.getInt(getContext(), Const.TICKET, 0);
            shoppingCartPersenter.getShoppingCartInfo(uid+"");


        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }


    public void allCount(){
        int allPricee = SharedPreUtil.getInt(getContext(), "allPrice", 0);
        tvAmount.setText("共计："+allPricee);
    }


    //确认订单后的被勾选的数据
    private ArrayList<ShoppingCartInfo.ResultBean.ItemsBean> cartBeans=new ArrayList<>();
    public void selectCart(ShoppingCartInfo.ResultBean.ItemsBean bean,boolean type,int t){
        if (type){  //type 为true代表checkbox为选中状态
            if (!cartBeans.contains(bean)) {   //如果不包含则切选中状态则加入集合中，包含则不理
                cartBeans.add(bean);
            }
        }else {
            if (cartBeans.contains(bean)) {
                cartBeans.remove(bean);
            }
        }

        if (t==1){
            cartBeans.clear();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //设置购物车选中总金额为0
        SharedPreUtil.saveInt(getContext(), "allPrice", 0);
        shoppingCartPersenter=null;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        //因为购物车在别的页面点击添加购物车，进入页面重新刷新adapter,而且虽然网络请求了，但是异步会导致adapter的数据map因为点击删除的时候而报空指针异常。
        setShoppingAdapter();
    }


    @Override
    public void onStop() {
        super.onStop();
    }










}
