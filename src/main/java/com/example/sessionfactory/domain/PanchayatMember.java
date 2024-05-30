package com.example.sessionfactory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanchayatMember {

    private int memberId;
    private String memberName;
    private String memberDesignation;
}
