package com.mybatis.xmlbase.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Actor {

    private int actorId;
    private String actorName;

    private List<Movie> movies=new ArrayList<>();
}
