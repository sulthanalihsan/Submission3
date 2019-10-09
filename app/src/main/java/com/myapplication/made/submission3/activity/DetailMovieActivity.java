package com.myapplication.made.submission3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.myapplication.made.submission3.R;
import com.myapplication.made.submission3.model.MovieModel;

import java.util.ArrayList;

public class DetailMovieActivity extends AppCompatActivity {
    private TextView dtlMovieTitle, dtlMovieReleaseDate, dtlMoviePopularity, dtlMovieVoteCount, dtlMovieVoteAverage, dtlMovieLanguage, dtlMovieGenre, dtlMovieOverview;
    private ImageView dtlImagePhoto;
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Film");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dtlImagePhoto = findViewById(R.id.dtl_imgPhoto);
        dtlMovieTitle = findViewById(R.id.dtl_movie_title);
        dtlMovieReleaseDate = findViewById(R.id.dtl_movie_release_date);
        dtlMoviePopularity = findViewById(R.id.dtl_movie_popularity);
        dtlMovieVoteCount = findViewById(R.id.dtl_movie_vote_count);
        dtlMovieVoteAverage = findViewById(R.id.dtl_movie_vote_average);
        dtlMovieLanguage = findViewById(R.id.dtl_movie_language);
        dtlMovieGenre = findViewById(R.id.dtl_movie_genre);
        dtlMovieOverview = findViewById(R.id.dtl_movie_overview);

        MovieModel movieModel = getIntent().getParcelableExtra(EXTRA_DATA);

        Glide.with(this)
                .load(movieModel.getPosterPath())
                .apply(new RequestOptions().override(350, 550))
                .into(dtlImagePhoto);
//        dtlImagePhoto.setImageResource(movieModel.getPosterPath());
        dtlMovieTitle.setText(movieModel.getTitle());
        dtlMovieReleaseDate.setText(movieModel.getReleaseDate());
        dtlMoviePopularity.setText(Double.toString(movieModel.getPopularity()));
        dtlMovieVoteCount.setText(Integer.toString(movieModel.getVoteCount()));
        dtlMovieVoteAverage.setText(Double.toString(movieModel.getVoteAverage()));
        dtlMovieLanguage.setText(movieModel.getOriginalLanguage());
        dtlMovieGenre.setText(movieModel.getListGenreString().toString().replaceAll("\\[|\\]", ""));
        dtlMovieOverview.setText(movieModel.getOverview());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
