package com.myapplication.made.submission3.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.myapplication.made.submission3.R;
import com.myapplication.made.submission3.activity.DetailTvShowActivity;
import com.myapplication.made.submission3.adapter.TvShowAdapter;
import com.myapplication.made.submission3.model.TvShowModel;
import com.myapplication.made.submission3.viewmodel.TvShowViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private TvShowAdapter adapter;
    private ProgressBar progressBar;
    private TvShowViewModel tvShowViewModel;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        showLoading(true);

        tvShowViewModel = ViewModelProviders.of(getActivity()).get(TvShowViewModel.class);
        tvShowViewModel.setTvShows();
        tvShowViewModel.getListTvShows().observe(getActivity(), getTvShow);

        adapter = new TvShowAdapter();
        adapter.notifyDataSetChanged();

        RecyclerView recyclerView = view.findViewById(R.id.rv_tv_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickCallback(new TvShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShowModel tvShowModel) {
                Toast.makeText(getActivity(), getResources().getString(R.string.toast_text) + " " + tvShowModel.getName(), Toast.LENGTH_SHORT).show();
                Intent moveWithObjectIntent = new Intent(getContext(), DetailTvShowActivity.class);
                moveWithObjectIntent.putExtra(DetailTvShowActivity.EXTRA_DATA, tvShowModel);
                startActivity(moveWithObjectIntent);
            }
        });


        return view;
    }

    private Observer<ArrayList<TvShowModel>> getTvShow = new Observer<ArrayList<TvShowModel>>() {
        @Override
        public void onChanged(@Nullable ArrayList<TvShowModel> tvShowModels) {
            if (tvShowModels != null) {
                adapter.setmData(tvShowModels);
                Log.d("Data list tvshow", adapter.getmData().toString());
                showLoading(false);
            }
        }
    };


    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
