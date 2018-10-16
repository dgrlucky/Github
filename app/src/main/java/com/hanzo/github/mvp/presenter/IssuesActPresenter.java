package com.hanzo.github.mvp.presenter;


import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.mvp.contract.IIssuesActContract;
import com.hanzo.github.mvp.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 17:22:16
 */

public class IssuesActPresenter extends BasePresenter<IIssuesActContract.View>
        implements IIssuesActContract.Presenter{

    @Inject
    public IssuesActPresenter(DaoSession daoSession) {
        super(daoSession);
    }

}
