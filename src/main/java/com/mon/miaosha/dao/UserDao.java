package com.mon.miaosha.dao;

import com.mon.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Insert("insert user(id,name) value (#{id},#{name})")
    public Boolean tx(User user);


    @Select("select * from user where id=#{id}")
    public User getById(@Param("id") Integer id);
}
