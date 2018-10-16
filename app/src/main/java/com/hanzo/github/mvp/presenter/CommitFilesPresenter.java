

package com.hanzo.github.mvp.presenter;

import com.hanzo.github.dao.DaoSession;
import com.hanzo.github.mvp.contract.ICommitFilesContract;
import com.hanzo.github.mvp.model.CommitFile;
import com.hanzo.github.mvp.model.CommitFilesPathModel;
import com.hanzo.github.mvp.presenter.base.BasePresenter;
import com.hanzo.github.ui.adapter.base.DoubleTypesModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ThirtyDegreesRay on 2017/10/18 15:22:34
 */

public class CommitFilesPresenter extends BasePresenter<ICommitFilesContract.View>
        implements ICommitFilesContract.Presenter {

    @Inject
    public CommitFilesPresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public ArrayList<DoubleTypesModel<CommitFilesPathModel, CommitFile>> getSortedList(
            ArrayList<CommitFile> commitFiles) {
        ArrayList<DoubleTypesModel<CommitFilesPathModel, CommitFile>>  list = new ArrayList<>();
        String preBasePath = "";
        for(CommitFile commitFile : commitFiles){
            if(!preBasePath.equals(commitFile.getBasePath())){
                list.add(new DoubleTypesModel<CommitFilesPathModel, CommitFile>(
                        new CommitFilesPathModel().setPath(commitFile.getBasePath()), null));
                preBasePath = commitFile.getBasePath();
            }
            list.add(new DoubleTypesModel<CommitFilesPathModel, CommitFile>(null, commitFile));
        }
        return list;
    }
}
