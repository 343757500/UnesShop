package com.unes.shopp.ui.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseFragment;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.MineInfo;
import com.unes.shopp.model.bean.PostAllPriceInfo;
import com.unes.shopp.model.bean.ShoppingCartInfo;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.MinePresenter;
import com.unes.shopp.ui.activity.ConfirmationActivity;
import com.unes.shopp.ui.activity.MainActivity;
import com.unes.shopp.ui.adapter.ConfirmationCartAdapter;

import java.util.ArrayList;


public class ConfirmationFragment extends BaseFragment {

    private RecyclerView rv;
    private TextView tv_adress;
    private ArrayList<ShoppingCartInfo.ResultBean.ItemsBean> itemsBeans;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_confirmation;
    }

    @Override
    public void initView() {
        rv = findView(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        tv_adress = findView(R.id.tv_adress);


        ConfirmationCartAdapter confirmationCartAdapter = new ConfirmationCartAdapter(getContext(), null);
        rv.setAdapter(confirmationCartAdapter);
        itemsBeans = ((ConfirmationActivity) getActivity()).getItemsBean();
        confirmationCartAdapter.setDatas(itemsBeans);




    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        int uid = SharedPreUtil.getInt(getContext(), "Uid", 0);
        MinePresenter minePresenter = new MinePresenter(this);
        minePresenter.getMineInFo(uid+"");
        int allPrice=0;
        for (int i = 0; i < itemsBeans.size(); i++) {
            allPrice = itemsBeans.get(i).getPrice()+allPrice;
        }
        minePresenter.posthOrderPublicCouponList(uid+"",allPrice);
    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_MINEINFO){
            MineInfo mineInfo= (MineInfo) obj.obj;
            tv_adress.setText(mineInfo.getResult().getCeo2Address().getReceiverAddress());
        }else if (reqType==IHttpService.TYPE_ALLPRICE){
            PostAllPriceInfo postAllPriceInfo= (PostAllPriceInfo) obj.obj;
        }
    }
}
