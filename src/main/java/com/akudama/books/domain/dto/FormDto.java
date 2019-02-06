package com.akudama.books.domain.dto;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.entity.HomeCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private Long id;
    private BookKind value;
    private HomeCollection homeCollection;
}
