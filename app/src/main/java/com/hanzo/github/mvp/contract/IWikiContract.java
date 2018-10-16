package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.contract.base.IBaseListContract;
import com.hanzo.github.mvp.model.WikiModel;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/12/6 16:34:22
 */

public interface IWikiContract {

    interface View extends IBaseContract.View, IBaseListContract.View {
        void showWiki(ArrayList<WikiModel> wikiList);
    }

    interface Presenter extends IBaseContract.Presenter<IWikiContract.View>{
        void loadWiki(boolean isReload);
    }

}
