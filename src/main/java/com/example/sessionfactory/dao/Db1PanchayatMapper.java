package com.example.sessionfactory.dao;

import com.example.sessionfactory.config.Db1DatabaseConfig;
import com.example.sessionfactory.domain.Panchayat;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Db1PanchayatMapper {

    private static String prefix="com.example.sessionfactory.dao.Db1PanchayatMapper.";

    public void createPanchayatTable() {
        try(SqlSession sqlSession = Db1DatabaseConfig.getSqlSessionFactory().openSession(true);) {
            sqlSession.update(prefix+"createPanchayatTable");
            sqlSession.commit();
        }
    }

    public void insertPanchayat(Panchayat panchayat){
        try(SqlSession sqlSession =Db1DatabaseConfig.getSqlSessionFactory().openSession(true);) {
            if (panchayat.getPanchayatNo() == 0) {
                 System.out.println("Panchayat number cannot be null");
            }else {
                System.out.println("Panchayat number :-  "+panchayat.getPanchayatNo());
            }
            Map<String,Object>map=new HashMap<>();
            map.put("panchayat",panchayat);
            sqlSession.insert(prefix + "insertPanchayat",map);
            System.out.println(panchayat+"===================================");
            sqlSession.commit();
        }
    }
    public List<Panchayat> findAll(){
        try (SqlSession session=Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){
            return session.selectList(prefix+"findAll");
        }
    }
    public Panchayat getPanchayatById(int panchayatNo) {
        try(SqlSession sqlSession =Db1DatabaseConfig.getSqlSessionFactory().openSession(true);) {

            Panchayat panchayat=sqlSession.selectOne(prefix+"getPanchayatById",panchayatNo);
            System.out.println(panchayat+"===================================");
            sqlSession.commit();
            return panchayat;
        }
    }

    public void updatePanchayat(Panchayat panchayat) {
        try(SqlSession sqlSession =Db1DatabaseConfig.getSqlSessionFactory().openSession(true);) {
            if (panchayat.getPanchayatNo() == 0) {
                System.out.println("Panchayat number cannot be null");
            } else {
                System.out.println("Panchayat number :-  " + panchayat.getPanchayatNo());
            }
            Map<String, Object> map = new HashMap<>();
            map.put("panchayat", panchayat);
            sqlSession.update(prefix + "updatePanchayat", map);
            System.out.println(panchayat + "===================================");
            sqlSession.commit();
        }
    }
    public void deletePanchayat(int id){
        try(SqlSession session=Db1DatabaseConfig.getSqlSessionFactory().openSession(true)){

                session.delete(prefix+"deletePanchayat",id);
        }
    }
}
