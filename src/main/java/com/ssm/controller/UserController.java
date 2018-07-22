package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by viking on 2018/07/04
 * controller层接口类
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private  UserService userService;
    Logger log = Logger.getLogger(UserController.class);

    @RequestMapping("select")
    @ResponseBody
    public Object userTest(int id){
        System.out.println("测试成功~~"+id);
        List<User> user = userService.getUser(id);
        System.out.println(user.toString());
        log.info(user);
        return user;
    }
    @RequestMapping("addUser")
    public Object insertUser(int id,String name,int age,String sex){
            userService.insertUser(id,name,age,sex);
       return "OK";
    }
    @RequestMapping("selectAll")
    public Object selectAll(){
        return userService.selectAll();
    }
    @RequestMapping("update")
    public Object update(){
        return userService.update();
    }

}
