package com.mybatis.xmlbase.services;

import com.mybatis.xmlbase.domain.Movie;

import java.util.List;

public interface MovieService {

    String AddNewMovie(Movie movie);

    String createMovieTable();

    String upadateMovie(Movie movie);

    List<Movie> selectMoviesByActorId(int actorId);

    Movie getMovieById(int movieId);

    String deleteMovie(int movieId);
}
