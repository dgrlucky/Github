package com.hanzo.github.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hanzo.github.R;
import com.hanzo.github.inject.component.AppComponent;
import com.hanzo.github.inject.component.DaggerFragmentComponent;
import com.hanzo.github.inject.module.FragmentModule;
import com.hanzo.github.mvp.contract.IWikiContract;
import com.hanzo.github.mvp.model.WikiModel;
import com.hanzo.github.mvp.presenter.WikiPresenter;
import com.hanzo.github.ui.activity.ViewerActivity;
import com.hanzo.github.ui.adapter.WikiAdapter;
import com.hanzo.github.ui.fragment.base.ListFragment;
import com.hanzo.github.util.BundleHelper;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/12/6 16:43:16
 */

public class WikiFragment extends ListFragment<WikiPresenter, WikiAdapter>
        implements IWikiContract.View {

    public static WikiFragment create(@NonNull String owner, @NonNull String repo){
        WikiFragment fragment = new WikiFragment();
        fragment.setArguments(BundleHelper.builder().put("owner", owner).put("repo", repo).build());
        return fragment;
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
        setCanLoadMore(false);
    }

    @Override
    protected void onReLoadData() {
        mPresenter.loadWiki(true);
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_recent_wiki_updates);
    }

    @Override
    public void showWiki(ArrayList<WikiModel> wikiList) {
        adapter.setData(wikiList);
        postNotifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        WikiModel wikiModel = adapter.getData().get(position);
        ViewerActivity.showMdSource(getActivity(), wikiModel.getName(), wikiModel.getContentWithTitle());
    }

}
