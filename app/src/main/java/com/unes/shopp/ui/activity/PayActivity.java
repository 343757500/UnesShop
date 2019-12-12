package com.unes.shopp.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alipay.sdk.app.PayTask;
import com.unes.shopp.R;
import com.unes.shopp.alpay.AuthResult;
import com.unes.shopp.alpay.OrderInfoUtil2_0;
import com.unes.shopp.alpay.PayResult;
import com.unes.shopp.common.base.BaseActivity;

import java.util.Map;

public class PayActivity extends BaseActivity{

    private Button bt_alipay;

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        showAlert(PayActivity.this,"支付成功" + payResult);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        showAlert(PayActivity.this, "支付失败" + payResult);
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        showAlert(PayActivity.this, "授权成功" + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(PayActivity.this, "授权失败" + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };





    @Override
    public int getLayoutRes() {
        return R.layout.activity_pay;
    }

    @Override
    public void initView() {
        bt_alipay = findView(R.id.bt_alipay);
    }

    @Override
    public void initListener() {
        bt_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap("", "2019062565657117", "", true);
                String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);

                String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChdwoelAq1s6vr11ihqD5wHb0Prl2e3znSHE07AC+v0bqv//ZsKPfK89hs5hVv7sldQhmNzIsFUh1KOsOGWCz75RWEOf/RPP0Rkw1MxOYdrGpjcFBEbtqcOlU+IGE57ieLQyUv24NPb9ujB18UiVsa1XKSatF6ku93wz2EgPTvXNRoe2KVIo71YQbJQxyV8e2gLJPw7Gv/qcUyOXH/057Pr2lQybQJNxH5N9I040wD5imf6C4ECwvl8gUNIQRBk5Zsvxwo8ZvqD5hjAIDBOOK6V2Vgi+RCi5J/zBMb2l2tbl1WTaIYi2YcwuYd+km3iPa0b/VLvumRFwetlSny+s3BAgMBAAECggEAbvdQjRNRCO8iCENHNlJaFtNZS52Z2cWwByZMLXBDVaHdm3dd85d0NJbA9pZpxTNmUCFNTpZ0NIPqfUlFdt7Ci5s03lq95R71DU7ypP/s5hfIRe66O020EApG6xt1tkpmAt9yfyFtbPqDB9fZEFQVuKtYwieHL6YrzTLw5E98BcO9qS6/Fg35SYTum17oG0izq/WG7kJBBM00vGgDYZ/68n+B6CLabXi2Kl3cMZMcgqaI3QvlEam7bC7PFr0bbYaZ1YB8vrFqFUNT+p33mrFcGWiJwHVHxJYGQHrMbliqbgkknsrqzvZDMO0yIRg+ygfucZSTQjzaB7bGw/YTrVu3wQKBgQDgTw3EFrRKK8aKSOCBdU/7WnfinYW7moqA4+9zxTazJsxVdlwUFJykreczerOkO0AUleEiAKrqEzlH6iHhfTskddG3DccpMeOsIC3nno7DDTYapeCUD+N70XMtM786pOjpje8Nyw0fA4jtiksGAP4jT+vok0ZY1fC/BV/ByOmZzwKBgQC4RwKgAzjMhTnE+uW5QxhEXal9jwGoQtjqOB4pGTfndlrpy3ydltMnV8BCPjyrwKDsjMYxlfrXCSMqx83VUL9ZV3LLDlqBmInnXKORoQWpwUrs05e20Isbjg6d1EB2wJD8mrgxZK1fhVqCugC/pznW+epUzGLxSOwuUGCPhb1TbwKBgQDA630df6GEgW37FX7yGSG3PzIJGA4jMmGZRXF3EtFe+CmZ/3hmVOv8vw0wu4Gx6LvOeLHu+sAFHo+PiJGnTHwHecXrONBoX94+9lZE9Zw3qi80cCJddeTjY1s6L11zZM5lwYsvQ8p/OB0WoHCyMzxgxqZRnAlO8oJi6I5ZLyGrBQKBgDZYuu12BcpLgD4XwKhioUWIWfQtuM9m55Ir+rkkNtiMj0NkP9w6Hwv7VTg0IrCEnvEkk08MbG3+w+BaDNpcdhJjN/eqxAZ0djdFmvfYBVOLLg2qWZQQ7PWzb5wcfOaI5DmbZ7cpefgx2/+x24aqSuSb0AAyRvviBcWi7tdlGfEBAoGBAJ08Ki5RDa0+h7qnHbo+OBz1SelYRVF5m805liFG2Ns4QNZ2d5+NRwCM+xgCVNV1cbJoUHZxQm5+AoH4vL5DX+3V6AUwFBalzdN0K+LCJq7hzCDNbSTuAOmPYnnq3Rog+xXi/Yx66jJcZvcxbyHdgSU4VRRYLViE6e69ByeLP3FB";
                String sign = OrderInfoUtil2_0.getSign(authInfoMap, privateKey, true);
                final String authInfo = info + "&" + sign;


                final Runnable payRunnable = new Runnable() {

                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PayActivity.this);
                        Map<String, String> result = alipay.payV2(authInfo, true);
                        Log.i("msp", result.toString());

                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };

                // 必须异步调用
                Thread payThread = new Thread(payRunnable);
                payThread.start();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }



    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton("确定", null)
                .setOnDismissListener(onDismiss)
                .show();
    }
}
