package com.unes.shopp.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseFragment;
import com.unes.shopp.model.bean.SchoolDetailOneInfo;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.HomePagePresenter;
import com.unes.shopp.presenter.SchoolDetailOnePresenter;
import com.unes.shopp.ui.adapter.SchoolDetailOneAdapter;

import java.util.ArrayList;
import java.util.List;

public class SchoolDetailOneFragment extends BaseFragment {

    private RecyclerView rv_school;
    private SchoolDetailOneAdapter schoolDetailOneAdapter;
    private SchoolDetailOnePresenter schoolDetailOnePresenter;
    private String courseCategory;

    @Override
    public int getLayoutRes() {
        Bundle bundle = getArguments();
        courseCategory = bundle.getString("courseCategory");
        return R.layout.fragment_schoolonedetail;
    }

    @Override
    public void initView() {
        rv_school = findView(R.id.rv_school);

        LinearLayoutManager lm=new LinearLayoutManager(mActivity);
        rv_school.setLayoutManager(lm);
        schoolDetailOneAdapter = new SchoolDetailOneAdapter(mActivity,null);
        rv_school.setAdapter(schoolDetailOneAdapter);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        schoolDetailOnePresenter = new SchoolDetailOnePresenter(this);
        schoolDetailOnePresenter.getSchoolOneInfo("1",courseCategory,"0","10");

    }

    @Override
    public void onClick(View v, int id) {

    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_SCHOOLDETAILONE){
            SchoolDetailOneInfo schoolDetailOneInfo= (SchoolDetailOneInfo) obj.obj;
            List<SchoolDetailOneInfo.ResultBean.CoursesBean> courses = schoolDetailOneInfo.getResult().getCourses();
            List list=new ArrayList();
            for (int i = 0; i < courses.size(); i++) {
                list.add(courses.get(i));
            }

            schoolDetailOneAdapter.setDatas(list);
        }
    }


    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }
}
