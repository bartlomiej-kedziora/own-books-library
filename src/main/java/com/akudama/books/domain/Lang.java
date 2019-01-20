package com.akudama.books.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LANGS")
public class Lang {
    private Long id;
    private LangKind value;
    private HomeCollection homeCollection;

    public Lang() {
    }

    public Lang(LangKind value) {
        this.value = value;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "lang_id")
    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    public LangKind getValue() {
        return value;
    }

    @ManyToOne
    @JoinColumn(name = "homecollection_id")
    public HomeCollection getHomeCollection() {
        return homeCollection;
    }
}
