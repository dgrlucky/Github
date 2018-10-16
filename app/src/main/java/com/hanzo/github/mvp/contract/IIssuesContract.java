package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.contract.base.IBaseListContract;
import com.hanzo.github.mvp.contract.base.IBasePagerContract;
import com.hanzo.github.mvp.model.Issue;
import com.hanzo.github.mvp.model.filter.IssuesFilter;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 14:55:29
 */

public interface IIssuesContract {

    interface View extends IBaseContract.View, IBasePagerContract.View, IBaseListContract.View {
        void showIssues(ArrayList<Issue> issues);
    }

    interface Presenter extends IBasePagerContract.Presenter<IIssuesContract.View>{
        void loadIssues(int page, boolean isReload);
        void loadIssues(IssuesFilter issuesFilter, int page, boolean isReload);
    }

}
