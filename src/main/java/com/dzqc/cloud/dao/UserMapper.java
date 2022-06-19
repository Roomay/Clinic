package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserMapper {
    public User getUserById(@Param("id") int id);
    public int insertUser(@RequestBody User user);

}