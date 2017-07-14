package com.miku.mvvm.injector.module;

import android.content.Context;

import com.miku.mvvm.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rickey on 2017/7/14/014.
 */

@Module(includes = ApiModule.class)
public class AppModule {

    private final MyApp myApp;

    public AppModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @Singleton @Provides
    public Context provideAppContext() {
        return myApp.getApplicationContext();
    }
}