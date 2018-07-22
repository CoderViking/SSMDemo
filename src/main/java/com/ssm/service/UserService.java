package com.ssm.service;

import com.ssm.model.User;

import java.util.List;
/**
 * created by viking on 2018/07/04
 * 业务层接口
 */
public interface UserService {
     List<User> getUser(int id);

     void insertUser(int id, String name, int age, String sex);

     List<User> selectAll();

     Object update();

     User getUserByName(String uname);

     void updateBid(User user);
}
