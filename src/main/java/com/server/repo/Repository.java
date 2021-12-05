package com.server.repo;

import com.server.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private ArrayList<Movie> movies;

    private JSONTemplate jsonTemplate;

    public Repository() {
        movies = new ArrayList<>();
        jsonTemplate = new JSONTemplate();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void createMoviesCollection() {
        this.jsonTemplate.createMoviesCollection();
    }
    public void addMovieToDB(Movie movie){
        this.jsonTemplate.addMovie(movie);
    }
    public void saveMovieToDB(Movie movie){
        this.jsonTemplate.saveMovie(movie);
    }
    public List<Movie> getAllMovies(){
        return this.jsonTemplate.getMovies();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    public Movie getMovie(int pos){
        return movies.get(pos);
    }
    public Movie getMovieById(int id){
        for (Movie mov:movies
             ) {
            if (mov.getId() == id) {
                return mov;
            }
        }
        return null;
    }
}
