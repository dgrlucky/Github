

package com.hanzo.github.mvp.contract;

import android.support.annotation.NonNull;

import com.hanzo.github.dao.AuthUser;
import com.hanzo.github.mvp.contract.base.IBaseContract;

import java.util.List;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

public interface IMainContract {

    interface View extends IBaseContract.View {
        void restartApp();
    }

    interface Presenter extends IBaseContract.Presenter<IMainContract.View>{
        boolean isFirstUseAndNoNewsUser();
        List<AuthUser> getLoggedUserList();
        void toggleAccount(@NonNull String loginId);
        void logout();
    }

}
