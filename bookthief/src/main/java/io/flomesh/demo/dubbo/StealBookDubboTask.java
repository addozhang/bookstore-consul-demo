package io.flomesh.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import io.flomesh.demo.api.BookstoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Profile("dubbo")
public class StealBookDubboTask {

    @Reference(version = "${service.bookstore.version}", url="${service.bookstore.url}")
    private BookstoreService bookstoreService;

    @Scheduled(fixedRate = 1000)
    public void buyABook(){
        try {
            if (bookstoreService.sellBook()) {
                log.info("A book is stolen");
            }
        } catch (Exception e) {
            log.error("Error while stealing a book", e);
            throw new RuntimeException(e);
        }
    }
}
