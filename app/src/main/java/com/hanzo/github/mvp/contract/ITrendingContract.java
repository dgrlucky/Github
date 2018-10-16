

package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.TrendingLanguage;

import java.util.ArrayList;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

public interface ITrendingContract {

    interface View extends IBaseContract.View {

    }

    interface Presenter extends IBaseContract.Presenter<ITrendingContract.View>{
        ArrayList<TrendingLanguage> getLanguagesFromLocal();
    }

}
