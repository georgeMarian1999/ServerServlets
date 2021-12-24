package com.server.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.Objects;
@Document(collection = "movies", schemaVersion = "1.0")
public class Movie {
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && rating == movie.rating && title.equals(movie.title) && genre.equals(movie.genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                '}';
    }

}
