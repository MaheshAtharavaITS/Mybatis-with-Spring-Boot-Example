package com.mybatis.xmlbase.controllers;

import com.mybatis.xmlbase.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieActor")
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;


    @PostMapping("/createMovieActorTable")
    public ResponseEntity<String> createMovieActorTable()
    {
        String response= movieActorService.createMovieActorTable();
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }

    @PostMapping("/insertMovieActor/{movieId}/{actorId}")
    public ResponseEntity<String> insertMovieActor(@PathVariable("movieId") int movieId,@PathVariable("actorId") int actorId){
        String response=movieActorService.insertMovieActor(movieId,actorId);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("/deleteMovieFromMovieActor/{movieId}")
    public ResponseEntity<String> deleteMovieFromMovieActorTable(@PathVariable("movieId") int movieId)
    {
        String response=movieActorService.deleteMovieFromMovieActorTable(movieId);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }

    @DeleteMapping("deleteActorFromMovieActorTable/{actorId}")
    public ResponseEntity<String> deleteActorFromMovieActorTable(@PathVariable("actorId") int actorId)
    {
        String response=movieActorService.deleteActorFromMovieActorTable(actorId);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }
}
