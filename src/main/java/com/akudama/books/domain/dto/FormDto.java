package com.akudama.books.domain.dto;

import com.akudama.books.domain.BookKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private Long id;
    private BookKind value;
    private HomeCollectionDto homeCollection;

    public FormDto(Long id, BookKind value) {
        this.id = id;
        this.value = value;
    }
}
