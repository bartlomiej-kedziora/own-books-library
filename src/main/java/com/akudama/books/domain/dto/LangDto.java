package com.akudama.books.domain.dto;

import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.entity.HomeCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LangDto {
    private Long id;
    private LangKind value;
    private HomeCollection homeCollection;
}
