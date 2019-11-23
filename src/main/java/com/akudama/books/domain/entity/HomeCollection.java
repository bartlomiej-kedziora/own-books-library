package com.akudama.books.domain.entity;

import com.akudama.books.auth.user.User;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        name = "HOMECOLLECTIONS",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"user_user_id"},
                name = "user"
        )})
public class HomeCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "homecollection_id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    @OneToMany(targetEntity = HomeCollectionItem.class, mappedBy = "homeCollection", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<HomeCollectionItem> homeCollectionItems;
}
