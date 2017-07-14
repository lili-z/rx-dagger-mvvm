package com.miku.mvvm.ui.home;

import com.miku.mvvm.R;
import com.miku.mvvm.base.BaseActivity;
import com.miku.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    @Override protected void initInjector() {
        getAppComponent().plus(new MainModule()).inject(this);
    }

    @Override protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override protected void initUI() {

    }
}
