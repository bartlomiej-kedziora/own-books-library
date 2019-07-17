package com.akudama.books.domain.entity;

import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.entity.HomeCollection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "LANGS")
public class Lang {
    private Long id;
    private LangKind value;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "lang_id")
    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    public LangKind getValue() {
        return value;
    }
}
