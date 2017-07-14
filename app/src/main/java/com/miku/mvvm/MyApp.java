package com.miku.mvvm;

import android.app.Application;

import com.miku.mvvm.injector.component.AppComponent;
import com.miku.mvvm.injector.component.DaggerAppComponent;

/**
 * 全局Application
 */

public class MyApp extends Application {

    private AppComponent appComponent;
    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        initInjector();
    }

    private void initInjector() {
        appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyApp getIns() {
        return myApp;
    }
}
