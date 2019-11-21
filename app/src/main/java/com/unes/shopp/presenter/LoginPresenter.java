package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;

public class LoginPresenter extends BasePresenter {
    public LoginPresenter(BaseView baseView) {
        super(baseView);
    }


    public void getLoginInfo(String username,String password){
        mProtocol.getLoginInfo(mBaseCallback,username,password);
    }

}
