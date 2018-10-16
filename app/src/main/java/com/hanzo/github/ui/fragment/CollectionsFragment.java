package com.hanzo.github.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hanzo.github.R;
import com.hanzo.github.inject.component.AppComponent;
import com.hanzo.github.inject.component.DaggerFragmentComponent;
import com.hanzo.github.inject.module.FragmentModule;
import com.hanzo.github.mvp.contract.ICollectionsContract;
import com.hanzo.github.mvp.model.Collection;
import com.hanzo.github.mvp.presenter.CollectionsPresenter;
import com.hanzo.github.ui.activity.RepoListActivity;
import com.hanzo.github.ui.adapter.CollectionAdapter;
import com.hanzo.github.ui.fragment.base.ListFragment;
import com.hanzo.github.util.PrefUtils;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/12/25 15:17:38
 */

public class CollectionsFragment extends ListFragment<CollectionsPresenter, CollectionAdapter>
        implements ICollectionsContract.View {

    public static Fragment create(){
        return new CollectionsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);
        setLoadMoreEnable(false);
    }

    @Override
    protected void onReLoadData() {
        mPresenter.loadCollections(true);
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_repo_collections);
    }

    @Override
    public void showCollections(ArrayList<Collection> collections) {
        adapter.setData(collections);
        postNotifyDataSetChanged();
        if(collections != null && collections.size() > 0 && PrefUtils.isCollectionsTipAble()){
            showOperationTip(R.string.collections_tip);
            PrefUtils.set(PrefUtils.COLLECTIONS_TIP_ABLE, false);
        }
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        RepoListActivity.showCollection(getActivity(), adapter.getData().get(position));
    }
}
