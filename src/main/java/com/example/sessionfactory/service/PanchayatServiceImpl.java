package com.example.sessionfactory.service;


import com.example.sessionfactory.dao.Db1PanchayatMapper;
import com.example.sessionfactory.dao.Db2PanchayatMapper;
import com.example.sessionfactory.dao.DeleteRecordMapper;
import com.example.sessionfactory.domain.DeleteRecord;
import com.example.sessionfactory.domain.Panchayat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PanchayatServiceImpl implements PanchayatService {

    @Autowired
    private Db1PanchayatMapper db1Mapper;
    @Autowired
    private Db2PanchayatMapper db2Mapper;
    @Autowired
    private DeleteRecordMapper deleteRecordMapper;

    @Override
    public void createPanchayatTable() {

        db1Mapper.createPanchayatTable();
        db2Mapper.createPanchayatTable();

    }

    @Override
    public void insertPanchayat(Panchayat panchayat) {
        db1Mapper.insertPanchayat(panchayat);
       // db2Mapper.insertPanchayat(panchayat);
    }
    public List<Panchayat> getAllPanchayatDetails(){
        return db2Mapper.findAll();
    }

    @Override
    public void createDeletedRecordTable() {
        deleteRecordMapper.createTable();
    }


    public Panchayat getPanchayatById(int id)
    {
        return db2Mapper.getPanchayatById(id);
    }

    public void updatePanchayat(Panchayat panchayat)
    {
        db1Mapper.updatePanchayat(panchayat);
      //  db2Mapper.updatePanchayat(panchayat);
    }
    public String deletePanchayatById(int id) {
        Panchayat panchayat =db1Mapper.getPanchayatById(id);
        db1Mapper.deletePanchayat(id);
        DeleteRecord deleteRecord=new DeleteRecord();

        deleteRecord.setOriginalId(id);
        deleteRecord.setEntityName("Books");
        deleteRecord.setDeleteAt(LocalDateTime.now());
        deleteRecordMapper.insertDeleteRecord(deleteRecord);
        return "Book are Deleted";
    }

}
