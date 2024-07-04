package com.example.sessionfactory.dao;

import com.example.sessionfactory.config.Db1DatabaseConfig;
import com.example.sessionfactory.domain.DeleteRecord;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeleteRecordMapper {
    private static String prefix="com.example.sessionfactory.dao.DeleteRecordMapper.";

    public void createTable(){
        try(SqlSession session= Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){
            session.update(prefix+"createTable");
            session.commit();
        }
    }
    public void insertDeleteRecord(DeleteRecord record){
        try(SqlSession session=Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){
            session.insert(prefix+"insertDeleteRecord",record);
            session.commit();
        }
    }

    public void deleteDeletedeRecordById(long deletedRecordId){
        try(SqlSession session=Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){
            session.delete(prefix+"deleteDeletedRecordById",deletedRecordId);
        }
    }

    public List<DeleteRecord> findAll(){
        try(SqlSession session=Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){
            return  session.selectList(prefix+"findAll");
        }
    }
}
