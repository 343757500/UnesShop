package com.unes.shopp.presenter;

import com.unes.shopp.base.BasePresenter;
import com.unes.shopp.base.BaseView;

public class SchoolDetailOnePresenter extends BasePresenter {
    public SchoolDetailOnePresenter(BaseView baseView) {
        super(baseView);
    }

    public void getSchoolOneInfo(String type,String courseCategory,String pg,String sz){
        mProtocol.getSchoolOneInfo(mBaseCallback,type,courseCategory,pg,sz);
    }


}
