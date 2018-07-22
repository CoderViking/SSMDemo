package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * created by viking on 2018/07/04
 * 业务层接口实现类
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUser(int id) {
        Map map = new HashMap();
        map.put("id",id);
        return  userMapper.getUser(map);
    }

    public void insertUser(int id, String name, int age, String sex) {
        Map param = new HashMap();
        param.put("id",id);param.put("name",name);
        param.put("age",age);param.put("sex",sex);
        userMapper.insertUser(param);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public Object update() {
        Map param = new HashMap();
        param.put("total",10);
        param.put("name","测试一");
        userMapper.update(param);
        return "OK";
    }

    public User getUserByName(String uname) {

        return userMapper.getUserByName(uname);
    }

    public void updateBid(User user) {
        userMapper.updateBid(user);
    }


}
