

package com.hanzo.github.mvp.presenter;

import com.hanzo.github.AppData;
import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.mvp.contract.ISettingsContract;
import com.hanzo.github.mvp.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created on 2017/8/1.
 *
 * @author ThirtyDegreesRay
 */

public class SettingsPresenter extends BasePresenter<ISettingsContract.View>
        implements ISettingsContract.Presenter{

    @Inject
    public SettingsPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void logout() {
        daoSession.getAuthUserDao().delete(AppData.INSTANCE.getAuthUser());
        AppData.INSTANCE.setAuthUser(null);
        AppData.INSTANCE.setLoggedUser(null);
        mView.showLoginPage();
    }

}
