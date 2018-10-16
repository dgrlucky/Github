package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.contract.base.IBaseListContract;
import com.hanzo.github.mvp.model.IssueEvent;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/9/27 11:49:17
 */

public interface IIssueTimelineContract {

    interface View extends IBaseContract.View, IBaseListContract.View {
        void showTimeline(ArrayList<IssueEvent> events);
        void showEditCommentPage(String commentId, String body);
    }

    interface Presenter extends IBaseContract.Presenter<IIssueTimelineContract.View> {
        void loadTimeline(int page, boolean isReload);
        boolean isEditAndDeleteEnable(int position);
        void deleteComment(String commentId);
        void editComment(String commentId, String body);
    }

}
