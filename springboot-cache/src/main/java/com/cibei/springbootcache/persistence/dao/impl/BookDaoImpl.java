package com.cibei.springbootcache.persistence.dao.impl;

import com.cibei.springbootcache.persistence.dao.BookDao;
import com.cibei.springbootcache.persistence.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 15:07
 */

@Component
public class BookDaoImpl implements BookDao {
    @Override
    @Cacheable("books")
    public Book queryByIsbn(String isbn) {
        SomeComplexService();
        return new Book(isbn,"someBook");
    }

    private void SomeComplexService(){
        try {
            long time=3000L;
            Thread.sleep(time);

        }catch (Exception e){
            throw new IllegalStateException() ;
        }
    }
}
