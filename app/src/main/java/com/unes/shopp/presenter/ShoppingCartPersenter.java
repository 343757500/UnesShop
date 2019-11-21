package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;
import com.unes.shopp.model.bean.AddShopCartInfo;

import java.util.Map;

public class ShoppingCartPersenter extends BasePresenter {

    public ShoppingCartPersenter(BaseView baseView) {
        super(baseView);
    }

    public void getShoppingCartInfo(String ticket){
        mProtocol.getShoppingCartInfo(mBaseCallback,ticket);
    }


    public void changeShoppingCartInfo(AddShopCartInfo items){
        mProtocol.changeShoppingCartInfo(mBaseCallback,items);
    }
}
