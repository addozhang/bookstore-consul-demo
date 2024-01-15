package io.flomesh.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import io.flomesh.demo.api.BookWarehouseService;
import io.flomesh.demo.model.Book;
import io.flomesh.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Service(version = "${service.bookwarehouse.version}")
@Profile("dubbo")
@Slf4j
public class BookWarehouseServiceProvider implements BookWarehouseService {

    @Autowired
    private BookService bookService;

    public boolean restockBooks(String id, int quantity) {
        log.info("restockBooks() is called with id: " + id + ", quantity: " + quantity);
        bookService.restockBooks(id, quantity);
        return true;
    }

    @Override
    public List<Book> listBooks() {
        log.info("listBooks() is called");
        return bookService.getBooks();
    }

    @Override
    public Book getBook(String id) {
        log.info("getBook() is called with id: " + id);
        return bookService.getBook(id);
    }
}
