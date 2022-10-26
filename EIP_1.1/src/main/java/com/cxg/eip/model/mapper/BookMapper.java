package com.cxg.eip.model.mapper;

import com.cxg.eip.model.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    //查询全部图书
    List<Book> getBooks();
    //根据图书名添加一条记录
    void addBook(@Param("bookName") String bookName);
}
