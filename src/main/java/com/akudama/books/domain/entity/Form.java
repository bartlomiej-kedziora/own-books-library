package com.akudama.books.domain.entity;

import com.akudama.books.domain.BookKind;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "FORMS")
public class Form {
    private Long id;
    private BookKind value;
    private HomeCollection homeCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
