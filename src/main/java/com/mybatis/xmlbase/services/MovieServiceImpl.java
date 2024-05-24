package com.mybatis.xmlbase.services;

import com.mybatis.xmlbase.mappers.CommonMovieActorMapper;
import com.mybatis.xmlbase.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private CommonMovieActorMapper mapper;


    @Override
    public String AddNewMovie(Movie movie) {
        mapper.insertMovie(movie);

        return "New Movie Added Success";
    }

    @Override
    public String createMovieTable() {

        mapper.createMovieTable();
        return "Movie Table created ";
    }

    @Override
    public String upadateMovie(Movie movie) {
        mapper.updateMovie(movie);
        return "Movie Details Updated Success";
    }

    @Override
    public List<Movie> selectMoviesByActorId(int actorId) {
        return mapper.selectMoviesByActorId(actorId);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return mapper.selectMovieById(movieId);
    }

    @Override
    public String deleteMovie(int movieId) {
        mapper.deleteMovie(movieId);
        return "Movie Deleted Success";
    }
}
