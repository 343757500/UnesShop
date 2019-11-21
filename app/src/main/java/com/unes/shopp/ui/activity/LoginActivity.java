package com.unes.shopp.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unes.shopp.R;
import com.unes.shopp.common.base.BaseActivity;
import com.unes.shopp.common.util.SharedPreUtil;
import com.unes.shopp.model.bean.LoginInfo;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity {

    private LoginPresenter loginPresenter;
    private EditText edt_username;
    private EditText edt_password;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }


    @Override
    public void initView() {
        edt_username = findView(R.id.username);
        edt_password = findView(R.id.password);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View v, int id) {
        if (id==R.id.bt_login){
            Toast.makeText(this,"登录",Toast.LENGTH_LONG).show();
            loginPresenter.getLoginInfo(edt_username.getText().toString(),edt_password.getText().toString());
        }

    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);

        if (reqType== IHttpService.TYPE_LOGININFO){
            LoginInfo loginInfo= (LoginInfo) obj.obj;
            SharedPreUtil.saveInt(this,"Uid",loginInfo.getResult().getUid());
            this.setResult(2);
            this.finish();
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
