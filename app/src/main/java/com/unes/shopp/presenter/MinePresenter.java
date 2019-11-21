package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;

public class MinePresenter extends BasePresenter {

    public MinePresenter(BaseView baseView) {
        super(baseView);
    }

    public void getMineInFo(String ticket){
        mProtocol.getMineInfo(mBaseCallback,ticket);
    }

    public void posthOrderPublicCouponList(String ticket,int allPrice){
        mProtocol.posthOrderPublicCouponList(mBaseCallback,ticket,allPrice);
    }

    public void posthOrder(String ticket,String items,String pType,String orderType,long adTime ,String msg,int isTaxFree,int point,int couonId,String idCard,String from,String isCommint){
        mProtocol.posthOrder(mBaseCallback,ticket,items,pType,orderType,adTime,msg,isTaxFree,point,couonId,idCard,from,isCommint);
    }
}
