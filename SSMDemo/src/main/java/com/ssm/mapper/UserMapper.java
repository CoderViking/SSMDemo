package com.ssm.mapper;

import com.ssm.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * created by viking on 2018/07/04
 * dao层接口
 */
public interface UserMapper {
    List<User> getUser(@Param("param") Map map);

    void insertUser(@Param("param") Map param);

    List<User> selectAll();

    void update(@Param("param") Map param);

    User getUserByName(@Param("param") String uname);

    void updateBid(@Param("param") User user);
}
