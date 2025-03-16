package com.example.fragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fragments.domain.DAO.GenreDAO;
import com.example.fragments.domain.Unit;
import com.example.fragments.models.Genre;

public class GenreAdapter extends BaseAdapter {
    GenreDAO genreDAO = Unit.getGenreRepository();

    @Override
    public int getCount() {
        return genreDAO.getItemCount();
    }

    @Override
    public Object getItem(int position) {
        return genreDAO.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return genreDAO.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_dropdown_item_1line, null);
        }

        Genre genre = genreDAO.getItem(position);

        ((TextView) convertView).setText(String.format(genre.getName()));

        return convertView;
    }
}
