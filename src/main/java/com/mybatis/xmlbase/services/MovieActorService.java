package com.mybatis.xmlbase.services;

public interface MovieActorService {
    String createMovieActorTable();

    String insertMovieActor(int movieId, int actorId);

    String deleteMovieFromMovieActorTable(int movieId);

    String deleteActorFromMovieActorTable(int actorId);
}
