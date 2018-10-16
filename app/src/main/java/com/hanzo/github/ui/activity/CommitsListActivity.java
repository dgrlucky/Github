

package com.hanzo.github.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hanzo.github.R;
import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.ui.activity.base.SingleFragmentActivity;
import com.hanzo.github.ui.fragment.CommitsFragment;
import com.hanzo.github.util.BundleHelper;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;

/**
 * Created by ThirtyDegreesRay on 2017/10/20 11:30:58
 */

public class CommitsListActivity extends SingleFragmentActivity<IBaseContract.Presenter, CommitsFragment> {

    public static void showForRepo(@NonNull Activity activity, @NonNull String user,
                                   @NonNull String repo, @Nullable String branch) {
        Intent intent = createIntentForRepo(activity, user, repo, branch);
        activity.startActivity(intent);
    }

    public static void showForCompare(@NonNull Activity activity, @NonNull String user,
                                      @NonNull String repo, @NonNull String before, @NonNull String head) {
        Intent intent = createIntentForCompare(activity, user, repo, before, head);
        activity.startActivity(intent);
    }

    public static Intent createIntentForCompare(@NonNull Activity activity, @NonNull String user,
                                                @NonNull String repo, @NonNull String before, @NonNull String head) {
        return new Intent(activity, CommitsListActivity.class)
                .putExtras(BundleHelper.builder()
                        .put("type", CommitsListActivity.CommitsListType.Compare)
                        .put("user", user)
                        .put("repo", repo)
                        .put("before", before)
                        .put("head", head).build());
    }

    public static Intent createIntentForRepo(@NonNull Activity activity, @NonNull String user,
                                                @NonNull String repo, @Nullable String branch) {
        return new Intent(activity, CommitsListActivity.class)
                .putExtras(BundleHelper.builder()
                        .put("type", CommitsListType.Repo)
                        .put("user", user)
                        .put("repo", repo)
                        .put("branch", branch)
                        .build());
    }

    public enum CommitsListType {
        Compare, Repo
    }

    @AutoAccess
    CommitsListActivity.CommitsListType type;
    @AutoAccess String user;
    @AutoAccess String repo;

    @AutoAccess String branch;

    @AutoAccess String before;
    @AutoAccess String head;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        String repoFullName = user.concat("/").concat(repo);
        setToolbarTitle(getToolbarTitle(), repoFullName);
        setToolbarScrollAble(true);
    }

    private String getToolbarTitle(){
        if (CommitsListType.Compare.equals(type)) {
            return getString(R.string.compare);
        } else if (CommitsListType.Repo.equals(type)) {
            return getString(R.string.commits).concat(" ").concat(branch);
        } else {
            return getString(R.string.commits);
        }
    }

    @Override
    protected CommitsFragment createFragment() {
        if (CommitsListType.Compare.equals(type)) {
            return CommitsFragment.createForCompare(user, repo, before, head);
        } else if (CommitsListType.Repo.equals(type)) {
            return CommitsFragment.createForRepo(user, repo, branch);
        } else {
            return null;
        }
    }


}
