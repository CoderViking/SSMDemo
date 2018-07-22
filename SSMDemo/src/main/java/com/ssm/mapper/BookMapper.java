package com.ssm.mapper;

import com.ssm.model.Book;
import org.apache.ibatis.annotations.Param;

/**
 * Created by viking on 2018/07/08
 */
public interface BookMapper {

    Book getBookByName(@Param("param") String bname);

    void updateUid(@Param("param") Book book);
}
