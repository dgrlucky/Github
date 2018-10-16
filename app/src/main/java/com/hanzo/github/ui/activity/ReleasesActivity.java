package com.hanzo.github.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hanzo.github.R;
import com.hanzo.github.mvp.contract.base.IBaseContract;
import com.hanzo.github.ui.activity.base.SingleFragmentActivity;
import com.hanzo.github.ui.fragment.ReleasesFragment;
import com.hanzo.github.util.BundleHelper;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;

/**
 * Created by ThirtyDegreesRay on 2017/9/16 10:58:03
 */

public class ReleasesActivity extends SingleFragmentActivity<IBaseContract.Presenter, ReleasesFragment> {

    public static void show(Activity activity, String owner, String repo) {
        Intent intent = createIntent(activity, owner, repo);
        activity.startActivity(intent);
    }

    public static Intent createIntent(Activity activity, String owner, String repo) {
        return new Intent(activity, ReleasesActivity.class)
                .putExtras(BundleHelper.builder()
                        .put("owner", owner)
                        .put("repo", repo).build());
    }

    @AutoAccess
    String owner;
    @AutoAccess String repo;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        String subTitle = owner.concat("/").concat(repo);
        setToolbarTitle(getString(R.string.releases), subTitle);
        setToolbarScrollAble(true);
    }

    @Override
    protected ReleasesFragment createFragment() {
        return ReleasesFragment.create(owner, repo);
    }
}
