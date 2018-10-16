

package com.hanzo.github.inject.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.hanzo.github.inject.ActivityScope;
import com.hanzo.github.ui.activity.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * ActivityModule
 * Created by ThirtyDegreesRay on 2016/8/30 14:53
 */
@Module
public class ActivityModule {

    private BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public BaseActivity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityScope
    public Context provideContext(){
        return mActivity;
    }

    @Provides
    @ActivityScope
    public FragmentManager provideFragmentManager(){
        return mActivity.getSupportFragmentManager();
    }

}
