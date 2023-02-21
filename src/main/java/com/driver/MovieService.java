package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository watchListRepository;

    public String addMovie( Movie movie){
        return watchListRepository.addMovie(movie);
    }


    public String addDirector( Director director){
        return watchListRepository.addDirector(director);
    }

    public String addMovieDirectorPair( String movieName, String directorName){
        return watchListRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName( String movieName){
        return watchListRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName( String directorName){
        return watchListRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName( String directorName){
        return watchListRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies(){
        return watchListRepository.findAllMovies();
    }

    public String deleteDirectorByName( String directorName){
        return watchListRepository.deleteDirectorByName(directorName);
    }

    public String deleteAllDirectors(){
        return watchListRepository.deleteAllDirectors();
    }
}
