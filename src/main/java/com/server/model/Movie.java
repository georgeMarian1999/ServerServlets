package com.server.model;

public class Movie {
    private int id;
    private String title;
    private int rating;
    private String genre;

    public Movie(){

    }

    public Movie(int id,String title,int rating,String genre) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
