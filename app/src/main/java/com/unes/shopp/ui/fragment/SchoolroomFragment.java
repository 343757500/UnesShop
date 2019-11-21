package com.unes.shopp.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseFragment;
import com.unes.shopp.common.base.Global;
import com.unes.shopp.ui.adapter.SchoolTabAdapter;

public class SchoolroomFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tl;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_schoolroom;
    }

    @Override
    public void initView() {
        //谷歌状态栏文字底色的黑白   true就是黑色底，false为白色底
        Global.setAndroidNativeLightStatusBar(getActivity(),true);


        tl = findView(R.id.tl);
        vp = findView(R.id.vp);



        SchoolTabAdapter schoolTabAdapter=new SchoolTabAdapter(getFragmentManager(),new String[]{"护肤知识","清爽夏日"});
        vp.setAdapter(schoolTabAdapter);
        tl.setupWithViewPager(vp);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }
}
