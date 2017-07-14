package com.miku.mvvm.injector.component;

import com.miku.mvvm.MyApp;
import com.miku.mvvm.injector.module.AppModule;
import com.miku.mvvm.ui.home.MainComponent;
import com.miku.mvvm.ui.home.MainModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/7/14/014.
 */

@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MyApp app);

    MainComponent plus(MainModule module);
}
