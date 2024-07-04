package com.example.sessionfactory.service;

import com.example.sessionfactory.dao.Db1PanchayatMapper;
import com.example.sessionfactory.dao.Db2PanchayatMapper;
import com.example.sessionfactory.dao.DeleteRecordMapper;
import com.example.sessionfactory.domain.DeleteRecord;
import com.example.sessionfactory.domain.Panchayat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SyncService {

    @Autowired
    private Db1PanchayatMapper db1Mapper;
    @Autowired
    private Db2PanchayatMapper db2Mapper;
    @Autowired
    private DeleteRecordMapper deleteRecordMapper;

    public void syncFromDb1ToDb2() {
        List<Panchayat>panchayatList =db1Mapper.findAll();
        for(Panchayat panchayat:panchayatList){
            if(isPresent(panchayat.getPanchayatNo())) {
              db2Mapper.updatePanchayat(panchayat);
            }else{
                db2Mapper.insertPanchayat(panchayat);
            }
        }
    }
    private boolean isPresent(int panchayatId){
        if(null==db2Mapper.getPanchayatById(panchayatId))
            return false;
        else
            return true;
    }

    public void syncDeletions(){
        System.out.println("syncDeletions method colled --------------------------------------");
        List<DeleteRecord>deleteRecordList=deleteRecordMapper.findAll();
        for(DeleteRecord record:deleteRecordList){
            db2Mapper.deletePanchayat(record.getOriginalId());
            deleteRecordMapper.deleteDeletedeRecordById(record.getId());
        }
    }
}
