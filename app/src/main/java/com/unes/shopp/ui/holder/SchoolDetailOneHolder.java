package com.unes.shopp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.model.bean.SchoolDetailOneInfo;
import com.unes.shopp.ui.activity.SchoolActivity;
import com.unes.shopp.ui.adapter.SchoolDetailOneAdapter;

public class SchoolDetailOneHolder extends BaseHolderRV<SchoolDetailOneInfo.ResultBean.CoursesBean> {

    private ImageView iv;
    private TextView tv;

    public SchoolDetailOneHolder(Context context, ViewGroup parent, SchoolDetailOneAdapter schoolDetailOneAdapter, int viewType) {
        super(context, parent, schoolDetailOneAdapter, viewType, R.layout.school_detail_one);
    }

    @Override
    public void onFindViews(View itemView) {
        iv = itemView.findViewById(R.id.iv);
        tv = itemView.findViewById(R.id.tv);
    }

    @Override
    protected void onRefreshView(SchoolDetailOneInfo.ResultBean.CoursesBean bean, int position) {
        SchoolDetailOneInfo.ResultBean.CoursesBean  coursesBean = bean;
        Picasso.with(context).load(coursesBean.getTopUrl()).into(iv);

        tv.setText(coursesBean.getTitle());
    }


    @Override
    protected void onItemClick(View itemView, int position, SchoolDetailOneInfo.ResultBean.CoursesBean bean) {
        super.onItemClick(itemView, position, bean);

        Intent intent = new Intent(context,SchoolActivity.class);
        intent.putExtra("id",bean.getId()+"");
        context.startActivity(intent);
    }
}
