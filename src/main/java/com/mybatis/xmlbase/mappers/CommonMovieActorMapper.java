package com.mybatis.xmlbase.mappers;

import com.mybatis.xmlbase.domain.Actor;
import com.mybatis.xmlbase.domain.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  // Optional in this Xmlbase
public interface CommonMovieActorMapper {


    void createMovieTable();

    void createActorTable();

    void makeRelationMovie_Actor();

    void insertMovie(Movie movie);
    void insertActor(Actor actor);
    void insertMovieActor( int movieId, int actorId);

    void updateMovie(Movie movie);
    void updateActor(Actor actor);

    List<Actor> selectActorsByMovieId(int movieId);
    List<Movie> selectMoviesByActorId(int actorId);

    Movie selectMovieById(int movieId);
    Actor selectActorById(int actorId);

    void deleteMovie(int movieId);
    void deleteMovieActors(int movieId);

    void deleteActor(int actorId);
    void deleteActorMovies(int actorId);
}
