package com.hanzo.github.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.hanzo.github.dao.AuthUser;
import com.hanzo.github.dao.TraceUser;
import com.hanzo.github.dao.TraceRepo;
import com.hanzo.github.dao.BookMarkUser;
import com.hanzo.github.dao.BookMarkRepo;
import com.hanzo.github.dao.LocalUser;
import com.hanzo.github.dao.LocalRepo;
import com.hanzo.github.dao.Trace;
import com.hanzo.github.dao.Bookmark;
import com.hanzo.github.dao.MyTrendingLanguage;

import com.hanzo.github.dao.AuthUserDao;
import com.hanzo.github.dao.TraceUserDao;
import com.hanzo.github.dao.TraceRepoDao;
import com.hanzo.github.dao.BookMarkUserDao;
import com.hanzo.github.dao.BookMarkRepoDao;
import com.hanzo.github.dao.LocalUserDao;
import com.hanzo.github.dao.LocalRepoDao;
import com.hanzo.github.dao.TraceDao;
import com.hanzo.github.dao.BookmarkDao;
import com.hanzo.github.dao.MyTrendingLanguageDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig authUserDaoConfig;
    private final DaoConfig traceUserDaoConfig;
    private final DaoConfig traceRepoDaoConfig;
    private final DaoConfig bookMarkUserDaoConfig;
    private final DaoConfig bookMarkRepoDaoConfig;
    private final DaoConfig localUserDaoConfig;
    private final DaoConfig localRepoDaoConfig;
    private final DaoConfig traceDaoConfig;
    private final DaoConfig bookmarkDaoConfig;
    private final DaoConfig myTrendingLanguageDaoConfig;

    private final AuthUserDao authUserDao;
    private final TraceUserDao traceUserDao;
    private final TraceRepoDao traceRepoDao;
    private final BookMarkUserDao bookMarkUserDao;
    private final BookMarkRepoDao bookMarkRepoDao;
    private final LocalUserDao localUserDao;
    private final LocalRepoDao localRepoDao;
    private final TraceDao traceDao;
    private final BookmarkDao bookmarkDao;
    private final MyTrendingLanguageDao myTrendingLanguageDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        authUserDaoConfig = daoConfigMap.get(AuthUserDao.class).clone();
        authUserDaoConfig.initIdentityScope(type);

        traceUserDaoConfig = daoConfigMap.get(TraceUserDao.class).clone();
        traceUserDaoConfig.initIdentityScope(type);

        traceRepoDaoConfig = daoConfigMap.get(TraceRepoDao.class).clone();
        traceRepoDaoConfig.initIdentityScope(type);

        bookMarkUserDaoConfig = daoConfigMap.get(BookMarkUserDao.class).clone();
        bookMarkUserDaoConfig.initIdentityScope(type);

        bookMarkRepoDaoConfig = daoConfigMap.get(BookMarkRepoDao.class).clone();
        bookMarkRepoDaoConfig.initIdentityScope(type);

        localUserDaoConfig = daoConfigMap.get(LocalUserDao.class).clone();
        localUserDaoConfig.initIdentityScope(type);

        localRepoDaoConfig = daoConfigMap.get(LocalRepoDao.class).clone();
        localRepoDaoConfig.initIdentityScope(type);

        traceDaoConfig = daoConfigMap.get(TraceDao.class).clone();
        traceDaoConfig.initIdentityScope(type);

        bookmarkDaoConfig = daoConfigMap.get(BookmarkDao.class).clone();
        bookmarkDaoConfig.initIdentityScope(type);

        myTrendingLanguageDaoConfig = daoConfigMap.get(MyTrendingLanguageDao.class).clone();
        myTrendingLanguageDaoConfig.initIdentityScope(type);

        authUserDao = new AuthUserDao(authUserDaoConfig, this);
        traceUserDao = new TraceUserDao(traceUserDaoConfig, this);
        traceRepoDao = new TraceRepoDao(traceRepoDaoConfig, this);
        bookMarkUserDao = new BookMarkUserDao(bookMarkUserDaoConfig, this);
        bookMarkRepoDao = new BookMarkRepoDao(bookMarkRepoDaoConfig, this);
        localUserDao = new LocalUserDao(localUserDaoConfig, this);
        localRepoDao = new LocalRepoDao(localRepoDaoConfig, this);
        traceDao = new TraceDao(traceDaoConfig, this);
        bookmarkDao = new BookmarkDao(bookmarkDaoConfig, this);
        myTrendingLanguageDao = new MyTrendingLanguageDao(myTrendingLanguageDaoConfig, this);

        registerDao(AuthUser.class, authUserDao);
        registerDao(TraceUser.class, traceUserDao);
        registerDao(TraceRepo.class, traceRepoDao);
        registerDao(BookMarkUser.class, bookMarkUserDao);
        registerDao(BookMarkRepo.class, bookMarkRepoDao);
        registerDao(LocalUser.class, localUserDao);
        registerDao(LocalRepo.class, localRepoDao);
        registerDao(Trace.class, traceDao);
        registerDao(Bookmark.class, bookmarkDao);
        registerDao(MyTrendingLanguage.class, myTrendingLanguageDao);
    }
    
    public void clear() {
        authUserDaoConfig.clearIdentityScope();
        traceUserDaoConfig.clearIdentityScope();
        traceRepoDaoConfig.clearIdentityScope();
        bookMarkUserDaoConfig.clearIdentityScope();
        bookMarkRepoDaoConfig.clearIdentityScope();
        localUserDaoConfig.clearIdentityScope();
        localRepoDaoConfig.clearIdentityScope();
        traceDaoConfig.clearIdentityScope();
        bookmarkDaoConfig.clearIdentityScope();
        myTrendingLanguageDaoConfig.clearIdentityScope();
    }

    public AuthUserDao getAuthUserDao() {
        return authUserDao;
    }

    public TraceUserDao getTraceUserDao() {
        return traceUserDao;
    }

    public TraceRepoDao getTraceRepoDao() {
        return traceRepoDao;
    }

    public BookMarkUserDao getBookMarkUserDao() {
        return bookMarkUserDao;
    }

    public BookMarkRepoDao getBookMarkRepoDao() {
        return bookMarkRepoDao;
    }

    public LocalUserDao getLocalUserDao() {
        return localUserDao;
    }

    public LocalRepoDao getLocalRepoDao() {
        return localRepoDao;
    }

    public TraceDao getTraceDao() {
        return traceDao;
    }

    public BookmarkDao getBookmarkDao() {
        return bookmarkDao;
    }

    public MyTrendingLanguageDao getMyTrendingLanguageDao() {
        return myTrendingLanguageDao;
    }

}
