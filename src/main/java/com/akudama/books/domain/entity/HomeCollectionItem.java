package com.akudama.books.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HOMECOLLECTIONITEMS",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"book_id", "homecollectionitem_id"},
                name = "uk_hci"
        )}
)
public class HomeCollectionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(
            name = "homecolitem_form",
            joinColumns = {@JoinColumn(name = "homecollectionitem_id", referencedColumnName = "homecollectionitem_id")},
            inverseJoinColumns = {@JoinColumn(name = "form_id", referencedColumnName = "form_id")}
    )
    private Set<Form> forms = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "homecolitem_lang",
            joinColumns = {@JoinColumn(name = "homecollectionitem_id", referencedColumnName = "homecollectionitem_id")},
            inverseJoinColumns = {@JoinColumn(name = "lang_id", referencedColumnName = "lang_id")}
    )
    private Set<Lang> langs = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HomeCollectionItem that = (HomeCollectionItem) o;
        return Objects.equals(book, that.book) &&
                Objects.equals(homeCollection, that.homeCollection) &&
                Objects.equals(myScore, that.myScore) &&
                Objects.equals(forms, that.forms) &&
                Objects.equals(langs, that.langs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, homeCollection, myScore, forms, langs);
    }


    public static final class HomeCollectionItemBuilder {

        private Long id;
        private Book book;
        private HomeCollection homeCollection;
        private MyScore myScore;
        private Set<Form> forms = new HashSet<>();
        private Set<Lang> langs = new HashSet<>();

        private HomeCollectionItemBuilder() {
        }

        public static HomeCollectionItemBuilder aHomeCollectionItem() {
            return new HomeCollectionItemBuilder();
        }

        public HomeCollectionItemBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public HomeCollectionItemBuilder withBook(Book book) {
            this.book = book;
            return this;
        }

        public HomeCollectionItemBuilder withHomeCollection(HomeCollection homeCollection) {
            this.homeCollection = homeCollection;
            return this;
        }

        public HomeCollectionItemBuilder withMyScore(MyScore myScore) {
            this.myScore = myScore;
            return this;
        }

        public HomeCollectionItemBuilder withForms(Set<Form> forms) {
            this.forms = forms;
            return this;
        }

        public HomeCollectionItemBuilder withLangs(Set<Lang> langs) {
            this.langs = langs;
            return this;
        }

        public HomeCollectionItem build() {
            HomeCollectionItem homeCollectionItem = new HomeCollectionItem();
            homeCollectionItem.setId(id);
            homeCollectionItem.setBook(book);
            homeCollectionItem.setHomeCollection(homeCollection);
            homeCollectionItem.setMyScore(myScore);
            homeCollectionItem.setForms(forms);
            homeCollectionItem.setLangs(langs);
            return homeCollectionItem;
        }
    }
}
