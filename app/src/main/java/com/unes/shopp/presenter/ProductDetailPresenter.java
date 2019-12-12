package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;

public class ProductDetailPresenter extends BasePresenter{
    public ProductDetailPresenter(BaseView baseView) {
        super(baseView);
    }

    public void getFetchItemsInfo(String ticket,String ids){
        mProtocol.getFetchItemsInfo(mBaseCallback,ticket,ids);
    }


    public void getFodderItemByItemId(String ticket,String itemId){
        mProtocol.getFodderItemByItemId(mBaseCallback,ticket,itemId);
    }
}
