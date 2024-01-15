package io.flomesh.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import io.flomesh.demo.api.BookWarehouseService;
import io.flomesh.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

@Service(version = "${service.version.bookwarehouse}")
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
}
