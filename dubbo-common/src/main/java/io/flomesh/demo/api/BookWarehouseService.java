package io.flomesh.demo.api;

import io.flomesh.demo.model.Book;

import java.util.List;

public interface  BookWarehouseService {
    boolean restockBooks(String id, int quantity);

    List<Book> listBooks();

    Book getBook(String id);
}