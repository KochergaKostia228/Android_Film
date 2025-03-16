package com.example.fragments.domain.DAO;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fragments.domain.FilmSQLiteHelper;
import com.example.fragments.models.Genre;

public class GenreDAO {

    FilmSQLiteHelper _helper;
    SQLiteDatabase _database;
    Cursor _cursor;
    public GenreDAO(FilmSQLiteHelper _helper) {
        this._helper = _helper;
        this._database = this._helper.getReadableDatabase();
        this._cursor = _database.rawQuery(
                "SELECT id, name " +
                        "FROM Genre",
                new String[]{}
        );
    }

    public int getItemCount(){
        return _cursor.getCount();
    }

    public Genre getItem(int pos){
        this._cursor.moveToPosition(pos);
        return new Genre(_cursor);
    }

    @SuppressLint("Range")
    public int getItemId(int pos){
        this._cursor.moveToPosition(pos);
        return _cursor.getInt(_cursor.getColumnIndex("id"));
    }
}
