package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private Long id;
    private BookKind value;
    private HomeCollection homeCollection;
}
