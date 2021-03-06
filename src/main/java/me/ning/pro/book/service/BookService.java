package me.ning.pro.book.service;

import me.ning.pro.book.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> queryAll();

    Book queryBookById(Integer bookId);

    List<Book> queryBookByName(String name);

    boolean insertBook(Book book);

    boolean insertBooks(List<Book> books);

    boolean updateBook(Book book);

    boolean deleteBook(Integer bookId);

    boolean deleteBooks(List<Integer> bookIds);

}
