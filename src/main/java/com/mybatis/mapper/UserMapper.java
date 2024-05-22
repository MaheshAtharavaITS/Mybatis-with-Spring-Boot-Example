package com.mybatis.mapper;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Update("CREATE TABLE IF NOT EXISTS users ("
            + "id BIGINT PRIMARY KEY, "
            + "firstName VARCHAR(255), "
            + "lastName VARCHAR(255), "
            + "mail VARCHAR(255) UNIQUE, "
            + "mobileNo VARCHAR(20) UNIQUE, "
            + "address VARCHAR(255), "
            + "userName VARCHAR(50) UNIQUE, "
            + "password VARCHAR(255)"
            + ")")
    public void createTable();

    @Insert("INSERT INTO users (id,firstName, lastName, mail, mobileNo, address, userName, password) "
            + "VALUES (#{id}, #{firstName}, #{lastName}, #{mail}, #{mobileNo}, #{address}, #{userName}, #{password})")
    void insertUserInfo(User user);

    @Update("UPDATE users SET firstName = #{firstName}, lastName = #{lastName}, mail = #{mail}, "
            + "mobileNo = #{mobileNo}, address = #{address}, userName = #{userName}, "
            + "password = #{password} WHERE id = #{id}")
    void updateUser(User user);

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where id=#{id}")
    User findById(Long id);

    @Select("select * from users where userName=#{userName} and password=#{password}")
    User findByUserNameAndPassword(String userName, String password);

    @Delete("delete from users where id=#{id}")
    void deleteById(Long id);
}
