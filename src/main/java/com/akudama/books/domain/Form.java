package com.akudama.books.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FORMS")
public class Form {
    private Long id;
    private BookKind value;
    private HomeCollection homeCollection;

    public Form() {
    }

    public Form(BookKind value) {
        this.value = value;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "form_id")
    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    public BookKind getValue() {
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

    public void setValue(BookKind value) {
        this.value = value;
    }

    public void setHomeCollection(HomeCollection homeCollection) {
        this.homeCollection = homeCollection;
    }
}
