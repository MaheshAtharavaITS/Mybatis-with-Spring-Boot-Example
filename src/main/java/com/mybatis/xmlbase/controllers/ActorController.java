package com.mybatis.xmlbase.controllers;

import com.mybatis.xmlbase.domain.Actor;
import com.mybatis.xmlbase.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/createActorTable")
    public ResponseEntity<String> createActorTable()
    {
        String response= actorService.createActorTable();
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }


    @PostMapping("/addActorInfo")
    public ResponseEntity<String> addNewActorInfo(@RequestBody Actor actor)
    {
        System.out.println("--------------------------------------"+actor.getActorId());
        System.out.println("--------------------------------------"+actor.getActorName());
        String response= actorService.AddNewActor(actor);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }

    @PutMapping("/updateActorDetails")
    public ResponseEntity<String> updateActiorDetails(@RequestBody Actor actor)
    {
        String response=actorService.upadateActor(actor);

        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Actor information's update is failed",HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/selectActorsBy/{movieId}")
    public ResponseEntity<List<Actor>> selectActorsByMovieId(@PathVariable("movieId") int movieId)
    {
        List<Actor>actors=actorService.selectActorsByMovieId( movieId);
        if (null!=actors)
            return new ResponseEntity<>(actors,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/selectActorBy/{actorId}")
    public ResponseEntity<Actor> getActorById(@PathVariable("actorId") int actorId)
    {
        Actor actor=actorService.getActorById(actorId);
        if (null!=actor)
            return new ResponseEntity<>(actor,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteActor/{actorId}")
    public ResponseEntity<String>deleteActor(@PathVariable("actorId") int actorId)
    {
        String response= actorService.deleteActor(actorId);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("Movie is not Dalated",HttpStatus.NOT_MODIFIED);
    }
}
