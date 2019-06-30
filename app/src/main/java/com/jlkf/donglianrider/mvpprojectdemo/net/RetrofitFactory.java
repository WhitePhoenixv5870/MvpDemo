package com.jlkf.donglianrider.mvpprojectdemo.net;

import com.google.gson.GsonBuilder;
import com.jlkf.donglianrider.mvpprojectdemo.net.interceptor.Logger;
import com.jlkf.donglianrider.mvpprojectdemo.net.interceptor.LoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络访问
 */
public class RetrofitFactory {
    //访问超时
    private static final long TIMEOUT = 60;

    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 打印接口信息，方便接口调试
            //添加数据拦截器
            .addInterceptor(new LoggingInterceptor(new Logger()).setLevel(LoggingInterceptor.Level.BODY)).
                    connectTimeout(TIMEOUT, TimeUnit.SECONDS).
                    readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Response proceed = chain.proceed(original);
                    Request request;
                        request = original.newBuilder()
                                .header("ltype", "1")
                                .method(original.method(), original.body())
                                .build();

                    return chain.proceed(request);
                }
            })
            .build();


    private static ServiceSApi retrofitService = new Retrofit.Builder().baseUrl(Http.ROOT)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()

            .create(ServiceSApi.class);

    //     获得RetrofitService对象
    public static ServiceSApi getInstance() {
        return retrofitService;
    }

}
