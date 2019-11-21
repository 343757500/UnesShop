package com.unes.shopp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.common.base.Global;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.AddShopCartInfo;
import com.unes.shopp.model.bean.PosthOrderInfo;
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.model.bean.TestBean;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.MinePresenter;
import com.unes.shopp.ui.adapter.ConfirmationAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lzy.okgo.OkGo.getContext;

public class ConfirmationActivity extends BaseActivity{

    private ArrayList<ShoppingCartInfo.ResultBean.ItemsBean> itemsBeans=new ArrayList<>();
    private TextView tv_amount;
    private TextView tv_submit;
    private MinePresenter minePresenter;

    @Override
    public int getLayoutRes() {

        return R.layout.activity_confirmation;
    }

    @Override
    public void initView() {
        //谷歌状态栏文字底色的黑白   true就是黑色底，false为白色底


        Global.setAndroidNativeLightStatusBar(this,true);
        TabLayout tl = findView(R.id.tl);
        ViewPager vp = findView(R.id.vp);
        tv_amount = findView(R.id.tv_amount);
        tv_submit = findView(R.id.tv_submit);

        ConfirmationAdapter confirmationAdapter= new ConfirmationAdapter(getSupportFragmentManager(),new String[]{"门店自提","快速配送"});
        vp.setAdapter(confirmationAdapter);
        tl.setupWithViewPager(vp);

    }

    @Override
    public void initListener() {
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"rrr",Toast.LENGTH_LONG).show();


                Map map= new HashMap();
                List result = new ArrayList();
                for (int i = 0; i < itemsBeans.size(); i++) {
                    itemsBeans.get(i).getItemId();
                    itemsBeans.get(i).getItemNum();
                    map.put("item_id",itemsBeans.get(i).getItemId());
                    map.put("num", itemsBeans.get(i).getCartCount());
                    JSONObject json = new JSONObject(map);
                    result.add(json.toString());
                }


                int uid = SharedPreUtil.getInt(getApplicationContext(), "Uid", 0);
                AddShopCartInfo addShopCartInfo=new AddShopCartInfo();
                addShopCartInfo.setTicket(uid+"");
                addShopCartInfo.setItem_id(result.toString());

                long adTime=(int) (System.currentTimeMillis()/1000);
                minePresenter.posthOrder(uid+"",result.toString(),"4","1",adTime,"",0,0, 0,null,"cart","yes");
            }
        });
    }

    @Override
    public void initData() {
        minePresenter = new MinePresenter(this);
    }

    @Override
    public void onClick(View v, int id) {

    }



    //发送消息,
    //一般用 post发送， @Subscribe接收就可以了
    // 此处因为发送消息的时候，SecondActivity还没启动，所以必须用粘性事件postSticky发送
    // 所以接收的时候必须用粘性事件接收@Subscribe(threadMode= ThreadMode.MAIN,sticky=true)
    @Subscribe(threadMode= ThreadMode.MAIN,sticky=true)
    public void EventBus(ArrayList<ShoppingCartInfo.ResultBean.ItemsBean>  itemsBean){
        this.itemsBeans=itemsBean;
        EventBus.getDefault().postSticky(new TestBean("buer"));
        int allPrice=0;
        for (int i = 0; i < itemsBeans.size(); i++) {
            allPrice=itemsBeans.get(i).getPrice()+allPrice;
        }
        tv_amount.setText("应付：￥"+allPrice/100);
    }


    //获取购物车选中商品
    public ArrayList<ShoppingCartInfo.ResultBean.ItemsBean> getItemsBean(){
        return this.itemsBeans;
    }

    //============otto事件监听(begin)====================
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }



    @Override
    protected void onDestroy () {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_POSTHORDER){
            PosthOrderInfo posthOrderInfo= (PosthOrderInfo) obj.obj;
        }
    }
}
