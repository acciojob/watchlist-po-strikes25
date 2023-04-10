package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movie_database = new HashMap<>();
    HashMap<String, Director> director_database = new HashMap<>();
    HashMap<String, ArrayList<Movie>> director_movie_database = new HashMap<>();

    public void addMovie(Movie movie) {
        movie_database.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        director_database.put(director.getName(), director);
    }

    public Movie getMovieByName(String name){
        return movie_database.get(name);
    }

    public Director getDirectorByName(String name){
        return director_database.get(name);
    }

    public List<String> getMoviesByDirectorName(String director_name){
        List<String> movies_list = new ArrayList<>();
        for(Movie movie : director_movie_database.get(director_name)){
            movies_list.add(movie.getName());
        }
        return movies_list;
    }

    public List<String> findAllMovies(){
        // Very Intelligent way of returning the keySet() of the movie_database :
        return new ArrayList<>(movie_database.keySet());
    }

    public String deleteAllDirectors() {
        director_database.clear();
        director_movie_database.clear();
        return "Success";
    }

    public String deleteDirectorByName(String director_name) throws NullPointerException {
        for(int i = 0 ; i < director_database.size() ; i++) {
            if(director_database.get(i).equals(director_name)){
                director_database.remove(director_name);
                break;
            }
        }
        return "Success";
    }

    public String addMovieDirectorPair(String movie_name, String director_name) throws NullPointerException {
        if(!director_movie_database.containsKey(director_name))
            director_movie_database.put(director_name,new ArrayList<Movie>());

        director_movie_database.get(director_name).add(getMovieByName(movie_name));
        return "Success";
    }
}