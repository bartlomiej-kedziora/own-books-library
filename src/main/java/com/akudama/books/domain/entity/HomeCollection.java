package com.akudama.books.domain.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.akudama.books.auth.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(
        name = "HOMECOLLECTIONS",
        uniqueConstraints = {@UniqueConstraint(
        columnNames = {"user_user_id"},
        name = "user"
)})
public class HomeCollection {

    private Long id;
    private User user;
    private List<HomeCollectionItem> homeCollectionItems;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "homecollection_id")
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    @OneToMany(targetEntity = HomeCollectionItem.class, mappedBy = "homeCollection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<HomeCollectionItem> getHomeCollectionItems() {
        return homeCollectionItems;
    }
}
