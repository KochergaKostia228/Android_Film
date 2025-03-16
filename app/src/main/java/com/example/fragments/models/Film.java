package com.example.fragments.models;

import android.annotation.SuppressLint;
import android.database.Cursor;

public class Film {
    private int id;
    private String title;
    private String genre;
    private int year;

    public Film(String title, String genre, int year) {
        this.genre = genre;
        this.title = title;
        this.year = year;
    }

    @SuppressLint("Range")
    public Film(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.genre = cursor.getString(cursor.getColumnIndex("genre"));
        this.title = cursor.getString(cursor.getColumnIndex("title"));;
        this.year = cursor.getInt(cursor.getColumnIndex("year"));;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toText() {
        return id + ": " + title + " (" + year + ") - " + genre;
    }
}
