package com.hanzo.github.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hanzo.github.R;
import com.hanzo.github.inject.component.AppComponent;
import com.hanzo.github.inject.component.DaggerFragmentComponent;
import com.hanzo.github.inject.module.FragmentModule;
import com.hanzo.github.mvp.contract.ITopicsContract;
import com.hanzo.github.mvp.model.Topic;
import com.hanzo.github.mvp.presenter.TopicsPresenter;
import com.hanzo.github.ui.activity.RepoListActivity;
import com.hanzo.github.ui.adapter.TopicsAdapter;
import com.hanzo.github.ui.fragment.base.ListFragment;
import com.hanzo.github.util.PrefUtils;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/12/29 11:12:41
 */

public class TopicsFragment extends ListFragment<TopicsPresenter, TopicsAdapter>
        implements ITopicsContract.View {

    public static Fragment create(){
        return new TopicsFragment();
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);
        setLoadMoreEnable(false);
    }

    @Override
    public void showTopics(ArrayList<Topic> topics) {
        adapter.setData(topics);
        postNotifyDataSetChanged();
        if(topics != null && topics.size() > 0 && PrefUtils.isTopicsTipEnable()){
            showOperationTip(R.string.topics_tip);
            PrefUtils.set(PrefUtils.TOPICS_TIP_ABLE, false);
        }
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
        mPresenter.loadTopics(true);
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_topics);
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        RepoListActivity.showTopic(getActivity(), adapter.getData().get(position));
    }
}
