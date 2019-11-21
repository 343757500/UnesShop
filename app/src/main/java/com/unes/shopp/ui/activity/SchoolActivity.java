package com.unes.shopp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.common.base.Global;

public class SchoolActivity extends BaseActivity{

    @Override
    public int getLayoutRes() {

        return R.layout.activity_school_detail;
    }

    @Override
    public void initView() {
        //谷歌状态栏文字底色的黑白   true就是黑色底，false为白色底
        Global.setAndroidNativeLightStatusBar(this,true);
        String   id = getIntent().getStringExtra("id");
        WebView wb = findView(R.id.wb);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //加了这句才能正常显示
        wb.getSettings().setDomStorageEnabled(true);
        wb.loadUrl("https://shop.unesmall.com/pages_su/school/imagePage?id="+id);
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
