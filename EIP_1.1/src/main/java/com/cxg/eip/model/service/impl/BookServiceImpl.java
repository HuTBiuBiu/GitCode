package com.cxg.eip.model.service.impl;

import com.cxg.eip.model.mapper.BookMapper;
import com.cxg.eip.model.pojo.Book;
import com.cxg.eip.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> getBooks() {
        List<Book> books = bookMapper.getBooks();
        return books;
    }

    @Override
    public void addBook(String bookName) {
        bookMapper.addBook(bookName);
    }
}
