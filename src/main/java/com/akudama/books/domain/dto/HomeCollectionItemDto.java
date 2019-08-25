package com.akudama.books.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.Lang;
import com.akudama.books.domain.entity.MyScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeCollectionItemDto {

    private Long id;
    private Book book;
    private HomeCollection homeCollection;
    private MyScore myScore;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();
}
