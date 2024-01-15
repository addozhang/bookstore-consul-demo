package io.flomesh.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.flomesh.demo.Instants;
import io.flomesh.demo.api.BookWarehouseService;
import io.flomesh.demo.api.BookstoreService;
import lombok.extern.slf4j.Slf4j;

@Service(version = "${service.version.bookstore}")
@Slf4j
public class BookstoreServiceProvider implements BookstoreService {

    @Reference(version = "${service.version.bookwarehouse}")
    private BookWarehouseService bookWarehouseService;

    @Override
    public boolean sellBook() {
        log.info("sellBook() is called");
        return bookWarehouseService.restockBooks(Instants.DEFAULT_ID, 1);
    }
}
