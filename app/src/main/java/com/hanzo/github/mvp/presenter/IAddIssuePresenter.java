package com.hanzo.github.mvp.presenter;


import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.mvp.contract.IAddIssueContract;
import com.hanzo.github.mvp.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by ThirtyDegreesRay on 2017/9/26 16:56:35
 */

public class IAddIssuePresenter extends BasePresenter<IAddIssueContract.View>
        implements IAddIssueContract.Presenter{

    @Inject
    public IAddIssuePresenter(DaoSession daoSession) {
        super(daoSession);
    }

}
