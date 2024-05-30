package com.example.sessionfactory.service;


import com.example.sessionfactory.dao.PanchayatMapper;
import com.example.sessionfactory.domain.Panchayat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanchayatServiceImpl implements PanchayatService {

    @Autowired
    private PanchayatMapper panchayatMapper;


    @Override
    public void createPanchayatTable() {

        panchayatMapper.createPanchayatTable();

    }

    @Override
    public void insertPanchayat(Panchayat panchayat) {
        panchayatMapper.insertPanchayat(panchayat);
    }

    public Panchayat getPanchayatById(int id)
    {
        return panchayatMapper.getPanchayatById(id);
    }

    public void updatePanchayat(Panchayat panchayat)
    {
        panchayatMapper.updatePanchayat(panchayat);
    }
}
