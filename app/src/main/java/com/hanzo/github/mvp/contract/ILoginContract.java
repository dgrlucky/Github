

package com.hanzo.github.mvp.contract;

import android.content.Intent;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.BasicToken;

/**
 * Created on 2017/7/12.
 *
 * @author ThirtyDegreesRay
 */

public interface ILoginContract {

    interface View extends IBaseContract.View {

        void onGetTokenSuccess(BasicToken basicToken);

        void onGetTokenError(String errorMsg);

        void onLoginComplete();

    }

    interface Presenter extends IBaseContract.Presenter<ILoginContract.View>{

        void getToken(String code, String state);

        String getOAuth2Url();

        void basicLogin(String userName, String password);

        void handleOauth(Intent intent);

        void getUserInfo(BasicToken basicToken);

    }

}