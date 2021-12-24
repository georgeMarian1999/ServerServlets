package com.server.jsontemplate;

import com.server.model.Movie;
import io.jsondb.JsonDBTemplate;

import java.util.List;

public class JSONTemplate {
    private String dbFilesLocation;
    private String baseScanPackage;
    private JsonDBTemplate jsonDBTemplate;

    public JSONTemplate() {
        // Trebuie inlocuit cu calea absoluta al directorului webapp\db de pe statia pe care
        // se ruleaza aplicatia. In alte cuvinte trebuie pusa in fata la \\server calea unde
        // se afla proiectul.
        dbFilesLocation = "C:\\Work\\server\\src\\main\\webapp\\db";
        baseScanPackage = "com.server.model";
        jsonDBTemplate = new JsonDBTemplate(dbFilesLocation,baseScanPackage);
    }

    public void addMovie(Movie movie) {
        this.jsonDBTemplate.insert(movie);
    }
    public void deleteMovie(int id) {
        Movie movie = this.jsonDBTemplate.findById(id, Movie.class);
        this.jsonDBTemplate.remove(movie, Movie.class);
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
