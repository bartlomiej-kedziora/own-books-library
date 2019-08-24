package com.akudama.books.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "HOMECOLLECTIONITEMS")
public class HomeCollectionItem {
    private Long id;
    private Book book;
    private HomeCollection homeCollection;
    private MyScore myScore;
    private List<Form> forms = new ArrayList<>();
    private List<Lang> langs = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "homecollectionitem_id", unique = true)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    @ManyToOne
    @JoinColumn(name = "homecollection_id")
    public HomeCollection getHomeCollection() {
        return homeCollection;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "myscore_id")
    public MyScore getMyScore() {
        return myScore;
    }

    @OneToMany(targetEntity = Form.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Form> getForms() {
        return forms;
    }

    @OneToMany(targetEntity = Lang.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Lang> getLangs() {
        return langs;
    }
}
