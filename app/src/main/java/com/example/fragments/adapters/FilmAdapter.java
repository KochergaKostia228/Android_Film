package com.example.fragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fragments.R;
import com.example.fragments.domain.DAO.FilmDAO;
import com.example.fragments.domain.Unit;
import com.example.fragments.models.Film;

public class FilmAdapter extends BaseAdapter {

    FilmDAO filmDAO = Unit.getFilmRepository();

    @Override
    public int getCount() {
        return filmDAO.getItemCount();
    }

    @Override
    public Object getItem(int position) {
        return filmDAO.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return filmDAO.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.film_item, null);
        }

        Film film = filmDAO.getItem(position);

        ((TextView) convertView.findViewById(R.id.film_title)).setText(String.format("Title: " + film.getTitle()));
        ((TextView) convertView.findViewById(R.id.film_genre)).setText(String.format("Genre: " + film.getGenre()));
        ((TextView) convertView.findViewById(R.id.film_year)).setText(String.format(" %d year",film.getYear()));


        return convertView;
    }
}
