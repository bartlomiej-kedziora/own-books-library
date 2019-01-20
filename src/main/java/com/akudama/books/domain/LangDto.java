package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LangDto {
    private Long id;
    private LangKind value;
    private HomeCollection homeCollection;
}
