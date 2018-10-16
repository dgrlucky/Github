package com.hanzo.github.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BOOK_MARK_USER".
*/
public class BookMarkUserDao extends AbstractDao<BookMarkUser, String> {

    public static final String TABLENAME = "BOOK_MARK_USER";

    /**
     * Properties of entity BookMarkUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Login = new Property(0, String.class, "login", true, "LOGIN");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property AvatarUrl = new Property(2, String.class, "avatarUrl", false, "AVATAR_URL");
        public final static Property Followers = new Property(3, Integer.class, "followers", false, "FOLLOWERS");
        public final static Property Following = new Property(4, Integer.class, "following", false, "FOLLOWING");
        public final static Property MarkTime = new Property(5, java.util.Date.class, "markTime", false, "MARK_TIME");
    }


    public BookMarkUserDao(DaoConfig config) {
        super(config);
    }
    
    public BookMarkUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BOOK_MARK_USER\" (" + //
                "\"LOGIN\" TEXT PRIMARY KEY NOT NULL ," + // 0: login
                "\"NAME\" TEXT," + // 1: name
                "\"AVATAR_URL\" TEXT," + // 2: avatarUrl
                "\"FOLLOWERS\" INTEGER," + // 3: followers
                "\"FOLLOWING\" INTEGER," + // 4: following
                "\"MARK_TIME\" INTEGER);"); // 5: markTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BOOK_MARK_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BookMarkUser entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getLogin());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String avatarUrl = entity.getAvatarUrl();
        if (avatarUrl != null) {
            stmt.bindString(3, avatarUrl);
        }
 
        Integer followers = entity.getFollowers();
        if (followers != null) {
            stmt.bindLong(4, followers);
        }
 
        Integer following = entity.getFollowing();
        if (following != null) {
            stmt.bindLong(5, following);
        }
 
        java.util.Date markTime = entity.getMarkTime();
        if (markTime != null) {
            stmt.bindLong(6, markTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BookMarkUser entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getLogin());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String avatarUrl = entity.getAvatarUrl();
        if (avatarUrl != null) {
            stmt.bindString(3, avatarUrl);
        }
 
        Integer followers = entity.getFollowers();
        if (followers != null) {
            stmt.bindLong(4, followers);
        }
 
        Integer following = entity.getFollowing();
        if (following != null) {
            stmt.bindLong(5, following);
        }
 
        java.util.Date markTime = entity.getMarkTime();
        if (markTime != null) {
            stmt.bindLong(6, markTime.getTime());
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    @Override
    public BookMarkUser readEntity(Cursor cursor, int offset) {
        BookMarkUser entity = new BookMarkUser( //
            cursor.getString(offset + 0), // login
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // avatarUrl
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // followers
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // following
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)) // markTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BookMarkUser entity, int offset) {
        entity.setLogin(cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAvatarUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFollowers(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setFollowing(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setMarkTime(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
     }
    
    @Override
    protected final String updateKeyAfterInsert(BookMarkUser entity, long rowId) {
        return entity.getLogin();
    }
    
    @Override
    public String getKey(BookMarkUser entity) {
        if(entity != null) {
            return entity.getLogin();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BookMarkUser entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
