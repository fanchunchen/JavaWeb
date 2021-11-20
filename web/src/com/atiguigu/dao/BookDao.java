package com.atiguigu.dao;

import com.atiguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(int id);
    public int updateBook(Book book);
    public List<Book> queryBooks();
    public Book queryBookById(int id);

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
