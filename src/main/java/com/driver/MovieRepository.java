package com.driver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Repository
public class MovieRepository {
    private Map<String,Movie> movieMap = new TreeMap<>();
    private Map<String,Director> directorMap = new TreeMap<>();;
    private Map<String,List<Movie>> directorMovieMap = new TreeMap<>();// key is director name and value is list of movies
    public String addMovie( Movie movie){
        movieMap.put(movie.getName(),movie);
        return "Movie " +movie.getName() + " added successfully";
    }


    public String addDirector( Director director){
        directorMap.put(director.getName(),director);
        return "Director " +director.getName() + " added successfully";
    }

    public String addMovieDirectorPair( String movieName, String directorName)throws NullPointerException{
        if(!directorMovieMap.containsKey(directorName)){
            directorMovieMap.put(directorName,new ArrayList<Movie>());
        }
        directorMovieMap.get(directorName).add(getMovieByName(movieName));

        return "Movie " + movieName + " added under director " + directorName;
    }

    public Movie getMovieByName( String movieName)throws NullPointerException{
        return movieMap.get(movieName);
    }

    public Director getDirectorByName( String directorName)throws NullPointerException{
        return directorMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName( String directorName){
        List<String> movies = new ArrayList<>();
        for(Movie movie : directorMovieMap.get(directorName)){
            movies.add(movie.getName());
        }
        return movies;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());

    }

    public String deleteDirectorByName( String directorName)throws NullPointerException{
        for(Movie movie: directorMovieMap.get(directorName)){
            movieMap.remove(movie.getName());
        }
        directorMovieMap.remove(directorName);
        directorMap.remove(directorName);
        return "movies assigned to " + directorName + " has been deleted";
    }

    public String deleteAllDirectors()throws NullPointerException{
        for(String directorName : directorMap.keySet()){
            for(Movie movie: directorMovieMap.get(directorName)){
                movieMap.remove(movie.getName());
            }
            directorMovieMap.remove(directorName);
            directorMap.remove(directorName);
        }

        return "all director and there movies has been deleted";
    }
}
