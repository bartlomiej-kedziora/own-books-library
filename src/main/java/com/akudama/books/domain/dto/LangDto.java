package com.akudama.books.domain.dto;

import com.akudama.books.domain.LangKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LangDto {
    private Long id;
    private LangKind value;
    private HomeCollectionDto homeCollection;

    public LangDto(Long id, LangKind value) {
        this.id = id;
        this.value = value;
    }
}
