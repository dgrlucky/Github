

package com.hanzo.github.inject.component;


import com.hanzo.github.inject.FragmentScope;
import com.hanzo.github.inject.module.FragmentModule;
import com.hanzo.github.ui.fragment.ActivityFragment;
import com.hanzo.github.ui.fragment.BookmarksFragment;
import com.hanzo.github.ui.fragment.CollectionsFragment;
import com.hanzo.github.ui.fragment.CommitFilesFragment;
import com.hanzo.github.ui.fragment.CommitsFragment;
import com.hanzo.github.ui.fragment.IssueTimelineFragment;
import com.hanzo.github.ui.fragment.IssuesFragment;
import com.hanzo.github.ui.fragment.LabelManageFragment;
import com.hanzo.github.ui.fragment.LanguagesEditorFragment;
import com.hanzo.github.ui.fragment.NotificationsFragment;
import com.hanzo.github.ui.fragment.ProfileInfoFragment;
import com.hanzo.github.ui.fragment.ReleasesFragment;
import com.hanzo.github.ui.fragment.RepoFilesFragment;
import com.hanzo.github.ui.fragment.RepoInfoFragment;
import com.hanzo.github.ui.fragment.RepositoriesFragment;
import com.hanzo.github.ui.fragment.TopicsFragment;
import com.hanzo.github.ui.fragment.TraceFragment;
import com.hanzo.github.ui.fragment.UserListFragment;
import com.hanzo.github.ui.fragment.ViewerFragment;
import com.hanzo.github.ui.fragment.WikiFragment;

import dagger.Component;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(RepositoriesFragment fragment);
    void inject(RepoInfoFragment fragment);
    void inject(RepoFilesFragment fragment);
    void inject(UserListFragment fragment);
    void inject(ViewerFragment fragment);
    void inject(ProfileInfoFragment fragment);
    void inject(ActivityFragment fragment);
    void inject(ReleasesFragment fragment);
    void inject(IssuesFragment fragment);
    void inject(IssueTimelineFragment fragment);
    void inject(CommitsFragment fragment);
    void inject(CommitFilesFragment fragment);
    void inject(NotificationsFragment fragment);
    void inject(BookmarksFragment fragment);
    void inject(TraceFragment fragment);
    void inject(LanguagesEditorFragment fragment);
    void inject(WikiFragment fragment);
    void inject(CollectionsFragment fragment);
    void inject(TopicsFragment fragment);
    void inject(LabelManageFragment fragment);
}
