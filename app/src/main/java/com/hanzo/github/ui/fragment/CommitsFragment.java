

package com.hanzo.github.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hanzo.github.R;
import com.hanzo.github.inject.component.AppComponent;
import com.hanzo.github.inject.component.DaggerFragmentComponent;
import com.hanzo.github.inject.module.FragmentModule;
import com.hanzo.github.mvp.contract.ICommitsContract;
import com.hanzo.github.mvp.model.Branch;
import com.hanzo.github.mvp.model.RepoCommit;
import com.hanzo.github.mvp.model.Repository;
import com.hanzo.github.mvp.presenter.CommitsPresenter;
import com.hanzo.github.ui.activity.CommitDetailActivity;
import com.hanzo.github.ui.activity.CommitsListActivity;
import com.hanzo.github.ui.activity.RepositoryActivity;
import com.hanzo.github.ui.adapter.CommitAdapter;
import com.hanzo.github.ui.fragment.base.ListFragment;
import com.hanzo.github.util.BundleHelper;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/10/17 14:51:32
 */

public class CommitsFragment extends ListFragment<CommitsPresenter, CommitAdapter>
        implements ICommitsContract.View, RepositoryActivity.RepositoryListener{

    public static CommitsFragment createForRepo(@NonNull String user, @NonNull String repo,
                                                @Nullable String branch){
        CommitsFragment fragment = new CommitsFragment();
        fragment.setArguments(BundleHelper.builder().put("type", CommitsListActivity.CommitsListType.Repo)
                .put("user", user).put("repo", repo).put("branch", branch).build());
        return fragment;
    }

    public static CommitsFragment createForCompare(@NonNull String user, @NonNull String repo,
                                                   @NonNull String before, @NonNull String head){
        CommitsFragment fragment = new CommitsFragment();
        fragment.setArguments(BundleHelper.builder().put("type", CommitsListActivity.CommitsListType.Compare)
                .put("user", user).put("repo", repo).put("before", before).put("head", head).build());
        return fragment;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);
        setLoadMoreEnable(CommitsListActivity.CommitsListType.Repo.equals(mPresenter.getType()));
    }

    @Override
    public void showCommits(ArrayList<RepoCommit> commits) {
        adapter.setData(commits);
        postNotifyDataSetChanged();
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
    protected void onReLoadData() {
        mPresenter.loadCommits(true, 1);
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_commits);
    }

    @Override
    protected void onLoadMore(int page) {
        super.onLoadMore(page);
        mPresenter.loadCommits(false, page);
    }

    @Override
    public void onFragmentShowed() {
        super.onFragmentShowed();
        if(mPresenter != null) mPresenter.prepareLoadData();
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        View userAvatar = view.findViewById(R.id.user_avatar);
        CommitDetailActivity.show(getActivity(), mPresenter.getUser(), mPresenter.getRepo(),
                adapter.getData().get(position), userAvatar);
    }

    @Override
    public void onRepositoryInfoUpdated(Repository repository) {

    }

    @Override
    public void onBranchChanged(Branch branch) {
        if(mPresenter == null){
            getArguments().putString("branch", branch.getName());
        } else {
            mPresenter.setLoaded(false);
            mPresenter.setBranch(branch.getName());
            mPresenter.prepareLoadData();
        }
    }
}
