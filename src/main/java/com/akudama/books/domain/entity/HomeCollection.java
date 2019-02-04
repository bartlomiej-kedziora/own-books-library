package com.akudama.books.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "HOMECOLLECTION")
public class HomeCollection {
    private Long id;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "homecollection_id")
    public Long getId() {
        return id;
    }

    @OneToMany(targetEntity = Form.class, mappedBy = "homeCollection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Form> getForms() {
        return forms;
    }

    @OneToMany(targetEntity = Lang.class, mappedBy = "homeCollection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Lang> getLangs() {
        return langs;
    }
}
