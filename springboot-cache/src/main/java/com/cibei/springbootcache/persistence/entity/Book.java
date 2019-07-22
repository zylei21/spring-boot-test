package com.cibei.springbootcache.persistence.entity;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 15:05
 */
public class Book {
    private String isbn;
    private String name;

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
