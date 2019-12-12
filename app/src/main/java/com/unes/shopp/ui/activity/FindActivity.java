package com.unes.shopp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.model.bean.FetchItemsByIdInfo;
import com.unes.shopp.ui.adapter.FindAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class FindActivity extends BaseActivity {

    private RecyclerView rv_find;
    private FindAdapter findAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_find;
    }

    @Override
    public void initView() {

        rv_find = findView(R.id.rv_find);
        rv_find.setLayoutManager(new LinearLayoutManager(this));
        findAdapter = new FindAdapter(this,null);
        rv_find.setAdapter(findAdapter);
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    //发送消息,
    //一般用 post发送， @Subscribe接收就可以了
    // 此处因为发送消息的时候，SecondActivity还没启动，所以必须用粘性事件postSticky发送
    // 所以接收的时候必须用粘性事件接收@Subscribe(threadMode= ThreadMode.MAIN,sticky=true)
    @Subscribe(threadMode= ThreadMode.MAIN,sticky=true)
    public void EventBus(List<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> fodderItemDOs){
        findAdapter.setDatas(fodderItemDOs);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
}
