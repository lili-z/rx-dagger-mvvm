package com.miku.mvvm.ui.home;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2017/7/14/014.
 */

@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}