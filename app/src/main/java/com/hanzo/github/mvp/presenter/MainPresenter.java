

package com.hanzo.github.mvp.presenter;

import android.support.annotation.NonNull;

import com.hanzo.github.AppData;
import com.hanzo.github.dao.AuthUser;
import com.hanzo.github.dao.AuthUserDao;
import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.mvp.contract.IMainContract;
import com.hanzo.github.mvp.model.User;
import com.hanzo.github.mvp.presenter.base.BasePresenter;
import com.hanzo.github.util.PrefUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

public class MainPresenter extends BasePresenter<IMainContract.View>
        implements IMainContract.Presenter{

    @Inject
    public MainPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public boolean isFirstUseAndNoNewsUser() {
        User user = AppData.INSTANCE.getLoggedUser();
        if(user.getFollowing() == 0
                && user.getPublicRepos() == 0 && user.getPublicGists() == 0
                && PrefUtils.isFirstUse()){
            PrefUtils.set(PrefUtils.FIRST_USE, false);
            return true;
        }
        return false;
    }

    @Override
    public List<AuthUser> getLoggedUserList() {
        List<AuthUser> users = daoSession.getAuthUserDao().loadAll();
        if(users != null){
            for(AuthUser user : users){
                if(AppData.INSTANCE.getLoggedUser().getLogin().equals(user.getLoginId())){
                    users.remove(user);
                    break;
                }
            }
        }
        return users;
    }

    @Override
    public void toggleAccount(@NonNull String loginId) {
        String removeSelectSql = "UPDATE " + daoSession.getAuthUserDao().getTablename()
                + " SET " + AuthUserDao.Properties.Selected.columnName + " = 0 "
                + " WHERE " + AuthUserDao.Properties.LoginId.columnName
                + " ='" + AppData.INSTANCE.getLoggedUser().getLogin() + "'";
        String selectSql = "UPDATE " + daoSession.getAuthUserDao().getTablename()
                + " SET " + AuthUserDao.Properties.Selected.columnName + " = 1"
                + " WHERE " + AuthUserDao.Properties.LoginId.columnName
                + " ='" + loginId + "'";
        daoSession.getAuthUserDao().getDatabase().execSQL(removeSelectSql);
        daoSession.getAuthUserDao().getDatabase().execSQL(selectSql);
        AppData.INSTANCE.setAuthUser(null);
        AppData.INSTANCE.setLoggedUser(null);
        mView.restartApp();
    }

    @Override
    public void logout() {
        daoSession.getAuthUserDao().delete(AppData.INSTANCE.getAuthUser());
        AppData.INSTANCE.setAuthUser(null);
        AppData.INSTANCE.setLoggedUser(null);
        mView.restartApp();
    }

}
