package com.cibei.springbootcache.persistence.dao;

import com.cibei.springbootcache.persistence.entity.Book;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 15:06
 */
public interface BookDao {
    Book queryByIsbn(String isbn);
}
