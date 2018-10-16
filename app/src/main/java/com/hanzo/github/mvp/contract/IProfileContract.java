

package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.User;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

public interface IProfileContract {

    interface View extends IBaseContract.View {
        void showProfileInfo(User user);
        void invalidateOptionsMenu();
    }

    interface Presenter extends IBaseContract.Presenter<IProfileContract.View>{
        void followUser(boolean follow);
        boolean isBookmarked();
        void bookmark(boolean bookmark);
    }

}
