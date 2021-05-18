package com.example.net.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
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
                .baseUrl("121.4.241.78:8080")
                .build();
    }

    //创建OKhttp实例
    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
              .addNetworkInterceptor(createNetworkInterceptor())
           //.addInterceptor(createTokenInterceptor())
                .build();
    }

    // 创建处理Token的自定义拦截器
//
//    private Interceptor createTokenInterceptor() {
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Response response = chain.proceed(request);
//                //todo 缓存Token 添加到请求头 待实现...
//                //如果是401 同步请求Token然后加载到新请求的Header里，重新发起业务请求
//                if (checkHttpCode401(response)) {
//                    String token = requestToken();
//                    if (TextUtils.isEmpty(token)) {
//                        throw new RuntimeException("Token is null...");
//                    }
//                    Request.Builder newBuilder = request.newBuilder().addHeader("Authorization", "bearer " + token);
//                    Request newRequest = newBuilder.build();
//                    return chain.proceed(newRequest);
//                }
//                return response;
//            }
//        };
//        return interceptor;
//    }
//    //判断 Code 是否为401
//
//    private boolean checkHttpCode401(Response response) {
//        if (null == response) {
//            return false;
//        }
//        if (response.code() == 401) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * 获取Token的同步网络请求
//     *
//     * @return
//     */
//    private String requestToken() {
//
//
//        TokenApi tokenApi = create(TokenApi.class);
//        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", ConsValue.AUTHCODE, "");
//        try {
//            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
//            if (result != null && result.body() != null) {
//                return result.body().getAccess_token();
//            }
//        } catch (IOException e) {
//        }
//        return "";
//    }


    /**
     * 创建日志拦截器
     *
     * @return
     */
    private Interceptor createNetworkInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Log.i("www", "createNetworkInterceptor: +dadad");
        return interceptor;
    }

    //创建接口实例

    public <T> T create(Class<?> clazz) {
        return (T) mRetrofit.create(clazz);
    }
}
