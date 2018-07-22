package com.ssm.service;

import com.ssm.model.Book;

/**
 * Created by viking on 2018/07/08
 */
public interface BookServie {
    Book getBookByName(String bname);

    void updateUid(Book book);
}
