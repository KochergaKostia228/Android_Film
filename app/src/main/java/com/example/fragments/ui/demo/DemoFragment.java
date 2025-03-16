package com.example.fragments.ui.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragments.adapters.FilmAdapter;
import com.example.fragments.adapters.GenreAdapter;
import com.example.fragments.databinding.FragmentDemoBinding;
import com.example.fragments.ui.dashboard.DashboardViewModel;

public class DemoFragment extends Fragment {

    private FragmentDemoBinding demoBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        demoBinding = FragmentDemoBinding.inflate(inflater, container, false);
        View root = demoBinding.getRoot();

        final ListView listView = demoBinding.list;
        listView.setAdapter(new FilmAdapter());

        final Spinner spinner = demoBinding.spGenre;
        spinner.setAdapter(new GenreAdapter());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        demoBinding = null;
    }
}
