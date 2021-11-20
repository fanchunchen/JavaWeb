package com.atiguigu.test;

import com.atiguigu.pojo.Book;
import com.atiguigu.service.impl.BookService;
import com.atiguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "诛仙", "萧鼎", new BigDecimal(110), 320, 1000, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23, "异火", "天蚕土豆", new BigDecimal(200), 210, 400, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookService.queryBooks();
        bookList.forEach(System.out::println);
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,10,50));

    }
}