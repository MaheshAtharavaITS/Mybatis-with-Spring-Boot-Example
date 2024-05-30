package com.example.sessionfactory.domain;



import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panchayat {

    private int panchayatNo;
    private String panchayatName;
    private String panchayatAddress;


    private List<PanchayatMember> panchayatMemberList=new ArrayList<>();



}
