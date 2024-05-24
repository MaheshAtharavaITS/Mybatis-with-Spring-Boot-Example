package com.mybatis.xmlbase.services;

import com.mybatis.xmlbase.mappers.CommonMovieActorMapper;
import com.mybatis.xmlbase.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    private CommonMovieActorMapper mapper;


    @Override
    public String AddNewActor(Actor actor) {
        mapper.insertActor(actor);
        return "New Actor Added Success";
    }

    @Override
    public String createActorTable() {
        mapper.createActorTable();
        return "Actor Table created ";
    }

    @Override
    public String upadateActor(Actor actor) {
        mapper.updateActor(actor);
        return "Actor Details Updated Success";
    }

    @Override
    public List<Actor> selectActorsByMovieId(int movieId) {
        return mapper.selectActorsByMovieId(movieId);
    }

    @Override
    public Actor getActorById(int actorId) {
        return mapper.selectActorById(actorId);
    }

    @Override
    public String deleteActor(int actorId) {
        mapper.deleteActor(actorId);
        return "Actort Deleted Success";
    }
}
