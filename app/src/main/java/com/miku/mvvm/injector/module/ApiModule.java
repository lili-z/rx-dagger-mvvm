package com.miku.mvvm.injector.module;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rickey on 2017/7/14/014.
 * <p>
 * Provide Objects for Network.
 */

@Module
public class ApiModule {

    private static final String BASE_URL = "https://api.github.com/";

    @Singleton @Provides public Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Singleton @Provides public OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Log.e("header>>>", request.headers().toString());
                    Request.Builder builder1 = request.newBuilder();
                    Request build = builder1
                            .build();
                    Response response = chain.proceed(build);
                    okhttp3.MediaType mediaType = response.body().contentType();
                    String result = response.body().string();
                    Log.e("result>>>", result);
                    return response.newBuilder()
                            .body(okhttp3.ResponseBody.create(mediaType, result))
                            .build();
                })
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        return client;
    }
}
