package com.example.finalpractice2.Models;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AnimalDao_Impl implements AnimalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Animals> __insertionAdapterOfAnimals;

  public AnimalDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAnimals = new EntityInsertionAdapter<Animals>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `animals` (`AnimalId`,`AnimalPicRef`,`AnimalName`,`DoB`,`AnimalPrice`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Animals entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        statement.bindLong(2, entity.getAnimalPicture());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getDob() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDob());
        }
        if (entity.getPrice() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getPrice());
        }
      }
    };
  }

  @Override
  public Long[] insertAnimals(final List<Animals> Animal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Long[] _result = __insertionAdapterOfAnimals.insertAndReturnIdsArrayBox(Animal);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Animals> getAllAnimals() {
    final String _sql = "Select * From animals";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalId");
      final int _cursorIndexOfAnimalPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalPicRef");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalName");
      final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "DoB");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalPrice");
      final List<Animals> _result = new ArrayList<Animals>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Animals _item;
        _item = new Animals();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final int _tmpAnimalPicture;
        _tmpAnimalPicture = _cursor.getInt(_cursorIndexOfAnimalPicture);
        _item.setAnimalPicture(_tmpAnimalPicture);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpDob;
        if (_cursor.isNull(_cursorIndexOfDob)) {
          _tmpDob = null;
        } else {
          _tmpDob = _cursor.getString(_cursorIndexOfDob);
        }
        _item.setDob(_tmpDob);
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Animals getAnimalById(final String id) {
    final String _sql = "Select * From animals where animals.AnimalId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalId");
      final int _cursorIndexOfAnimalPicture = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalPicRef");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalName");
      final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "DoB");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "AnimalPrice");
      final Animals _result;
      if (_cursor.moveToFirst()) {
        _result = new Animals();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final int _tmpAnimalPicture;
        _tmpAnimalPicture = _cursor.getInt(_cursorIndexOfAnimalPicture);
        _result.setAnimalPicture(_tmpAnimalPicture);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpDob;
        if (_cursor.isNull(_cursorIndexOfDob)) {
          _tmpDob = null;
        } else {
          _tmpDob = _cursor.getString(_cursorIndexOfDob);
        }
        _result.setDob(_tmpDob);
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        _result.setPrice(_tmpPrice);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
