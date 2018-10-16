package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;

/**
 * Created by ThirtyDegreesRay on 2017/9/26 16:52:33
 */

public interface IAddIssueContract {

    interface View extends IBaseContract.View {

    }

    interface Presenter extends IBaseContract.Presenter<IAddIssueContract.View>{

    }

}
