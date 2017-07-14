package com.miku.mvvm.injector.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/7/14/014.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
