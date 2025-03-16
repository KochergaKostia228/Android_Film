package com.example.fragments;

import android.app.Application;
import android.content.Context;

public class FilmApplication extends Application {
    static FilmApplication app;

    public FilmApplication(){
        app = this;
    }

    public static Context getApp(){
        return app;
    }
}
