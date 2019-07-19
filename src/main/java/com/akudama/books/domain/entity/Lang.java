package com.akudama.books.domain.entity;

import com.akudama.books.domain.LangKind;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
