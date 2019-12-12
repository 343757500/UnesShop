package com.unes.shopp.ui.fragment;

import android.graphics.Color;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseFragment;
import com.unes.shopp.model.bean.HomeBannerInfo;
import com.unes.shopp.model.bean.HomeFetchCatesInfo;
import com.unes.shopp.model.bean.HomeListItemsInfo;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.HomePagePresenter;
import com.unes.shopp.presenter.ShoppingCartPersenter;
import com.unes.shopp.ui.TextSliderView;
import com.unes.shopp.ui.activity.MainActivity;
import com.unes.shopp.ui.adapter.HomeAdapter;
import com.unes.shopp.ui.adapter.HomeMessage01Adapter;
import com.unes.shopp.ui.adapter.HomeMessage02Adapter;
import com.unes.shopp.ui.adapter.HomeMessage03Adapter;
import com.unes.shopp.ui.adapter.HomeMessage04Adapter;

import java.util.ArrayList;
import java.util.List;

//首页页面
public class HomePageFragment extends BaseFragment {

    private AppBarLayout mAppBarLayout;
    private RecyclerView rv_message04;

    View mFLayout;
    private SliderLayout slider_layout;
    private PagerIndicator indicator;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView rv_message01;
    private RecyclerView rv_message02;
    private RecyclerView rv_message03;
    private HomePagePresenter homePagePresenter;
    private HomeMessage01Adapter homeMessage01Adapter;
    private HomeMessage02Adapter homeMessage02Adapter;
    private HomeMessage03Adapter homeMessage03Adapter;
    private ImageView iv_selected;
    private HomeMessage04Adapter homeMessage04Adapter;
    private ShoppingCartPersenter shoppingCartPersenter;
    private RelativeLayout rl_seckill;


    public ShoppingCartPersenter getShoppingCartPersenter(){
        return this.shoppingCartPersenter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_05;
    }

    @Override
    public void initView() {
        getActivity().getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mAppBarLayout = findView(R.id.appbar);
        mFLayout =  findView(R.id.fl_layout);
        slider_layout = findView(R.id.slider_layout);
        indicator = findView(R.id.custom_indicator);
        refreshLayout = findView(R.id.refreshLayout);
        rl_seckill = findView(R.id.rl_seckill);
        initRecycleview();

        
        //下拉刷新和上来加载更多
        initSpringView();

    }

    private void initRecycleview() {

        rv_message01 = findView(R.id.rv_message01);
        LinearLayoutManager lm1=new LinearLayoutManager(mActivity);
        lm1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_message01.setLayoutManager(new GridLayoutManager(mActivity, 4));
        homeMessage01Adapter = new HomeMessage01Adapter(mActivity,null);
        rv_message01.setAdapter(homeMessage01Adapter);




        //秒杀活动
        rv_message02 = findView(R.id.rv_message02);
        LinearLayoutManager lm2=new LinearLayoutManager(mActivity);
        rv_message02.setLayoutManager(lm2);
        homeMessage02Adapter = new HomeMessage02Adapter(mActivity,null);
        rv_message02.setAdapter(homeMessage02Adapter);


        //精选活动
        iv_selected = findView(R.id.iv_selected);
        rv_message03 = findView(R.id.rv_message03);
        LinearLayoutManager lm3=new LinearLayoutManager(mActivity);
        lm3.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_message03.setLayoutManager(new GridLayoutManager(mActivity, 2));
        homeMessage03Adapter = new HomeMessage03Adapter(mActivity,null);
        rv_message03.setAdapter(homeMessage03Adapter);


        //精选产品
        rv_message04 = findView(R.id.rv_message04);
        rv_message04.setLayoutManager(new GridLayoutManager(mActivity, 2));
        homeMessage04Adapter = new HomeMessage04Adapter(mActivity, null);
        rv_message04.setAdapter(homeMessage04Adapter);

    }

    @Override
    public void initListener() {
        //搜索栏滑动渐变监听
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float percent = Float.valueOf(Math.abs(verticalOffset)) / Float.valueOf(appBarLayout.getTotalScrollRange());
                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();
                int dy = Math.abs(verticalOffset);
                if (dy <= toolbarHeight/2) {
                    float scale = (float)(toolbarHeight- dy) / toolbarHeight;
                    float alpha = scale * 255;
                    //设置搜索栏渐变色，第一个参数控制渐变是否透明，后面三个红绿蓝控制最终渐变成什么颜色
                    mFLayout.setBackgroundColor(Color.argb((int) alpha, 0, 0, 0));
                }else{
                    float scale = (float)dy / toolbarHeight;
                    float alpha = scale * 255;
                    //设置搜索栏渐变色，第一个参数控制渐变是否透明，后面三个红绿蓝控制最终渐变成什么颜色
                    mFLayout.setBackgroundColor(Color.argb((int) alpha, 0, 0, 0));
                }
            }
        });
    }

    @Override
    public void initData() {

        initDataRefresh();
    }

    //下拉刷新直接调用刷新全部数据
    private void initDataRefresh() {
        homePagePresenter = new HomePagePresenter(this);
        homePagePresenter.getHomeBannerInfo("418,423,419,425,422,420,421");
        homePagePresenter.getHomeFetchCatesInfo();
        homePagePresenter.getHomelistItemsInfo("","","","1","0","10");


        shoppingCartPersenter = new ShoppingCartPersenter(this);

    }

    @Override
    public void onClick(View v, int id) {

    }



    /** 显示轮播图*/
    private void initLooperImage( List<HomeBannerInfo.ResultBean.BannersBean._$418Bean>  _$418Bean) {
        slider_layout.removeAllSliders();
        for (int i = 0; i < _$418Bean.size(); i++) {
        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description(_$418Bean.get(i).getTitle())
                .image(_$418Bean.get(i).getPicUrl());

            final int finalI = i;
            textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(getActivity(),"轮播图的第一"+ finalI +"个图的点击效果",Toast.LENGTH_LONG).show();
            }
        });

        slider_layout.addSlider(textSliderView1);
        }
        // slider_layout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);// 设置默认指示器位置(默认指示器白色)
        slider_layout.setCustomIndicator(indicator); // 设置自定义指示器(位置自定义)
        // slider_layout.setCustomAnimation(new DescriptionAnimation());   // 设置TextView自定义动画
        slider_layout.setPresetTransformer(SliderLayout.Transformer.Tablet);//设置默认过渡效果(可在xml中设置)的动画
        slider_layout.setDuration(3000);//设置时间 这个时间 就是延迟时间 第一个图跟第2个图3秒间隔
        if (_$418Bean.size()<=1){
            //如果数据为一个则停止轮播
            slider_layout.stopAutoCycle();
        }


    }


    private void initSpringView() {

        //这里我们滚动的布局控件 ScrollView 或NestScrollView 加一个SwipeRefreshLayout下拉刷新，会出现这样一种情况：
        //先将ScrollView 向上滑动一部分,然后松手，然后再向下滑动,.此时会出现先触发swipeRefreshLayout的问题。
        //影响客户体验
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    refreshLayout.setEnabled(true);
                } else {
                    refreshLayout.setEnabled(false);
                }
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                initDataRefresh();
                // 设置是否开始刷新,true为刷新，false为停止刷新
                refreshLayout.setRefreshing(false);
            }

        });


    }


    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        super.onHttpSuccess(reqType, msg);

        if (reqType== IHttpService.TYPE_HOMEBANNER){
            HomeBannerInfo homeBannerInfo= (HomeBannerInfo) msg.obj;
            //轮播图数据
            List<HomeBannerInfo.ResultBean.BannersBean._$418Bean> _$418Bean = homeBannerInfo.getResult().getBanners().get_$418();
            //轮播图
            initLooperImage(_$418Bean);


            //秒杀数据

            List<HomeBannerInfo.ResultBean.BannersBean._$422Bean> _$422Bean = homeBannerInfo.getResult().getBanners().get_$422();

            initSecKill(_$422Bean);



            //精选数据
            List<HomeBannerInfo.ResultBean.BannersBean._$421Bean> _$421Bean = homeBannerInfo.getResult().getBanners().get_$421();
            initSelect(_$421Bean);



            return;
        }


        if (reqType==IHttpService.TYPE_HOMEFETCHCATES){
            HomeFetchCatesInfo homeFetchCatesInfo= (HomeFetchCatesInfo) msg.obj;
            List<HomeFetchCatesInfo.ResultBean.CatesBean> cates = homeFetchCatesInfo.getResult().getCates();

            ArrayList list=new ArrayList();
            for (int i = 0; i < cates.size(); i++) {
                list.add(cates.get(i));
            }
            homeMessage01Adapter.setDatas(list);
            return;
        }


        //精选产品
        if (reqType==IHttpService.TYPE_LISTITEMS){
            HomeListItemsInfo homeListItemsInfo= (HomeListItemsInfo) msg.obj;
            List<HomeListItemsInfo.ResultBean.ItemsBean> items = homeListItemsInfo.getResult().getItems();
            List list=new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
                list.add(items.get(i));
            }
            homeMessage04Adapter.setDatas(list);


            return;
        }
    }

    private void initSelect(List<HomeBannerInfo.ResultBean.BannersBean._$421Bean> bean) {
        Picasso.with(getContext()).load(bean.get(0).getPicUrl()).into(iv_selected);
        ArrayList list=new ArrayList<>();
        for (int i = 1; i < bean.size(); i++) {
            list.add(bean.get(i));
        }
        homeMessage03Adapter.setDatas(list);
    }

    //秒杀活动数据
    private void initSecKill(List<HomeBannerInfo.ResultBean.BannersBean._$422Bean> bean) {
        ArrayList list=new ArrayList<>();
        if (bean!=null) {
            for (int i = 0; i < bean.size(); i++) {
                list.add(bean.get(i));
            }
            homeMessage02Adapter.setDatas(list);
            rl_seckill.setVisibility(View.VISIBLE);
        }else {
            rl_seckill.setVisibility(View.GONE);
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        slider_layout.removeAllSliders();
        homePagePresenter=null;
        mRoot=null;
    }
}
