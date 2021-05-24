package com.example.net.retrofit;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetTools {
    private Retrofit mRetrofit;

    private NetTools() {
        createRetorfit();
    }

    private volatile static NetTools instance = null;

    public static NetTools getInstance() {
        if (null == instance) {
            synchronized (NetTools.class) {
                if (null == instance) {
                    instance = new NetTools();
                }
            }
        }
        return instance;
    }

    //创建Retrofit实例
    private void createRetorfit() {
        mRetrofit = new Retrofit.Builder()
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .baseUrl("http://121.4.241.78:8080/")
                .build();
    }

    //创建OKhttp实例
    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .addNetworkInterceptor(createNetworkInterceptor())
                .addInterceptor(createTokenInterceptor())
                .build();
    }

    // 创建处理Token的自定义拦截器
//
    private Interceptor createTokenInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request token = request.newBuilder().addHeader("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMjMifQ.xKPoMpjMrGHF2iDgqhXrvyypo8HGEZtqDcnND2tQyPo").build();
                Response proceed = chain.proceed(token);
                return proceed;
            }
        };
        return interceptor;
    }
    //判断 Code 是否为401

    private boolean checkHttpCode401(Response response) {
        if (null == response) {
            return false;
        }
        if (response.code() == 401) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取Token的同步网络请求
     *
     * @return
     */
    private String requestToken() {


        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", ConsValue.AUTHCODE, "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result != null && result.body() != null) {
                return result.body().getAccess_token();
            }
        } catch (IOException e) {
        }
        return "";
    }


    /**
     * 创建日志拦截器
     *
     * @return
     */
    private Interceptor createNetworkInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Log.i("www", "createNetworkInterceptor: +maixilele");
        return interceptor;
    }

    //创建接口实例

    public <T> T create(Class<?> clazz) {
        return (T) mRetrofit.create(clazz);
    }
}
