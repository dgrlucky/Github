package com.hanzo.github.mvp.contract;

import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.mvp.contract.base.IBaseListContract;
import com.hanzo.github.mvp.model.TrendingLanguage;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/11/28 17:20:30
 */

public interface ILanguagesEditorContract {

    interface View extends IBaseContract.View, IBaseListContract.View {
        void showLanguages(ArrayList<TrendingLanguage> languages);
        void notifyItemInserted(int position);
    }

    interface Presenter extends IBaseContract.Presenter<ILanguagesEditorContract.View>{
        void loadLanguages();
        void searchLanguages(String key);
        void saveSelectedLanguages();
        TrendingLanguage removeLanguage(int position);
        void undoRemoveLanguage();
        int getListSelectedLanguageCount();
    }

}
