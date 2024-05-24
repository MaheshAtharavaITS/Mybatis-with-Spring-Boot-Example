package com.mybatis.xmlbase.services;

import com.mybatis.xmlbase.mappers.CommonMovieActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieActorServiceImpl implements MovieActorService{

    @Autowired
    private CommonMovieActorMapper mapper;
    @Override
    public String createMovieActorTable() {
        mapper.makeRelationMovie_Actor();
        return "Table Created";
    }

    @Override
    public String insertMovieActor(int movieId, int actorId) {
        mapper.insertMovieActor(movieId,actorId);
        return "Inserted";
    }

    @Override
    public String deleteMovieFromMovieActorTable(int movieId) {
        mapper.deleteMovieActors(movieId);
        return "Movie deleted from Movie-Actor table";
    }

    @Override
    public String deleteActorFromMovieActorTable(int actorId) {
        mapper.deleteActorMovies(actorId);
        return "Actor deleted from Movie-Actor table";
    }
}
