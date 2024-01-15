package io.flomesh.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.flomesh.demo.Instants;
import io.flomesh.demo.api.BookWarehouseService;
import io.flomesh.demo.api.BookstoreService;
import io.flomesh.demo.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service(version = "${service.bookstore.version}")
@Slf4j
public class BookstoreServiceProvider implements BookstoreService {

    @Reference(version = "${service.bookwarehouse.version}", url="${service.bookwarehouse.url}")
    private BookWarehouseService bookWarehouseService;

    @Override
    public boolean sellBook() {
        log.info("sellBook() is called");
        return bookWarehouseService.restockBooks(Instants.DEFAULT_ID, 1);
    }

    @Override
    public List<Book> listBooks() {
        log.info("listBooks() is called");
        return bookWarehouseService.listBooks();
    }

    @Override
    public Book getBook(String id) {
        log.info("getBook() is called with id: " + id);
        return bookWarehouseService.getBook(id);
    }
}
