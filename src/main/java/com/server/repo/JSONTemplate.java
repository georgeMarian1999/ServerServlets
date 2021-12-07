package com.server.repo;

import com.server.model.Movie;
import io.jsondb.JsonDBTemplate;

import java.util.List;

public class JSONTemplate {
    private String dbFilesLocation;
    private String baseScanPackage;
    private JsonDBTemplate jsonDBTemplate;

    public JSONTemplate() {
        dbFilesLocation = "C:\\Work\\server\\src\\main\\webapp\\db";
        baseScanPackage = "com.server.model";
        jsonDBTemplate = new JsonDBTemplate(dbFilesLocation,baseScanPackage);
    }

    public JsonDBTemplate getJsonDBTemplate() {
        return jsonDBTemplate;
    }
    public void createMoviesCollection(){
        this.jsonDBTemplate.createCollection(Movie.class);
    }
    public void addMovie(Movie movie) {
        this.jsonDBTemplate.insert(movie);
    }
    public void saveMovie(Movie movie){
        this.jsonDBTemplate.save(movie,Movie.class);
    }
    public int getMaxId() {
        List<Movie> movies = this.jsonDBTemplate.findAll(Movie.class);
        int id = -99999;
        for (Movie mov:movies
             ) {
            if(mov.getId() > id) {
                id = mov.getId();
            }
        }
        return id + 1;

    }
    public List<Movie> getMovies(){
        return this.jsonDBTemplate.findAll(Movie.class);
    }
}
