package com.cxg.eip.model.service;

import com.cxg.eip.model.pojo.Book;

import java.util.List;

public interface BookService {
    //查询全部图书
    List<Book> getBooks();

    void addBook(String bookName);
}
