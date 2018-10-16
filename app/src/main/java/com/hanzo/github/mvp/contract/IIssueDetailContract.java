package com.hanzo.github.mvp.contract;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.Issue;
import com.hanzo.github.mvp.model.IssueEvent;

/**
 * Created by ThirtyDegreesRay on 2017/9/26 16:18:18
 */

public interface IIssueDetailContract {

    interface View extends IBaseContract.View {
        void showIssue(@NonNull Issue issue);
        void showAddedComment(@NonNull IssueEvent event);
        void showAddCommentPage(@Nullable String text);
    }

    interface Presenter extends IBaseContract.Presenter<IIssueDetailContract.View> {
        void addComment(@NonNull String text);
        void toggleIssueState();
    }

}
