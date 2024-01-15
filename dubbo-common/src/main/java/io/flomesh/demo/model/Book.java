package io.flomesh.demo.model;

import lombok.*;
import lombok.experimental.PackagePrivate;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {

    @PackagePrivate
    String id;
    @PackagePrivate
    int value;
    @PackagePrivate
    String name;
    @PackagePrivate
    String author;
    @PackagePrivate
    String isbn;
    @PackagePrivate
    LocalDate date;

    public Book(String id, int value) {
        this.id = id;
        this.value = value;
    }
}
