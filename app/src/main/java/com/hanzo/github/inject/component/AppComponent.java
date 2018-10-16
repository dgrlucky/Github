

package com.hanzo.github.inject.component;

import com.hanzo.github.AppApplication;
import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * Created by ThirtyDegreesRay on 2016/8/30 14:08
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    /**
     * 获取AppApplication
     * @return
     */
    AppApplication getApplication();

    /**
     * 获取数据库Dao
     * @return
     */
    DaoSession getDaoSession();

}
