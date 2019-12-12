package com.unes.shopp.ui.activity;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.common.base.Global;
import com.unes.shopp.common.ui.GradientTab;
import com.unes.shopp.ui.NoScrollViewPager;
import com.unes.shopp.ui.adapter.MyFragmentAdapter;
import com.unes.shopp.ui.fragment.HomePageFragment;
import com.unes.shopp.ui.fragment.MineFragment;
import com.unes.shopp.ui.fragment.SchoolroomFragment;
import com.unes.shopp.ui.fragment.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private String[] titles = new String[] {
            "首页", "分类", "购物车", "我的"
    };

    private int[] icons = new int[] {
            R.drawable.icon_tab_01,
            R.drawable.icon_tab_02,
            R.drawable.icon_tab_03,
            R.drawable.icon_tab_04,
    };

    private int[] iconsSelected = new int[] {
            R.drawable.icon_tab_01_selected,
            R.drawable.icon_tab_02_selected,
            R.drawable.icon_tab_03_selected,
            R.drawable.icon_tab_04_selected,
    };



    /** 选项卡控件 */
    private GradientTab[] mTabs = new GradientTab[4];
    /** 当前选中的选项卡 */
    private GradientTab mCurrentTab;

    private LinearLayout llTabLayout;
    private NoScrollViewPager viewPager;
    private MyFragmentAdapter myFragmentAdapter;
    private ShoppingCartFragment shoppingCartFragment;
    private HomePageFragment homePageFragment;


    public ShoppingCartFragment getShoppingCartFragment(){
        return this.shoppingCartFragment;
    }


    public HomePageFragment getHomePageFragment(){
        return this.homePageFragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        llTabLayout = findView(R.id.ll_tab_layout);
        viewPager = findView(R.id.view_pager);


        initTab();
        initViewPager();
    }

    @Override
    public void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                onTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }





    private void initTab() {
        int padding = Global.dp2px(5); // 5dp
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT);
        param.weight = 1;   // 宽度平分
        for (int i = 0; i < titles.length; i++) {
            GradientTab tab = new GradientTab(this);
            mTabs[i] = tab;
            tab.setTag(i);  // 设置标识
            // 设置选项卡点击事件
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    // 选项卡切换了
                    // onTabSelected(position);
                    // false： 禁用切换的动画
                    viewPager.setCurrentItem(position, false);
                }
            });

            // 设置标题和图标
            tab.setTextAndIcon(titles[i], icons[i], iconsSelected[i]);
            // 指定高亮显示的颜色
            tab.setHighlightColor(getResources().getColor(R.color.tab_text_pressed));
            //这里修改了下面图标距离上下15的距离
            tab.setPadding(0, 15, 0, 15);

            // 设置未读条数
            // tab.setUnreadCount(3);
            // 有新消息: 显示红点
            // tab.setRedDotVisible(true);
            llTabLayout.addView(tab, param);
        }

        mCurrentTab = mTabs[0];  // 默认选中第一个
        mCurrentTab.setTabSelected(true);   // 选中，会高亮
    }



    private void initViewPager() {
        homePageFragment = new HomePageFragment();
        shoppingCartFragment = new ShoppingCartFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homePageFragment);
        fragments.add(new SchoolroomFragment());
        fragments.add(shoppingCartFragment);
        fragments.add(new MineFragment());

        myFragmentAdapter = new MyFragmentAdapter(
                getSupportFragmentManager(), fragments);

        viewPager.setAdapter(myFragmentAdapter);
    }


    /** 选项卡切换了*/
    private void onTabSelected(int position) {
        mCurrentTab.setTabSelected(false);  // 取消高亮

        mCurrentTab = mTabs[position];

        mCurrentTab.setTabSelected(true);   // 设置为高亮
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            Toast.makeText(this,"返回成功",Toast.LENGTH_LONG).show();

            //viewPager.setCurrentItem(0);
            //这句使页面fragment全部刷新，不然fragment3和4的登录失效判断不会再执行
            // 为什么调用 FragmentPagerAdapter.notifyDataSetChanged() 并不能更新其 Fragment
            //https://www.cnblogs.com/wanqieddy/p/4863760.html
            //initViewPager();
            viewPager.setCurrentItem(1);

        }


        if(resultCode==2){
            Toast.makeText(this,"返回结果2000",Toast.LENGTH_LONG).show();
            viewPager.setCurrentItem(2);
            //直接跳转到这个fragment 数据已经加载过了，需要重新获取数据
            shoppingCartFragment.initData();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        shoppingCartFragment=null;
        llTabLayout.removeAllViews();
        myFragmentAdapter=null;
    }
}
