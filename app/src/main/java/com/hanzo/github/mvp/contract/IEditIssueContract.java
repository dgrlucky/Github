

package com.hanzo.github.mvp.contract;

import android.support.annotation.NonNull;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.Issue;
import com.hanzo.github.mvp.model.Label;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/10/14 16:48:20
 */

public interface IEditIssueContract {

    interface View extends IBaseContract.View {
        void showNewIssue(@NonNull Issue issue);
        void onLoadLabelsComplete(ArrayList<Label> labels);
    }

    interface Presenter extends IBaseContract.Presenter<IEditIssueContract.View>{
        void commitIssue(@NonNull String title, @NonNull String comment);
        void loadLabels();
        void clearAllLabelsData();
    }

}
