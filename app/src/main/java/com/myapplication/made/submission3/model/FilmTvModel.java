package com.myapplication.made.submission3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmTvModel implements Parcelable {
    private int photo;
    private String title;
    private String releaseDate;
    private String duration;
    private String language;
    private String userScore;
    private String rating;
    private String revenue;
    private String genre;
    private String overview;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.releaseDate);
        dest.writeString(this.duration);
        dest.writeString(this.language);
        dest.writeString(this.userScore);
        dest.writeString(this.rating);
        dest.writeString(this.revenue);
        dest.writeString(this.genre);
        dest.writeString(this.overview);
    }

    public FilmTvModel() {
    }

    protected FilmTvModel(Parcel in) {
        this.photo = in.readInt();
        this.title = in.readString();
        this.releaseDate = in.readString();
        this.duration = in.readString();
        this.language = in.readString();
        this.userScore = in.readString();
        this.rating = in.readString();
        this.revenue = in.readString();
        this.genre = in.readString();
        this.overview = in.readString();
    }

    public static final Parcelable.Creator<FilmTvModel> CREATOR = new Parcelable.Creator<FilmTvModel>() {
        @Override
        public FilmTvModel createFromParcel(Parcel source) {
            return new FilmTvModel(source);
        }

        @Override
        public FilmTvModel[] newArray(int size) {
            return new FilmTvModel[size];
        }
    };
}
