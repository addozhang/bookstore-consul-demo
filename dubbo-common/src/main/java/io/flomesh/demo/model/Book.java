package io.flomesh.demo.model;

import lombok.*;
import lombok.experimental.PackagePrivate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book implements Serializable {

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
//    LocalDate date;
    Date date;
    public Book(String id, int value) {
        this.id = id;
        this.value = value;
    }
}
