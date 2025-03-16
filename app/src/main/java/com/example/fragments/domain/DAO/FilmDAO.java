package com.example.fragments.domain.DAO;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fragments.domain.FilmSQLiteHelper;
import com.example.fragments.models.Film;

public class FilmDAO {
    FilmSQLiteHelper _helper;
    SQLiteDatabase _database;
    Cursor _cursor;

    public FilmDAO(FilmSQLiteHelper _helper) {
        this._helper = _helper;
        this._database = _helper.getReadableDatabase();
        this._cursor = _database.rawQuery(
                "SELECT Films.id, Films.title AS title, Genre.name AS genre, year " +
                        "FROM Films INNER JOIN Genre ON Films.genre_id = Genre.id",
                new String[]{}
        );
    }

    public int getItemCount(){
        return _cursor.getCount();
    }

    public Film getItem(int pos){
        this._cursor.moveToPosition(pos);
        return new Film(_cursor);
    }

    @SuppressLint("Range")
    public int getItemId(int pos){
        this._cursor.moveToPosition(pos);
        return _cursor.getInt(_cursor.getColumnIndex("id"));
    }

    public void addItem(Film film){
        _helper.getReadableDatabase().execSQL(
                "INSERT INTO Films (title, year, genre_id) VALUES(?,?,(SELECT id FROM Genre WHERE name = ?))",
                new String[]{film.getTitle(), Integer.toString(film.getYear()), film.getGenre()}
        );
    }

    public void updateItem(int id, Film film){
        _helper.getReadableDatabase().execSQL(
                "UPDATE Films SET title = ?, genre_id = (SELECT id FROM Genre WHERE name = ?), year = ? WHERE id = ?",
                new String[]{film.getTitle(), film.getGenre(), Integer.toString(film.getYear()), Integer.toString(id)}
        );
    }
}