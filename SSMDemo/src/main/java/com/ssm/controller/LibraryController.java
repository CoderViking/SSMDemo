package com.ssm.controller;

import com.ssm.model.Book;
import com.ssm.model.User;
import com.ssm.service.BookServie;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by viking on 2018/07/08
 * Library 接口类
 */
@RestController
@RequestMapping("library")
public class LibraryController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookServie bookServie;

    @RequestMapping("borrow")
    public Object Borrow(String uname,String bname) throws Exception{
        User user = userService.getUserByName(uname);
        Book book = bookServie.getBookByName(bname);
        if (user.getBid()==null) user.setBid(book.getId()+"");
        else user.setBid(user.getBid()+";"+book.getId());
        if (book.getUid()==null) book.setUid(user.getId()+"");
        else book.setUid(book.getUid()+";"+user.getId());
        userService.updateBid(user);
        int i=100;
        System.out.println("-----------------制造一个运行时异常--------------");
        System.out.println("制造一个运行异常:"+i/0);
        bookServie.updateUid(book);
        return "借阅成功";
    }

}
