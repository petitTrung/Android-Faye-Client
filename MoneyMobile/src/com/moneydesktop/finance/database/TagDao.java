package com.moneydesktop.finance.database;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.moneydesktop.finance.database.Tag;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TAG.
*/
public class TagDao extends AbstractDao<Tag, Long> {

    public static final String TABLENAME = "TAG";

    /**
     * Properties of entity Tag.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TagId = new Property(1, String.class, "tagId", false, "TAG_ID");
        public final static Property TagName = new Property(2, String.class, "tagName", false, "TAG_NAME");
        public final static Property BusinessObjectId = new Property(3, long.class, "businessObjectId", false, "BUSINESS_OBJECT_ID");
    };

    private DaoSession daoSession;


    public TagDao(DaoConfig config) {
        super(config);
    }
    
    public TagDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TAG' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TAG_ID' TEXT," + // 1: tagId
                "'TAG_NAME' TEXT," + // 2: tagName
                "'BUSINESS_OBJECT_ID' INTEGER NOT NULL );"); // 3: businessObjectId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TAG'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Tag entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String tagId = entity.getTagId();
        if (tagId != null) {
            stmt.bindString(2, tagId);
        }
 
        String tagName = entity.getTagName();
        if (tagName != null) {
            stmt.bindString(3, tagName);
        }
        stmt.bindLong(4, entity.getBusinessObjectId());
    }

    @Override
    protected void attachEntity(Tag entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Tag readEntity(Cursor cursor, int offset) {
        Tag entity = new Tag( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tagId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // tagName
            cursor.getLong(offset + 3) // businessObjectId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Tag entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTagId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTagName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBusinessObjectId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Tag entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Tag entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getBusinessObjectBaseDao().getAllColumns());
            builder.append(" FROM TAG T");
            builder.append(" LEFT JOIN BUSINESS_OBJECT_BASE T0 ON T.'BUSINESS_OBJECT_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Tag loadCurrentDeep(Cursor cursor, boolean lock) {
        Tag entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        BusinessObjectBase businessObjectBase = loadCurrentOther(daoSession.getBusinessObjectBaseDao(), cursor, offset);
         if(businessObjectBase != null) {
            entity.setBusinessObjectBase(businessObjectBase);
        }

        return entity;    
    }

    public Tag loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Tag> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Tag> list = new ArrayList<Tag>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Tag> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Tag> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
