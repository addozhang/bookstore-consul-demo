package io.flomesh.demo;

import io.flomesh.demo.model.Book;
import io.flomesh.demo.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Date;

@SpringBootApplication
public class BookWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookWarehouseApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setMaxPayloadLength(1000);
        loggingFilter.setAfterMessagePrefix("REQ:");
        return loggingFilter;
    }

    @Bean
    BookRepository initStocks(BookRepository repository) {
        repository.add(new Book("1", 0 ,"Pipy 入门", "Flomesh","9787517054221", new Date()));
        repository.add(new Book("2", 0 ,"Pipy 从入门到放弃", "Flomesh","9787517054222", new Date()));
        repository.add(new Book("3", 0 ,"FSM 入门", "Flomesh","9787517054223", new Date()));
        return repository;
    }

}