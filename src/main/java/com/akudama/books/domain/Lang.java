package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LANGS")
public class Lang {
    private Long id;
    private LangKind value;
    private HomeCollection homeCollection;

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

    private void setId(Long id) {
        this.id = id;
    }

    public void setValue(LangKind value) {
        this.value = value;
    }

    public void setHomeCollection(HomeCollection homeCollection) {
        this.homeCollection = homeCollection;
    }
}
