

package com.hanzo.github.mvp.contract;

import android.support.annotation.NonNull;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.contract.base.IBaseListContract;
import com.hanzo.github.mvp.contract.base.IBasePagerContract;
import com.hanzo.github.mvp.model.ActivityRedirectionModel;
import com.hanzo.github.mvp.model.Event;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/8/23 21:51:44
 */

public interface IActivityContract {

    interface View extends IBaseContract.View, IBasePagerContract.View, IBaseListContract.View {
        void showEvents(ArrayList<Event> events);
    }

    interface Presenter extends IBasePagerContract.Presenter<IActivityContract.View>{
        void loadEvents(boolean isReload, int page);
        ArrayList<ActivityRedirectionModel> getRedirectionList(@NonNull Event event);
    }

}
