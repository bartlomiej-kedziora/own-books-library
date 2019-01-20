package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthorDto {
    private Long Id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
    private List<Book> books = new ArrayList<>();
}