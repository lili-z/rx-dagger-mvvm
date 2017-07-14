package com.miku.mvvm.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.miku.mvvm.MyApp;
import com.miku.mvvm.injector.component.AppComponent;

import javax.inject.Inject;

/**
 * Created by Rickey on 2017/7/14/014.
 * <p>
 * BaseActivity
 */

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private Context mContext;

    protected B mDataBinding;
    @Inject protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initInjector();
        super.onCreate(savedInstanceState);
        mContext = this;
        mDataBinding = DataBindingUtil.setContentView(this, initContentView());
        initUI();
        loadData();
    }

    protected abstract void initInjector();

    @LayoutRes protected abstract int initContentView();

    protected abstract void initUI();

    protected void loadData() {
        ;
    }

    protected AppComponent getAppComponent() {
        return MyApp.getIns().getAppComponent();
    }
}
