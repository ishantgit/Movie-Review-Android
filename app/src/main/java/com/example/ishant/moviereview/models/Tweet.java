package com.example.ishant.moviereview.models;

/**
 * Created by ishant on 19/11/15.
 */
public class Tweet {
    private int id;
    private String text;
    private String polarity;
    private String subjectivity;
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPolarity() {
        return polarity;
    }

    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }

    public String getSubjectivity() {
        return subjectivity;
    }

    public void setSubjectivity(String subjectivity) {
        this.subjectivity = subjectivity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
