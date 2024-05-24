package com.mybatis.xmlbase.controllers;

import com.mybatis.xmlbase.domain.Movie;
import com.mybatis.xmlbase.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/createMovieTable")
    public ResponseEntity<String> createMovieTable()
    {
        String response= movieService.createMovieTable();
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }


    @PostMapping("/addMovieInfo")
    public ResponseEntity<String> addNewMovieInfo(@RequestBody Movie movie)
    {
        String response= movieService.AddNewMovie(movie);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }

    @PutMapping("/updateMovieDetails")
    public ResponseEntity<String> updateMovieDetails(@RequestBody Movie movie)
    {
        String response=movieService.upadateMovie(movie);

        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
        else
            return new ResponseEntity<>("User information's is failed",HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/selectMoviesBy/{actorId}")
    public ResponseEntity<List<Movie>> selectMoviesByActorId(@PathVariable("actorId") int actorId)
    {
        List<Movie>movies=movieService.selectMoviesByActorId( actorId);
        if (null!=movies)
           return new ResponseEntity<>(movies,HttpStatus.OK);
        else
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/selectMovieBy/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") int movieId)
    {
        Movie movie=movieService.getMovieById(movieId);
        if (null!=movie)
            return new ResponseEntity<>(movie,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<String>deleteMovie(@PathVariable("movieId") int movieId)
    {
        String response= movieService.deleteMovie(movieId);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("Movie is not Dalated",HttpStatus.NOT_MODIFIED);
    }
}
