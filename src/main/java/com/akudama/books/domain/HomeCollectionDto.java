package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomeCollectionDto {
    private Long Id;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();

}
