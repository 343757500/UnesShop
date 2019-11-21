package com.unes.shopp.model.protocol;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author WJQ
 */
public class RetrofitManager {

    private static RetrofitManager instance;

    private RetrofitManager(){
    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized(RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                    initRetrofit();
                }
            }
        }
        return instance;
    }

    private static Retrofit mRetrofit;
    private static IHttpService mHttpService;

    public IHttpService getHttpService() {
        return mHttpService;
    }

    private static void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(IHttpService.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mHttpService = mRetrofit.create(IHttpService.class);
    }

}
