package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "HOMECOLLECTIONITEMS")
public class HomeCollectionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "homecollectionitem_id", unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "homecollection_id")
    private HomeCollection homeCollection;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "myscore_id")
    private MyScore myScore;
    @OneToMany(targetEntity = Form.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Form> forms = new ArrayList<>();
    @OneToMany(targetEntity = Lang.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lang> langs = new ArrayList<>();
}
