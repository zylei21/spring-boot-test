package com.cibei.springbootcache.component;

import com.cibei.springbootcache.persistence.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 15:15
 */
@Component
public class TestCacheComponent implements CommandLineRunner {
    private static final Logger LOGGER= LoggerFactory.getLogger(TestCacheComponent.class);
    private final BookDao bookDao;

    public TestCacheComponent(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("开始测试.....");
        LOGGER.info("isbn-1234---->"+bookDao.queryByIsbn("isbn-1234"));
        LOGGER.info("isbn-2345---->"+bookDao.queryByIsbn("isbn-2345"));
        LOGGER.info("isbn-3456---->"+bookDao.queryByIsbn("isbn-3456"));
        LOGGER.info("isbn-4567---->"+bookDao.queryByIsbn("isbn-4567"));
        LOGGER.info("isbn-1234---->"+bookDao.queryByIsbn("isbn-1234"));
        LOGGER.info("isbn-1234---->"+bookDao.queryByIsbn("isbn-1234"));
        LOGGER.info("isbn-1234---->"+bookDao.queryByIsbn("isbn-1234"));
    }
}
