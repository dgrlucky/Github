

package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;

/**
 * Created on 2017/7/12.
 *
 * @author ThirtyDegreesRay
 */

public interface ISplashContract{

    interface View extends IBaseContract.View {
        void showMainPage();
    }

    interface Presenter extends IBaseContract.Presenter<ISplashContract.View>{

        void getUser();

        void saveAccessToken(String accessToken, String scope, int expireIn);

    }

}
