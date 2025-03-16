package com.example.fragments.models;

import android.annotation.SuppressLint;
import android.database.Cursor;

public class Genre {
    private int id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }

    @SuppressLint("Range")
    public Genre(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.name = cursor.getString(cursor.getColumnIndex("name"));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
