package com.example.sessionfactory.service;

import com.example.sessionfactory.domain.Panchayat;

import java.util.List;
import java.util.Map;

public interface PanchayatService {

    void createPanchayatTable();

    void insertPanchayat(Panchayat panchayat);

    Panchayat getPanchayatById(int id);

    void updatePanchayat(Panchayat panchayat);

    public List<Panchayat> getAllPanchayatDetails();

    void createDeletedRecordTable();

    String deletePanchayatById(int id);
}