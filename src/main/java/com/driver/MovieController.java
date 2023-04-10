package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    // Within ResponseEntity<Data-Type> include the type of Return value :
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie_name){
        // Wrapping the return value like this in ResponseEntity<>() :
        return new ResponseEntity<>(movieService.getMovieByName(movie_name), HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director_name){
        return new ResponseEntity<>(movieService.getDirectorByName(director_name), HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director_name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director_name), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director-name") String director_name) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(director_name), HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie-name") String movie_name, @RequestParam("director-name") String director_name) {
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie_name, director_name), HttpStatus.CREATED);
    }
}
