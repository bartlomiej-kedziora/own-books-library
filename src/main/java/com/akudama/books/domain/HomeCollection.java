package com.akudama.books.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HOMECOLLECTION")
public class HomeCollection {
    private Long Id;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();

    public HomeCollection() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "homecollection_id")
    public Long getId() {
        return Id;
    }

    @OneToMany(targetEntity = Form.class, mappedBy = "homeCollection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Form> getForms() {
        return forms;
    }

    @OneToMany(targetEntity = Lang.class, mappedBy = "homeCollection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Lang> getLangs() {
        return langs;
    }

    private void setId(Long id) {
        Id = id;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public void setLangs(List<Lang> langs) {
        this.langs = langs;
    }
}
