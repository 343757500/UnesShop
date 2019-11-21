package com.unes.shopp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.SchoolDetailOneInfo;
import com.unes.shopp.ui.holder.SchoolDetailOneHolder;

import java.util.List;

public class SchoolDetailOneAdapter extends BaseAdapterRV<SchoolDetailOneInfo.ResultBean.CoursesBean> {
    public SchoolDetailOneAdapter(Context context, List<SchoolDetailOneInfo.ResultBean.CoursesBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<SchoolDetailOneInfo.ResultBean.CoursesBean> createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new SchoolDetailOneHolder(context, parent, this, viewType);
    }
}
