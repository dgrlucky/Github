

package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.model.CommitFile;
import com.hanzo.github.mvp.model.CommitFilesPathModel;
import com.hanzo.github.ui.adapter.base.DoubleTypesModel;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/10/18 15:21:28
 */

public interface ICommitFilesContract {

    interface View extends IBaseContract.View {

    }

    interface Presenter extends IBaseContract.Presenter<ICommitFilesContract.View>{
        ArrayList<DoubleTypesModel<CommitFilesPathModel, CommitFile>> getSortedList(ArrayList<CommitFile> commitFiles);
    }

}
