package com.example.sessionfactory.service;

import com.example.sessionfactory.domain.Panchayat;

import java.util.Map;

public interface PanchayatService {

    void createPanchayatTable();

    void insertPanchayat(Panchayat panchayat);

    Panchayat getPanchayatById(int id);

    void updatePanchayat(Panchayat panchayat);
}
