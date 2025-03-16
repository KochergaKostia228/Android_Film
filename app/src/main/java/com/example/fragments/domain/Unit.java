package com.example.fragments.domain;

import com.example.fragments.domain.DAO.FilmDAO;
import com.example.fragments.domain.DAO.GenreDAO;

public class Unit {
    private FilmSQLiteHelper _helper = new FilmSQLiteHelper();
    private GenreDAO _genreRepository;
    private FilmDAO _filmRepository;

    private static Unit _instance;

    static {
        _instance = new Unit();
    }

    private Unit(){
        _filmRepository = new FilmDAO(_helper);
        _genreRepository = new GenreDAO(_helper);
    }

    public static FilmDAO getFilmRepository() {
        return _instance._filmRepository;
    }

    public static GenreDAO getGenreRepository() {
        return _instance._genreRepository;
    }

    public FilmSQLiteHelper getHelper() {
        return _instance._helper;
    }

    public static Unit getInstance() {
        return _instance;
    }
}
