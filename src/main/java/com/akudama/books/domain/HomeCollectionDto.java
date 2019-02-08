package com.akudama.books.domain;

import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.entity.Lang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomeCollectionDto {
    private Long id;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();

}
