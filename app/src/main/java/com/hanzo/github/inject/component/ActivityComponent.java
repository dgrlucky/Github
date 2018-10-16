

package com.hanzo.github.inject.component;


import com.hanzo.github.inject.ActivityScope;
import com.hanzo.github.inject.module.ActivityModule;
import com.hanzo.github.ui.activity.CommitDetailActivity;
import com.hanzo.github.ui.activity.EditIssueActivity;
import com.hanzo.github.ui.activity.IssueDetailActivity;
import com.hanzo.github.ui.activity.IssuesActivity;
import com.hanzo.github.ui.activity.LoginActivity;
import com.hanzo.github.ui.activity.MainActivity;
import com.hanzo.github.ui.activity.ProfileActivity;
import com.hanzo.github.ui.activity.ReleaseInfoActivity;
import com.hanzo.github.ui.activity.RepositoryActivity;
import com.hanzo.github.ui.activity.SearchActivity;
import com.hanzo.github.ui.activity.SettingsActivity;
import com.hanzo.github.ui.activity.SplashActivity;
import com.hanzo.github.ui.activity.TrendingActivity;

import dagger.Component;

/**
 * ActivityComponent
 * Created by ThirtyDegreesRay on 2016/8/30 14:56
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(MainActivity activity);
    void inject(SettingsActivity activity);
    void inject(RepositoryActivity activity);
    void inject(ProfileActivity activity);
    void inject(SearchActivity activity);
    void inject(ReleaseInfoActivity activity);
    void inject(IssuesActivity activity);
    void inject(IssueDetailActivity activity);
    void inject(EditIssueActivity activity);
    void inject(CommitDetailActivity activity);
    void inject(TrendingActivity activity);
}
