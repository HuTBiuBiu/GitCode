package com.cxg.eip.model.pojo;

public class Book {
    private Integer id;
    private String bookName;
    private String bookId;

    public Book() {
    }

    public Book(String bookName, String bookId) {
        this.bookName = bookName;
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
