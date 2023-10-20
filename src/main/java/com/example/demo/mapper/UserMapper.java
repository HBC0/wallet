package com.example.demo.mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //添加用户
    @Insert("insert into users (id , user_name , password, create_time, update_time) " +
            "value (#{id},#{userName},#{password},#{createTime},#{updateTime})")
    Boolean addUser(User user);
    // ...
}
