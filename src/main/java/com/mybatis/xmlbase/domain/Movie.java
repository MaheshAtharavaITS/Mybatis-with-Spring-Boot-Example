package com.mybatis.xmlbase.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {

    private int movieId;
    private String title;
    private String genre;
    private String language;

    private List<Actor> actors=new ArrayList<>();
}
