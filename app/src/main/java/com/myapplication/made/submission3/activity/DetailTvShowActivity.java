package com.myapplication.made.submission3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.myapplication.made.submission3.R;
import com.myapplication.made.submission3.model.TvShowModel;

public class DetailTvShowActivity extends AppCompatActivity {
    private TextView dtlTvShowName, dtlTvShowReleaseDate, dtlTvShowPopularity, dtlTvShowCountry, dtlTvShowVoteCount, dtlTvShowVoteAverage, dtlTvShowLanguage, dtlTvShowGenre, dtlTvShowOverview;
    private ImageView dtlImagePhoto;
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Film");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dtlImagePhoto = findViewById(R.id.dtl_imgPhoto);
        dtlTvShowName = findViewById(R.id.dtl_tv_show_title);
        dtlTvShowReleaseDate = findViewById(R.id.dtl_tv_show_release_date);
        dtlTvShowPopularity = findViewById(R.id.dtl_tv_show_popularity);
        dtlTvShowCountry = findViewById(R.id.dtl_tv_show_country);
        dtlTvShowVoteCount = findViewById(R.id.dtl_tv_show_vote_count);
        dtlTvShowVoteAverage = findViewById(R.id.dtl_tv_show_vote_average);
        dtlTvShowLanguage = findViewById(R.id.dtl_tv_show_language);
        dtlTvShowGenre = findViewById(R.id.dtl_tv_show_genre);
        dtlTvShowOverview = findViewById(R.id.dtl_tv_show_overview);

        TvShowModel tvShowModel = getIntent().getParcelableExtra(EXTRA_DATA);

        Glide.with(this)
                .load(tvShowModel.getPosterPath())
                .apply(new RequestOptions().override(350, 550))
                .into(dtlImagePhoto);
//        dtlImagePhoto.setImageResource(movieModel.getPosterPath());
        dtlTvShowName.setText(tvShowModel.getName());
        dtlTvShowReleaseDate.setText(tvShowModel.getFirstAirDate());
        dtlTvShowPopularity.setText(Double.toString(tvShowModel.getPopularity()));
        dtlTvShowCountry.setText(tvShowModel.getOriginCountry().toString().replaceAll("\\[|\\]", ""));
        dtlTvShowVoteCount.setText(Integer.toString(tvShowModel.getVoteCount()));
        dtlTvShowVoteAverage.setText(Double.toString(tvShowModel.getVoteAverage()));
        dtlTvShowLanguage.setText(tvShowModel.getOriginalLanguage());
        dtlTvShowGenre.setText(tvShowModel.getListGenreString().toString().replaceAll("\\[|\\]", ""));
        dtlTvShowOverview.setText(tvShowModel.getOverview());
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
