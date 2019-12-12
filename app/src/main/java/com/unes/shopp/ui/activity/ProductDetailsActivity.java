package com.unes.shopp.ui.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.common.base.Const;
import com.unes.shopp.common.util.DateUtil;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.common.util.Utils;
import com.unes.shopp.model.bean.FetchItemsByIdInfo;
import com.unes.shopp.model.bean.FetchItemsInfo;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.ProductDetailPresenter;
import com.unes.shopp.ui.TextSliderView;
import com.unes.shopp.ui.adapter.FetchItemsAdapter;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class ProductDetailsActivity extends BaseActivity {

    private RecyclerView rv;
    private String pids;
    private SliderLayout slider_layout;
    private PagerIndicator indicator;
    private FetchItemsAdapter fetchItemsAdapter;
    private TextView tv_price;
    private TextView tv_allprice;
    private TextView tv_discount;
    private TextView tv_netprofit;
    private TextView tv_name;
    private TextView tv_sold;
    private TextView tv_type;
    private LinearLayout ll;
    private TextView tv_count;
    private RelativeLayout rl;
    private TextView tv_sendCount;
    private TextView tv_content;
    private TextView tv_time;
    private TextView tv_fetchName;
    private List<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> fodderItemDOs;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_productdetails;
    }

    @Override
    public void initView() {
        pids = getIntent().getStringExtra(Const.PIDS);
        rv = findView(R.id.rv);
        ll = findView(R.id.ll);
        rl = findView(R.id.rl);
        slider_layout = findView(R.id.slider_layout);
        indicator = findView(R.id.custom_indicator);

        GridLayoutManager layoutManager=new GridLayoutManager (getApplicationContext(),3);
        rv.setLayoutManager(layoutManager);

        fetchItemsAdapter = new FetchItemsAdapter(this,null);
        rv.setAdapter(fetchItemsAdapter);


        tv_price = findView(R.id.tv_price);
        tv_allprice     = findView(R.id.tv_allprice);
        tv_discount  = findView(R.id.tv_discount);
        tv_netprofit = findView(R.id.tv_netprofit);
        tv_name      = findView(R.id.tv_name);
        tv_sold      = findView(R.id.tv_sold);
        tv_type = findView(R.id.tv_type);
        tv_count = findView(R.id.tv_count);
        tv_sendCount = findView(R.id.tv_sendCount);
        tv_content = findView(R.id.tv_content);
        tv_time = findView(R.id.tv_time);
        tv_fetchName = findView(R.id.tv_fetchName);

    }

    @Override
    public void initListener() {
        tv_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FindActivity.class);
                getApplicationContext().startActivity(intent);
                if (fodderItemDOs!=null) {
                    EventBus.getDefault().postSticky(fodderItemDOs);
                }else{
                    //数据为null时传个没数据的对象  不能传null
                    EventBus.getDefault().postSticky(new ArrayList<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean>());
                }
            }
        });
    }

    @Override
    public void initData() {
        int uid = SharedPreUtil.getInt(getApplicationContext(), Const.TICKET, 0);
        if (uid!=0){
            rl.setVisibility(View.VISIBLE);
            tv_netprofit.setVisibility(View.VISIBLE);
        }else{
            rl.setVisibility(View.GONE);
            tv_netprofit.setVisibility(View.INVISIBLE);
        }
        ProductDetailPresenter productDetailPresenter = new ProductDetailPresenter(this);
        productDetailPresenter.getFetchItemsInfo(uid+"",pids);
        productDetailPresenter.getFodderItemByItemId(uid+"",pids);
    }

    @Override
    public void onClick(View v, int id) {

    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_FENCHITEMS) {
            FetchItemsInfo fetchItemsInfo = (FetchItemsInfo) obj.obj;

            FetchItemsInfo.ResultBean.ItemsBean itemsBean = fetchItemsInfo.getResult().getItems().get(0);
            String pics = fetchItemsInfo.getResult().getItems().get(0).getPics();
            String detail = fetchItemsInfo.getResult().getItems().get(0).getDetail();
            String[] split = pics.split("\\;");
            String[] details = detail.split("\\;");

            //轮播图
            initLooperImage(split);
            List<String> list = Arrays.asList(details);
           // fetchItemsAdapter.setDatas(list);

            // 为子View设置布局参数
            for (int i = 0; i < list.size(); i++) {
                ImageView iv=new ImageView(this);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(this).load(list.get(i).toString()).into(iv);
                ll.addView(iv,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }

            tv_price.setText("￥"+itemsBean.getPrice()/100);
            tv_allprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
            tv_allprice .setText("￥"+itemsBean.getRefPrice()/100);
            String discount = dateProcessing(itemsBean.getPrice(), itemsBean.getRefPrice());
            tv_discount .setText(Double.parseDouble(discount)*10+"折");
            tv_netprofit.setText("赚￥"+itemsBean.getMaxShare());
            tv_name     .setText(itemsBean.getTitle());
            tv_sold     .setText("已售"+itemsBean.getBaseSoldQuantity()+"件");
            tv_type.setText(itemsBean.getDesc());

        }else if (reqType==IHttpService.TYPE_FENCHITEMSITEM){
            FetchItemsByIdInfo fetchItemsByIdInfo= (FetchItemsByIdInfo) obj.obj;
            fodderItemDOs = fetchItemsByIdInfo.getResult().getFodderItemDOs();
            if (fodderItemDOs !=null) {
                tv_count.setText("查看全部" + fodderItemDOs.size() + "条");
                tv_sendCount.setText("已发圈"+ fodderItemDOs.get(0).getCountShare()+"数");
                tv_content.setText(fodderItemDOs.get(0).getComment());
                tv_time.setText( DateUtil.getDateToString(fodderItemDOs.get(0).getDateCreated(),"yyyy年-MM月dd日 HH时mm分ss秒"));
                tv_fetchName.setText(fodderItemDOs.get(0).getNickname());
                String fodderUrl =fodderItemDOs.get(0).getFodderUrl();
                String[] splitVal = fodderUrl.split("\\;");//转数组
                List<String> asList = Arrays.asList(splitVal);//转集合
                fetchItemsAdapter.setDatas(asList);

            }else{
                tv_count.setText("查看全部" + 0 + "条");
                fodderItemDOs=null;
            }


        }

    }

    private void initLooperImage(String[] split) {
        slider_layout.removeAllSliders();
        for (int i = 0; i < split.length; i++) {
            TextSliderView textSliderView1 = new TextSliderView(this);
            textSliderView1
                   // .description()
                    .image(split[i]);

            final int finalI = i;
            textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getApplication(),"轮播图的第一"+ finalI +"个图的点击效果",Toast.LENGTH_LONG).show();
                }
            });

            slider_layout.addSlider(textSliderView1);
        }
        // slider_layout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);// 设置默认指示器位置(默认指示器白色)
        slider_layout.setCustomIndicator(indicator); // 设置自定义指示器(位置自定义)
        // slider_layout.setCustomAnimation(new DescriptionAnimation());   // 设置TextView自定义动画
        slider_layout.setPresetTransformer(SliderLayout.Transformer.Tablet);//设置默认过渡效果(可在xml中设置)的动画
        slider_layout.setDuration(3000);//设置时间 这个时间 就是延迟时间 第一个图跟第2个图3秒间隔
        if (split.length<=1){
            //如果数据为一个则停止轮播
            slider_layout.stopAutoCycle();
        }
    }


    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }



    /**
     * 数据计算结果处理(四舍五入，保留一位小数)
     * @param member    分子
     * @param denominator   分母
     * @return
     */
    public static String dateProcessing(int member,int denominator){
        float num =(float)member/denominator;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }
}
