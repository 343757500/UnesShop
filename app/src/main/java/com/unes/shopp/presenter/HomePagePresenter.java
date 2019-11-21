package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;

public class HomePagePresenter extends BasePresenter {
    public HomePagePresenter(BaseView baseView) {
        super(baseView);
    }

    public void getHomeBannerInfo(String value){
        mProtocol.getHomeBannerInfo(mBaseCallback,value);
    }

    public void getHomeFetchCatesInfo(){
        mProtocol.getHomeFetchCatesInfo(mBaseCallback);
    }

    public void getHomelistItemsInfo(String q,String orderColumn,String sortType,String itemTypes,String pg,String sz){
        mProtocol.getHomelistItemsInfo(mBaseCallback,q,orderColumn,sortType,itemTypes,pg,sz);
    }
}
