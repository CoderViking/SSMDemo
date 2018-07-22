package com.ssm.service.impl;

import com.ssm.mapper.BookMapper;
import com.ssm.model.Book;
import com.ssm.service.BookServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by viking on 2018/07/08
 * book Service
 */
@Service
public class BookServieImpl implements BookServie {
    @Autowired
    private BookMapper mapper;

    public Book getBookByName(String bname) {
        return mapper.getBookByName(bname);
    }

    public void updateUid(Book book) {
        mapper.updateUid(book);
    }
}
