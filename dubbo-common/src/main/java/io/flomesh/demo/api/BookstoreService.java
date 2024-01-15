package io.flomesh.demo.api;

import io.flomesh.demo.model.Book;

import java.util.List;

public interface BookstoreService {
    boolean sellBook();

    List<Book> listBooks();

    Book getBook(String id);
}
