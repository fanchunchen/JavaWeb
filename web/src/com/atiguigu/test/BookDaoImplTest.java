package com.atiguigu.test;

import com.atiguigu.dao.impl.BookDaoImpl;
import com.atiguigu.pojo.Book;
import com.atiguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "元尊", "土豆", new BigDecimal(99), 1000, 100, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "万相之王", "土豆", new BigDecimal(105), 2000, 0, null));
    }

    @Test
    public void queryBooks() {
        System.out.print(bookDao.queryBooks());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(0, Page.PAGE_SIZE));
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }
    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDao.queryForPageItemsByPrice(0,4,10,50));
    }
}