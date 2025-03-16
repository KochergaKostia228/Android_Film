package com.example.fragments.domain;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fragments.FilmApplication;

public class FilmSQLiteHelper extends SQLiteOpenHelper {

    public FilmSQLiteHelper() {
        super(FilmApplication.getApp(), "FilmDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Genre (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL" +
                ")");

        db.execSQL("CREATE TABLE Films (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL," +
                "year INTEGER, " +
                "genre_id INTEGER," +
                " FOREIGN KEY (genre_id) REFERENCES Genre (id))");

        db.execSQL("INSERT INTO Genre(name) VALUES('Фантатика'),('Ужасы'),('Триллери'),('Комедия'),('Детективы')");
        db.execSQL("INSERT INTO Films(genre_id, title, year) VALUES(2, 'Пила 10', 2024)," +
                "(1, 'Звёздные войны. Эпизод 1: Скрытая угроза', 1999)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
