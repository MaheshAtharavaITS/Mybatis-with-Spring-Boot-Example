package com.mybatis.xmlbase.services;

import com.mybatis.xmlbase.domain.Actor;

import java.util.List;

public interface ActorService {
    String createActorTable();

    String AddNewActor(Actor actor);

    String upadateActor(Actor actor);

    List<Actor> selectActorsByMovieId(int movieId);

    Actor getActorById(int actorId);

    String deleteActor(int actorId);
}
