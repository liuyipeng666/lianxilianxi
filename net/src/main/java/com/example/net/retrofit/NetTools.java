package com.example.net.retrofit;

import android.util.Log;

import com.example.net.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
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
                .baseUrl(BuildConfig.SERVICE_URL)
                .build();
    }

    //创建OKhttp实例
    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
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

                    Request token = request.newBuilder().addHeader("token",ConsValue.TOKEN).build();
                    Response proceed = chain.proceed(token);
                    return proceed;
            }
        };
        return interceptor;
    }

    /**
     * 创建日志拦截器
     *
     * @return
     */
    private Interceptor createNetworkInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Log.i("www", "createNetworkInterceptor: +dadad");
        return interceptor;
    }

    //创建接口实例

    public <T> T create(Class<?> clazz) {
        return (T) mRetrofit.create(clazz);
    }
}
